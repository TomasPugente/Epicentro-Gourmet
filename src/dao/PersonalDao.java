package dao;
import java.util.List;

import datos.Personal;
import datos.Cajero;

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
	
	public List<Personal> traerCajerosTurnoNoche() throws Exception {
		 List<Personal> lista = null;
	        try {
	            iniciaOperacion();
	            String hql = "from Cajero c where c.turno = :turno";
	            lista = session.createQuery(hql, Personal.class)
	                    .setParameter("turno", "noche")
	                    .getResultList();
	        } finally {
	            session.close();
	        }
	        return lista;
		
	}
	

}
