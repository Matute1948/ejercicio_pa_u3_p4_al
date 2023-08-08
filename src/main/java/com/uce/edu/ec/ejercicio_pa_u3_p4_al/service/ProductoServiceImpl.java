package com.uce.edu.ec.ejercicio_pa_u3_p4_al.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.IProductoRepository;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    @Transactional(value = TxType.REQUIRED)
    public void agregar(Producto producto) {
        Producto p = this.buscarPorCodBarras(producto.getCodigoBarras());
        if(p == null){
            this.productoRepository.insertar(producto);
        }else{
            Integer stock = p.getStock();
            p.setStock(stock+producto.getStock());
            this.actualizarPorCodBarras(p);
        }
        
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public Producto buscarPorCodBarras(String codigoBarras) {
        return this.productoRepository.seleccionarPorCodBarras(codigoBarras);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void actualizarPorCodBarras(Producto producto) {
        this.productoRepository.actualizarPorCodBarras(producto);
    }
    
}
