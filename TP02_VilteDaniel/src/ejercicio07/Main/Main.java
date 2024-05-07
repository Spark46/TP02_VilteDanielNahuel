package ejercicio07.Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ejercicio07.Main.Producto;

public class Main {

	public static void menu() {
		System.out.println("----- MENU -----");
		System.out.println("1- Mostrar Datos");
		System.out.println("2- Mostrar los productos faltantes");
		System.out.println("3- Incrementar los precios de los productos en un 20%");
		System.out.println("4- Mostrar los productos que corresponden a la categoria Electrohogar y esten disponibles en venta");
		System.out.println("5- Ordenar los productos por precio de forma descendente");
		System.out.println("6- Mostrar los productos con los nombres en mayusculas");
		System.out.println("7- Salir");
	}
	
	public static void main(String[] args) {

		// Precargado de Productos
				ArrayList<Producto> arr = new ArrayList<>();
				 	arr.add(new Producto("1", "Jabon para baño", 50, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, true));
				 	arr.add(new Producto("2", "Telefono Celular", 1000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, true));
				 	arr.add(new Producto("3", "Computador", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true));
				 	arr.add(new Producto("4", "Lavaropas", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, false));
				 	arr.add(new Producto("5", "Martillo", 750, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, false));
				 	arr.add(new Producto("6", "Clavos", 200, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, true));
				 	arr.add(new Producto("7", "Povadora", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, true));
				 	arr.add(new Producto("8", "Laptop", 3500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, false));
				 	arr.add(new Producto("9", "Cargador de Celular", 500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, false));
				 	arr.add(new Producto("10", "Cable de Cargador", 250, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, true));
				 	arr.add(new Producto("11", "Limpiador Automatico", 2500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, false));
				 	arr.add(new Producto("12", "Aeromatizante", 1500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
				 	arr.add(new Producto("13", "TV", 3500, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, false));
				 	arr.add(new Producto("14", "Juegos", 900, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, false));
				 	arr.add(new Producto("15", "Procesador", 4000, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, true));
		//
		int op=0;
		Scanner scan = new Scanner(System.in);
		
		do {
			menu();
			op=scan.nextInt();
			switch(op) {
				case 1: System.out.println("--- Productos Disponibles ---");
					Consumer<Producto> imprimirSiTrue = objeto -> {
						if (objeto.isDisp()) {
							objeto.MostrarDatos();
						}
					};
					arr.forEach(imprimirSiTrue);
				break;
				case 2: System.out.println("--- Productos NO Disponibles ---");
					Consumer<Producto> imprimirSiFalse = objeto -> {
						if (!objeto.isDisp()) {
							objeto.MostrarDatos();
						}
					};
					arr.forEach(imprimirSiFalse);
				break;
				case 3: System.out.println("--- Incrementar 20% ---");
					 Function<Producto, Producto> IncrementoAux = objeto ->{
						 int aux = (int) (objeto.getPrecioUnitario() * 1.20); 
				            objeto.setPrecioUnitario(aux);
				            return objeto;
					 };
					 List<Producto> arrIncrementado = new ArrayList<>();
					 arr.stream()
					 .map(IncrementoAux).forEach(arrIncrementado::add);
					 
					 
					 arrIncrementado.forEach(objeto -> System.out.println(objeto.getPrecioUnitario()));
				break;
				case 4: System.out.println("-- ElectroHogar --");
					Predicate<Producto> FiltElectHog = producto ->
                	producto.getCategoria() == Producto.Categoria.ELECTROHOGAR && producto.isDisp();

                	arr.stream()
                		.filter(FiltElectHog).forEach(System.out::println);
				break;
				case 5: System.out.println("-- Orden Descendente --");
					arr.sort(Comparator.comparingInt(Producto::getPrecioUnitario).reversed());

		        	arr.forEach(objeto -> System.out.println(objeto.getPrecioUnitario()));
				break;
				case 6: System.out.println("-- Transformar Mayuscula --");
				Function<Producto, Producto> mayuscula = (n) -> {
                    Producto prod = n;
                    prod.setDescripcion(n.getDescripcion().toUpperCase());
                    return prod;
                };
                List<Producto> prodMayus = arr.stream().map(mayuscula).collect(Collectors.toList());
                prodMayus.forEach(Producto::MostrarDatos);
				break;
			}
		} while (op!=7);
		
	}

}
