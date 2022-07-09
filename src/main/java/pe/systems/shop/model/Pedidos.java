package pe.systems.shop.model;

import java.io.Serializable;
import java.util.Date;

public class Pedidos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6902997780969133006L;
	
	private Integer		idPedido;
	private Usuario		usuarioComprador;
	private Usuario		usuarioVendedor;
	private Date		fechaPedido;
	private Integer		estadoPedido;
	private Cupon		cupon;
	private String		medioPago;
	
	
	public Pedidos() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	

	public Cupon getCupon() {
		if(cupon==null) {
			cupon = new Cupon();
		}
		return cupon;
	}


	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}


	public Usuario getUsuarioComprador() {
		if(usuarioComprador==null) {
			usuarioComprador= new Usuario();
		}
		return usuarioComprador;
	}


	public void setUsuarioComprador(Usuario usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}


	public Usuario getUsuarioVendedor() {
		if(usuarioVendedor==new Usuario()) {
			usuarioVendedor = new Usuario();
		}
		return usuarioVendedor;
	}


	public void setUsuarioVendedor(Usuario usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}


	public Date getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}



	public Integer getEstadoPedido() {
		return estadoPedido;
	}


	public void setEstadoPedido(Integer estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	
	
	


	public String getMedioPago() {
		return medioPago;
	}


	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedidos other = (Pedidos) obj;
		if (idPedido == null) {
			if (other.idPedido != null) {
				return false;
			}
		} else if (!idPedido.equals(other.idPedido)) {
			return false;
		}
		return true;
	}
	
	
}
