package pe.systems.shop.model;

import java.io.Serializable;

public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6472220005076107994L;
	/**
	 * 
	 */
	 
	private Integer idProducto;
	private String	nombreProducto;
	private String	tituloProducto;
	private String	descripcion;
	private String	tipoModelo;
	private Integer	rating;
	private Usuario	usuarioPropietario;
	private Categoria	categoria;
	private	Integer	estadoProducto;
	private String	fotoTop;
	private Double	precio;
	private Tipo	tipo;
	private Integer	meGusta;
	private byte[]	data;

	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getTituloProducto() {
		return tituloProducto;
	}

	public void setTituloProducto(String tituloProducto) {
		this.tituloProducto = tituloProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipoModelo() {
		return tipoModelo;
	}

	public void setTipoModelo(String tipoModelo) {
		this.tipoModelo = tipoModelo;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Usuario getUsuarioPropietario() {
		if(usuarioPropietario==null) {
			usuarioPropietario= new Usuario();
		}
		return usuarioPropietario;
	}

	public void setUsuarioPropietario(Usuario usuarioPropietario) {
		this.usuarioPropietario = usuarioPropietario;
	}

	public Categoria getCategoria() {
		if(categoria ==null) {
			categoria = new Categoria();
		}
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getEstadoProducto() {
		return estadoProducto;
	}

	public void setEstadoProducto(Integer estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	
	

	public Tipo getTipo() {
		if(tipo == null) {
			tipo = new Tipo();
		}
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
	
 
	

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Integer getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(Integer meGusta) {
		this.meGusta = meGusta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		result = prime * result + ((nombreProducto == null) ? 0 : nombreProducto.hashCode());
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
		Producto other = (Producto) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		if (nombreProducto == null) {
			if (other.nombreProducto != null)
				return false;
		} else if (!nombreProducto.equals(other.nombreProducto))
			return false;
		return true;
	}

	public String getFotoTop() {
		return fotoTop;
	}

	public void setFotoTop(String fotoTop) {
		this.fotoTop = fotoTop;
	}
	
	
	
	
	

	 
	
}	
