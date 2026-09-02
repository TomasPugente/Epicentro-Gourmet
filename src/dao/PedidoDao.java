package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import datos.Pedido;

public class PedidoDao extends Dao<Pedido> {

	private static PedidoDao instancia;

	public PedidoDao() {}

	public static PedidoDao getInstancia() {
		if (instancia == null) {
			instancia = new PedidoDao();
		}
		return instancia;
	}

	public Pedido traerPedidoConPlatos(int idPedido) throws HibernateException {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Pedido p left join fetch p.platos where p.idPedido = :idPedido";
			objeto = (Pedido) session.createQuery(hql)
					.setParameter("idPedido", idPedido)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Pedido> traerPedidosPorUnidadDeVenta(int idUnidadDeVenta) throws HibernateException {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Pedido p where p.unidadDeVenta.idUnidadDeVenta = :idUnidadDeVenta";
			lista = session.createQuery(hql, Pedido.class)
					.setParameter("idUnidadDeVenta", idUnidadDeVenta)
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
    public List<Pedido> traerPorFecha(LocalDate fecha) throws HibernateException {
        List<Pedido> lista = null;
        try {
            iniciaOperacion();
            String hql = "from Pedido p where p.fecha = :fecha";
            lista = session.createQuery(hql, Pedido.class)
                    .setParameter("fecha", fecha)
                    .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
}