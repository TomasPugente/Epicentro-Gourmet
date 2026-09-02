package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Cocinero extends Personal {

	private String especialidad;
	private float plusPorCategoria;
	
	public Cocinero() {
		super();
	}

	public Cocinero(String especialidad, float plusPorCategoria) {
		super();
		this.especialidad = especialidad;
		this.plusPorCategoria = plusPorCategoria;
	}

	public Cocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase,UnidadDeVenta unidadDeVenta, String especialidad, float plusPorCategoria) {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase,unidadDeVenta);
		this.especialidad = especialidad;
		this.plusPorCategoria = plusPorCategoria;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public float getPlusPorCategoria() {
		return plusPorCategoria;
	}

	public void setPlusPorCategoria(float plusPorCategoria) {
		this.plusPorCategoria = plusPorCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(especialidad, plusPorCategoria);
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
		Cocinero other = (Cocinero) obj;
		return Objects.equals(especialidad, other.especialidad)
				&& Float.floatToIntBits(plusPorCategoria) == Float.floatToIntBits(other.plusPorCategoria);
	}

	

	
	
	
	
	
	
	
}
