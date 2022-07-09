package pe.systems.shop.persistence;


import pe.systems.shop.model.Usuario;
 
public interface UsuarioMapper {

	public Usuario getUsuarioPorUserName(String email);
	public Usuario getUsuarioPorUserName2(String email);
	public Usuario getUsuarioPorId(Integer usuarioId);
	public void actualizarNombreServer(Usuario	usuario);
	public void actualizarNombreServerFondo(Usuario	usuario);
	public void registrarUsuario(Usuario usuario);
	public void actualizarUsuario(Usuario usuario);
	
}
