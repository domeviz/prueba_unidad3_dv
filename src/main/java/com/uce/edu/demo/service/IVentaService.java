package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaService {

	public void insertar(Venta venta);

	public Venta buscar(Integer id);

	public void actualizar(Venta venta);
	
	public void procesarVenta(String cedula, String numeroFactura, List<String> listaCodigos);
	
	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);
}
