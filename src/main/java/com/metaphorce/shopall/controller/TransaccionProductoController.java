package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.models.TransaccionProducto;
import com.metaphorce.shopall.services.TransaccionProductoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaccion-productos")
@Tag(name="Transacciones de productos")
public class TransaccionProductoController {

    @Autowired
    private TransaccionProductoService transaccionProductoService;

    @GetMapping
    public List<TransaccionProducto> getAllTransaccionProductos() {
        return transaccionProductoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionProducto> getTransaccionProductoById(@PathVariable Long id) {
        Optional<TransaccionProducto> transaccionProducto = transaccionProductoService.findById(id);
        return transaccionProducto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TransaccionProducto createTransaccionProducto(@RequestBody TransaccionProducto transaccionProducto) {
        return transaccionProductoService.save(transaccionProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionProducto> updateTransaccionProducto(@PathVariable Long id, @RequestBody TransaccionProducto transaccionProductoDetails) {
        Optional<TransaccionProducto> transaccionProducto = transaccionProductoService.findById(id);
        if (transaccionProducto.isPresent()) {
            TransaccionProducto updatedTransaccionProducto = transaccionProducto.get();
            updatedTransaccionProducto.setTransaccion(transaccionProductoDetails.getTransaccion());
            updatedTransaccionProducto.setProducto(transaccionProductoDetails.getProducto());
            updatedTransaccionProducto.setCantidad(transaccionProductoDetails.getCantidad());
            return ResponseEntity.ok(transaccionProductoService.save(updatedTransaccionProducto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccionProducto(@PathVariable Long id) {
        transaccionProductoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
