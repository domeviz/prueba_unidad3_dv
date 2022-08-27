package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

public class VentaSencilla {

	private LocalDateTime fecha;
	private String categoria;
	private Integer cantidad;
	
	public VentaSencilla() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VentaSencilla(LocalDateTime fecha, String categoria, Integer cantidad) {
		super();
		this.fecha = fecha;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}
	
	//GET Y SET
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
