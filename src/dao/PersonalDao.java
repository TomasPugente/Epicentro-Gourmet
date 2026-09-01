package dao;
import java.util.List;

import datos.Personal;

public class PersonalDao extends Dao<Personal> {
	private static PersonalDao instancia = null;
	
	private PersonalDao() {
		super();
	}
	
	public static PersonalDao getInstancia() {
		if(instancia==null) {
			instancia= new PersonalDao();
		}
		
		return instancia;
	
	}
	

}
