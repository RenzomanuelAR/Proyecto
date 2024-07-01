package model;

import gui.MenuPrincipal;

public class Venta {
	private int codigoVenta;
	private int codigoCliente;
	private int codigoAutomovil;
	private int cantidad;
	private	double precio;
	private String fecha;
	private boolean anulado;
	
	public Venta() {

	} 
	public Venta(int codigoVenta, int codigoCliente, int codigoAutomovil, int cantidad, double precio, String fecha) {
		this.codigoVenta = codigoVenta;
		this.codigoCliente = codigoCliente;
		this.codigoAutomovil = codigoAutomovil;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}
	public void setCodigoAutomovil(int codigoAutomovil) {
		this.codigoAutomovil = codigoAutomovil;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isAnulado() {
		return anulado;
	}
	public void setAnulado(boolean anulado) {
		this.anulado = anulado;
	}
	public double getImporte() {
		return this.precio * this.cantidad;
	}
	public double getDescuento() {
		double pordescuento =0;
		if(this.precio>= 20000 && this.precio<30000) {
			pordescuento = 0.017;
		}else if(this.precio>= 30000 && this.precio<40000){
			pordescuento = 0.027;
		}else if(this.precio>= 40000){
			pordescuento = 0.037;
		}	
		return pordescuento * this.getImporte();
	}	
	public double getImporteMenosDescuento() {
		return this.getImporte() - this.getDescuento();
	}

	public double getIgv() {
		return (this.getImporte() - this.getDescuento()) * MenuPrincipal.IMPUESTO;
	}



	public double getTotal() {
		return this.getImporteMenosDescuento() + this.getIgv();

	}
}
