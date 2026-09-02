package test;
import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.Session;
import dao.HibernateUtil;
import negocio.FestivalABM;
import negocio.UnidadDeVentaABM;
import negocio.PersonalABM;
import negocio.PersonalABM;
public class TestTizi {

	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		
		//FestivalABM.getInstancia().agregar("Feria de las naciones", "Primavera" ,LocalDate.now(), LocalDate.now());
        //FestivalABM.getInstancia().agregar("Feria del libro", "Verano" ,LocalDate.now(), LocalDate.now());
		//FestivalABM.getInstancia().eliminar(2);
		//UnidadDeVentaABM.getinstancia().agregarFoodTruck("Taquitos al pastor", 12, 10, FestivalABM.getInstancia().traer(1), 200, 12, "h2bc34", 20);
		//UnidadDeVentaABM.getinstancia().agregarFoodTruck("Ian´s Burguer", 12, 10, FestivalABM.getInstancia().traer(1), 200, 12, "ina2a2", 20);
		
		
		
		//System.out.println(FestivalABM.getInstancia().traer(1));
		
		//PersonalABM.getInstancia().agregar("Jorge", "Benavidez", 30123456, LocalDate.of(2004,2,2), LocalDate.of(2004, 2, 2), 1000,null,LocalTime.of(10, 0), LocalTime.of(18, 30),"Noche");;

		
		
		System.out.println(PersonalABM.getInstancia().traerCajerosTurnoNoche());
		
		
	}

}