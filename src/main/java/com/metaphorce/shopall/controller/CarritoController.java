package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.models.Carrito;
import com.metaphorce.shopall.services.CarritoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carritos")
@Tag(name="Carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getAllCarritos() {
        return carritoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> getCarritoById(@PathVariable Long id) {
        Optional<Carrito> carrito = carritoService.findById(id);
        return carrito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrito createCarrito(@RequestBody Carrito carrito) {
        return carritoService.save(carrito);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> updateCarrito(@PathVariable Long id, @RequestBody Carrito carritoDetails) {
        Optional<Carrito> carrito = carritoService.findById(id);
        if (carrito.isPresent()) {
            Carrito updatedCarrito = carrito.get();
            updatedCarrito.setUsuario(carritoDetails.getUsuario());
            updatedCarrito.setTotal(carritoDetails.getTotal());
            return ResponseEntity.ok(carritoService.save(updatedCarrito));
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrito(@PathVariable Long id) {
        carritoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
