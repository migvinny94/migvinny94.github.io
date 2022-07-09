package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.FotosProducto;
import pe.systems.shop.persistence.FotosProductoMapper;


@Service
public class FotosProductoService {

	@Autowired
	FotosProductoMapper fotosProductoMapper;
	
	public void registrarFoto(FotosProducto fotosProducto) {
		fotosProductoMapper.registrarFoto(fotosProducto);
	}
	public void actualizarFoto1(FotosProducto fotosProducto) {
		fotosProductoMapper.actualizarFoto1(fotosProducto);
	}
	public List<FotosProducto> listarFotoProductos(Integer id){
		return fotosProductoMapper.listarFotoProductos(id);
	}
	public void eliminarFoto(Integer id) {
		fotosProductoMapper.eliminarFoto(id);
	}
	 
}
