package test;
import java.time.LocalDate;
import org.hibernate.Session;
import dao.HibernateUtil;
import datos.Festival;
import datos.UnidadDeVenta;
import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.UnidadDeVentaABM;
public class TestTizi {

	public static void main(String[] args) throws Exception{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK");
		/*
		FestivalABM.getInstancia().agregar("Feria de las naciones", "Primavera" ,LocalDate.now(), LocalDate.now());
        FestivalABM.getInstancia().agregar("Feria del libro", "Verano" ,LocalDate.now(), LocalDate.now());
		//FestivalABM.getInstancia().eliminar(2);
		UnidadDeVentaABM.getinstancia().agregarFoodTruck("Taquitos al pastor", 12, 10, FestivalABM.getInstancia().traer(1), 200, 12, "h2bc34", 20);
		UnidadDeVentaABM.getinstancia().agregarFoodTruck("Ian´s Burguer", 12, 10, FestivalABM.getInstancia().traer(2), 200, 12, "ina2a2", 20);
		
		*/
		
		Festival festival = FestivalABM.getInstancia().traer(1);

		UnidadDeVenta unidad = UnidadDeVentaABM.getInstancia().traer(1);
		
		
		
		System.out.println("El costo total de la Unidad de Venta es: " + UnidadDeVentaABM.getInstancia().calcularCostoTotal(festival,unidad));
		
		
		System.out.println("NUEVA CONSULTA REALIZADA");
		
		System.out.println("El total de cajeros en la Unidad de Venta en los distintos turnos son: " + UnidadDeVentaABM.getInstancia().cantidadCajerosPorTurno(festival));
		
		
	}

}