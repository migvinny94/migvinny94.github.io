package pe.systems.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Usuario;
import pe.systems.shop.persistence.UsuarioMapper;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioMapper usuarioMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioMapper.getUsuarioPorUserName(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("not fount user" + username);
		}
		return usuario;
	}
	
	public UserDetails loadUserByUsername2(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioMapper.getUsuarioPorUserName(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("not fount user" + username);
		}
		return usuario;
	}

}
