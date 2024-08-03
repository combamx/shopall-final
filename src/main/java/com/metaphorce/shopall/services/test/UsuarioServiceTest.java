package com.metaphorce.shopall.services.test;

import com.metaphorce.shopall.exception.InvalidUsuarioDataException;
import com.metaphorce.shopall.models.Usuario;
import com.metaphorce.shopall.repository.UsuarioRepository;
import com.metaphorce.shopall.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    UsuarioServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsuarios() {
        when(usuarioRepository.findAll()).thenReturn(List.of(new Usuario()));
        assertFalse(usuarioService.obtenerTodos().isEmpty());
    }

    @Test
    void getUsuarioById() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        assertEquals(usuario, usuarioService.obtenerPorId(1L));
    }

    @Test
    void getUsuarioByIdNotFound() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(InvalidUsuarioDataException.class, () -> usuarioService.obtenerPorId(1L));
    }

    // Add more tests for createUsuario, updateUsuario, and deleteUsuario
}