package datos;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Festival {
	private int idfestival;
	private String nombre;
	private String temporada;
	private LocalDate fechainicio;
	private LocalDate fechafin;
	private Set<UnidadDeVenta> unidadDeVenta;
	
	public Festival() {
		super();
	}

	public Festival(String nombre, String temporada, LocalDate fechainicio, LocalDate fechafin) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}

	public int getIdfestival() {
		return idfestival;
	}

	public void setIdfestival(int idfestival) {
		this.idfestival = idfestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(LocalDate fechainicio) {
		this.fechainicio = fechainicio;
	}

	public LocalDate getFechafin() {
		return fechafin;
	}

	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
	}
	
	public Set<UnidadDeVenta> getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(Set<UnidadDeVenta> unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechafin, fechainicio, idfestival, nombre, temporada);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		return Objects.equals(fechafin, other.fechafin) && Objects.equals(fechainicio, other.fechainicio)
				&& idfestival == other.idfestival && Objects.equals(nombre, other.nombre)
				&& Objects.equals(temporada, other.temporada);
	}

	@Override
	public String toString() {
		return "Festival [idfestival=" + idfestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechainicio=" + fechainicio + ", fechafin=" + fechafin + ", unidadDeVenta=" + unidadDeVenta + "]";
	}
	
	


	
	
	
	
	
}
