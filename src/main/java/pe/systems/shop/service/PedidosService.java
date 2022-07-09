package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Comentarios;
import pe.systems.shop.model.Pedidos;
import pe.systems.shop.persistence.ComentariosMapper;
import pe.systems.shop.persistence.PedidosMapper;



@Service
public class PedidosService {

	@Autowired
	PedidosMapper		pedidosMapper;
	


	public List<Pedidos> listarPedidos(Integer id){
		return pedidosMapper.listarPedidos(id);
	}
	
	public void registrarPedido(Pedidos pedidos) {
		pedidosMapper.registrarPedido(pedidos);
	}
	

	public List<Pedidos> listarPedidosGeneral(){
		return pedidosMapper.listarPedidosGeneral();
	}
	public List<Pedidos> listarPedidosPorUsuario(Integer usuarioId){
		return pedidosMapper.listarPedidosPorUsuario(usuarioId);
	}

	

	public void actualizarPedidoConfirmado(Integer id) {
		 pedidosMapper.actualizarPedidoConfirmado(id);
	}
	public void actualizarPedidoEntregado(Integer id) {
		 pedidosMapper.actualizarPedidoEntregado(id);
	}
	
	
}
