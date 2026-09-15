package dao;

import java.util.List;
import org.hibernate.HibernateException;

import datos.PuestoDesarmable;
import datos.UnidadDeVenta;
import datos.Festival;
import datos.FoodTruck;

public class UnidadDeVentaDao extends Dao<UnidadDeVenta> {
	private static UnidadDeVentaDao instancia = null;

	public UnidadDeVentaDao() {
		super();
	}
	
	public static UnidadDeVentaDao getInstancia() {
		if(instancia == null) {
			instancia = new UnidadDeVentaDao();
		}
		return instancia;
	}
	
	public List<UnidadDeVenta> traerFestivalYUnidadDeVenta(float superficie) throws Exception {
        List<UnidadDeVenta> lista = null;
        try {
            iniciaOperacion();
            String hql = "from UnidadDeVenta u join fetch u.festival where u.superficie <= :superficie";
            lista = session.createQuery(hql, UnidadDeVenta.class)
                    .setParameter("superficie", superficie)
                    .getResultList();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            session.close();
        }
        return lista;
    }
	
	
	public List<FoodTruck> traerFoodTrucksQueRequierenElectricidad() throws HibernateException {
		List<FoodTruck> lista = null;
		try {
		iniciaOperacion();

		    String hql = "from FoodTruck f where f.usoElectricidad > 0";

		    lista = session.createQuery(hql, FoodTruck.class)
		            .getResultList();

		} finally {
		    session.close();
		}

		return lista;

	
}
	
	//caso de uso: uno a muchos
	@SuppressWarnings("unchecked")
	public List<UnidadDeVenta> traerUnidadesPorFestival(int idFestival) throws Exception {
	    List<UnidadDeVenta> lista = null;
	    try {
	        iniciaOperacion();
	        String hql = "select distinct u from UnidadDeVenta u " +
	                     "join fetch u.festival f " +
	                     "left join fetch u.personal " +
	                     "where f.idfestival = :idFestival";
	        lista = session.createQuery(hql)
	                       .setParameter("idFestival", idFestival)
	                       .list();
	    } catch (HibernateException e) {
	        manejaExcepcion(e);
	    } finally {
	        session.close();
	    }
	    return lista;
	}
	
	//correccion herencia: festival, tiempo desde, tiempo hasta
	@SuppressWarnings("unchecked")
	public List<PuestoDesarmable> traerPuestosDesarmables(Festival festival, int tiempoDesde, int tiempoHasta) throws Exception {
	    List<PuestoDesarmable> lista = null;
	    try {
	        iniciaOperacion();
	        String hql = "from PuestoDesarmable p where p.festival = :festival "
	                   + "and p.tiempoMontaje between :tiempoDesde and :tiempoHasta";
	        
	        lista = session.createQuery(hql)
	                       .setParameter("festival", festival)
	                       .setParameter("tiempoDesde", tiempoDesde)
	                       .setParameter("tiempoHasta", tiempoHasta)
	                       .list();
	    } catch (HibernateException e) {
	        manejaExcepcion(e);
	    } finally {
	        session.close();
	    }
	    return lista;
	}
}
