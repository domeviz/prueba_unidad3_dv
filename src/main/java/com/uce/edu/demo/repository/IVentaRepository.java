package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.repository.modelo.VentaSencilla;

public interface IVentaRepository {

	public void insertar(Venta venta);

	public Venta buscar(Integer id);

	public void actualizar(Venta venta);

	public List<VentaSencilla> reporte(LocalDateTime fecha, String categoria, Integer cantidad);
}
