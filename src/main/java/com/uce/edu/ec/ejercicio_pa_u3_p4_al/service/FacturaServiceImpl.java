package com.uce.edu.ec.ejercicio_pa_u3_p4_al.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.IFacturaRepository;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.DetalleFactura;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Factura;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService{
    @Autowired
    IFacturaRepository facturaRepository;

    @Override
    public void agregar(List<Producto> listPro, String cedCliente) {

        Factura factura = new Factura();
		DetalleFactura detalleFactura= new DetalleFactura();

		detalleFactura.setFactura(factura);
		detalleFactura.setCantidad(listPro.size());
        List<BigDecimal> list = new ArrayList<>();
        int con = 0;
        BigDecimal sum = new BigDecimal(0);
        for (Producto producto : listPro) {
            list.add(con, producto.getPrecio());
            con++;
            sum = sum.add(producto.getPrecio());
        }
        detalleFactura.setPrecioUnitario(list);
        detalleFactura.setSubtotal(sum);
		factura.setCedulaCliente(cedCliente);
		factura.setFecha(LocalDate.now());
        factura.setDetalleFactura(detalleFactura);
        factura.setTotalFactura(sum);
        this.facturaRepository.insertar(factura);




        
    }


}
