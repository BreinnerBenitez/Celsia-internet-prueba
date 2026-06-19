package com.celsia.internet.controller;

import com.celsia.internet.dto.ServicioDTO;
import com.celsia.internet.model.Servicio;
import com.celsia.internet.service.IServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/servicio")
@Tag(name = "Servicios",
        description = "Operaciones relacionadas con los servicios")
public class ServicioController {

    private final IServicioService servicioService;

    public ServicioController(IServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @Operation(
            summary = "Obtener todos los servicios",
            description = "Retorna una lista con todos los servicios registrados"
    )
    @GetMapping
    public ResponseEntity<List<ServicioDTO>> getServicios() {
        return ResponseEntity.ok(servicioService.getServicios());
    }

    @Operation(
            summary = "Buscar un servicio",
            description = "Retorna un servicio según su identificación"
    )
    @GetMapping("/{identificacion}")
    public ResponseEntity<ServicioDTO> findServicio(@PathVariable String identificacion) {

        return ResponseEntity.ok(
                servicioService.findServicio(identificacion));
    }


    @Operation(summary = "Crear un servicio")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Servicio creado"),

            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<String> saveServicio(@Valid @RequestBody ServicioDTO servicioDTO) {

        servicioService.saveServicio(servicioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Servicio creado");
    }


    @Operation(
            summary = "Editar un servicio",
            description = "Actualiza un servicio existente"
    )
    @PutMapping("/{identificacion}")
    public ResponseEntity<Void> editServicio(@PathVariable String identificacion,
                                             @Valid @RequestBody ServicioDTO servicioDTO) {

        servicioDTO.setIdentificacion(identificacion);

        servicioService.editServicio(servicioDTO);

        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Eliminar un servicio",
            description = "Elimina un servicio por su identificación"
    )
    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Void> deleteServicio(
            @PathVariable String identificacion) {

        servicioService.deleteServicio(identificacion);

        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Obtener servicios de un cliente",
            description = "Retorna todos los servicios asociados a un cliente"
    )
    @GetMapping("/cliente/{identificacionCliente}") // me falta implementar esta
    public ResponseEntity<List<ServicioDTO>> getServiciosCliente(
            @PathVariable String identificacionCliente) {

        return ResponseEntity.ok(servicioService.getServiciosCliente(identificacionCliente));
    }

}
