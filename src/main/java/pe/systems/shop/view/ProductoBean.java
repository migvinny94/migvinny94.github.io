package pe.systems.shop.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;

import pe.systems.shop.model.Categoria;
import pe.systems.shop.model.Comentarios;
import pe.systems.shop.model.Cupon;
import pe.systems.shop.model.DetalleCalificativo;
import pe.systems.shop.model.DetallePedidos;
import pe.systems.shop.model.FotosProducto;
import pe.systems.shop.model.Pedidos;
import pe.systems.shop.model.Producto;
import pe.systems.shop.model.Tipo;
import pe.systems.shop.model.Usuario;
import pe.systems.shop.service.CategoriaService;
import pe.systems.shop.service.ComentariosService;
import pe.systems.shop.service.CuponService;
import pe.systems.shop.service.DetalleCalificativoService;
import pe.systems.shop.service.DetallePedidosService;
import pe.systems.shop.service.FotosProductoService;
import pe.systems.shop.service.PedidosService;
import pe.systems.shop.service.ProductoService;
import pe.systems.shop.service.TipoService;
import pe.systems.shop.service.UsuarioService;
import pe.systems.shop.utils.FacesUtils;
import pe.systems.shop.utils.SecurityUtils;

/**
 * @author OHUIPA STREAMING
 *
 */
