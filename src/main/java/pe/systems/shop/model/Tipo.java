package pe.systems.shop.model;

import java.io.Serializable;

public class Tipo implements Serializable {
	
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
	private Integer idTipo;
	private String	nombreTipo;
	private Categoria	categoria;
	
	public Tipo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public Categoria getCategoria() {
		if(categoria==null) {
			categoria = new Categoria();
		}
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipo == null) ? 0 : idTipo.hashCode());
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
		Tipo other = (Tipo) obj;
		if (idTipo == null) {
			if (other.idTipo != null)
				return false;
		} else if (!idTipo.equals(other.idTipo))
			return false;
		return true;
	}

	
	
}	
