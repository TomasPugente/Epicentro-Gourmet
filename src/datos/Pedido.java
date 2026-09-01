package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido {
	private int idPedido;
	private LocalDate fechaTransaccion;
	private UnidadDeVenta unidadDeVenta;
	private Set<Plato> platos = new HashSet<>();

	// Constructor vacío
	public Pedido() {
		super();
	}

	// Constructor con parámetros (sin el id para cuando se persiste por autoincrement)
	public Pedido(LocalDate fechaTransaccion, UnidadDeVenta unidadDeVenta) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.unidadDeVenta = unidadDeVenta;
	}

	// Getters y Setters
	public int getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaTransaccion, idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return idPedido == other.idPedido && Objects.equals(fechaTransaccion, other.fechaTransaccion);
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
}