package test;


import datos.Festival;
import datos.UnidadDeVenta;
import datos.PuestoDesarmable;
import datos.FoodTruck;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import dao.HibernateUtil;
import dao.UnidadDeVentaDao;
import negocio.FestivalABM;
import negocio.UnidadDeVentaABM;
import negocio.FestivalABM;
public class TestUnidadDeVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		
		try {
			List<UnidadDeVenta> lista = UnidadDeVentaABM.getinstancia().traerFestivalYUnidadDeVenta(11);
			for (UnidadDeVenta u : lista) { System.out.println("Nombre: " + u.getNombreComercial());
			System.out.println("Superficie: " + u.getSuperficie());
			System.out.println("Código: " + u.getCodigo());
			System.out.println("Festival: " + u.getFestival().getNombre()); }
			
			List<Festival> lista1 = FestivalABM.getInstancia().traerFestivalesConMayorCantidadDeVentas();

			System.out.println("\n=== Festivales con mayor cantidad de ventas ===");
			
			for (Festival f : lista1) {
			    System.out.println("Festival: " + f.getNombre());
			    System.out.println("Temporada: " + f.getTemporada());
			    System.out.println("Fecha inicio: " + f.getFechainicio());
			    System.out.println("Fecha fin: " + f.getFechafin());
			    System.out.println("---------------------------");
			}
			
			List<FoodTruck> listaFoodTrucks =UnidadDeVentaABM.getinstancia().traerFoodTrucksQueRequierenElectricidad();

					System.out.println("\n=== FOOD TRUCKS QUE REQUIEREN ELECTRICIDAD ===");

					for (FoodTruck ft : listaFoodTrucks) {

					System.out.println("Nombre: " + ft.getNombreComercial());
					System.out.println("Código: " + ft.getCodigo());
					System.out.println("Superficie: " + ft.getSuperficie());
					System.out.println("Uso electricidad: " + ft.getUsoElectricidad());
					System.out.println("---------------------------");

					}
			
			//System.out.println(UnidadDeVentaABM.getinstancia().traerFestivalYUnidadDeVenta(10));
		} catch (Exception e) {
			System.err.println("Error durante las pruebas de la capa de negocio:");
			e.printStackTrace();
		}
	}
	
	

}
