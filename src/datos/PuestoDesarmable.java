package datos;

public class PuestoDesarmable extends UnidadDeVenta {
	private int cantidadCarpas;
	private int tiempoMontaje;
	private float costoPorMontaje;
	
	public PuestoDesarmable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PuestoDesarmable( String nombreComercial, float superficie, int codigo, Festival festival,
		  float sueldoBase, float costoPorSuperficie,
			int cantidadCarpas, int tiempoMontaje, float costoPorMontaje) {
		super(nombreComercial, superficie, codigo, festival,sueldoBase,
				costoPorSuperficie);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempoMontaje = tiempoMontaje;
		this.costoPorMontaje = costoPorMontaje;
	}

	public int getCantidadCarpas() {
		return cantidadCarpas;
	}

	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}

	public int getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	public float getCostoPorMontaje() {
		return costoPorMontaje;
	}

	public void setCostoPorMontaje(float costoPorMontaje) {
		this.costoPorMontaje = costoPorMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [cantidadCarpas=" + cantidadCarpas + ", tiempoMontaje=" + tiempoMontaje
				+ ", costoPorMontaje=" + costoPorMontaje + ", idUnidadDeVenta=" + idUnidadDeVenta + ", nombreComercial="
				+ nombreComercial + ", superficie=" + superficie + ", codigo=" + codigo + ", personal=" + personal
				+ ", pedido=" + pedido + ", plato=" + plato + ", sueldoBase=" + sueldoBase
				+ ", costoPorSuperficie=" + costoPorSuperficie + "]";
	}

	
	
	
	
	
	
	
	
}
