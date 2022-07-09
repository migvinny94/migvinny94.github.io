package pe.systems.shop.model;

import java.io.Serializable;
import java.util.Date;

public class Comentarios implements Serializable {
 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7117088388990091793L;

	private Integer		idComentario;
	private String		mensaje;
	private String		mensajeRespuesta;
	private Integer		estadoRespuesta;
	private Usuario		usuarioComento;
	private Usuario		usuarioRespuesta;
	private Date		fechaComentario;
	private	Producto	producto;
	private Date		fechaRespuesta;
	private String		nombresComento;
	private String		nombresRespuesta;
	
	
	public Comentarios() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdComentario() {
		return idComentario;
	}


	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}


	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}


	public Integer getEstadoRespuesta() {
		return estadoRespuesta;
	}


	public void setEstadoRespuesta(Integer estadoRespuesta) {
		this.estadoRespuesta = estadoRespuesta;
	}


	public Usuario getUsuarioComento() {
		if(usuarioComento==null) {
			usuarioComento = new Usuario();
		}
		return usuarioComento;
	}


	public void setUsuarioComento(Usuario usuarioComento) {
		this.usuarioComento = usuarioComento;
	}


	public Usuario getUsuarioRespuesta() {
		if(usuarioRespuesta==null) {
			usuarioRespuesta=new Usuario();
		}
		return usuarioRespuesta;
	}


	public void setUsuarioRespuesta(Usuario usuarioRespuesta) {
		this.usuarioRespuesta = usuarioRespuesta;
	}


	public Date getFechaComentario() {
		return fechaComentario;
	}


	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
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
	
	


	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}


	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}


	public String getNombresComento() {
		return nombresComento;
	}


	public void setNombresComento(String nombresComento) {
		this.nombresComento = nombresComento;
	}


	public String getNombresRespuesta() {
		return nombresRespuesta;
	}


	public void setNombresRespuesta(String nombresRespuesta) {
		this.nombresRespuesta = nombresRespuesta;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idComentario == null) ? 0 : idComentario.hashCode());
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
		Comentarios other = (Comentarios) obj;
		if (idComentario == null) {
			if (other.idComentario != null)
				return false;
		} else if (!idComentario.equals(other.idComentario))
			return false;
		return true;
	}
	
	
	
	
}
