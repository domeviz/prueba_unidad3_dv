package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.service.IGestorMegaSantaMaria;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class PruebaUnidad3DvApplication implements CommandLineRunner{

	private static final Logger LOG= Logger.getLogger(PruebaUnidad3DvApplication.class);
	
	@Autowired
	private IGestorMegaSantaMaria iGestorMegaSantaMaria;
	
	@Autowired
	private IProductoService iProductoService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3DvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("Prueba Unidad 3");
		
		Producto p=new Producto();
		p.setNombre("Pan cacero");
		p.setCodigoBarras("333");
		p.setPrecio(new BigDecimal(1));
		p.setStock(20);
		p.setCategoria("Panes");
		this.iProductoService.insertar(p);
		
		LOG.info("Se ha insertado el producto "+p);
		
		ProductoSencillo pSencillo=new ProductoSencillo();
		pSencillo.setCantidad(40);
		pSencillo.setCodigoBarras("111");
		
		List<ProductoSencillo> detalles= new ArrayList<ProductoSencillo>();
		detalles.add(pSencillo);
		
		this.iGestorMegaSantaMaria.realizarVenta(detalles, "12345", "1");
		LOG.info("Venta realizada");
		
		Producto prod=this.iProductoService.buscar("111");
		LOG.info("Producto encontrado"+prod);
		
		List<Producto> lista=this.iGestorMegaSantaMaria.consultarStock("111");
		
		for (Producto i : lista) {
			LOG.debug("Productos encontrados: " + i);
		}
	}

}
