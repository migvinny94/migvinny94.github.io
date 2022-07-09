package pe.systems.shop.model;

import java.io.Serializable;

public class DetallePedidos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8794668684676514219L;
	
	
	private Integer		idDetallePedido;
	private Producto	producto;
	private Pedidos		pedidos;
	private Integer		cantidad;
	private Double		importe;
	private	Integer		usuarioComprador;
	private Integer		estadoDetallePedido;
	private String		nombreProducto;
	private Double		precioProducto;
	private Integer		idFoto;
	
	
	public DetallePedidos() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}


	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
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


	public Pedidos getPedidos() {
		if(pedidos == null) {
			pedidos = new Pedidos();
		}
		return pedidos;
	}


	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getImporte() {
		return importe;
	}


	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	


	public Integer getUsuarioComprador() {
		return usuarioComprador;
	}


	public void setUsuarioComprador(Integer usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}


	public Integer getEstadoDetallePedido() {
		return estadoDetallePedido;
	}


	public void setEstadoDetallePedido(Integer estadoDetallePedido) {
		this.estadoDetallePedido = estadoDetallePedido;
	}
	
	


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public Double getPrecioProducto() {
		return precioProducto;
	}


	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	


	public Integer getIdFoto() {
		return idFoto;
	}


	public void setIdFoto(Integer idFoto) {
		this.idFoto = idFoto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDetallePedido == null) ? 0 : idDetallePedido.hashCode());
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
		DetallePedidos other = (DetallePedidos) obj;
		if (idDetallePedido == null) {
			if (other.idDetallePedido != null) {
				return false;
			}
		} else if (!idDetallePedido.equals(other.idDetallePedido)) {
			return false;
		}
		return true;
	}
	
	
	
}
