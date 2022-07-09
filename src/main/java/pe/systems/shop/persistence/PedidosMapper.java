package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.Categoria;
import pe.systems.shop.model.Comentarios;
import pe.systems.shop.model.Pedidos;

public interface PedidosMapper {

	
	public List<Pedidos> listarPedidos(Integer id);
	
	

	public List<Pedidos> listarPedidosGeneral();
	public List<Pedidos> listarPedidosPorUsuario(Integer usuarioId);
	
	public void registrarPedido(Pedidos pedidos);

	public void actualizarPedidoConfirmado(Integer id);
	public void actualizarPedidoEntregado(Integer id);
	
}
