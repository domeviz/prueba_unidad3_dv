package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public Producto buscar(String codigoBarras);
	
	public void ingresarConStock(Producto producto, Integer stock);
	
	public List<Producto> consultarStock(String codigoBarras);
}
