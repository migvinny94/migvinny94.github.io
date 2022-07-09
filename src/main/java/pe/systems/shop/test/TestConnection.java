package pe.systems.shop.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pe.systems.shop.config.AppConfig;
import pe.systems.shop.model.Usuario;
import pe.systems.shop.service.UsuarioService;




public class TestConnection {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UsuarioService usuarioService = applicationContext.getBean(UsuarioService.class);
		Usuario user = usuarioService.getUsuarioPorUserName("admin");
		if(user.getUsuarioId()!=null){
			System.out.println("si hay usuario " + user.getNombres());
			System.out.println("si hay usuario " + user.getUsuarioId());
		}else{
			System.out.println("ERROR DE AUTENTICACION");
		 
		}
		 
	}
	
	
	 

}
