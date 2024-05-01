package ejercicio03.Main;

import java.util.ArrayList;
import ejercicio03.Constantes.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provincias[] arr = Provincias.values();
		
		for (Provincias i : arr) {
			System.out.println("Pronvicia: "+i);
			System.out.println("Poblacion: "+i.getPoblacion());
			System.out.println("Superficie: "+i.getSuperficie());
			System.out.println("Densidad Poblacionanl de la Provincia: "+i.Densidad());
			System.out.println();
		}
	}

}
