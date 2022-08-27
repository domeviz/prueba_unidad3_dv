package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IGestorMegaSantaMaria {

	public void ingresarProducto(Producto producto, Integer stock);

	public void realizarVenta(List<ProductoSencillo> detalles, String cedula, String numeroVenta);

	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);

	public List<Producto> consultarStock(String codigoBarras);
}
