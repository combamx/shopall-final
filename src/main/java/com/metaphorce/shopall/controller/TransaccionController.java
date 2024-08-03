package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.models.Transaccion;
import com.metaphorce.shopall.models.Usuario;
import com.metaphorce.shopall.models.request.TransaccionRequest;
import com.metaphorce.shopall.models.response.TransaccionResponse;
import com.metaphorce.shopall.services.TransaccionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transacciones")
@Tag(name="Transacciones")
@Validated
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping
    public List<TransaccionResponse> getAllTransacciones() {
        return transaccionService.findAll()
                .stream()
                .map(transaccion -> new TransaccionResponse(
                        transaccion.getComprador().getId(),
                        transaccion.getMontoTotal(),
                        transaccion.getDireccionEnvio()
                        ))
                .collect(Collectors.toList()).reversed();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionResponse> getTransaccionById(@PathVariable Long id) {
        Optional<Transaccion> transaccion = transaccionService.findById(id);

        TransaccionResponse response = new TransaccionResponse(
                transaccion.get().getId(),
                transaccion.get().getMontoTotal(),
                transaccion.get().getDireccionEnvio()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TransaccionResponse> createTransaccion(@Valid @RequestBody TransaccionRequest request) {
        Usuario usuario = new Usuario();

        usuario.setId(request.getUsuarioId());
        Transaccion transaccion = new Transaccion(
                usuario,
                request.getTotal(),
                request.getDireccion(),
                request.getInformacionPago()
        );
        Transaccion createdTransaccion = transaccionService.save(transaccion);
        TransaccionResponse response = new TransaccionResponse(
                createdTransaccion.getComprador().getId(),
                createdTransaccion.getMontoTotal(),
                createdTransaccion.getDireccionEnvio());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionResponse> updateTransaccion(@PathVariable Long id, @Valid @RequestBody TransaccionRequest request) {
        Optional<Transaccion> transaccionT = transaccionService.findById(id);
        if (transaccionT.isPresent()) {
            Usuario usuario = new Usuario();

            usuario.setId(request.getUsuarioId());
            Transaccion transaccion = new Transaccion(
                    usuario,
                    request.getTotal(),
                    request.getFecha(),
                    request.getDireccion());
            Transaccion updatedTransaccion = transaccionService.save(transaccion);
            TransaccionResponse response = new TransaccionResponse(
                    updatedTransaccion.getComprador().getId(),
                    updatedTransaccion.getMontoTotal(),
                    updatedTransaccion.getDireccionEnvio());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        transaccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
