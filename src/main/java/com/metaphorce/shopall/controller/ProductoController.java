package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.exception.InvalidProductoDataException;
import com.metaphorce.shopall.exception.InvalidUsuarioDataException;
import com.metaphorce.shopall.models.Producto;
import com.metaphorce.shopall.models.request.ProductoRequest;
import com.metaphorce.shopall.models.response.ProductoResponse;
import com.metaphorce.shopall.services.ProductoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.bytebuddy.agent.VirtualMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
@Tag(name="Productos")
@Validated
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> getAllProductos() {
        try{
            return ResponseEntity.ok( productoService.getAllProductos()
                    .stream()
                    .map(producto -> new ProductoResponse(
                            producto.getId(),
                            producto.getNombre(),
                            producto.getDescripcion(),
                            producto.getPrecio(),
                            producto.getCantidad(),
                            producto.getCategoria()))
                    .collect(Collectors.toList()));
        }
        catch (InvalidProductoDataException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> getProductoById(@PathVariable Long id) {
        try{
            Producto producto = productoService.getProductoById(id);
            ProductoResponse response = new ProductoResponse(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getCantidad(),
                    producto.getCategoria()
            );
            return ResponseEntity.ok(response);
        }
        catch (InvalidProductoDataException ex){
            return null;
        }

    }

    @PostMapping
    public ResponseEntity<ProductoResponse> createProducto(@Valid @RequestBody ProductoRequest request) {
        try{
            Producto producto = new Producto(
                    request.getNombre(),
                    request.getDescripcion(),
                    request.getPrecio(),
                    request.getCantidad(),
                    request.getCategoria()
            );
            Producto createdProducto = productoService.createProducto(producto);
            ProductoResponse response = new ProductoResponse(
                    createdProducto.getId(),
                    createdProducto.getNombre(),
                    createdProducto.getDescripcion(),
                    createdProducto.getPrecio(),
                    createdProducto.getCantidad(),
                    createdProducto.getCategoria()
            );
            return ResponseEntity.ok(response);
        }
        catch (InvalidProductoDataException ex){
            return null;
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> updateProducto(@PathVariable Long id, @Valid @RequestBody ProductoRequest request) {
        try{
            Optional<Producto> producto = productoService.findById(id);
            if (producto.isPresent()) {
                Producto productoEdit = new Producto(
                        request.getNombre(),
                        request.getDescripcion(),
                        request.getPrecio(),
                        request.getCantidad(),
                        request.getCategoria()
                );
                Producto updatedProducto = productoService.updateProducto(id, productoEdit);
                ProductoResponse response = new ProductoResponse(
                        updatedProducto.getId(),
                        updatedProducto.getNombre(),
                        updatedProducto.getDescripcion(),
                        updatedProducto.getPrecio(),
                        updatedProducto.getCantidad(),
                        updatedProducto.getCategoria()
                );
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (InvalidProductoDataException ex){
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        try{
            productoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (InvalidProductoDataException ex){
            return null;
        }
    }
}
