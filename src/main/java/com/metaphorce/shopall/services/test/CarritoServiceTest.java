package com.metaphorce.shopall.services.test;

import com.metaphorce.shopall.exception.InvalidCarritoDataException;
import com.metaphorce.shopall.exception.InvalidUsuarioDataException;
import com.metaphorce.shopall.models.Carrito;
import com.metaphorce.shopall.models.CarritoProducto;
import com.metaphorce.shopall.models.Usuario;
import com.metaphorce.shopall.repository.CarritoRepository;
import com.metaphorce.shopall.repository.UsuarioRepository;
import com.metaphorce.shopall.services.CarritoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarritoServiceTest {

    @Mock
    private CarritoRepository carritoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private CarritoService carritoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCarritoById_existingId_shouldReturnCarrito() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        when(carritoRepository.findById(1L)).thenReturn(Optional.of(carrito));

        // Act
        Optional<Carrito> foundCarrito = carritoService.findById(1L);

        // Assert
        assertEquals(carrito, foundCarrito);
    }

    @Test
    void getCarritoById_nonExistingId_shouldThrowCarritoNotFoundException() {
        // Arrange
        when(carritoRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(InvalidCarritoDataException.class, () -> carritoService.deleteById(1L));
    }

    @Test
    void createCarrito_validUsuarioId_shouldReturnCarrito() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        Carrito carrito = new Carrito();
        carrito.setComprador(usuario);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(carritoRepository.save(any(Carrito.class))).thenReturn(carrito);

        // Act
        Optional<Carrito> createdCarrito = carritoService.findById(1L);

        // Assert
        assertNotNull(createdCarrito);
        assertEquals(usuario, createdCarrito.get().getComprador());
    }

    @Test
    void createCarrito_invalidUsuarioId_shouldThrowUsuarioNotFoundException() {
        // Arrange
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(InvalidUsuarioDataException.class, () -> carritoService.deleteById(1L));
    }

    @Test
    void addProductoToCarrito_validCarritoIdAndProducto_shouldAddProducto() {
        // Arrange
        Carrito carrito = new Carrito();
        carrito.setId(1L);
        carrito.setProductos(Collections.emptyList());
        CarritoProducto carritoProducto = new CarritoProducto();
        when(carritoRepository.findById(1L)).thenReturn(Optional.of(carrito));
        when(carritoRepository.save(carrito)).thenReturn(carrito);

        // Act
        carritoService.save(carrito);

        // Assert
        assertFalse(carrito.getProductos().isEmpty());
        assertTrue(carrito.getProductos().contains(carritoProducto));
    }

    // Add more tests for removeProductoFromCarrito, getCarritosByUsuario, etc.
}