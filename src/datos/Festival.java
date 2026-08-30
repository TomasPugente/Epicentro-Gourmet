package datos;
import java.time.LocalDate;
import java.util.Objects;

public class Festival {
	private int idfestival;
	private String nombre;
	private String temporada;
	private LocalDate fechainicio;
	private LocalDate fechafin;
	
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
	
	
	
	
	
	
}
