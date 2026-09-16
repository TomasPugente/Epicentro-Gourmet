package dao;
import datos.Festival;
import datos.Pedido;
import datos.Plato;
import org.hibernate.HibernateException;

import java.time.LocalDate;
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
	
	
	public List<Object[]> traerFestivalesConMayorCantidadDeVentas(LocalDate fechaInicio, LocalDate fechaFin) {

	    List<Object[]> lista = null;

	    try {

	        iniciaOperacion();

	        String hql =
	                "SELECT f, COUNT(p) " +
	                "FROM Festival f " +
	                "JOIN f.unidadDeVenta u " +
	                "JOIN u.pedido p " +
	                "WHERE f.fechainicio >= :fechaInicio " +
	                "AND f.fechafin <= :fechaFin " +
	                "GROUP BY f " +
	                "ORDER BY COUNT(p) DESC";

	        lista = session.createQuery(hql, Object[].class)
	                .setParameter("fechaInicio", fechaInicio)
	                .setParameter("fechaFin", fechaFin)
	                .setMaxResults(3)
	                .getResultList();

	    } finally {

	        session.close();

	    }

	    return lista;
	}
	
	

	
}
	
