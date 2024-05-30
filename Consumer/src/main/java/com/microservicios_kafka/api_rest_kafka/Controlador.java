package com.microservicios_kafka.api_rest_kafka;
 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
@RestController
public class Controlador {
 
    private final Consumidor consumidor;
 
    public Controlador(Consumidor consumidor) {
        this.consumidor = consumidor;
    }
 
    @PostMapping("/mensajes")
    public List<String> obtenerMensajes() {
        return consumidor.obtenerMensajes();
    }
}