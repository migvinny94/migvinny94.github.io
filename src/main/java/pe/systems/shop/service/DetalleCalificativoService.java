package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.DetalleCalificativo;
import pe.systems.shop.persistence.DetalleCalificativoMapper;



@Service
public class DetalleCalificativoService {

	@Autowired
	DetalleCalificativoMapper	detalleCalificativoMapper;
	


	public List<DetalleCalificativo> listarDetalleCalificativo(Integer idProducto){
		return detalleCalificativoMapper.listarDetalleCalificativo(idProducto);
	}
	
	public DetalleCalificativo listarDetalleCalificativoId(Integer idProducto,Integer idUsuario){
		return detalleCalificativoMapper.listarDetalleCalificativoId(idProducto, idUsuario);
	}
	
	public  List<DetalleCalificativo> listarDetalleCalificativoIdEmpty(Integer idProducto,Integer idUsuario){
		return detalleCalificativoMapper.listarDetalleCalificativoIdEmpty(idProducto, idUsuario);
	}
	
	public void registrarCalificativo(DetalleCalificativo detalleCalificativo) {
		detalleCalificativoMapper.registrarCalificativo(detalleCalificativo);
		
	}
	public void actualizarCalificativo(DetalleCalificativo detalleCalificativo) {
		detalleCalificativoMapper.actualizarCalificativo(detalleCalificativo);
		
	}
	public List<DetalleCalificativo>	listarCalificativos(Integer id){
		return detalleCalificativoMapper.listarCalificativos(id);
	}
	
}
