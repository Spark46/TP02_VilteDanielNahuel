package ejercicio02.Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import ejercicio02.Model.*;
import ejercicio02.Constantes.*;

public class Main {
	
	public static void menu() {
		System.out.println("1. Crear efemeride");
		System.out.println("2. Mostrar efemerides");
		System.out.println("3. Eliminar efemeride");
		System.out.println("4. Modificar efemeride");
		System.out.println("5. Salir");
	}
	
	public static int obtenerDiasDelMes(Mes mes) {
	    switch (mes) {
	        case ENERO: 
	        case MARZO: 
	        case MAYO: 
	        case JULIO:
	        case AGOSTO:
	        case OCTUBRE:
	        case DICIEMBRE:
	            return 31;
	        case ABRIL: 
	        case JUNIO:
	        case SEPTIEMBRE:
	        case NOVIEMBRE:
	            return 30;
	        case FEBRERO:
	            return 28; // No se considera el año bisiesto en este ejemplo
	        default:
	            return -1; // Mes no válido
	    }
	}
	
	public static void main(String[] args) {

		ArrayList<Efemeride> arr = new ArrayList<>();
		int op=0;
		Scanner scan = new Scanner(System.in);
		
		do {
			menu();
			System.out.print("Elija una opcion: ");
			op = scan.nextInt();
			switch(op) {
				case 1: System.out.println("----- Ingresar Datos -----");
				
				scan.nextLine(); //Limpiar Buffer
				
				System.out.print("Ingrese el codigo: ");
				String cod = scan.nextLine();
				System.out.print("Ingrese el Mes (1-12): ");
				int aux;
				do {
					aux= scan.nextInt();
				} while (aux<=0 || aux>12);
				Mes mesEntrada;
			    switch (aux) {
		        case 1: mesEntrada=  Mes.ENERO;
		        case 2: mesEntrada=  Mes.FEBRERO;
		        case 3: mesEntrada=  Mes.MARZO;
		        case 4: mesEntrada=  Mes.ABRIL;
		        case 5: mesEntrada=  Mes.MAYO;
		        case 6: mesEntrada=  Mes.JUNIO;
		        case 7: mesEntrada=  Mes.JULIO;
		        case 8: mesEntrada=  Mes.AGOSTO;
		        case 9: mesEntrada=  Mes.SEPTIEMBRE;
		        case 10: mesEntrada=  Mes.OCTUBRE;
		        case 11: mesEntrada=  Mes.NOVIEMBRE;
		        case 12: mesEntrada=  Mes.DICIEMBRE;
		        default: mesEntrada= Mes.ENERO; 
			    }
			    
			    System.out.print("Ingrese el dia (tener en cuenta el mes ingresado anteriormente): ");
			    int diaEntrada;
			    do {
			    	diaEntrada= scan.nextInt();
			    } while (diaEntrada<0 && diaEntrada>obtenerDiasDelMes(mesEntrada));
				
			    scan.nextLine(); // Limpiar Buffer
			    
			    System.out.print("Ingrese los detalles del producto: ");
			    String detallesEntrada= scan.nextLine();
			    
			    Efemeride input = new Efemeride(cod, mesEntrada, diaEntrada, detallesEntrada);
			    
			    arr.add(input);
			    
			    System.out.println("Se agrego correctamente el Efemeride.");
			    System.out.println("---------------------------------------");
			    break;
				case 2: System.out.println("----- Efemerides -----");
					Iterator<Efemeride> it = arr.iterator();
					
					while (it.hasNext()) {
						Efemeride aux2 =  it.next();
						aux2.MostrarDatos();
						System.out.println("-----------------");
					}
					break;
				case 3: System.out.println("----- Eliminar -----");
					System.out.print("Ingrese el codigo del efemeride a eliminar: ");
					String buscar = scan.nextLine();
					
					Iterator<Efemeride> it3 = arr.iterator();
					boolean find=false;
					
					while (it3.hasNext()) {
						Efemeride aux3 =  it3.next();
						if (aux3.getCodigo().equals(buscar)) {
							it3.remove();
							find=true;
							break;
						}
					}
					
					if (find) System.out.println("Se elimino correctamente el elemento");
					else System.out.println("No se encontro el elemento");
					System.out.println("---------------------------------------");
					break;
				case 4: System.out.println("----- Modificar -----");
				
				scan.nextLine(); // Limpiar Buffer
				
				System.out.print("Ingrese el codigo del efemeride a eliminar: ");
				String buscar4 = scan.nextLine();
				
				Iterator<Efemeride> it4 = arr.iterator();
				boolean find4=false;
				int index=0;
				
				while (it4.hasNext()) {
					Efemeride aux4 =  it4.next();
					if (aux4.getCodigo().equals(buscar4)) {
					    find4=true;
					    System.out.println("Encontrado!");
					    break;
					}
					index++;
				}
				
				if (find4) {
					System.out.print("Ingrese el Mes (1-12): ");
					int aux4;
					do {
						aux4= scan.nextInt();
					} while (aux4<=0 || aux4>12);
					Mes mesEntrada4;
				    switch (aux4) {
			        case 1: mesEntrada4=  Mes.ENERO;
			        case 2: mesEntrada4=  Mes.FEBRERO;
			        case 3: mesEntrada4=  Mes.MARZO;
			        case 4: mesEntrada4=  Mes.ABRIL;
			        case 5: mesEntrada4=  Mes.MAYO;
			        case 6: mesEntrada4=  Mes.JUNIO;
			        case 7: mesEntrada4=  Mes.JULIO;
			        case 8: mesEntrada4=  Mes.AGOSTO;
			        case 9: mesEntrada4=  Mes.SEPTIEMBRE;
			        case 10: mesEntrada4=  Mes.OCTUBRE;
			        case 11: mesEntrada4=  Mes.NOVIEMBRE;
			        case 12: mesEntrada4=  Mes.DICIEMBRE;
			        default: mesEntrada4= Mes.ENERO; 
				    }
				    
				    System.out.print("Ingrese el dia (tener en cuenta el mes ingresado anteriormente): ");
				    int diaEntrada4;
				    do {
				    	diaEntrada4= scan.nextInt();
				    } while (diaEntrada4<0 && diaEntrada4>obtenerDiasDelMes(mesEntrada4));
					
				    scan.nextLine(); // Limpiar Buffer
				    
				    System.out.print("Ingrese los detalles del producto: ");
				    String detallesEntrada4= scan.nextLine();
				    
				    Efemeride input4 = new Efemeride(buscar4, mesEntrada4, diaEntrada4, detallesEntrada4);
				
				    arr.set(index, input4);
				    
				    System.out.println("¡Se modifico el elemento correctamente!");
				}
				else System.out.println("No se encontro el elemento");
				System.out.println("---------------------------------------");
				break;
				case 5: System.out.println("Programa Finalizado.");
			}
		} while (op!=5); 
		
	}
	
}
