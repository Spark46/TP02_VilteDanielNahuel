package ejercicio04.Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import ejercicio04.Model.*;
import ejercicio04.Constantes.*;

public class Main {

	public static void menu() {
		System.out.println("1. Alta de Jugador");
		System.out.println("2. Mostrar todos los jugadores");
		System.out.println("3. Modificar la posicion de un jugador");
		System.out.println("4. Eliminar un juegador");
		System.out.println("5. Salir");
		System.out.print("Elija una opcion: ");
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int op=0;
		ArrayList<Jugador> arr = new ArrayList<>();
		
		do {
			menu();
			op = scan.nextInt();
			
			switch (op) {
				case 1: System.out.println("----- Ingrese los Datos -----");
				
					scan.nextLine();//Limpieza del buffer
				
					System.out.print("Ingrese el nombre: ");
					String nombre = scan.nextLine();
					System.out.print("Ingrese el apellido: ");
					String apellido = scan.nextLine();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					System.out.print("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
			        String fechaNacimientoStr = scan.nextLine();
			        LocalDate fechaNacimiento;

			        try {
			            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

			        } catch (DateTimeParseException e) {
			            System.out.println("Error: Formato de fecha incorrecto. Por favor, ingrese la fecha en el formato dd/MM/yyyy.");
			            break;
			        }
			        
			        System.out.print("Ingrese su Nacionalidad: ");
			        String nacionalidad = scan.nextLine();
			        
			        System.out.print("Ingrese su estatura (x,xx): ");
			        double est = scan.nextDouble();
			        
			        System.out.print("Ingrese su peso(xx,x): ");
			        double pes = scan.nextDouble();
			        
			        int op1=0;
			        do {
			        	System.out.println("Elija una posicion:");
			        	System.out.println("1. DELANTERO");
			        	System.out.println("2. MEDIO");
			        	System.out.println("3. DEFENSA");
			        	System.out.println("4. ARQUERO");
			        	op1=scan.nextInt();
			        } while (op1<0 || op1>4);
			        
			        Posicion pos=Posicion.DELANTERO;
			        switch(op1) {
			        case 1: pos=Posicion.DELANTERO; break;
			        case 2: pos=Posicion.MEDIO; break;
			        case 3: pos=Posicion.DEFENSA; break;
			        case 4: pos=Posicion.ARQUERO; break;
			        }
			        
			        Jugador input = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, est, pes, pos);
			        
			        arr.add(input);
			        System.out.println("¡Se agrego correctamente al jugador!");
			        
			        break;
				case 2: System.out.println("----- Jugadores -----");
					Iterator<Jugador> it = arr.iterator();
					
					while (it.hasNext()) {
						Jugador aux = it.next();
						aux.MostrarDatos();
						System.out.println();
					}
					break;
				case 3: System.out.println("----- Modificar -----");
				
					scan.nextLine(); //Limpieza del buffer
				
					System.out.print("Ingrese el nombre: ");
					String nomBuscar = scan.nextLine();
					System.out.println("Ingrese el apellido: ");
					String apellBuscar = scan.nextLine();
					Iterator<Jugador> it3 = arr.iterator();
					boolean find3=true;
					Jugador modificador = null;
					int index=0;
					
					while (it3.hasNext()) {
						Jugador aux = it3.next();
						if (aux.getApellido().equals(apellBuscar) && aux.getNombre().equals(nomBuscar)) {
							find3=true;
							modificador=aux;
							break;
						}
						index++;
					}
					
					if (find3) {
						int op3=0;
				        do {
				        	System.out.println("Elija una posicion:");
				        	System.out.println("1. DELANTERO");
				        	System.out.println("2. MEDIO");
				        	System.out.println("3. DEFENSA");
				        	System.out.println("4. ARQUERO");
				        	op3=scan.nextInt();
				        } while (op3<0 || op3>4);
				        
				        Posicion pos3=Posicion.DELANTERO;
				        switch(op3) {
				        case 1: pos3=Posicion.DELANTERO; break;
				        case 2: pos3=Posicion.MEDIO; break;
				        case 3: pos3=Posicion.DEFENSA; break;
				        case 4: pos3=Posicion.ARQUERO; break;
				        }
				        modificador.setPos(pos3);
				        
				        arr.set(index, modificador);
				        
				        System.out.println("!Se realizo el cambio correctamet¡");
				        
					} else System.out.println("No se encontro un jugador con ese nombre y apellido");
					break;
				case 4: System.out.println("----- Eliminar -----");
				
					scan.nextLine(); //Limpieza del buffer
				
					System.out.print("Ingrese el nombre: ");
					String nomBuscar4 = scan.nextLine();
					System.out.println("Ingrese el apellido: ");
					String apellBuscar4 = scan.nextLine();
					Iterator<Jugador> it4 = arr.iterator();
					boolean find4=true;
					int index4=0;
				
					while (it4.hasNext()) {
						Jugador aux = it4.next();
						if (aux.getApellido().equals(apellBuscar4) && aux.getNombre().equals(nomBuscar4)) {
							it4.remove();
							break;
						}
					}
					
					if (find4) System.out.println("¡Se elimino correctamente al jugador!");
					else System.out.println("No se encontro al jugador");
					
					break;
			}
		} while (op!=5);
		
	}

}
