package pe.systems.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Cupon;
import pe.systems.shop.persistence.CuponMapper;

@Service
public class CuponService {

	@Autowired
	CuponMapper cuponMapper;
	
	public List<Cupon> listarCupon(){
		return cuponMapper.listarCupon();
	}
	public void registrarCupon(Cupon cupon) {
		cuponMapper.registrarCupon(cupon);
	}
	public Cupon buscarCupon(String nombre){
		return cuponMapper.buscarCupon(nombre);
	}
	

	public Cupon buscarCuponId(Integer id) {
		return cuponMapper.buscarCuponId(id);
	}
	
	public void actualizarCupon(Cupon cupon) {
		cuponMapper.actualizarCupon(cupon);
	}
	
	public void actualizarUsado(Integer id) {
		cuponMapper.actualizarUsado(id);
	}
	
}
