package test;


import datos.UnidadDeVenta;
import datos.PuestoDesarmable;
import datos.FoodTruck;
import org.hibernate.Session;

import dao.HibernateUtil;
import dao.UnidadDeVentaDao;
import negocio.UnidadDeVentaABM;
public class TestUnidadDeVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		
		try {
		
		//int idUnidadDeVenta1= UnidadDeVentaABM.getinstancia().agregarFoodTruck("Lo de tito", 60, 1, 650000, 50, "3st4", 556);
		//int idUnidadDeVenta2= UnidadDeVentaABM.getinstancia().agregarPuestoDesarmable("Lo del tano", 50, 2, 60000, 40, 4, 30, 700);
		//int idUnidadDeVenta3= UnidadDeVentaABM.getinstancia().agregarFoodTruck("La perla", 55, 3, 675000, 700, "abc 123", 640);
		//int idUnidadDeVenta4= UnidadDeVentaABM.getinstancia().agregarPuestoDesarmable("Las palmas", 75, 4, 68500, 75, 7, 30, 800);
		//System.out.println(UnidadDeVentaABM.getinstancia().traer(1));
		//System.out.println(UnidadDeVentaABM.getinstancia().traer(2));
			//System.out.println(UnidadDeVentaABM.getinstancia().traerFoodTruck());
			//System.out.println(UnidadDeVentaABM.getinstancia().traerPuestoDesarmable());
			//UnidadDeVentaABM.getinstancia().eliminar(1);
		
		} catch (Exception e) {
			System.err.println("Error durante las pruebas de la capa de negocio:");
			e.printStackTrace();
		}
	}

}
