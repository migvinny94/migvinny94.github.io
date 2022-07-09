package pe.systems.shop.model;

import java.io.Serializable;

public class DetalleCalificativo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer idDetalle;
	private	Integer	idProducto;
	private Integer	idUsuario;
	private Integer estado;
	private String	nombresUsuario;
	
	public DetalleCalificativo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDetalle == null) ? 0 : idDetalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DetalleCalificativo other = (DetalleCalificativo) obj;
		if (idDetalle == null) {
			if (other.idDetalle != null) {
				return false;
			}
		} else if (!idDetalle.equals(other.idDetalle)) {
			return false;
		}
		return true;
	}
	
	

}
