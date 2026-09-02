package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.PedidoDao;
import datos.Pedido;
import datos.UnidadDeVenta;

public class PedidoABM {
	private static PedidoABM instancia;

	protected PedidoABM() {}

	public static PedidoABM getInstancia() {
		if (instancia == null) {
			instancia = new PedidoABM();
		}
		return instancia;
	}

	public Pedido traer(int idPedido) {
		return PedidoDao.getInstancia().traer((long) idPedido);
	}

	public Pedido traerPedidoConPlatos(int idPedido) {
		return PedidoDao.getInstancia().traerPedidoConPlatos(idPedido);
	}

	public List<Pedido> traer() {
		return PedidoDao.getInstancia().traer();
	}

	public List<Pedido> traerPorUnidadDeVenta(int idUnidadDeVenta) {
		return PedidoDao.getInstancia().traerPedidosPorUnidadDeVenta(idUnidadDeVenta);
	}

	public int agregar(LocalDate fechaTransaccion, UnidadDeVenta unidadDeVenta) throws Exception {
		Pedido p = new Pedido(fechaTransaccion, unidadDeVenta);
		return PedidoDao.getInstancia().agregar(p);
	}

	public void modificar(Pedido p) throws Exception {
		PedidoDao.getInstancia().actualizar(p);
	}

	public void eliminar(int idPedido) throws Exception {
		Pedido p = traer(idPedido);
		if (p == null) {
			throw new Exception("El pedido a eliminar no existe.");
		}
		PedidoDao.getInstancia().eliminar(p);
	}
	
	public List<Pedido> traer(LocalDate fecha) {
	    return PedidoDao.getInstancia().traerPorFecha(fecha);
	}
	
	
}