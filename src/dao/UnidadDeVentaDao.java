package dao;
import datos.UnidadDeVenta;

public class UnidadDeVentaDao extends Dao<UnidadDeVenta> {
	private static UnidadDeVentaDao instancia =null;

	public UnidadDeVentaDao() {
		super();
	}
	
	public static UnidadDeVentaDao getInstancia() {
		if(instancia==null) {
			instancia = new UnidadDeVentaDao();
		}
		return instancia;
	}
	
	public UnidadDeVenta traerUnidadDeVentaYFestival(long idFestival) {
	    try {
	        iniciaOperacion();

	        UnidadDeVenta unidad = session.createQuery(
	                "from UnidadDeVenta u " +
	                "join fetch u.festival f " +
	                "where f.idFestival = :idFestival",
	                UnidadDeVenta.class)
	                .setParameter("idFestival", idFestival)
	                .uniqueResult();

	        session.close();

	        return unidad;

        } finally {
            session.close();
        }
	}
}
