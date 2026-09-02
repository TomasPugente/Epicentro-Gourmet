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
public class TestUnidadDeVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		
		try {
		/*
			FestivalABM.getInstancia().agregar("Feria de las naciones", "Primavera" ,LocalDate.now(), LocalDate.now());
	        FestivalABM.getInstancia().agregar("Feria del libro", "Verano" ,LocalDate.now(), LocalDate.now());

			UnidadDeVentaABM.getinstancia().agregarFoodTruck("Taquitos al pastor", 12, 10, FestivalABM.getInstancia().traer(1), 200, 12, "h2bc34", 20);
			UnidadDeVentaABM.getinstancia().agregarFoodTruck("Ian´s Burguer", 10, 10, FestivalABM.getInstancia().traer(1), 200, 12, "ina2a2", 20);
			*/
		//System.out.println(UnidadDeVentaABM.getinstancia().traer(1));
		//System.out.println(UnidadDeVentaABM.getinstancia().traer(2));
			//System.out.println(UnidadDeVentaABM.getinstancia().traerFoodTruck());
			//System.out.println(UnidadDeVentaABM.getinstancia().traerPuestoDesarmable());
			//UnidadDeVentaABM.getinstancia().eliminar(1);
			List<UnidadDeVenta> lista = UnidadDeVentaABM.getinstancia().traerFestivalYUnidadDeVenta(11);
			for (UnidadDeVenta u : lista) { System.out.println("Nombre: " + u.getNombreComercial());
			System.out.println("Superficie: " + u.getSuperficie());
			System.out.println("Código: " + u.getCodigo());
			System.out.println("Festival: " + u.getFestival().getNombre()); }
			
			//System.out.println(UnidadDeVentaABM.getinstancia().traerFestivalYUnidadDeVenta(10));
		} catch (Exception e) {
			System.err.println("Error durante las pruebas de la capa de negocio:");
			e.printStackTrace();
		}
	}

}
