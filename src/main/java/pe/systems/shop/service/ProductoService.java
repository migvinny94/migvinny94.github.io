package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Producto;
import pe.systems.shop.persistence.ProductoMapper;


@Service
public class ProductoService {

	@Autowired
	ProductoMapper productoMapper;
	


	public List<Producto> listarProductoPorUsuario(Integer id){
		return productoMapper.listarProductoPorUsuario(id);
	}
	public List<Producto> listarProductoPorCategoria(Integer id){
		return productoMapper.listarProductoPorCategoria(id);
	}

	public Producto listarProductoPorId(Integer id){
		return productoMapper.listarProductoPorId(id);
	}
	

	public void activarProducto(Integer id) {
		productoMapper.activarProducto(id);
	}

	public void desactivarProducto(Integer id) {
		productoMapper.desactivarProducto(id);
	}
	
	public void registrarProducto(Producto producto) {
		productoMapper.registrarProducto(producto);
	}
	
	public void actualizarProducto(Producto producto) {
		productoMapper.actualizarProducto(producto);
	}
	
	public  List<Producto>  listarProductos() {
		return productoMapper.listarProductos();
	}
	
	public List<Producto> listarTopInicioProducto(){
		return productoMapper.listarTopInicioProducto();
	}
	public List<Producto> listarTopInicioLikeProducto(){
		return productoMapper.listarTopInicioLikeProducto();
	}
	
	public void actualizarLikes() {
		productoMapper.actualizarLikes();
	}
	
	
	//PAGINA PRODUCTOS LISTADOS
	public List<Producto> listarProductoPorCategoriaYEventoTop (Integer id){
		return productoMapper.listarProductoPorCategoriaYEventoTop(id);
	}
	public List<Producto> listarProductoPorCategoriaYEventoPrecioMenor(Integer id){
		return productoMapper.listarProductoPorCategoriaYEventoPrecioMenor(id);
	}
	public List<Producto> listarProductoPorCategoriaYEventoPrecioMayor(Integer id){
		return productoMapper.listarProductoPorCategoriaYEventoPrecioMayor(id);
	}
	public List<Producto> listarProductoPorCategoriaYEventoPopular(Integer id){
		return productoMapper.listarProductoPorCategoriaYEventoPopular(id);
	}
	public List<Producto> listarProductoPorCategoriaYEventoComprado(Integer id){
		return productoMapper.listarProductoPorCategoriaYEventoComprado(id);
	}
	/////////////////////////////////////////////////////////////////////////////
	
	public List<Producto> listarProductoPoNombre(String nombre){
		return productoMapper.listarProductoPoNombre(nombre);
	}
}
