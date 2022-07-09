package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.DetalleCalificativo;

public interface DetalleCalificativoMapper {

	

	public List<DetalleCalificativo> listarDetalleCalificativo(Integer idProducto);
	public  DetalleCalificativo listarDetalleCalificativoId(Integer idProducto,Integer idUsuario);
	public  List<DetalleCalificativo> listarDetalleCalificativoIdEmpty(Integer idProducto,Integer idUsuario);
	public void registrarCalificativo(DetalleCalificativo detalleCalificativo);
	public void actualizarCalificativo(DetalleCalificativo detalleCalificativo);
	public List<DetalleCalificativo>	listarCalificativos(Integer id);
	
}
