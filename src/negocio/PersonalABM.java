package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

import dao.PersonalDao;
import datos.Cajero;
import datos.Personal;

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
	
	public Personal traer(long idPersonal) {
		return PersonalDao.getInstancia().traer(idPersonal);
	}
	
	public int agregar(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase, LocalTime horaEntrada, LocalTime horaSalida, String turno) {
		return PersonalDao.getInstancia().agregar(new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso,sueldoBase, horaEntrada,horaSalida, turno));
	}
}
