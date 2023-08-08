package com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository;


import org.springframework.stereotype.Repository;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Factura factura) {
        this.entityManager.persist(factura);
    }
    
}
