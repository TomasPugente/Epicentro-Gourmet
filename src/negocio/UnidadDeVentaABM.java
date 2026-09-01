package negocio;

import dao.UnidadDeVentaDao;
import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;


public class UnidadDeVentaABM {
	private static UnidadDeVentaABM instancia = null;
	protected UnidadDeVentaABM() {
		
	}
	public static UnidadDeVentaABM getinstancia() {
		if(instancia==null) {
			instancia= new UnidadDeVentaABM();
		}
		return instancia;
	}
	
	public UnidadDeVenta traer(long idUnidadDeVenta) {
		return UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);
	}
	
	public int agregarFoodTruck(String nombreComercial, float superficie, int codigo, Personal personal,/*Pedido pedido, Plato plato,*/ float sueldoBase, float costoPorSuperficie, String patente, float usoElectricidad) {
		return UnidadDeVentaDao.getInstancia().agregar(new FoodTruck(nombreComercial, superficie, codigo, personal/*, null, null*/, sueldoBase, costoPorSuperficie, patente, usoElectricidad));
	}
	
	public int agregarPuestoDesarmable(String nombreComercial, float superficie, int codigo, Personal personal,/*Pedido pedido, Plato plato,*/ float sueldoBase, float costoPorSuperficie, int cantidadCarpas, int tiempoMontaje, float costoPorMontaje) {
		return UnidadDeVentaDao.getInstancia().agregar(new PuestoDesarmable(nombreComercial, superficie, codigo, personal,/* null, null,*/ sueldoBase, costoPorSuperficie, cantidadCarpas, tiempoMontaje, costoPorMontaje));
	}
	
}
