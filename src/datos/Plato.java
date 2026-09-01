package datos;

import java.util.Objects;

public class Plato {
	private int idPlato;
	private String nombre;
	private float precioVenta;
	private float costoProduccion;
	private Pedido pedido;
	private UnidadDeVenta unidadDeVenta;

	// Constructor vacío
	public Plato() {
		super();
	}

	// Constructor con parámetros
	public Plato(String nombre, float precioVenta, float costoProduccion, Pedido pedido) {
		super();
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
		this.pedido = pedido;
	}

	// Getters y Setters
	public int getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costoProduccion, idPlato, nombre, precioVenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		return Float.floatToIntBits(costoProduccion) == Float.floatToIntBits(other.costoProduccion)
				&& idPlato == other.idPlato && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(precioVenta) == Float.floatToIntBits(other.precioVenta);
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precioVenta=" + precioVenta
				+ ", costoProduccion=" + costoProduccion + "]";
	}
}