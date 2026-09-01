package dao;

import java.util.List;
import org.hibernate.HibernateException;
import datos.Plato;

public class PlatoDao extends Dao<Plato> {

	private static PlatoDao instancia;

	public PlatoDao() {}

	public static PlatoDao getInstancia() {
		if (instancia == null) {
			instancia = new PlatoDao();
		}
		return instancia;
	}

	public List<Plato> traerPlatosPorPedido(int idPedido) throws HibernateException {
		List<Plato> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Plato p where p.pedido.idPedido = :idPedido";
			lista = session.createQuery(hql, Plato.class)
					.setParameter("idPedido", idPedido)
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}