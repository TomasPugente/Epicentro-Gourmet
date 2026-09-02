package test;
import java.time.LocalDate;
import org.hibernate.Session;
import dao.HibernateUtil;
import negocio.FestivalABM;
import negocio.UnidadDeVentaABM;
public class TestTizi {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		
		FestivalABM.getInstancia().agregar("Feria de las naciones", "Primavera" ,LocalDate.now(), LocalDate.now());
        FestivalABM.getInstancia().agregar("Feria del libro", "Verano" ,LocalDate.now(), LocalDate.now());
		//UnidadDeVentaABM.getinstancia().agregarFoodTruck("Taquitos al pastor", 12, 10, FestivalABM.getInstancia().traer(1), 200, 12, "h2bc34", 20);
		//UnidadDeVentaABM.getinstancia().agregarFoodTruck("Ian´s Burguer", 12, 10, FestivalABM.getInstancia().traer(1), 200, 12, "ina2a2", 20);
		
		
		
	}

}