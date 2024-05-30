package com.api.crud.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.modelos.Usuario;

@Repository
public interface IUsuarioRepositorio extends CrudRepository<Usuario, String>{
	
}
