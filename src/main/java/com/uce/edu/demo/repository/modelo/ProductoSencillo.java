package com.uce.edu.demo.repository.modelo;

public class ProductoSencillo {

	private String codigoBarras;
	private Integer cantidad;
	
	public ProductoSencillo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductoSencillo(String codigoBarras, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.cantidad = cantidad;
	}
	
	//GET Y SET
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
