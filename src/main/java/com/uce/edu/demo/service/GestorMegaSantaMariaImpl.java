package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Service
public class GestorMegaSantaMariaImpl implements IGestorMegaSantaMaria {

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IVentaService iVentaService;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(Producto producto, Integer stock) {
		// TODO Auto-generated method stub
		this.iProductoService.ingresarConStock(producto, stock);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ProductoSencillo> detalles, String cedula, String numeroVenta) {
		// TODO Auto-generated method stub

		List<String> listaCodigos= new ArrayList<>();
		for (ProductoSencillo pS : detalles) {
			listaCodigos.add(pS.getCodigoBarras());
		}
		
		this.iVentaService.procesarVenta(cedula, numeroVenta, listaCodigos);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		this.iVentaService.reporteVentas(fecha, categoria, cantidad);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<Producto> consultarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoService.consultarStock(codigoBarras);
	}

}
