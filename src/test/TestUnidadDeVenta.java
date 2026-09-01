package test;


import datos.UnidadDeVenta;
import datos.PuestoDesarmable;
import datos.FoodTruck;
import dao.UnidadDeVentaDao;
import negocio.UnidadDeVentaABM;
public class TestUnidadDeVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnidadDeVentaABM.getinstancia().agregarFoodTruck("Lo de tito", 05, 1234,null, 15000, 505, "Esta",605);
	}

}
