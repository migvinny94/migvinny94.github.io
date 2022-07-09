package pe.systems.shop.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.imgscalr.Scalr;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;

import pe.systems.shop.model.FotosProducto;
import pe.systems.shop.model.Producto;
import pe.systems.shop.model.Usuario;
import pe.systems.shop.persistence.UsuarioMapper;
import pe.systems.shop.service.ProductoService;
import pe.systems.shop.service.UsuarioService;
import pe.systems.shop.utils.FacesUtils;
import pe.systems.shop.utils.SecurityUtils;

/**
 * @author OHUIPA STREAMING
 *
 */
@ViewScoped
@ManagedBean
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{usuarioService}")
	private UsuarioService usuarioService;
	private Usuario usuario;
	private List<Usuario> listarUsuario;
	private String newImage;
	private String nombreAdjuntoUsuario;
	private String nombreAdjuntoFondo;
	private Integer paginado;
	private boolean isPotBack = true;
	private String usuarioId;

	private CroppedImage croppedImage;

	@ManagedProperty("#{productoService}")
	private ProductoService productoService;
	private Producto producto;
	private List<Producto> listProductos;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
		paginado = 0;

	}
	
	public void crearUsuario() {
		
		if(usuario.getNombres().isEmpty() || usuario.getUsername().isEmpty() || usuario.getEmail().isEmpty() || usuario.getPassword().isEmpty())
		{
			FacesUtils.showMessage("Favor de completar todos los campos" , FacesUtils.ERROR);
			
		}else {
			FacesUtils.showMessage("Se registro Satisfactoriamente" , FacesUtils.INFO);
			usuarioService.registrarUsuario(usuario);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:login");
		}
	}

	public void verPerfil() {
		paginado = 1;

		if (isPotBack) {
			if (usuario == null) {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:404");
			} else {
				usuario = usuarioService.getUsuarioPorId(Integer.parseInt(usuarioId));
				listProductos = productoService.listarProductoPorUsuario(Integer.parseInt(usuarioId));
			}
		}
		isPotBack = false;
	}
	////////////////////

	public void salir() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:logout");
	}
	
	public void actualizarUsuario() {
		usuarioService.actualizarUsuario(usuario);
		FacesUtils.showMessage("CAMPOS ACTUALIZADOS" , FacesUtils.INFO);
	}

	public void verConfiguracion() {

		paginado = 1;
		if (isPotBack) {
			if (usuario == null) {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:404");
			} else if (SecurityUtils.getUsuario().getUsuarioId().toString().equals(usuarioId)
					|| SecurityUtils.getUsuario().getPerfil().equals("ADM")) {
				usuario = usuarioService.getUsuarioPorId(Integer.parseInt(usuarioId));
			} else {
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "pretty:403");
			}
		}
		isPotBack = false;
	}

	public void nuevaImagen() {
		newImage = null;
	}
 

	public void cargarFotoPerfil(final FileUploadEvent event) {
		nombreAdjuntoUsuario = event.getFile().getFileName();
		byte[] data = event.getFile().getContents();
		System.out.println("Nombre Data :" + data);
		usuario.setData(data);
	}

	public void cargarFotoPortada(final FileUploadEvent event) {
		nombreAdjuntoFondo = event.getFile().getFileName();
		byte[] dataPortada = event.getFile().getContents();
		System.out.println("Nombre Data Portada :" + dataPortada);
		usuario.setDataPortada(dataPortada);
	}

	public void saveImagePerfil() {
		FacesUtils.createFile(usuario.getData(),
				"/opt/sistemas/shop/photos-users/photo_" + usuario.getUsuarioId().toString() + ".jpg");
		usuario.setUsuarioId(usuario.getUsuarioId());
		usuario.setNombreServer("/opt/sistemas/shop/photos-users/photo_" + usuario.getUsuarioId().toString() + ".jpg");
		usuarioService.actualizarNombreServer(usuario);
		FacesUtils.showMessage("Foto Actualizado", FacesUtils.INFO);
		nombreAdjuntoUsuario = null;

	}

	public void saveImageFondo() {
		FacesUtils.createFile(usuario.getDataPortada(),
				"/opt/sistemas/shop/photos-users-fondos/photo_" + usuario.getUsuarioId().toString() + ".jpg");
		usuario.setUsuarioId(usuario.getUsuarioId());
		usuario.setNombreServerFondo(
				"/opt/sistemas/shop/photos-users-fondos/photo_" + usuario.getUsuarioId().toString() + ".jpg");
		usuarioService.actualizarNombreServerFondo(usuario);
		FacesUtils.showMessage("Foto Actualizado", FacesUtils.INFO);
		nombreAdjuntoFondo = null;
	}

	public String getFileName(String id) {
		String r = "profile.png";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
		String urlFileServer = "/opt/sistemas/shop/photos-users/photo_" + id + ".jpg";
		File fotoServer = new File(urlFileServer);
		if (fotoServer.exists()) {
			r = "photo_" + id + ".jpg";
			File foto = new File(scontext.getRealPath("") + "/photos/" + r);
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

	public String getFileNameFondos(String id) {
		String r = "fondo.jpg";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
		String urlFileServer = "/opt/sistemas/shop/photos-users-fondos/photo_" + id + ".jpg";
		File fotoServer = new File(urlFileServer);
		if (fotoServer.exists()) {
			r = "photo_" + id + ".jpg";
			File foto = new File(scontext.getRealPath("") + "/photosfondos/" + r);
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

	public String getNewImage() {
		return newImage;
	}

	public void setNewImage(String newImage) {
		this.newImage = newImage;
	}

	public String getNombreAdjuntoUsuario() {
		return nombreAdjuntoUsuario;
	}

	public void setNombreAdjuntoUsuario(String nombreAdjuntoUsuario) {
		this.nombreAdjuntoUsuario = nombreAdjuntoUsuario;
	}

	public Integer getPaginado() {
		return paginado;
	}

	public void setPaginado(Integer paginado) {
		this.paginado = paginado;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public CroppedImage getCroppedImage() {
		return croppedImage;
	}

	public void setCroppedImage(CroppedImage croppedImage) {
		this.croppedImage = croppedImage;
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

	public String getNombreAdjuntoFondo() {
		return nombreAdjuntoFondo;
	}

	public void setNombreAdjuntoFondo(String nombreAdjuntoFondo) {
		this.nombreAdjuntoFondo = nombreAdjuntoFondo;
	}

}