package com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;

public interface IProductoRepository {
    public void insertar(Producto producto);
    public Producto seleccionarPorCodBarras(String codigoBarras);
    public void actualizarPorCodBarras(Producto producto);

}
