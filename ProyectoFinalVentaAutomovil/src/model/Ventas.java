package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ventas {

	private ArrayList<Venta> listVentas;

	public Ventas() {
		this.listVentas = new ArrayList<Venta>();
	}

	public ArrayList<Venta> getListVentas() {
		return listVentas;
	}

	public void setListVentas(ArrayList<Venta> listVentas) {
		this.listVentas = listVentas;
	}
	
	public void agregar(Venta venta) {
		this.listVentas.add(venta);
	}
	
	public int tamanio() {
		return this.listVentas.size();
	}
	
	public int ultimo() {
		//ordena en forma descendente
        Collections.sort(listVentas, Comparator.comparing(Venta::getCodigoVenta));
        // Obtiene el último venta (el que tiene el código más alto)
        Venta ultimoVenta = listVentas.get(listVentas.size() - 1);
        
        return ultimoVenta.getCodigoVenta();
	}
	public Venta navegarVentas(int posicion) {
		Collections.sort(listVentas, Comparator.comparing(Venta::getCodigoVenta));
        return listVentas.get(posicion);
	}
	
	public boolean actualizar(Venta venta) {
		boolean isActualizado=false;
		for(Venta filaVenta: listVentas) {
			if(filaVenta.getCodigoVenta()==venta.getCodigoVenta()) {
				filaVenta.setCodigoVenta(venta.getCodigoVenta());
				filaVenta.setCodigoCliente(venta.getCodigoCliente());
				filaVenta.setCodigoAutomovil(venta.getCodigoAutomovil());
				filaVenta.setCantidad(venta.getCantidad());
				filaVenta.setPrecio(venta.getPrecio());
				filaVenta.setAnulado(venta.isAnulado());

				isActualizado = true;
				break;
			}
		}
		return isActualizado;
	}
	
	public boolean anular(Venta venta) {
		boolean isAnulado=false;
		for(Venta filaVenta: listVentas) {
			if(filaVenta.getCodigoVenta()==venta.getCodigoVenta()) {
				filaVenta.setAnulado(true);
				isAnulado = true;
				break;
			}
		}
		return isAnulado;
	}
	
	public boolean tieneVentasAutomovil(int codigo) {
		boolean isExsite=false;
		for(Venta filaVenta: listVentas) {
			if(filaVenta.getCodigoAutomovil()==codigo) {
				isExsite = true;
				break;
			}
		}
		return isExsite;
	}
	
	public boolean tieneVentasCliente(int codigo) {
		boolean isExsite=false;
		for(Venta filaVenta: listVentas) {
			if(filaVenta.getCodigoCliente()==codigo) {
				isExsite = true;
				break;
			}
		}
		return isExsite;
	}
	
	public Venta busqueda(int id) {
		for(Venta filaVenta: listVentas) {
			if(filaVenta.getCodigoVenta()==id) {
				return filaVenta;
			}
		}
		return null;
	}
	
	public Double sumaSubTotalVentas() {
		double subTotal=0;
		for (Venta venta:this.listVentas) {
			 subTotal += venta.getImporte();			 
		 }
		return subTotal;
	}
	
	public Double sumaDescuentos() {
		double totalDescuento=0;
		for (Venta venta:this.listVentas) {
			totalDescuento += venta.getDescuento();			 
		 }
		return totalDescuento;
	}
	
	public Double sumaIgv() {
		double totalIgv=0;
		for (Venta venta:this.listVentas) {
			totalIgv += venta.getIgv();			 
		 }
		return totalIgv;
	}
	
	public Double sumaTotal() {
		double totalGeneral=0;
		for (Venta venta:this.listVentas) {
			totalGeneral += venta.getTotal();			 
		 }
		return totalGeneral;
	}
	
	
}
