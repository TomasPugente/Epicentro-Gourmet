package test;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import dao.HibernateUtil;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadDeVentaABM;
import datos.Pedido;
import datos.Plato;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;

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

			System.out.println("\n=== CASO DE USO 1: Unidades por Festival con Personal ===");
			int idFestival = 1;
			List<UnidadDeVenta> unidades = UnidadDeVentaABM.getInstancia().traerUnidadesPorFestival(idFestival);
			for (UnidadDeVenta uv : unidades) {
				int cantPersonal = (uv.getPersonal() != null) ? uv.getPersonal().size() : 0;
				System.out.println("Unidad: " + uv.getNombreComercial() + " | Personal: " + cantPersonal);
			}

			System.out.println("\n=== CASO DE USO 2: Puestos con tiempo de montaje superior a limite ===");
			int tiempoLimite = 30;
			List<PuestoDesarmable> puestos = UnidadDeVentaABM.getInstancia().traerPuestosConTiempoMontajeMayorA(tiempoLimite);
			for (PuestoDesarmable p : puestos) {
				System.out.println("Puesto: " + p.getNombreComercial() + " | Tiempo: " + p.getTiempoMontaje() + " min");
			}

			System.out.println("\n=== PRUEBAS FINALIZADAS CON ÉXITO ===");

		} catch (Exception e) {
			System.err.println("Error durante las pruebas de la capa de negocio:");
			e.printStackTrace();
		}
	}
}