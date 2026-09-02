package dao;
import java.util.List;

import datos.Festival;
import datos.Plato;
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
	
	
	public List<UnidadDeVenta> traerFestivalYUnidadDeVenta(float superficie) throws Exception {
        List<UnidadDeVenta> lista = null;
        try {
            iniciaOperacion();
            String hql = "from UnidadDeVenta u join fetch u.festival where u.superficie <= :superficie";
            lista = session.createQuery(hql, UnidadDeVenta.class)
                    .setParameter("superficie", superficie)
                    .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
	
}
