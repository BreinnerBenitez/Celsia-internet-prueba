package com.celsia.internet.controller;

import com.celsia.internet.dto.ClienteDTO;
import com.celsia.internet.model.Cliente;
import com.celsia.internet.service.IClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
public class ClienteController {


    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {

        this.clienteService = clienteService;
    }

    @Operation(
            summary = "Obtener todos los clientes",
            description = "Retorna una lista con todos los clientes registrados"
    )
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getCliente() {
        return ResponseEntity.ok(clienteService.getCliente());
    }


    @Operation(summary = "Crear un cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente creado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<?> saveCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        clienteService.saveCliente(clienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("cliente creado");
    }


    @Operation(
            summary = "Eliminar un cliente",
            description = "Elimina un cliente según su ID"
    )
    @DeleteMapping("/{identificacion}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String identificacion) {
        clienteService.deleteCliente(identificacion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Editar un cliente",
            description = "Actualiza los datos de un cliente existente"
    )
    @PutMapping("/{identificacion}")
    public ResponseEntity<Void> editCliente(@PathVariable String identificacion, @Valid @RequestBody ClienteDTO clienteDTO) {
        clienteDTO.setIdentificacion(identificacion);
        clienteService.editCliente(clienteDTO);

        return ResponseEntity.noContent().build();
    }


}
