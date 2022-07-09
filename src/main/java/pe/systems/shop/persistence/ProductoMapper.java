package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.Producto;

public interface ProductoMapper {

	
	public List<Producto> listarProductoPorUsuario(Integer id);
	public  Producto  listarProductoPorId(Integer id);
	public  List<Producto>   listarProductos();
	public List<Producto> listarProductoPorCategoria(Integer id);
	public void registrarProducto(Producto producto);
	public void actualizarProducto(Producto producto);
	public List<Producto> listarTopInicioProducto();
	
	public List<Producto> listarTopInicioLikeProducto();
	
	
	public void actualizarLikes();
	
	public void desactivarProducto(Integer id);

	public void activarProducto(Integer id);

	

	public List<Producto> listarProductoPoNombre (String nombre);
	
	//PAGINA PRODUCTOS LISTADOS
	public List<Producto> listarProductoPorCategoriaYEventoTop (Integer id);
	public List<Producto> listarProductoPorCategoriaYEventoPrecioMenor(Integer id);
	public List<Producto> listarProductoPorCategoriaYEventoPrecioMayor(Integer id);
	public List<Producto> listarProductoPorCategoriaYEventoPopular(Integer id);
	public List<Producto> listarProductoPorCategoriaYEventoComprado(Integer id);
	/////////////////////////////////////////////////////////////////////////////
}

