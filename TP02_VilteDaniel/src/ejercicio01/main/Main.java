package ejercicio01.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ejercicio01.model.Producto;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> lista = new ArrayList<>();
		int op;
		Scanner scan = new Scanner(System.in);
		do {
			menu();
			op = scan.nextInt();
			switch(op) {
				case 1: System.out.println("----- Crear Producto -----");
					System.out.print("Ingrese el codigo: ");
					int codigo = scan.nextInt();
					scan.nextLine(); // limpiar buffer
					System.out.print("Ingrese una descripcion: ");
					String descripcion = scan.nextLine();
					int precio=0;
					do {
						System.out.print("Ingrese un precio unitario (un numero entero positivo): ");
						precio = scan.nextInt();
					} while (precio<0);
					
					Producto.OrigenFabricacion origen = Producto.OrigenFabricacion.ARGENTINA;
					int op1=0;
					do {
						System.out.println("--- Origen de Fabricacion---");
						System.out.println("1. Argentina");
						System.out.println("2. China");
						System.out.println("3. Brasil");
						System.out.println("4. Uruguay");
						System.out.print("Elija una opcion: ");
						op1 = scan.nextInt();
					} while (op1<0 && op1>5);
					
					switch(op1) {
						case 1: origen = Producto.OrigenFabricacion.ARGENTINA; break;
						case 2: origen = Producto.OrigenFabricacion.CHINA; break;
						case 3: origen = Producto.OrigenFabricacion.BRASIL; break;
						case 4: origen = Producto.OrigenFabricacion.URUGUAY; break;
					}
					
					int op2=0;
					Producto.Categoria cat = Producto.Categoria.TELEFONIA;;
					
					do {
						System.out.println("--- Categoria ---");
						System.out.println("1. Telefonia");
						System.out.println("2. Informatica");
						System.out.println("3. Electro Hogar");
						System.out.println("4. Herramientas");
						System.out.print("Elija una opcion: ");
						op2 = scan.nextInt();
					} while (op2<0 && op2>5);
					
					switch(op2) {
						case 1: cat = Producto.Categoria.TELEFONIA; break;
						case 2: cat = Producto.Categoria.INFORMATICA; break;
						case 3: cat = Producto.Categoria.ELECTROHOGAR; break;
						case 4: cat = Producto.Categoria.HERRAMIENTAS; break;
					}
					
					Producto prod = new Producto(codigo, descripcion, precio, origen, cat);
					
					lista.add(prod);
					
					System.out.println("Se agrego el producto correctamente!");
					break;
				case 2: System.out.println("--- Mostrar Productos ---");
					for (int i = 0; i < lista.size(); i++) {
						Producto elemento = lista.get(i);
						System.out.println("Elemento N°" + (i + 1) + ": ");
						elemento.MostrarDatos();
						System.out.println("-------------------------");
					}
					break;
				case 3: System.out.println("----- Cambiar Datos ------");
					System.out.println("Ingrese el codigo del producto a modificar: ");
					int camb = scan.nextInt();
					
					Iterator<Producto> it = lista.iterator();
					int pos=0;
					scan.nextLine(); // limpiar buffer
					while (it.hasNext()) {
						Producto aux = it.next();
						if (aux.getCodigo() == camb) {
							
							System.out.print("Ingrese una descripcion: ");
							String descripcion2 = scan.nextLine();
							
							int precio2=0;
							do {
								System.out.print("Ingrese un precio unitario (un numero entero positivo): ");
								precio2 = scan.nextInt();
							} while (precio2>0);
							
							Producto.OrigenFabricacion origen2 = Producto.OrigenFabricacion.ARGENTINA;
							int op12=0;
							do {
								System.out.println("--- Origen de Fabricacion---");
								System.out.println("1. Argentina");
								System.out.println("2. China");
								System.out.println("3. Brasil");
								System.out.println("4. Uruguay");
								System.out.print("Elija una opcion: ");
								op12 = scan.nextInt();
							} while (op12<0 && op12>5);
							
							switch(op12) {
								case 1: origen2 = Producto.OrigenFabricacion.ARGENTINA; break;
								case 2: origen2 = Producto.OrigenFabricacion.CHINA; break;
								case 3: origen2 = Producto.OrigenFabricacion.BRASIL; break;
								case 4: origen2 = Producto.OrigenFabricacion.URUGUAY; break;
							}
							
							int op22=0;
							Producto.Categoria cat2 = Producto.Categoria.TELEFONIA;;
							
							do {
								System.out.println("--- Categoria ---");
								System.out.println("1. Telefonia");
								System.out.println("2. Informatica");
								System.out.println("3. Electro Hogar");
								System.out.println("4. Herramientas");
								System.out.print("Elija una opcion: ");
								op22 = scan.nextInt();
							} while (op22<0 && op22>5);
							
							switch(op22) {
								case 1: cat2 = Producto.Categoria.TELEFONIA; break;
								case 2: cat2 = Producto.Categoria.INFORMATICA; break;
								case 3: cat2 = Producto.Categoria.ELECTROHOGAR; break;
								case 4: cat2 = Producto.Categoria.HERRAMIENTAS; break;
							}
							
							Producto prod2 = new Producto(camb, descripcion2, precio2, origen2, cat2);
							
							lista.set(pos, prod2);
							
							break;
						}
						pos++;
					}
					break;
				case 4: System.out.println("Programa Finalizado."); break;
				
				default : System.out.println("Esta no es una opcion");
			}
		} while (op!=4);
	}
	
	public static void menu() {
		System.out.println("----- MENU -----");
		System.out.println("1. Crear Producto");
		System.out.println("2. Mostrar Productos");
		System.out.println("3. Modificar Productos (solo puede modificar: descripcion, precio unitario, origen fabricacion o categoria)");
		System.out.println("4. Salir");
	}
	
}
