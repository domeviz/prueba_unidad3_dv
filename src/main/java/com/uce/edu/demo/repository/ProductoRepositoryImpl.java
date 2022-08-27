package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=: datoCodigoBarras", Producto.class);
		query.setParameter("datoCodigoBarras", codigoBarras);
		return query.getSingleResult();
	}

	@Override
	public List<Producto> consultarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createNativeQuery("SELECT * FROM producto WHERE prod_codigo_barras = :datoCodigoBarras", Producto.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		return (List<Producto>) myQuery.getResultList();
	}

}
