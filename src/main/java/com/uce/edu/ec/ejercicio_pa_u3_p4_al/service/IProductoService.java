package com.uce.edu.ec.ejercicio_pa_u3_p4_al.service;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;

public interface IProductoService {
    public void agregar(Producto producto);
    public Producto buscarPorCodBarras(String codigoBarras);
    public void actualizarPorCodBarras(Producto producto);
}
