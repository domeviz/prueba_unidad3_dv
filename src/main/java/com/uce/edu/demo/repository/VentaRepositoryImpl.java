package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.repository.modelo.VentaSencilla;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(venta);
	}

	@Override
	public Venta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Venta.class, id);
	}

	@Override
	public void actualizar(Venta venta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(Venta.class);
	}

	@Override
	public List<VentaSencilla> reporte(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<VentaSencilla> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.VentaSencilla(v.fecha, v.categoria, v.cantidad) FROM Venta v WHERE v.fecha = :datoFecha AND v.cantidad > :datoCantidad",
				VentaSencilla.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoCantidad", cantidad);
		return myQuery.getResultList();
	}

}
