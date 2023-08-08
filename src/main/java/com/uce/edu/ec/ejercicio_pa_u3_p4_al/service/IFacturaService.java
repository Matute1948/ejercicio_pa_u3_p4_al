package com.uce.edu.ec.ejercicio_pa_u3_p4_al.service;

import java.util.List;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Factura;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;

public interface IFacturaService {
    public void agregar(List<Producto> listPro, String cedCliente );
}
