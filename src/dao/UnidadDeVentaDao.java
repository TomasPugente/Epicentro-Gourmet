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
	
	
}
