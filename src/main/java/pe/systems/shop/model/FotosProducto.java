package pe.systems.shop.model;

import java.io.Serializable;

public class FotosProducto implements Serializable {
	
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -8305240572037030981L;
	private Integer idFotoProducto;
	private Producto	producto;
	private byte[] 	data;
	private String	nombreServer;
	private String	nombreFoto;
	
	public FotosProducto() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdFotoProducto() {
		return idFotoProducto;
	}
	public void setIdFotoProducto(Integer idFotoProducto) {
		this.idFotoProducto = idFotoProducto;
	}
	public Producto getProducto() {
		if(producto == null) {
			producto = new Producto();
		}
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getNombreServer() {
		return nombreServer;
	}
	public void setNombreServer(String nombreServer) {
		this.nombreServer = nombreServer;
	}
	
	

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFotoProducto == null) ? 0 : idFotoProducto.hashCode());
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
		FotosProducto other = (FotosProducto) obj;
		if (idFotoProducto == null) {
			if (other.idFotoProducto != null)
				return false;
		} else if (!idFotoProducto.equals(other.idFotoProducto))
			return false;
		return true;
	}
	
	

}
