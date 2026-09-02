package negocio;
import java.time.LocalDate;
import dao.FestivalDao;
import datos.Festival;

public class FestivalABM{

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
		return FestivalDao.getinstancia().agregar(new Festival(nombre,temporada,fechainicio,fechafin));
	}
	
	public Festival traer(int idfestival) {
		return FestivalDao.getinstancia().traer(idfestival);
		}
	
	public void eliminar(int idfestival ) {
		Festival festival = FestivalABM.getInstancia().traer(idfestival);
		FestivalDao.getinstancia().eliminar(festival);
	}
	
}