@ViewScoped
@ManagedBean
public class ProductoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	private Usuario usuario;
	private Integer	usuarioId;
	private List<Usuario> listarUsuario;
	
	@ManagedProperty("#{categoriaService}")
	private CategoriaService categoriaService;
	private Categoria categoria;
	private List<Categoria> listarCategoria;
	
	@ManagedProperty("#{productoService}")
	private ProductoService productoService;
	private Producto producto;
	private List<Producto> listProductos;
	private List<Producto> listarProductoTotal;

	private List<Producto> listarProductoBuscado;
	private List<Producto> listarProductoTopInicio;
	private List<Producto> listarProductoTopInicioLikes;
	
	@ManagedProperty("#{comentariosService}")
	private ComentariosService		comentariosService;
	private Comentarios				comentarios;
	private List<Comentarios>		listarComentariosByProducto;
	
	@ManagedProperty("#{detalleCalificativoService}")
	private DetalleCalificativoService	detalleCalificativoService;
	private DetalleCalificativo			detalleCalificativo;
	private DetalleCalificativo		listarDetalleCalificativoId;
	private List<DetalleCalificativo>	listarDetalleCalificativo;
	private List<DetalleCalificativo>	listarDetalleCalificativoEmpty;
	
	@ManagedProperty("#{pedidosService}")
	private PedidosService			pedidosService;
	private Pedidos					pedidos;
	private List<Pedidos>			listarPedidosPorId;
	private List<Pedidos>			listarPedidosPorUsurio;
	private List<Pedidos>			listarPedidosGeneral;
	

	

	@ManagedProperty("#{detallePedidosService}")
	private DetallePedidosService	detallePedidosService;
	private DetallePedidos			detallePedidos;
	private List<DetallePedidos>		listDetalleTemp;
	private List<DetallePedidos>	listDetallePedidosPorId;
	private List<DetallePedidos>		listDetalleOficial;
	private Integer 				indexDetalle;
	
	
	@ManagedProperty("#{fotosProductoService}")
	private FotosProductoService fotosProductoService;
	private FotosProducto fotosProducto;
	private List<FotosProducto> listarFotoProducto;
	private Integer idFotoProducto;
	
	@ManagedProperty("#{tipoService}")
	private TipoService		tipoService;
	private Tipo			tipo;
	private List<Tipo>		listarTipoTecnologia;
	private List<Tipo>		listarTipoModa;
	private List<Tipo>		listarTipoElectronica;
	private List<Tipo>		listarTipoBelleza;
	private List<Tipo>		listarTipoDeporte;
	private List<Tipo>		listarTipoOtros;
	private List<Tipo>		listarTipo;
	
	@ManagedProperty("#{cuponService}")
	private CuponService		cuponService;
	private Cupon			cupon;
	private List<Cupon>		listarCupon;
	
	private String newImage;
	private String nombreAdjuntoProducto;
	private boolean isPotBack = true;
	private String productoId;
	private Integer evento;
	private Double	totalCarrito;
	private CroppedImage croppedImage;
	private  String		nombreBusqueada="";
	private String	nomCupon;

	
	@PostConstruct
	public void init() {
		cupon = new Cupon();
		categoria = new Categoria();
		tipo	= new Tipo();
		producto = new Producto();
		evento= 0;
		listarCategoria = categoriaService.listarCategoria();
		listarProductoTotal = productoService.listarProductos();
		listarProductoTopInicio = productoService.listarTopInicioProducto();
		listarProductoTopInicioLikes	=	 productoService.listarTopInicioLikeProducto();
		listarTipoModa			= tipoService.listarTipoPorCategoria(10003);
		listarTipoElectronica	= tipoService.listarTipoPorCategoria(10002);
		listarTipoTecnologia 	= tipoService.listarTipoPorCategoria(10001);
		listarTipoBelleza		= tipoService.listarTipoPorCategoria(10004);
		listarTipoDeporte		= tipoService.listarTipoPorCategoria(10005);
		listarTipoOtros			= tipoService.listarTipoPorCategoria(10006);
		totalCarrito=0.0;
		
		
		
		 
		listarPedidosGeneral = pedidosService.listarPedidosPorUsuario(SecurityUtils.getUsuario().getUsuarioId());
			
		 
		listarCupon = cuponService.listarCupon();
		nombreBusqueada="";
		listDetalleTemp			=	detallePedidosService.listaDetallePedidos(SecurityUtils.getUsuario().getUsuarioId());
		getTotalAPagarSoles();
		pedidos	= new Pedidos();
		detallePedidos = new DetallePedidos();
		
	}
	
	
	
	//LISTADO DE MI PEDIDO POR ID 
	
	public void listarDetalle() {
		
		listDetalleOficial = detallePedidosService.listarDetallePedidosPorPedido(pedidos.getIdPedido());
	}
	
	
	public void eliminarProducto() {
		productoService.desactivarProducto(producto.getIdProducto());
		FacesUtils.showMessage("PEDIDO ELIMINADO", FacesUtils.ERROR);
		listarProductoTotal = productoService.listarProductos();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:inicio");	
	
	}
	
	public void eliminarProducto2() {
		productoService.desactivarProducto(Integer.parseInt(productoId));
		FacesUtils.showMessage("PRODUCTO DADO DE BAJO", FacesUtils.ERROR);
		listarProductoTotal = productoService.listarProductos();
	
	}
	public void activarProducto() {
		productoService.activarProducto(Integer.parseInt(productoId));
		FacesUtils.showMessage("PEDIDO ACTIVADO", FacesUtils.INFO);
		listarProductoTotal = productoService.listarProductos();
		
	}
	
	public void confirmarPedido() {
		pedidosService.actualizarPedidoConfirmado(pedidos.getIdPedido());
		FacesUtils.showMessage("PEDIDO CONFIRMADO", FacesUtils.INFO);
		listarPedidosGeneral = pedidosService.listarPedidosPorUsuario(SecurityUtils.getUsuario().getUsuarioId());
		 FacesUtils.execute("PF('pedidoDialog').hide();");
		
		
	}
	
	public void confirmarEntrega() {
		pedidosService.actualizarPedidoEntregado(pedidos.getIdPedido());
		FacesUtils.showMessage("PEDIDO ENTREGADO", FacesUtils.INFO);
		listarPedidosGeneral = pedidosService.listarPedidosPorUsuario(SecurityUtils.getUsuario().getUsuarioId());
		 FacesUtils.execute("PF('pedidoDialog').hide();");
	}
	
	// Listado de CALIFICATIVOS POR PRODUCTO 
	
	public void listarCalificativos() {
		
		listarDetalleCalificativo	=	detalleCalificativoService.listarCalificativos(Integer.parseInt(productoId));
		
	}
	
	public void buscarCupon() {
		System.out.println("llama al cupon " + nomCupon);
		cupon = cuponService.buscarCupon(nomCupon);
		System.out.println("objeto " + cupon);
		if(cupon !=null) {
			
			if(cupon.getUsado()==cupon.getCantidadMax()) {
				totalCarrito = getTotalAPagarSoles() ;
				FacesUtils.showMessage("CUPON EXPIRADO", FacesUtils.INFO);
			}else{
				FacesUtils.showMessage("CUPON VALIDO", FacesUtils.INFO);
				totalCarrito = getTotalAPagarSoles() + cupon.getDescuento();
			}
			
		}else {
			FacesUtils.showMessage("CUPON NO EXISTE", FacesUtils.WARN);
			totalCarrito = getTotalAPagarSoles() ;
		}
	}
	 
	
	//////////////////////////////////////////
	
	public void buscarProducto() {
		System.out.println("nombre buscado " + nombreBusqueada);
		listarProductoBuscado = productoService.listarProductoPoNombre(nombreBusqueada);
		System.out.println("cantidad de busqueda " + listarProductoBuscado.size());
	}
	
	
	public void registrarPedido() {
			
			
			pedidos.setUsuarioComprador(SecurityUtils.getUsuario());
			pedidos.setCupon(cupon);
			pedidosService.registrarPedido(pedidos);
			if(pedidos.getCupon().getIdCupon()!=null) {
				cuponService.actualizarUsado(cupon.getIdCupon());
			}
			System.out.println("codigo pedido " + pedidos.getIdPedido());
			detallePedidosService.asociarPedido(pedidos.getIdPedido(), SecurityUtils.getUsuario().getUsuarioId());
			
			FacesUtils.showMessage("PEDIDO REGISTRADO CON EXITO", FacesUtils.INFO);

			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:vercarrito");	
			
		
	}
	
	public Double getTotalAPagarSoles() {
		Double total = 0.0   ;
	  
			for (DetallePedidos d : listDetalleTemp) {
				total += d.getImporte();
		 
		}
		return total;
	}
	
	
	public void actualizarImporte() {

		System.out.println("id detalle pedido " + detallePedidos.getIdDetallePedido());
		 
		detallePedidosService.actualizarCantidad(detallePedidos.getCantidad(),detallePedidos.getIdDetallePedido());
		listDetalleTemp			=	detallePedidosService.listaDetallePedidos(SecurityUtils.getUsuario().getUsuarioId());
		 FacesUtils.execute("PF('dialogEdit').hide();");
		 getTotalAPagarSoles();
	}
	
	public void agregarCarrito() {
		if(SecurityUtils.getUsuario().getUsuarioId()==null) {
			
			FacesUtils.execute("PF('loginDialog').show();");
		}else {
			detallePedidos.setProducto(producto);
			detallePedidos.setNombreProducto(producto.getTituloProducto());
			detallePedidos.setPrecioProducto(producto.getPrecio());
			detallePedidos.setUsuarioComprador(SecurityUtils.getUsuario().getUsuarioId());
			detallePedidosService.registrarPedido(detallePedidos);
			listDetalleTemp			=	detallePedidosService.listaDetallePedidos(SecurityUtils.getUsuario().getUsuarioId());
			detallePedidos 			= new DetallePedidos();
			FacesUtils.showMessage("Item a�adido correctamente al carrito", FacesUtils.INFO);
		}
		
	
	}
	
	
	
	
	public void eliminarDetallePedido() {
		detallePedidosService.eliminarDetallePedido(detallePedidos.getIdDetallePedido());
		listDetalleTemp			=	detallePedidosService.listaDetallePedidos(SecurityUtils.getUsuario().getUsuarioId());
		FacesUtils.showMessage("Item Eliminado Correctamente", FacesUtils.INFO);
	}
	
	public void listarPageProducto () {
		System.out.println("categoria" + categoria.getIdCategoria());
		
		if(evento ==1) {
			listarProductoTotal = productoService.listarProductoPorCategoriaYEventoTop(categoria.getIdCategoria());
		}else if(evento ==2) {
			listarProductoTotal = productoService.listarProductoPorCategoriaYEventoComprado(categoria.getIdCategoria());
		}else if(evento ==3) {
			listarProductoTotal = productoService.listarProductoPorCategoriaYEventoPopular(categoria.getIdCategoria());
		}else if(evento ==4) {
			listarProductoTotal = productoService.listarProductoPorCategoriaYEventoPrecioMayor(categoria.getIdCategoria());
		}else if(evento ==5) {
			listarProductoTotal = productoService.listarProductoPorCategoriaYEventoPrecioMenor(categoria.getIdCategoria());
		}else {
			listarProductoTotal = productoService.listarProductoPorCategoria(categoria.getIdCategoria());
		}
	}
	
	
	
	 
	
	public void editarProducto() {
		 
		if (isPotBack) {
			if (producto == null) {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:404");
			} else {
				producto=productoService.listarProductoPorId(Integer.parseInt(productoId));
				listarFotoProducto = fotosProductoService.listarFotoProductos(producto.getIdProducto());
				listarTipo = tipoService.listarTipoPorCategoria(producto.getCategoria().getIdCategoria());
			}
		}
		isPotBack = false;
	}
	
 
	public void verProducto() {
	if(SecurityUtils.getUsuario().getUsuarioId()==null) {
			
			FacesUtils.execute("PF('loginDialog').show();");
		}else {
			if (isPotBack) {
				if (producto == null) {
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:404");
				} else {
					comentarios = new Comentarios();
					detalleCalificativo = new DetalleCalificativo();
					producto=productoService.listarProductoPorId(Integer.parseInt(productoId));
					listarFotoProducto = fotosProductoService.listarFotoProductos(producto.getIdProducto());
					listarComentariosByProducto = comentariosService.listarComentarioPorProducto(Integer.parseInt(productoId));
					listarDetalleCalificativoId = detalleCalificativoService.listarDetalleCalificativoId(Integer.parseInt(productoId), SecurityUtils.getUsuario().getUsuarioId());
				}
			}
			isPotBack = false;
		}
		
	}
	
	public void refrescar() {
		listarComentariosByProducto = comentariosService.listarComentarioPorProducto(Integer.parseInt(productoId));
	}
	
	
	public void registrarCalificativo() {
 
			listarDetalleCalificativoEmpty = detalleCalificativoService.listarDetalleCalificativoIdEmpty(Integer.parseInt(productoId), SecurityUtils.getUsuario().getUsuarioId());
			if(listarDetalleCalificativoEmpty.isEmpty() || listarDetalleCalificativoId.getIdDetalle()==null) {
				detalleCalificativo.setIdProducto(Integer.parseInt(productoId));
				detalleCalificativo.setIdUsuario(SecurityUtils.getUsuario().getUsuarioId());
				detalleCalificativoService.registrarCalificativo(detalleCalificativo);
				System.out.println("se registro calificativo");
			}else {
				
			}
			producto=productoService.listarProductoPorId(Integer.parseInt(productoId));
		listarDetalleCalificativoId = detalleCalificativoService.listarDetalleCalificativoId(Integer.parseInt(productoId), SecurityUtils.getUsuario().getUsuarioId());
		productoService.actualizarLikes();
	}
	
	public void actualizarCalificativo() {
			listarDetalleCalificativoId = detalleCalificativoService.listarDetalleCalificativoId(Integer.parseInt(productoId), SecurityUtils.getUsuario().getUsuarioId());
			detalleCalificativo.setIdDetalle(listarDetalleCalificativoId.getIdDetalle());
			if(listarDetalleCalificativoId.getEstado()==0) {
				detalleCalificativo.setEstado(1);
			}else {
				detalleCalificativo.setEstado(0);
			}
			detalleCalificativoService.actualizarCalificativo(detalleCalificativo);
			System.out.println("se atualizo 2 calificativo 2");
			listarDetalleCalificativoId = detalleCalificativoService.listarDetalleCalificativoId(Integer.parseInt(productoId), SecurityUtils.getUsuario().getUsuarioId());
			producto=productoService.listarProductoPorId(Integer.parseInt(productoId));
			productoService.actualizarLikes();
	}
	
	public void actualizarComentario() {
		comentarios.setUsuarioRespuesta(SecurityUtils.getUsuario());
		comentariosService.actualizarComentario(comentarios);
		listarComentariosByProducto = comentariosService.listarComentarioPorProducto(producto.getIdProducto());
		comentarios = new Comentarios();
		FacesUtils.execute("PF('dialogRespuesta').hide();");
		System.out.println("SI SE ACTUALIZO");
	}
	
	public void registrarComentario() {
		 
		comentarios.setUsuarioComento(SecurityUtils.getUsuario());
		comentarios.setProducto(producto);
		comentariosService.registrarComentario(comentarios);
		listarComentariosByProducto = comentariosService.listarComentarioPorProducto(producto.getIdProducto());
		comentarios = new Comentarios();
		System.out.println("SI SE REGISTRO");
	}
	
	public void listarTipoPorCategoria() {
		listarTipo = tipoService.listarTipoPorCategoria(producto.getCategoria().getIdCategoria());
	}
	
	 
	
	public void registrarProducto() {
		producto.setUsuarioPropietario(SecurityUtils.getUsuario());
		productoService.registrarProducto(producto);
		System.out.println("si registro");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:inicio");
	}
	
	public void actualizarProducto() {
		productoService.actualizarProducto(producto);
		System.out.println("si registro");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:verproducto");
	}

	public void registrarCupon() {
		
		if(cupon.getIdCupon()==null) {
			if(cupon.getNombreCupon().isEmpty() || cupon.getDescuento()==null || cupon.getCantidadMax()==null){ 
				FacesUtils.showMessage("Favor de colocar todos los datos", FacesUtils.ERROR);
			}else {
				FacesUtils.showMessage("Se registro Correctamente", FacesUtils.INFO);
				cuponService.registrarCupon(cupon);
				cupon = new Cupon();
				listarCupon = cuponService.listarCupon();
			}
		}else {
			if(cupon.getNombreCupon().isEmpty() || cupon.getDescuento()==null || cupon.getCantidadMax()==null){ 
				FacesUtils.showMessage("Favor de colocar todos los datos", FacesUtils.ERROR);
			}else {
				FacesUtils.showMessage("Se actualizo Correctamente", FacesUtils.INFO);
				cuponService.actualizarCupon(cupon);
				cupon = new Cupon();
				listarCupon = cuponService.listarCupon();
			}
		}
		
	}
	

	public void verCupon() {
		cupon = cuponService.buscarCuponId(cupon.getIdCupon());
	} 
	
	 public void cargarArchivoProducto(final FileUploadEvent event) {
	        nombreAdjuntoProducto = event.getFile().getFileName();
	        byte[] data = event.getFile().getContents();
	        System.out.println("Nombre Data :" + data);
	        producto.setData(data);
	        fotosProducto = new FotosProducto();
	 }
	 
	 

	public void saveImageProducto() {
		System.out.println("codigo " + producto.getIdProducto());
		fotosProducto.setProducto(producto);
		fotosProducto.setNombreFoto(nombreAdjuntoProducto);
		fotosProductoService.registrarFoto(fotosProducto);
		FacesUtils.createFile(producto.getData(),
				"/opt/sistemas/shop/photos-productos/photo_" + fotosProducto.getIdFotoProducto().toString() + ".jpg");
		fotosProducto.setNombreServer("/opt/sistemas/shop/photos-productos/photo_" + fotosProducto.getIdFotoProducto().toString() + ".jpg");
		fotosProductoService.actualizarFoto1(fotosProducto);
		FacesUtils.showMessage("Foto Actualizado", FacesUtils.INFO);
		listarFotoProducto = fotosProductoService.listarFotoProductos(producto.getIdProducto());
	}
	
	public void eliminarFoto() {
		System.out.println(idFotoProducto);
		fotosProductoService.eliminarFoto(idFotoProducto);
		FacesUtils.deleteFile("/opt/sistemas/shop/photos-productos/photo_"+idFotoProducto+".jpg");
		listarFotoProducto = fotosProductoService.listarFotoProductos(producto.getIdProducto());
	}
 
	 
	
	public String getFileName(String id) {
		String r = "product.png";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
		String urlFileServer = "/opt/sistemas/shop/photos-productos/photo_" + id + ".jpg";
		File fotoServer = new File(urlFileServer);
		if (fotoServer.exists()) {
			r = "photo_" + id + ".png";
			File foto = new File(scontext.getRealPath("") + "/photosproductos/" + r);
			FileOutputStream fos;
 
			try {
				fos = new FileOutputStream(foto);
				fos.write(Files.readAllBytes(fotoServer.toPath()));
				fos.close();

			} catch (IOException e) {
				System.out.println("Error al crear Archivo: " + e.getMessage());
			}
		}
 	return r;
	}


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getListarUsuario() {
		return listarUsuario;
	}


	public void setListarUsuario(List<Usuario> listarUsuario) {
		this.listarUsuario = listarUsuario;
	}


	public CategoriaService getCategoriaService() {
		return categoriaService;
	}


	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public List<Categoria> getListarCategoria() {
		return listarCategoria;
	}


	public void setListarCategoria(List<Categoria> listarCategoria) {
		this.listarCategoria = listarCategoria;
	}


	public ProductoService getProductoService() {
		return productoService;
	}


	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public List<Producto> getListProductos() {
		return listProductos;
	}


	public void setListProductos(List<Producto> listProductos) {
		this.listProductos = listProductos;
	}


	public FotosProductoService getFotosProductoService() {
		return fotosProductoService;
	}


	public void setFotosProductoService(FotosProductoService fotosProductoService) {
		this.fotosProductoService = fotosProductoService;
	}


	public FotosProducto getFotosProducto() {
		return fotosProducto;
	}


	public void setFotosProducto(FotosProducto fotosProducto) {
		this.fotosProducto = fotosProducto;
	}


	public List<FotosProducto> getListarFotoProducto() {
		return listarFotoProducto;
	}


	public void setListarFotoProducto(List<FotosProducto> listarFotoProducto) {
		this.listarFotoProducto = listarFotoProducto;
	}


	public String getNewImage() {
		return newImage;
	}


	public void setNewImage(String newImage) {
		this.newImage = newImage;
	}


	public String getNombreAdjuntoProducto() {
		return nombreAdjuntoProducto;
	}


	public void setNombreAdjuntoProducto(String nombreAdjuntoProducto) {
		this.nombreAdjuntoProducto = nombreAdjuntoProducto;
	}


 

	public String getProductoId() {
		return productoId;
	}


	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}


	public CroppedImage getCroppedImage() {
		return croppedImage;
	}


	public void setCroppedImage(CroppedImage croppedImage) {
		this.croppedImage = croppedImage;
	}

	public List<Producto> getListarProductoTotal() {
		return listarProductoTotal;
	}

	public void setListarProductoTotal(List<Producto> listarProductoTotal) {
		this.listarProductoTotal = listarProductoTotal;
	}

	public Integer getIdFotoProducto() {
		return idFotoProducto;
	}

	public void setIdFotoProducto(Integer idFotoProducto) {
		this.idFotoProducto = idFotoProducto;
	}



	public List<Producto> getListarProductoTopInicio() {
		return listarProductoTopInicio;
	}



	public void setListarProductoTopInicio(List<Producto> listarProductoTopInicio) {
		this.listarProductoTopInicio = listarProductoTopInicio;
	}



	public TipoService getTipoService() {
		return tipoService;
	}



	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}



	public Tipo getTipo() {
		return tipo;
	}



	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}



	public List<Tipo> getListarTipoTecnologia() {
		return listarTipoTecnologia;
	}



	public void setListarTipoTecnologia(List<Tipo> listarTipoTecnologia) {
		this.listarTipoTecnologia = listarTipoTecnologia;
	}



	public List<Tipo> getListarTipoModa() {
		return listarTipoModa;
	}



	public void setListarTipoModa(List<Tipo> listarTipoModa) {
		this.listarTipoModa = listarTipoModa;
	}



	public List<Tipo> getListarTipoElectronica() {
		return listarTipoElectronica;
	}



	public void setListarTipoElectronica(List<Tipo> listarTipoElectronica) {
		this.listarTipoElectronica = listarTipoElectronica;
	}



	public List<Tipo> getListarTipoBelleza() {
		return listarTipoBelleza;
	}



	public void setListarTipoBelleza(List<Tipo> listarTipoBelleza) {
		this.listarTipoBelleza = listarTipoBelleza;
	}



	public List<Tipo> getListarTipoDeporte() {
		return listarTipoDeporte;
	}



	public void setListarTipoDeporte(List<Tipo> listarTipoDeporte) {
		this.listarTipoDeporte = listarTipoDeporte;
	}



	public List<Tipo> getListarTipoOtros() {
		return listarTipoOtros;
	}



	public void setListarTipoOtros(List<Tipo> listarTipoOtros) {
		this.listarTipoOtros = listarTipoOtros;
	}



	public List<Tipo> getListarTipo() {
		return listarTipo;
	}



	public void setListarTipo(List<Tipo> listarTipo) {
		this.listarTipo = listarTipo;
	}



	public Integer getEvento() {
		return evento;
	}



	public void setEvento(Integer evento) {
		this.evento = evento;
	}

	public ComentariosService getComentariosService() {
		return comentariosService;
	}

	public void setComentariosService(ComentariosService comentariosService) {
		this.comentariosService = comentariosService;
	}

	public Comentarios getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentarios comentarios) {
		this.comentarios = comentarios;
	}

	public List<Comentarios> getListarComentariosByProducto() {
		return listarComentariosByProducto;
	}

	public void setListarComentariosByProducto(List<Comentarios> listarComentariosByProducto) {
		this.listarComentariosByProducto = listarComentariosByProducto;
	}

	public DetalleCalificativoService getDetalleCalificativoService() {
		return detalleCalificativoService;
	}

	public void setDetalleCalificativoService(DetalleCalificativoService detalleCalificativoService) {
		this.detalleCalificativoService = detalleCalificativoService;
	}

	public DetalleCalificativo getDetalleCalificativo() {
		return detalleCalificativo;
	}

	public void setDetalleCalificativo(DetalleCalificativo detalleCalificativo) {
		this.detalleCalificativo = detalleCalificativo;
	}



	public DetalleCalificativo getListarDetalleCalificativoId() {
		return listarDetalleCalificativoId;
	}

	public void setListarDetalleCalificativoId(DetalleCalificativo listarDetalleCalificativoId) {
		this.listarDetalleCalificativoId = listarDetalleCalificativoId;
	}

	public List<DetalleCalificativo> getListarDetalleCalificativo() {
		return listarDetalleCalificativo;
	}

	public void setListarDetalleCalificativo(List<DetalleCalificativo> listarDetalleCalificativo) {
		this.listarDetalleCalificativo = listarDetalleCalificativo;
	}

	public List<DetalleCalificativo> getListarDetalleCalificativoEmpty() {
		return listarDetalleCalificativoEmpty;
	}

	public void setListarDetalleCalificativoEmpty(List<DetalleCalificativo> listarDetalleCalificativoEmpty) {
		this.listarDetalleCalificativoEmpty = listarDetalleCalificativoEmpty;
	}

	public PedidosService getPedidosService() {
		return pedidosService;
	}

	public void setPedidosService(PedidosService pedidosService) {
		this.pedidosService = pedidosService;
	}

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}

	public List<Pedidos> getListarPedidosPorId() {
		return listarPedidosPorId;
	}

	public void setListarPedidosPorId(List<Pedidos> listarPedidosPorId) {
		this.listarPedidosPorId = listarPedidosPorId;
	}

	public DetallePedidosService getDetallePedidosService() {
		return detallePedidosService;
	}

	public void setDetallePedidosService(DetallePedidosService detallePedidosService) {
		this.detallePedidosService = detallePedidosService;
	}

	public DetallePedidos getDetallePedidos() {
		return detallePedidos;
	}

	public void setDetallePedidos(DetallePedidos detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

	public List<DetallePedidos> getListDetalleTemp() {
		return listDetalleTemp;
	}

	public void setListDetalleTemp(List<DetallePedidos> listDetalleTemp) {
		this.listDetalleTemp = listDetalleTemp;
	}

	public List<DetallePedidos> getListDetallePedidosPorId() {
		return listDetallePedidosPorId;
	}

	public void setListDetallePedidosPorId(List<DetallePedidos> listDetallePedidosPorId) {
		this.listDetallePedidosPorId = listDetallePedidosPorId;
	}

	public Integer getIndexDetalle() {
		return indexDetalle;
	}

	public void setIndexDetalle(Integer indexDetalle) {
		this.indexDetalle = indexDetalle;
	}



	public Double getTotalCarrito() {
		
		return totalCarrito;
	}



	public void setTotalCarrito(Double totalCarrito) {
		this.totalCarrito = totalCarrito;
	}

	public String getNombreBusqueada() {
		return nombreBusqueada;
	}

	public void setNombreBusqueada(String nombreBusqueada) {
		this.nombreBusqueada = nombreBusqueada;
	}

	public List<Producto> getListarProductoBuscado() {
		return listarProductoBuscado;
	}

	public void setListarProductoBuscado(List<Producto> listarProductoBuscado) {
		this.listarProductoBuscado = listarProductoBuscado;
	}

	public List<Producto> getListarProductoTopInicioLikes() {
		return listarProductoTopInicioLikes;
	}

	public void setListarProductoTopInicioLikes(List<Producto> listarProductoTopInicioLikes) {
		this.listarProductoTopInicioLikes = listarProductoTopInicioLikes;
	}



	public Integer getUsuarioId() {
		return usuarioId;
	}



	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}



	public CuponService getCuponService() {
		return cuponService;
	}



	public void setCuponService(CuponService cuponService) {
		this.cuponService = cuponService;
	}



	public Cupon getCupon() {
		return cupon;
	}



	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}



	public List<Cupon> getListarCupon() {
		return listarCupon;
	}



	public void setListarCupon(List<Cupon> listarCupon) {
		this.listarCupon = listarCupon;
	}



	public String getNomCupon() {
		return nomCupon;
	}



	public void setNomCupon(String nomCupon) {
		this.nomCupon = nomCupon;
	}



	public List<Pedidos> getListarPedidosPorUsurio() {
		return listarPedidosPorUsurio;
	}



	public void setListarPedidosPorUsurio(List<Pedidos> listarPedidosPorUsurio) {
		this.listarPedidosPorUsurio = listarPedidosPorUsurio;
	}



	public List<Pedidos> getListarPedidosGeneral() {
		return listarPedidosGeneral;
	}



	public void setListarPedidosGeneral(List<Pedidos> listarPedidosGeneral) {
		this.listarPedidosGeneral = listarPedidosGeneral;
	}



	public List<DetallePedidos> getListDetalleOficial() {
		return listDetalleOficial;
	}



	public void setListDetalleOficial(List<DetallePedidos> listDetalleOficial) {
		this.listDetalleOficial = listDetalleOficial;
	}

	
	 
	
	
	
	
	  
	

}