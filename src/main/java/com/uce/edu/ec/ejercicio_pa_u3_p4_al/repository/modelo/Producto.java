package com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "producto")
@Entity
public class Producto {
    @GeneratedValue(generator = "seq_producto", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto",allocationSize = 1)
    @Id
    @Column(name = "pro_id")
    private Integer id;
    @Column(name = "pro_codigo_barras")
    private String codigoBarras;
    @Column(name = "pro_nombre")
    private String nombre;
    @Column(name = "pro_categoria")
    private String categoria;
    @Column(name = "pro_stock")
    private Integer stock;
    @Column(name = "pro_precio")
    private BigDecimal precio;
    @OneToMany(mappedBy = "producto")
    private List<DetalleFactura> listDetalleFactura;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public List<DetalleFactura> getListDetalleFactura() {
        return listDetalleFactura;
    }
    public void setListDetalleFactura(List<DetalleFactura> listDetalleFactura) {
        this.listDetalleFactura = listDetalleFactura;
    }
    @Override
    public String toString() {
        return "Producto [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", categoria="
                + categoria + ", stock=" + stock + ", precio=" + precio + "]";
    }
    
}
