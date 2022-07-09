package pe.systems.shop.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.systems.shop.model.Comentarios;
import pe.systems.shop.model.DetallePedidos;
import pe.systems.shop.model.Pedidos;
import pe.systems.shop.persistence.ComentariosMapper;
import pe.systems.shop.persistence.DetallePedidosMapper;
import pe.systems.shop.persistence.PedidosMapper;



@Service
public class DetallePedidosService {

	@Autowired
	DetallePedidosMapper		detallePedidosMapper;
	


	public List<DetallePedidos> listaDetallePedidos(Integer id){
		return detallePedidosMapper.listarDetallePedidos(id);
	}
	

	public List<DetallePedidos> listarDetallePedidosPorPedido(Integer id){
		return detallePedidosMapper.listarDetallePedidosPorPedido(id);
	}
	
	public void registrarPedido(DetallePedidos detallePedidos) {
		detallePedidosMapper.registrarDetallePedido(detallePedidos);
	}
	
	public void asociarPedido(Integer idPedido,Integer idUsuario) {
		detallePedidosMapper.asociarPedido(idPedido,idUsuario);
	}
	
	public void eliminarDetallePedido ( Integer id) {
		detallePedidosMapper.eliminarDetallePedido(id);
	}
	
	public void actualizarCantidad ( Integer id,Integer cantidad) {
		detallePedidosMapper.actualizarCantidad(id, cantidad);
	}
	
	
}
