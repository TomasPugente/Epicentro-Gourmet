package dao;
import datos.Festival;

public class FestivalDAO extends Dao<Festival> {
	private static FestivalDAO instancia = null;
	
	private FestivalDAO() {
		super();
	}
	
	public static FestivalDAO getinstancia() {
		if(instancia==null) {
			instancia = new FestivalDAO();
		}
		
		return instancia;
	}
	
	
	
	
}
