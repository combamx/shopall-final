package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.models.Usuario;
import com.metaphorce.shopall.models.request.UsuarioRequest;
import com.metaphorce.shopall.models.response.UsuarioResponse;
import com.metaphorce.shopall.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.metaphorce.shopall.exception.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
@Tag(name="Usuario")
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Crear Usuario")
    public ResponseEntity<Usuario> crearUsuario(@Validated @RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (InvalidUsuarioDataException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{email}")
    @Operation(summary = "Obtener Usuario por email")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorId(@PathVariable("email") String email) {
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email);
        UsuarioResponse response = new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTipoUsuario()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Obtener todos los Usuarios")
    public List<UsuarioResponse> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodos()
                .stream()
                .map(usuario -> new UsuarioResponse(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getEmail(),
                        usuario.getTipoUsuario()
                ))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Usuario")
    public ResponseEntity<UsuarioResponse> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioRequest request) {
        try {
            Usuario usuario = new Usuario(
                    request.getNombre(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getTipoUsuario()
            );
            Usuario updatedUsuario = usuarioService.actualizar(id, usuario);
            UsuarioResponse response = new UsuarioResponse(
                    updatedUsuario.getId(),
                    updatedUsuario.getNombre(),
                    updatedUsuario.getEmail(),
                    updatedUsuario.getTipoUsuario()
            );
            return ResponseEntity.ok(response);
        } catch (InvalidUsuarioDataException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Usuario")
    public ResponseEntity<HttpStatus> eliminarUsuario(@PathVariable("id") Long id) {
        try {
            usuarioService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidUsuarioDataException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}