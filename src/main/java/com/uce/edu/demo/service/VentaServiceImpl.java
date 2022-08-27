package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepository iVentaRepository;
	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.iVentaRepository.insertar(venta);
	}

	@Override
	public Venta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iVentaRepository.buscar(id);
	}

	@Override
	public void actualizar(Venta venta) {
		// TODO Auto-generated method stub
		this.iVentaRepository.actualizar(venta);
	}

	@Override
	public void procesarVenta(String cedula, String numeroFactura, List<String> listaCodigos) {
		// TODO Auto-generated method stub
		BigDecimal totalPagar = BigDecimal.ZERO;
		
		Venta v= new Venta();
		v.setCedulaCliente(cedula);
		v.setFecha(LocalDateTime.now());
		v.setNumero(numeroFactura);
		
		List<DetalleVenta> detalles = new ArrayList<>();
		
		for (String codProd : listaCodigos) {
			DetalleVenta d = new DetalleVenta();
			d.setCantidad(1);
			d.setVenta(v);
			Producto producto = this.iProductoRepository.buscar(codProd);
			if(producto.getStock()<=d.getCantidad()) {
				d.setCantidad(producto.getStock());
			} else if(producto.getStock()==0) {
				throw new RuntimeException();
			}
			d.setProducto(producto);
			d.setSubtotal(d.getProducto().getPrecio());
			totalPagar.add(d.getSubtotal());
			producto.setStock(producto.getStock() - d.getCantidad());
			this.iProductoRepository.actualizar(producto);
			detalles.add(d);
			
		}

		v.setDetalles(detalles);
		v.setTotalVenta(totalPagar);
		
		this.iVentaRepository.insertar(v);
		
	}

	@Override
	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		this.iVentaRepository.reporte(fecha, categoria, cantidad);
	}

}
