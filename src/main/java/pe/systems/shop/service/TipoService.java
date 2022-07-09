package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Tipo;
import pe.systems.shop.persistence.TipoMapper;


@Service
public class TipoService {

	@Autowired
	TipoMapper	tipoMapper;
	

	public List<Tipo> listarTipoPorCategoria(Integer id){
		return tipoMapper.listarTipoPorCategoria(id);
	}
	 
}
