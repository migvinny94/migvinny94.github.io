package pe.systems.shop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Usuario;
import pe.systems.shop.persistence.UsuarioMapper;

@Service
public class UsuarioService {

	@Autowired
	UsuarioMapper usuarioMapper;
	public Usuario getUsuarioPorUserName(String email){
		return usuarioMapper.getUsuarioPorUserName(email);
	}
	
	public Usuario getUsuarioPorUserName2(String email){
		return usuarioMapper.getUsuarioPorUserName2(email);
	}
	
	 
	public Usuario getUsuarioPorId (Integer usuarioId) {
		return usuarioMapper.getUsuarioPorId(usuarioId);
	}
	 
	public void actualizarNombreServer(Usuario	usuario) {
		usuarioMapper.actualizarNombreServer(usuario);
	}
	public void actualizarNombreServerFondo(Usuario	usuario) {
		usuarioMapper.actualizarNombreServerFondo(usuario);
	}
	
	public void registrarUsuario(Usuario usuario) {
		usuarioMapper.registrarUsuario(usuario);
	}
	

	public void actualizarUsuario(Usuario usuario) {
		usuarioMapper.actualizarUsuario(usuario);
	}
	
}
