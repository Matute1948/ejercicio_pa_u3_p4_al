package com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{
    @PersistenceContext 
    private EntityManager entityManager;

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Producto producto) {
        this.entityManager.persist(producto);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Producto seleccionarPorCodBarras(String codigoBarras) {
        String jpql = "SELECT p FROM Producto p WHERE p.codigoBarras =:datoCodigo";
        TypedQuery<Producto> mTypedQuery = this.entityManager.createQuery(jpql, Producto.class);
        mTypedQuery.setParameter("datoCodigo",codigoBarras);
        try{
            return mTypedQuery.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
        
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void actualizarPorCodBarras(Producto producto) {
        String jpql = "UPDATE Producto p SET p.stock = :datoStock WHERE p.codigoBarras = :datoCodigo";
        TypedQuery<Producto> mTypedQuery = this.entityManager.createQuery(jpql, Producto.class);
        mTypedQuery.setParameter("datoCodigo",producto.getCodigoBarras());
        mTypedQuery.setParameter("datoStock",producto.getStock());
    }
    
}
