package com.metaphorce.shopall.services;

import com.metaphorce.shopall.exception.InvalidProductoDataException;
import com.metaphorce.shopall.repository.ProductoRepository;
import com.metaphorce.shopall.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new InvalidProductoDataException("Producto no encontrado con id: " + id));
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id)
                .orElseThrow(() -> new InvalidProductoDataException("Producto no encontrado con id: " + id));

        existingProducto.setNombre(producto.getNombre());
        existingProducto.setPrecio(producto.getPrecio());
        existingProducto.setCantidad(producto.getCantidad());

        return productoRepository.save(existingProducto);
    }

    public void deleteProducto(Long id) {
        Producto existingProducto = productoRepository.findById(id)
                .orElseThrow(() -> new InvalidProductoDataException("Producto no encontrado con id: " + id));

        productoRepository.delete(existingProducto);
    }
}
