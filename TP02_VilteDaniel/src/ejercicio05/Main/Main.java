package ejercicio05.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ejercicio05.model.*;

public class Main {

	public static void main(String[] args) {
		
		int op=0;
		Scanner scan = new Scanner(System.in);
		
		// Precargado de Productos
		ArrayList<Producto> arr = new ArrayList<>();
		 	arr.add(new Producto("1", "Jabon para baño", 50, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS));
		 	arr.add(new Producto("2", "Telefono Celular", 1000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA));
		 	arr.add(new Producto("3", "Computador", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA));
		 	arr.add(new Producto("4", "Lavaropas", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR));
		 	arr.add(new Producto("5", "Martillo", 750, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS));
		 	arr.add(new Producto("6", "Clavos", 200, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS));
		 	arr.add(new Producto("7", "Povadora", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS));
		 	arr.add(new Producto("8", "Laptop", 3500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA));
		 	arr.add(new Producto("9", "Cargador de Celular", 500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA));
		 	arr.add(new Producto("10", "Cable de Cargador", 250, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA));
		 	arr.add(new Producto("11", "Limpiador Automatico", 2500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR));
		 	arr.add(new Producto("12", "Aeromatizante", 1500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR));
		 	arr.add(new Producto("13", "TV", 3500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR));
		 	arr.add(new Producto("14", "Juegos", 900, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA));
		 	arr.add(new Producto("15", "Procesador", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA));
		//
		
		do {
			System.out.println("----- MENU -----");
			System.out.println("1- Mostrar Productos");
			System.out.println("2- Realizar compra");
			System.out.println("3- Salir");
			op=scan.nextInt();
			
			switch(op) {
				case 1: System.out.println("----- Listado de Productos -----");
					for (Producto i : arr) {
						i.MostrarDatos();
						System.out.println("----------------");
					}
				break;
				case 2: System.out.println("----- Carrito -----");
					scan.nextLine();
					boolean continuar = true, agregado = false, valido = false;
					double total = 0;
					int opc = 0;
					ArrayList<Producto> carrito = new ArrayList<Producto>();
				
					System.out.println("----- Productos Disponibles");
					for (Producto i : arr) {
						i.MostrarDatos();
						System.out.println("----- * -----");
					}
					while(continuar) {
						agregado = false;
						
						if(!carrito.isEmpty()) {
							System.out.println("-- Carrito");
							for (Producto i : carrito) {
								i.MostrarDatos();
								System.out.println("");
							}
							System.out.println("");
						}
					
						System.out.println("Total dentro del carrito: $"+total);
						System.out.print("Ingrese codigo del producto ('N' si quiere parar): ");
						String codigo= scan.nextLine();
					
						for(Producto i : arr) {
							if(i.getCodigo().equals(codigo)) {
								total += i.getPrecioUnitario();
								carrito.add(i);
								agregado = true;
								System.out.println("--Producto Agregado al Carrito--");
							}
						}
						if(!agregado && !codigo.equals("N")) {
							System.out.println("No se encontro el producto");
						}
						
						if(codigo.equalsIgnoreCase("N")) {
							continuar = false;
						}
					}
				
					while (!valido) {
						System.out.println("-- Metodos de Pago");
						System.out.println("1- Pago Efectivo.");
						System.out.println("2- Pago con tarjeta.");
						try {
							System.out.print("Elija un metodo de pago: ");
							opc = scan.nextInt();
							scan.nextLine();
							if(opc>=1 && opc <=2) {
								valido = true;
							}else {
								System.out.println("Opcion Invalida");
							}
						} catch (InputMismatchException e) {
							System.out.println("Ingrese un numero");
							scan.nextLine();
						}
					}
				
					switch(opc) {
						case 1:
							PagoEfectivo efectivo = new PagoEfectivo(total, LocalDate.now());
							efectivo.realizarPago(total);
							efectivo.imprimirRecibo();
							break;
						case 2:
							System.out.print("Ingrese el numero de tarjeta: ");
							String numTarjeta = scan.nextLine();
							PagoTarjeta tarjeta = new PagoTarjeta(numTarjeta, LocalDate.now(), total);
							tarjeta.realizarPago(total);
							tarjeta.imprimirRecibo();
							break;
						}
						
						System.out.println("El pago se realizo correctamente");
					break;
				case 3: System.out.println("Programa Finalizado.");
				break;
				default: System.out.println("--- Esta no es una opcion ---");
				break;
			}
			
		} while (op!=3);
	}

}
