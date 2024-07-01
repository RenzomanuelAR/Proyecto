package model;

public class Almacen {
	private int codigoAlmacen;
	private String fechaRegistro;
	private int codigoAutomovil;
	private int cantidadIngreso;
	private String nombreUsuario;
	private boolean anulado;
	
	public Almacen() {

	}
	
	public Almacen(int codigoAlmacen, String fechaRegistro, int codigoAutomovil, int cantidadIngreso, String nombreUsuario,
			boolean anulado) {
		this.codigoAlmacen = codigoAlmacen;
		this.fechaRegistro = fechaRegistro;
		this.codigoAutomovil = codigoAutomovil;
		this.cantidadIngreso = cantidadIngreso;
		this.nombreUsuario = nombreUsuario;
		this.anulado = anulado;
	}

	public int getCodigoAlmacen() {
		return codigoAlmacen;
	}

	public void setCodigoAlmacen(int codigoAlmacen) {
		this.codigoAlmacen = codigoAlmacen;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}

	public void setCodigoAutomovil(int codigoAutomovil) {
		this.codigoAutomovil = codigoAutomovil;
	}

	public int getCantidadIngreso() {
		return cantidadIngreso;
	}

	public void setCantidadIngreso(int cantidadIngreso) {
		this.cantidadIngreso = cantidadIngreso;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public boolean isAnulado() {
		return anulado;
	}

	public void setAnulado(boolean anulado) {
		this.anulado = anulado;
	}
	
	
	
}
