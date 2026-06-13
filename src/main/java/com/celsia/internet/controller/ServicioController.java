package com.celsia.internet.controller;

import com.celsia.internet.dto.ServicioDTO;
import com.celsia.internet.model.Servicio;
import com.celsia.internet.service.IServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    @Autowired
    private IServicioService serviService;

    @Operation(
            summary = "Obtener todos los servicios",
            description = "Retorna una lista con todos los servicios registrados"
    )
    @GetMapping
    public ResponseEntity<List<ServicioDTO>> getServicio() {
        return ResponseEntity.ok(serviService.getServicio());
    }

    @Operation(summary = "Crear un servicio")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Servicio creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<?> saveServicio(@RequestBody Servicio servicio) {
        serviService.saveServicio(servicio);

        return ResponseEntity.status(HttpStatus.CREATED).body("servicio creado correcteamente");
    }

    @Operation(
            summary = "Eliminar un servicio",
            description = "Elimina un servicio según su ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Servicio eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Servicio no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServicio(@PathVariable Long id) {
        serviService.deleteServicio(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Actualizar un servicio",
            description = "Actualiza la información de un servicio existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Servicio actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Servicio no encontrado")})

    @PutMapping("/{id}")
    public String editPersona(@PathVariable String identificacion, @RequestBody Servicio service) {
        service.setIdentificacion(identificacion);
        serviService.editServicio(service);

        return serviService.findServicio(service.getIdentificacion());
    }
}
