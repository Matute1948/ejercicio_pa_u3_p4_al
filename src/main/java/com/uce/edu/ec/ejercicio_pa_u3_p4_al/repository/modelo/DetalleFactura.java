package com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Table(name = "detalle_factura")
@Entity
public class DetalleFactura {
    @GeneratedValue(generator = "seq_detalle_factura", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_detalle_factura", sequenceName = "seq_detalle_factura",allocationSize = 1)
    @Id
    @Column(name = "dtf_id")
    private Integer id;
    @Column(name = "dtf_cantidad")
    private Integer cantidad;
    @Column(name = "dtf_precio_unitario")
    private List<BigDecimal> precioUnitario;
    @Column(name = "dtf_subtotal")
    private BigDecimal subtotal;
    @OneToOne
    @JoinColumn(name = "dtf_id_factura")
    private Factura factura;
    @ManyToOne
    @JoinColumn(name = "dtf_id_productos")
    private Producto producto;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<BigDecimal> getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(List<BigDecimal> precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    @Override
    public String toString() {
        return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
                + ", subtotal=" + subtotal + "]";
    }
    
    
}
