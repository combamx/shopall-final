package com.metaphorce.shopall.services;

import com.metaphorce.shopall.exception.NotFoundException;
import com.metaphorce.shopall.models.Usuario;
import com.metaphorce.shopall.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(SHA256Util.hash(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado con id: " + id));
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new NotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado con id: " + id));

        existingUsuario.setNombre(usuario.getNombre());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setTipoUsuario(usuario.getTipoUsuario());
        // Encriptar la nueva contraseña si se está actualizando
        if (usuario.getPassword() != null) {
            existingUsuario.setPassword(SHA256Util.hash(usuario.getPassword()));
        }

        return usuarioRepository.save(existingUsuario);
    }

    // Otros métodos de servicio según sea necesario
}
