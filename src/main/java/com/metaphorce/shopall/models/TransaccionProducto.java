package com.metaphorce.shopall.models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "transaccion_productos")
public class TransaccionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    private Integer cantidad;

    @NotNull
    private BigDecimal precio;

    // Getters y Setters

    @Override
    public String toString() {
        return "TransaccionProducto{" +
                "id=" + id +
                ", transaccion=" + transaccion +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public @NotNull Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(@NotNull Integer cantidad) {
        this.cantidad = cantidad;
    }

    public @NotNull BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull BigDecimal precio) {
        this.precio = precio;
    }
}
