package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cajero;
import negocio.PersonalABM;

public class TestTomy {

	public static void main(String[] args) {

		//Cajero cajero= new Cajero("Jorge", "Benavidez", 30123456, LocalDate.of(2004,2,2), LocalDate.of(2004, 2, 2), 1000, LocalTime.of(10, 0), LocalTime.of(18, 30),"Noche" ); 
		//System.out.print(cajero.getHoraEntrada());
		
		//PersonalABM.getInstancia().agregar("Jorge", "Benavidez", 30123456, LocalDate.of(2004,2,2), LocalDate.of(2004, 2, 2), 1000, LocalTime.of(10, 0), LocalTime.of(18, 30),"Noche");;
		
		System.out.println(PersonalABM.getInstancia().traerCajeros());
	}

}
