package model;

public class Automovil {

	private int codigoProducto;
	private String marca;
	private double modelo; 	 
	private Integer anioFabricacion;	
	private String pais;
	private String color;	
	private boolean esAutomatico;	
	private double precio;
	private Integer cantidadAsientos;	
	private String tipoCombustible;
	private Integer stockActual;
	private Integer stockMinimo;	
	private Integer stockMaximo;	
	private boolean estado;
	
	public Automovil(int codigoProducto, String marca, double modelo, Integer anioFabricacion, String pais,
			String color, boolean esAutomatico, double precio, Integer cantidadAsientos, String tipoCombustible,
			Integer stockActual, Integer stockMinimo, Integer stockMaximo, boolean estado) {
		this.codigoProducto = codigoProducto;
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

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getModelo() {
		return modelo;
	}

	public void setModelo(double modelo) {
		this.modelo = modelo;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
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

	public Integer getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(Integer cantidadAsientos) {
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
