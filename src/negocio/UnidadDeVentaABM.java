package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.UnidadDeVentaDao;
import datos.Cajero;
import datos.Festival;
import datos.FoodTruck;
import datos.Pedido;
import datos.Personal;
import datos.Plato;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;

public class UnidadDeVentaABM {
	private static UnidadDeVentaABM instancia = null;

	protected UnidadDeVentaABM() {
	}

	public static UnidadDeVentaABM getInstancia() {
		if (instancia == null) {
			instancia = new UnidadDeVentaABM();
		}
		return instancia;
	}

	public List<UnidadDeVenta> traer() {
		return UnidadDeVentaDao.getInstancia().traer();
	}

	public UnidadDeVenta traer(int idUnidadDeVenta) {
		return UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);
	}

	public List<UnidadDeVenta> traerFoodTruck() {
		List<UnidadDeVenta> unidadDeVenta = UnidadDeVentaDao.getInstancia().traer();
		List<UnidadDeVenta> foodTruck = new ArrayList<>();
		for (UnidadDeVenta u : unidadDeVenta) {
			if (u instanceof FoodTruck) {
				foodTruck.add(u);
			}
		}
		return foodTruck;
	}

	public List<UnidadDeVenta> traerPuestoDesarmable() {
		List<UnidadDeVenta> unidadDeVenta = UnidadDeVentaDao.getInstancia().traer();
		List<UnidadDeVenta> puestoDesarmable = new ArrayList<>();
		for (UnidadDeVenta u : unidadDeVenta) {
			if (u instanceof PuestoDesarmable) {
				puestoDesarmable.add(u);
			}
		}
		return puestoDesarmable;
	}

	public int agregarFoodTruck(String nombreComercial, float superficie, int codigo, Festival festival, float sueldoBase, float costoPorSuperficie, String patente, float usoElectricidad) {
		return UnidadDeVentaDao.getInstancia().agregar(new FoodTruck(nombreComercial, superficie, codigo, festival, sueldoBase, costoPorSuperficie, patente, usoElectricidad));
	}

	public int agregarPuestoDesarmable(String nombreComercial, float superficie, int codigo, Festival festival, float sueldoBase, float costoPorSuperficie, int cantidadCarpas, int tiempoMontaje, float costoPorMontaje) {
		return UnidadDeVentaDao.getInstancia().agregar(new PuestoDesarmable(nombreComercial, superficie, codigo, festival, sueldoBase, costoPorSuperficie, cantidadCarpas, tiempoMontaje, costoPorMontaje));
	}

	public void eliminar(int idUnidadDeVenta) {
		UnidadDeVenta u = UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);
		UnidadDeVentaDao.getInstancia().eliminar(u);
	}

	public List<UnidadDeVenta> traerFestivalYUnidadDeVenta(float superficie) throws Exception {
		
     
        return UnidadDeVentaDao.getInstancia().traerFestivalYUnidadDeVenta(superficie);
    }
	
	public float calcularCostoTotal(int idUnidadDeVenta) {

	    UnidadDeVenta u = UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);

	    float costoTotal = 0;

	    costoTotal = u.getSueldoBase() + u.getCostoPorSuperficie();

	    if (u instanceof FoodTruck) {

	        FoodTruck foodTruck = (FoodTruck) u;

	        costoTotal += foodTruck.getUsoElectricidad();

	    }

	    if (u instanceof PuestoDesarmable) {

	        PuestoDesarmable puestoDesarmable = (PuestoDesarmable) u;

	        costoTotal += puestoDesarmable.getCostoPorMontaje();

	    }

	    return costoTotal;
	}


	public Map<String, Integer> cantidadCajerosPorTurno(int idUnidadDeVenta) {

	    UnidadDeVenta u = UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);

	    Map<String, Integer> cantidadPorTurno = new HashMap<>();

	    for (Personal p : u.getPersonal()) {

	        if (p instanceof Cajero) {

	            Cajero cajero = (Cajero) p;

	            String turno = cajero.getTurno();

	            if (cantidadPorTurno.containsKey(turno)) {

	                cantidadPorTurno.put(turno, cantidadPorTurno.get(turno) + 1);

	            } else {

	                cantidadPorTurno.put(turno, 1);

	            }
	        }
	    }

	    return cantidadPorTurno;
	}

	
	public List<FoodTruck> traerFoodTrucksQueRequierenElectricidad(){
		return UnidadDeVentaDao.getInstancia().traerFoodTrucksQueRequierenElectricidad();
	}
	

		return cantidadPorTurno;
	}

	public List<UnidadDeVenta> traerUnidadesPorFestival(int idFestival) throws Exception {
		return UnidadDeVentaDao.getInstancia().traerUnidadesPorFestival(idFestival);
	}
	
	public List<PuestoDesarmable> traerPuestosConTiempoMontajeMayorA(int tiempoLimite) throws Exception {
	    return UnidadDeVentaDao.getInstancia().traerPuestosConTiempoMontajeMayorA(tiempoLimite);
	}
	
	public float calcularIngresosDeUnidadDeVenta(int idUnidadDeVenta) {
		UnidadDeVenta unidadDeVenta= UnidadDeVentaDao.getInstancia().traer(idUnidadDeVenta);
		float ingresos=0;
		for( Pedido pedido: unidadDeVenta.getPedido()) {
			for(Plato plato: pedido.getPlatos()) {
				ingresos+=plato.getPrecioVenta(); 
			}
			
		}
		
		return ingresos;
	}
	
	
}