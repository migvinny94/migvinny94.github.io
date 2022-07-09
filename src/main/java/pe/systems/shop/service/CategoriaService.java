package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Categoria;
import pe.systems.shop.persistence.CategoriaMapper;


@Service
public class CategoriaService {

	@Autowired
	CategoriaMapper categoriaMapper;
	

	public List<Categoria> listarCategoria(){
		return categoriaMapper.listarCategoria();
	}
	 
}
