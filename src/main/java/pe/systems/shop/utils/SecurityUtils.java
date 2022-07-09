package pe.systems.shop.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import pe.systems.shop.model.Usuario;

public class SecurityUtils {

	private static final String ANONYMOUS = "anonymous";
	
	public static Usuario getUsuario() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		Usuario usuario = null;
		
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof Usuario) {
				usuario = (Usuario) principal;
			} else {
				usuario = new Usuario();
			}
		}
		
		return usuario;
	}
	
	public static boolean isAnonymous() {
		return isAnonymous(getUsuario());
	}
	
	public static boolean isAnonymous(Usuario cuenta) {
		return ANONYMOUS.equals(cuenta.getUsername());
	}
}
