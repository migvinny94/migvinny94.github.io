package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.Cupon;

public interface CuponMapper {

	
	public List<Cupon> listarCupon();
	public void registrarCupon(Cupon cupon);
	public Cupon buscarCupon(String nombre);

	public Cupon buscarCuponId(Integer id);
	public void actualizarCupon(Cupon cupon);
	public void actualizarUsado(Integer id);
	
	
	
}
