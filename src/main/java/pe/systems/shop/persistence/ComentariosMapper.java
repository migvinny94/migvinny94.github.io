package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.Categoria;
import pe.systems.shop.model.Comentarios;

public interface ComentariosMapper {

	
	public List<Comentarios> listarComentarioPorProducto(Integer id);
	public void registrarComentario(Comentarios comentarios);
	public void actualizarComentario(Comentarios comentarios);
	
}
