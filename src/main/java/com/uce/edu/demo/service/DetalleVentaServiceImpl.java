package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	@Autowired
	private IDetalleVentaRepository iDetalleVentaRepository;

	@Override
	public void insertar(DetalleVenta detalle) {
		// TODO Auto-generated method stub
		this.iDetalleVentaRepository.insertar(detalle);
	}

	@Override
	public DetalleVenta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iDetalleVentaRepository.buscar(id);
	}
}
