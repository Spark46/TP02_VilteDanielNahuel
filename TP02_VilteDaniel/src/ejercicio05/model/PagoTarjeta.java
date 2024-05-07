package ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ejercicio05.Interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String NumTarjeta;
	private LocalDate FechaPago;
	private double MontoPagado;

	public PagoTarjeta(String NumTarjeta, LocalDate FechaPago, double MontoPagado) {
		this.NumTarjeta = NumTarjeta;
		this.FechaPago = FechaPago;
		this.MontoPagado = MontoPagado;
	}

	public void realizarPago(double monto) {
		this.MontoPagado = monto + (monto * 0.15);
	}

	public void imprimirRecibo() {
		
		DateTimeFormatter aux = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("--Recibo del Pago con Tarjeta--");
		System.out.println("Numero de la Tarjeta utilizada: " + this.NumTarjeta);
		System.out.println("Fecha en que se realizo el Pago: " + this.FechaPago.format(aux));
		System.out.println("Monto Total: $" + this.MontoPagado);
		
	}

	public String getNumTarjeta() {
		return NumTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		NumTarjeta = numTarjeta;
	}

	public LocalDate getFechaPago() {
		return FechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		FechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return MontoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		MontoPagado = montoPagado;
	}

}