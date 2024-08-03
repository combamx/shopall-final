package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.models.CarritoProducto;
import com.metaphorce.shopall.services.CarritoProductoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrito-productos")
@Tag(name="Carrito de productos")
public class CarritoProductoController {

    @Autowired
    private CarritoProductoService carritoProductoService;

    @GetMapping
    public List<CarritoProducto> getAllCarritoProductos() {
        return carritoProductoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoProducto> getCarritoProductoById(@PathVariable Long id) {
        Optional<CarritoProducto> carritoProducto = carritoProductoService.findById(id);
        return carritoProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarritoProducto createCarritoProducto(@RequestBody CarritoProducto carritoProducto) {
        return carritoProductoService.save(carritoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoProducto> updateCarritoProducto(@PathVariable Long id, @RequestBody CarritoProducto carritoProductoDetails) {
        Optional<CarritoProducto> carritoProducto = carritoProductoService.findById(id);
        if (carritoProducto.isPresent()) {
            CarritoProducto updatedCarritoProducto = carritoProducto.get();
            updatedCarritoProducto.setCarrito(carritoProductoDetails.getCarrito());
            updatedCarritoProducto.setProducto(carritoProductoDetails.getProducto());
            updatedCarritoProducto.setCantidad(carritoProductoDetails.getCantidad());
            return ResponseEntity.ok(carritoProductoService.save(updatedCarritoProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarritoProducto(@PathVariable Long id) {
        carritoProductoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
