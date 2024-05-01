package ejercicio04.Model;

import java.time.LocalDate;
import java.time.Period;

import ejercicio04.Constantes.*;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechanac;
	private String Nacionalidad;
	private double estatura;
	private double peso;
	private Posicion pos;
	
	
	
	public Jugador(String nombre, String apellido, LocalDate fechanac, String nacionalidad, double estatura,
			double peso, Posicion pos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanac = fechanac;
		Nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.pos = pos;
	}



	public int edad() {
		LocalDate actual = LocalDate.now();
		Period dif = Period.between(fechanac, actual);
		
		int ans = dif.getYears();
		
		return ans;
	}
	
	public void MostrarDatos() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("Fecha de Nacimiento: "+fechanac);
		System.out.println("Edad: "+this.edad());
		System.out.println("Nacionalidad: "+Nacionalidad);
		System.out.println("Estatura: "+estatura);
		System.out.println("Peso: "+peso);
		System.out.println("Posicion: "+pos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	
}
