package com.celsia.internet.controller;

import com.celsia.internet.model.Servicio;
import com.celsia.internet.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    @Autowired
    private IServicioService  serviService;

    @GetMapping
    public List<Servicio> getServicio() {
        return serviService.getServicio();
    }

    @PostMapping("/crear")
    public String saveServicio(@RequestBody Servicio servicio) {
        serviService.saveServicio(servicio);

        return "el servicio fue creado correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteServicio(@PathVariable Long id) {
        serviService.deleteServicio(id);
        return "el Servicio fue eliminado correctamente";
    }

    @PutMapping("/editar")
    public Servicio editPersona(@RequestBody Servicio service) {
        serviService.editServicio(service);

        return serviService.findServicio(service.getIdentificacion());
    }
}
