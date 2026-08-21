package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;

public abstract class Dao<T> {

	private Class<T> clasePersistente;
	protected static Session session;
	protected Transaction tx;

	@SuppressWarnings("unchecked")
	protected Dao() {
		this.clasePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Class<T> getClasePersistente() {
		return clasePersistente;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public List<T> traer() {
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from :clase", clasePersistente)
						.setParameter("clase", clasePersistente.getName()).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	protected List<T> traerPorHQL(String hql) {
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from :clase", clasePersistente)
						.setParameter("clase", clasePersistente.getName()).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public T traer(long idObjeto) {
		T objeto = null;
		try {
			iniciaOperacion();
			objeto = (T) session.get(clasePersistente, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}

	public void eliminar(T objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public int agregar(T objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = (int) session.save(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(T objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
}