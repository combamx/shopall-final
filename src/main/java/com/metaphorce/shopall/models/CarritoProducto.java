package com.metaphorce.shopall.models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "carrito_productos")
public class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    private Integer cantidad;

    // Getters y Setters

    @Override
    public String toString() {
        return "CarritoProducto{" +
                "id=" + id +
                ", carrito=" + carrito +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
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
}