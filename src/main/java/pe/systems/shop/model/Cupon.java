package pe.systems.shop.model;

import java.io.Serializable;

public class Cupon implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7554201343621609062L;
	/**
	 * 
	 */ 
	
	/**
	 * 
	 */ 
	private Integer idCupon;
	private String	nombreCupon;
	private Double	descuento;
	private Integer	cantidadMax;
	private Integer usado;
	
	
	
	public Cupon() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdCupon() {
		return idCupon;
	}


	public void setIdCupon(Integer idCupon) {
		this.idCupon = idCupon;
	}


	public String getNombreCupon() {
		return nombreCupon;
	}


	public void setNombreCupon(String nombreCupon) {
		this.nombreCupon = nombreCupon;
	}


	public Double getDescuento() {
		return descuento;
	}


	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}


	 

	public Integer getCantidadMax() {
		return cantidadMax;
	}


	public void setCantidadMax(Integer cantidadMax) {
		this.cantidadMax = cantidadMax;
	}


	public Integer getUsado() {
		return usado;
	}


	public void setUsado(Integer usado) {
		this.usado = usado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCupon == null) ? 0 : idCupon.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cupon other = (Cupon) obj;
		if (idCupon == null) {
			if (other.idCupon != null)
				return false;
		} else if (!idCupon.equals(other.idCupon))
			return false;
		return true;
	}
	
	
	
	
}	
