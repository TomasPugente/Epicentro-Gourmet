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


			Pedido pedidoGuardado = PedidoABM.getInstancia().traer(1);
			System.out.println("Pedido recuperado de BD: " + pedidoGuardado);

			Pedido pedidoConPlatos = PedidoABM.getInstancia().traerPedidoConPlatos(2);
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
