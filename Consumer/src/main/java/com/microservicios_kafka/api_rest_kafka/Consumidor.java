package com.microservicios_kafka.api_rest_kafka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumidor {
    private final List<String> mensajes = new ArrayList<>();
    @KafkaListener(topics = "topico1", groupId = "1")
    public void getMensaje(String mensaje) {
        mensajes.add(mensaje);
    }
    public List<String> obtenerMensajes() {
        List<String> mensajesCopia = new ArrayList<>(mensajes);
        mensajes.clear();
        return mensajesCopia;
    }
}