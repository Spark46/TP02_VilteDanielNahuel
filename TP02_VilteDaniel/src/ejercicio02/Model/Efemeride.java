package ejercicio02.Model;

import ejercicio02.Constantes.*;

public class Efemeride {
	private String codigo;
	private Mes mes;
	private int dia;
	private String detalle;
	
	public void MostrarDatos() {
		System.out.println("Codigo: "+codigo);
		System.out.println("Mes: "+mes);
		System.out.println("Dia: "+dia);
		System.out.println("Detalles: "+detalle);
	}
	
	public Efemeride(String codigo, Mes mes, int dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	public String getCodigo() {
		return codigo;
	}
	
}
