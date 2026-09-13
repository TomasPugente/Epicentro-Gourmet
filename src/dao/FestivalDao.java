package dao;
import datos.Festival;
import datos.Pedido;
import datos.Plato;
import org.hibernate.HibernateException;
import java.util.ArrayList;
import java.util.List;

import datos.UnidadDeVenta;

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
	
	
	public List<Festival> traerFestivalesConMayorCantidadDeVentas() throws HibernateException {

		List<Festival> lista = null;

		try {

			iniciaOperacion();

			String hql = "SELECT f " +
					"FROM Festival f " +
					"JOIN f.unidadDeVenta u " +
					"JOIN u.pedido p " +
					"GROUP BY f " +
					"HAVING COUNT(p) >= ALL (" +
						"SELECT COUNT(p2) " +
						"FROM Festival f2 " +
						"JOIN f2.unidadDeVenta u2 " +
						"JOIN u2.pedido p2 " +
						"GROUP BY f2" +
					")";

			lista = session.createQuery(hql, Festival.class)
					.getResultList();

		} finally {

			session.close();
		}

		return lista;
	}
	
	

	
}
	
