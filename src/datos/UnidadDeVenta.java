package datos;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public abstract class UnidadDeVenta {
	protected int idUnidadDeVenta;
	protected String nombreComercial;
	protected float superficie;
	protected int codigo;
	protected Set<Personal> personal= new HashSet<>();
	protected Set<Pedido> pedido;
	protected Set<Plato> plato;
	
	protected float sueldoBase;
	protected float costoPorSuperficie;
	
	public UnidadDeVenta() {
		super();
	}

	public UnidadDeVenta( String nombreComercial, float superficie, int codigo,
			 float sueldoBase, float costoPorSuperficie) {
		super();
		this.nombreComercial = nombreComercial;
		this.superficie = superficie;
		this.codigo = codigo;
		this.sueldoBase = sueldoBase;
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public int getIdUnidadDeVenta() {
		return idUnidadDeVenta;
	}

	public void setIdUnidadDeVenta(int idUnidadDeVenta) {
		this.idUnidadDeVenta = idUnidadDeVenta;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Set<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(Set<Personal> personal) {
		this.personal = personal;
	}
	
	public Set<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}

	public Set<Plato> getPlato() {
		return plato;
	}

	public void setPlato(Set<Plato> plato) {
		this.plato = plato;
	}
	
	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public float getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(float costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(codigo), Float.valueOf(costoPorSuperficie), Long.valueOf(idUnidadDeVenta),
				nombreComercial, personal, Float.valueOf(sueldoBase), Float.valueOf(superficie));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadDeVenta other = (UnidadDeVenta) obj;
		return codigo == other.codigo
				&& Float.floatToIntBits(costoPorSuperficie) == Float.floatToIntBits(other.costoPorSuperficie)
				&& idUnidadDeVenta == other.idUnidadDeVenta && Objects.equals(nombreComercial, other.nombreComercial)
						&&Objects.equals(personal, other.personal)
				&& Float.floatToIntBits(sueldoBase) == Float.floatToIntBits(other.sueldoBase)
				&& Float.floatToIntBits(superficie) == Float.floatToIntBits(other.superficie);
	}

	@Override
	public String toString() {
		return "UnidadDeVenta [nombreComercial=" + nombreComercial
				+ ", superficie=" + superficie + ", codigo=" + codigo + ", personal=" + personal +", sueldoBase="
				+ sueldoBase + ", costoPorSuperficie=" + costoPorSuperficie + "]";
	}
	
	
	
}
