package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscar(codigoBarras);
	}

	@Override
	public void ingresarConStock(Producto producto, Integer stock) {
		// TODO Auto-generated method stub
		Producto p1 = this.iProductoRepository.buscar(producto.getCodigoBarras());
		p1.setStock(producto.getStock() + stock);
		this.iProductoRepository.actualizar(p1);
	}

	@Override
	public List<Producto> consultarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.consultarStock(codigoBarras);
	}
	
}
