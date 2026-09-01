package negocio;

import java.util.List;
import dao.PlatoDao;
import datos.Pedido;
import datos.Plato;

public class PlatoABM {
	private static PlatoABM instancia;

	protected PlatoABM() {}

	public static PlatoABM getInstancia() {
		if (instancia == null) {
			instancia = new PlatoABM();
		}
		return instancia;
	}

	public Plato traer(int idPlato) {
		return PlatoDao.getInstancia().traer((long) idPlato);
	}

	public List<Plato> traer() {
		return PlatoDao.getInstancia().traer();
	}

	public List<Plato> traerPorPedido(int idPedido) {
		return PlatoDao.getInstancia().traerPlatosPorPedido(idPedido);
	}

	public int agregar(String nombre, float precioVenta, float costoProduccion, Pedido pedido) throws Exception {
		Plato p = new Plato(nombre, precioVenta, costoProduccion, pedido);
		return PlatoDao.getInstancia().agregar(p);
	}

	public void modificar(Plato p) throws Exception {
		PlatoDao.getInstancia().actualizar(p);
	}

	public void eliminar(int idPlato) throws Exception {
		Plato p = traer(idPlato);
		if (p == null) {
			throw new Exception("El plato a eliminar no existe.");
		}
		PlatoDao.getInstancia().eliminar(p);
	}
}