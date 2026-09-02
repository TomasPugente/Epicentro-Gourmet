package datos;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Personal {
	protected int idPersonal;
	protected String nombre;
	protected String apellido;
	protected int dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected float sueldoBase;
	protected UnidadDeVenta unidadDeVenta;
	
	public Personal() {
		super();
	}

	public Personal(String nombre, String apellido, int dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, float sueldoBase,UnidadDeVenta unidadDeVenta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
		this.unidadDeVenta= unidadDeVenta;
	}

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idpersonal) {
		this.idPersonal = idpersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;	
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	

	public UnidadDeVenta getUnidadDeVenta() {
		return unidadDeVenta;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidadDeVenta) {
		this.unidadDeVenta = unidadDeVenta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, Integer.valueOf(dni), fechaIngreso, fechaNacimiento, Long.valueOf(idPersonal),
				nombre, Float.valueOf(sueldoBase));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personal other = (Personal) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni
				&& Objects.equals(fechaIngreso, other.fechaIngreso)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && idPersonal == other.idPersonal
				&& Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(sueldoBase) == Float.floatToIntBits(other.sueldoBase);
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase="
				+ sueldoBase + ", unidadDeVenta=" + unidadDeVenta + "]";
	}


	
	
	
	
	
}
