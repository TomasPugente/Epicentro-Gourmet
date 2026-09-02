package dao;
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
<<<<<<< Updated upstream
=======
	
	public List<Personal> traerPersonalPorSueldo(float sueldo) {
	    try {
	        iniciaOperacion();

	        List<Personal> lista = session
	                .createQuery(
	                    "from Personal p where p.sueldoBase > :sueldo",
	                    Personal.class
	                )
	                .setParameter("sueldo", sueldo)
	                .getResultList();

	        session.close();

	        return lista;

        } finally {
            session.close();
        }
	}

>>>>>>> Stashed changes
}
