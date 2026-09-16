package dao;
import java.util.List;

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

    public List<Personal> traerPersonalDeUnidadDeVentaEnFestival(int idUnidadDeVenta, int idFestival) throws Exception {

        List<Personal> lista = null;

        try {
            iniciaOperacion();

            String hql = "SELECT DISTINCT p " +
                         "FROM UnidadDeVenta u " +
                         "JOIN u.personal p " +
                         "WHERE u.idUnidadDeVenta = :idUnidadDeVenta " +
                         "AND u.festival.idfestival = :idFestival";

            lista = session.createQuery(hql, Personal.class)
                    .setParameter("idUnidadDeVenta", idUnidadDeVenta)
                    .setParameter("idFestival", idFestival)
                    .getResultList();

        } finally {
            session.close();
        }

        return lista;
    }
    public List<Personal> traerPersonalPorSueldoMenor(float sueldo) throws Exception {

        List<Personal> lista = null;

        try {

            iniciaOperacion();

            String hql = "from Personal c where c.sueldoBase <= :sueldo";

            lista = session.createQuery(hql, Personal.class)
                    .setParameter("sueldo", sueldo)
                    .getResultList();

        } finally {

            session.close();

        }

        return lista;
    }


}
