package model;

public class Automovil {

	private int codigoAutomovil;
	private String marca;
	private String modelo; 	 
	private String anioFabricacion;	
	private String pais;
	private String color;	
	private boolean esAutomatico;	
	private double precio;
	private String cantidadAsientos;	
	private String tipoCombustible;
	private Integer stockActual;
	private Integer stockMinimo;	
	private Integer stockMaximo;	
	private boolean estado;
	
	
	public Automovil() {
	}

	public Automovil(int codigoAutomovil, String marca, String modelo, String anioFabricacion, String pais,
			String color, boolean esAutomatico, double precio, String cantidadAsientos, String tipoCombustible,
			Integer stockActual, Integer stockMinimo, Integer stockMaximo, boolean estado) {
		this.codigoAutomovil = codigoAutomovil;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.pais = pais;
		this.color = color;
		this.esAutomatico = esAutomatico;
		this.precio = precio;
		this.cantidadAsientos = cantidadAsientos;
		this.tipoCombustible = tipoCombustible;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.estado = estado;
	}

	public int getCodigoAutomovil() {
		return codigoAutomovil;
	}

	public void setCodigoAutomovil(int codigoProducto) {
		this.codigoAutomovil = codigoProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isEsAutomatico() {
		return esAutomatico;
	}

	public void setEsAutomatico(boolean esAutomatico) {
		this.esAutomatico = esAutomatico;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(String cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public Integer getStockActual() {
		return stockActual;
	}

	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}

	public Integer getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public Integer getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(Integer stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
}
