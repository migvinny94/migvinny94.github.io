package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.Tipo;

public interface TipoMapper {

	
	public List<Tipo> listarTipoPorCategoria(Integer id);
	
}
