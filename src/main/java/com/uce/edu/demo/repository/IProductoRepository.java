package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void insertar(Producto producto);
	
	public Producto buscar(String codigoBarras);
	
	public void actualizar(Producto producto);
	
	public List<Producto> consultarStock(String codigoBarras);
	
}
