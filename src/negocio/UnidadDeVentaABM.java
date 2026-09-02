package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.PersonalDao;
import dao.UnidadDeVentaDao;
import datos.Cajero;
import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;
import datos.Pedido;
import datos.Plato;

public class UnidadDeVentaABM   {
	private static UnidadDeVentaABM instancia = null;
	protected UnidadDeVentaABM() {
		
	}
	public static UnidadDeVentaABM getinstancia() {
		if(instancia==null) {
			instancia= new UnidadDeVentaABM();
		}
		return instancia;
	}
	public List<UnidadDeVenta> traer(){
		return UnidadDeVentaDao.getInstancia().traer();
	}
	
	public UnidadDeVenta traer(int idUnidadDeVenta) {
		return UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);
	}
	
	public List<UnidadDeVenta> traerFoodTruck(){
		List<UnidadDeVenta> unidadDeVenta =UnidadDeVentaDao.getInstancia().traer();
		List<UnidadDeVenta> foodTruck= new ArrayList<>();
		for (UnidadDeVenta u : unidadDeVenta) {
			if(u instanceof FoodTruck)
		    foodTruck.add(u);
		}
		return foodTruck;
	}
	
	public List<UnidadDeVenta> traerPuestoDesarmable(){
		List<UnidadDeVenta> unidadDeVenta =UnidadDeVentaDao.getInstancia().traer();
		List<UnidadDeVenta> puestoDesarmable= new ArrayList<>();
		for (UnidadDeVenta u : unidadDeVenta) {
			if(u instanceof PuestoDesarmable)
		    puestoDesarmable.add(u);
		}
		return puestoDesarmable;
	}
	
	public int agregarFoodTruck(String nombreComercial, float superficie, int codigo, float sueldoBase, float costoPorSuperficie, String patente, float usoElectricidad) {
		return UnidadDeVentaDao.getInstancia().agregar(new FoodTruck(nombreComercial, superficie, codigo, sueldoBase, costoPorSuperficie, patente, usoElectricidad));
	}
	
	public int agregarPuestoDesarmable(String nombreComercial, float superficie, int codigo, float sueldoBase, float costoPorSuperficie, int cantidadCarpas, int tiempoMontaje, float costoPorMontaje) {
		return UnidadDeVentaDao.getInstancia().agregar(new PuestoDesarmable(nombreComercial, superficie, codigo, sueldoBase, costoPorSuperficie, cantidadCarpas, tiempoMontaje, costoPorMontaje));
	}
	
	public void eliminar(int idUnidadDeVenta) {
		UnidadDeVenta u= UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);
		UnidadDeVentaDao.getInstancia().eliminar(u);
	}
	
	public List<UnidadDeVenta> traerFestivalYUnidadDeVenta(float superficie) throws Exception {
		
     
        return UnidadDeVentaDao.getInstancia().traerFestivalYUnidadDeVenta(superficie);
    }

}
