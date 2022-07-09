package pe.systems.shop.persistence;

import java.util.List;

import pe.systems.shop.model.Categoria;
import pe.systems.shop.model.Comentarios;
import pe.systems.shop.model.DetallePedidos;

public interface DetallePedidosMapper {

	
	public List<DetallePedidos> listarDetallePedidos(Integer id);

	public List<DetallePedidos> listarDetallePedidosPorPedido(Integer id);
	
	
	public void registrarDetallePedido(DetallePedidos	detallePedidos);

	public void asociarPedido(Integer	idPedido,Integer usuarioId);
	public void eliminarDetallePedido ( Integer id);
	public void actualizarCantidad ( Integer id,Integer cantidad);
	
}
