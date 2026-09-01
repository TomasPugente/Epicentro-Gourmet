package test;
import java.time.LocalDate;

import org.hibernate.Session;
import dao.HibernateUtil;
import negocio.PedidoABM;
import negocio.PlatoABM;
import datos.Pedido;
import datos.Plato;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		
		
		try {
			System.out.println("\n=== INICIO DE PRUEBAS PEDIDO Y PLATO ===");

			int idPedido = PedidoABM.getInstancia().agregar(LocalDate.now(), null);
			System.out.println("Pedido agregado exitosamente con ID: " + idPedido);

			Pedido pedidoGuardado = PedidoABM.getInstancia().traer(idPedido);
			System.out.println("Pedido recuperado de BD: " + pedidoGuardado);

			int idPlato1 = PlatoABM.getInstancia().agregar("Empanada Gourmet", 2500.0f, 1000.0f, pedidoGuardado);
			int idPlato2 = PlatoABM.getInstancia().agregar("Papas Rústicas", 3500.0f, 1200.0f, pedidoGuardado);
			System.out.println("Platos agregados con IDs: " + idPlato1 + " y " + idPlato2);

			Pedido pedidoConPlatos = PedidoABM.getInstancia().traerPedidoConPlatos(idPedido);
			System.out.println("Platos del Pedido ID " + pedidoConPlatos.getIdPedido() + ":");
			for (Plato p : pedidoConPlatos.getPlatos()) {
				System.out.println(" - " + p.getNombre() + " ($" + p.getPrecioVenta() + ")");
			}

			System.out.println("\n=== PRUEBAS FINALIZADAS CON ÉXITO ===");

		} catch (Exception e) {
			System.err.println("Error durante las pruebas de la capa de negocio:");
			e.printStackTrace();
		}
		
	}

}
