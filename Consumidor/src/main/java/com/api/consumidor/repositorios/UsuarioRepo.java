package com.api.consumidor.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.consumidor.modelos.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, String> {
}
