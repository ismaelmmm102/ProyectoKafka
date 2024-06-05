package com.api.consumidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumidor {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @KafkaListener(topics = "usuarios", groupId = "group_id")
    public void consume(String mensaje) {
        String[] datos = mensaje.split(",");
        Usuario user = new Usuario();
        user.setId(datos[0]);
        user.setNombre(datos[1]);
        user.setEdad(datos[2]);
        usuarioRepo.save(user);
    }
}