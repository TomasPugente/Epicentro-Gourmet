package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.PersonalDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Personal;
import datos.UnidadDeVenta;

public class PersonalABM {
	private static PersonalABM instancia = null;
	protected PersonalABM() {
		
		}
	public static PersonalABM getInstancia() {
		if (instancia==null) {
			instancia= new PersonalABM();
		}
		return instancia;
		}
	
	public List<Personal> traer(){
		return PersonalDao.getInstancia().traer();
	}
	
	public List<Personal> traerCajeros(){
		List<Personal> personal =PersonalDao.getInstancia().traer();
		List<Personal> cajeros= new ArrayList<>();
		for (Personal p : personal) {
			if(p instanceof Cajero)
		    cajeros.add(p);
		}
		
		return cajeros;
	}
	
	public List<Personal> traerCocineros(){
		List<Personal> personal =PersonalDao.getInstancia().traer();
		List<Personal> cocineros= new ArrayList<>();
		for (Personal p : personal) {
			if(p instanceof Cocinero)
		    cocineros.add(p);
		}
		
		return cocineros;
	}
	
	public Personal traer(int idPersonal) {
		return PersonalDao.getInstancia().traer(idPersonal);
		}
	
	public List<Personal> traerCajerosTurnoNoche() throws Exception {
		return PersonalDao.getInstancia().traerCajerosTurnoNoche();
	}
	
	
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase,UnidadDeVenta unidadDeVenta, String especialidad, float plusPorCategoria) {
		return PersonalDao.getInstancia().agregar(new Cocinero(nombre, apellido, dni, fechaNacimiento, fechaIngreso,sueldoBase ,unidadDeVenta,especialidad, plusPorCategoria));
		}
	
	
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase,UnidadDeVenta unidadDeVenta, LocalTime horaEntrada, LocalTime horaSalida, String turno) {
		return PersonalDao.getInstancia().agregar(new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso,sueldoBase,unidadDeVenta, horaEntrada,horaSalida, turno));
		}
	
	public void eliminar(Personal personal) {
		PersonalDao.getInstancia().eliminar(personal);
	}
}
