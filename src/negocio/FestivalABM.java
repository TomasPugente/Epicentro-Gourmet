package negocio;
import java.time.LocalDate;

import dao.FestivalDAO;
import datos.Festival;

public class FestivalABM {

	private static FestivalABM instancia = null;
	protected FestivalABM() {
		
	}
	
	public static FestivalABM getInstancia() {
		if(instancia==null) {
			instancia = new FestivalABM();
		}
		
		return instancia;
	}
	
	public int agregar(String nombre, String temporada,LocalDate fechainicio, LocalDate fechafin) {
		return FestivalDAO.getinstancia().agregar(new Festival(nombre,temporada,fechainicio,fechafin));
	}
	
	
	
}
