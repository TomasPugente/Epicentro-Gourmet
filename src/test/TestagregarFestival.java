package test;
import java.time.LocalDate;
import negocio.FestivalABM;

public class TestagregarFestival {

	public static void main(String[] args) {
		FestivalABM.getInstancia().agregar("Feria de las Naciones", "Primavera", LocalDate.now(), LocalDate.now());

	}

}
