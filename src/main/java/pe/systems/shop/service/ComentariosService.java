package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Comentarios;
import pe.systems.shop.persistence.ComentariosMapper;



@Service
public class ComentariosService {

	@Autowired
	ComentariosMapper	comentariosMapper;
	


	public List<Comentarios> listarComentarioPorProducto(Integer id){
		return comentariosMapper.listarComentarioPorProducto(id);
	}
	public void registrarComentario(Comentarios comentarios) {
		comentariosMapper.registrarComentario(comentarios);
	}
	public void actualizarComentario(Comentarios comentarios) {
		comentariosMapper.actualizarComentario(comentarios);
	}
}
