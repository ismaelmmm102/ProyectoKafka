package com.api.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/app")
public class UsuarioControlador {

    @Autowired
    private IUsuarioRepositorio userRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers(){
    	return userRepository.findAll();
    }
    @GetMapping(path="/{id}")
    public @ResponseBody Usuario findUserById(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow();
    }
    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
        return "Usuario nº "+id+" eliminado";
    }
    @DeleteMapping(path="/delete/all")
    public @ResponseBody String deleteAllUsers(){
        userRepository.deleteAll();
        return "Todos los usuarios eliminados";
    }
 
    @PutMapping(path="/update/{id}")
    public @ResponseBody String updateUser(@PathVariable String id, @RequestBody Usuario usuario) {
    	Usuario usuarioExiste = userRepository.findById(id).orElseThrow();
        usuarioExiste.setNombre(usuario.getNombre());
        usuarioExiste.setEdad(usuario.getEdad());
        userRepository.save(usuarioExiste);
        return "Usuario nº "+id+"actualizado";
    }

}