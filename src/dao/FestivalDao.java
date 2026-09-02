package dao;
import datos.Festival;

public class FestivalDao extends Dao<Festival> {
	private static FestivalDao instancia = null;
	
	private FestivalDao() {
		super();
	}
	
	public static FestivalDao getinstancia() {
		if(instancia==null) {
			instancia = new FestivalDao();
		}
		
		return instancia;
	}
	
	
	
	
}