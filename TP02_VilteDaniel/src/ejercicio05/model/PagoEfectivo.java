package ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ejercicio05.Interfaces.Pago;

public class PagoEfectivo implements Pago{
	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	public void realizarPago(double monto) {
		this.montoPagado = monto - (monto * 0.1);
	}
	
	public void imprimirRecibo() {
		
		DateTimeFormatter aux = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("-- Recibo del Pago en Efectivo");
		System.out.println("Fecha en que se realizo el pago: "+this.fechaPago.format(aux));
		System.out.println("Monto Total: $"+this.montoPagado);
		
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
}