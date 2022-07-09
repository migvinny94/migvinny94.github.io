package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.FotosProducto;

public interface FotosProductoMapper {

	public void registrarFoto(FotosProducto fotosProducto);
	public void actualizarFoto1(FotosProducto fotosProducto) ;
	public void eliminarFoto(Integer id) ;
	public List<FotosProducto> listarFotoProductos(Integer id);
}

