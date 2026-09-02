package datos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Cajero extends Personal {
	
	private LocalTime horaEntrada;
	private LocalTime horaSalida;
	private String turno;
	
	public Cajero() {
		super();
	}

	public Cajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase,UnidadDeVenta unidadDeVenta, LocalTime horaEntrada, LocalTime horaSalida, String turno) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase,unidadDeVenta);
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.turno = turno;
	}


	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(horaEntrada, horaSalida, turno);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cajero other = (Cajero) obj;
		return Objects.equals(horaEntrada, other.horaEntrada) && Objects.equals(horaSalida, other.horaSalida)
				&& Objects.equals(turno, other.turno);
	}
	
	
	
	
	
}
