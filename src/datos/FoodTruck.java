package datos;

public class FoodTruck extends UnidadDeVenta {
	private String patente;
	private float usoElectricidad;
	
	public FoodTruck() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FoodTruck(String nombreComercial, float superficie, int codigo, Festival festival,
			float sueldoBase, float costoPorSuperficie, String patente, float usoElectricidad) {
		super(nombreComercial, superficie, codigo, festival,sueldoBase, costoPorSuperficie);
		this.patente = patente;
		this.usoElectricidad = usoElectricidad;
	}



	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public float getUsoElectricidad() {
		return usoElectricidad;
	}

	public void setUsoElectricidad(float usoElectricidad) {
		this.usoElectricidad = usoElectricidad;
	}

	@Override
	public String toString() {
		return " nombreComercial=" + nombreComercial + ", superficie=" + superficie + ", codigo="
				+ codigo +  ", sueldoBase=" + sueldoBase + ", costoPorSuperficie="
				+ costoPorSuperficie +" FoodTruck [patente=" + patente + ", usoElectricidad=" + usoElectricidad +"]";
	}
	
	
}
