package com.celsia.internet.controller;

import com.celsia.internet.model.Cliente;
import com.celsia.internet.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Nota los  DTO se pueden  implementar tambien para traer los datos mas seguro por cuestion
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public    List<Cliente> getCliente() {
        return clienteService.getCliente();
    }

    @PostMapping("/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);

        return "el cleinte fue creada correctamente";
    }

    @DeleteMapping("/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "el cliente fue eliminada correctamente";
    }

    @PutMapping("/editar")
    public Cliente editPersona(@RequestBody Cliente cliente) {
        clienteService.editCliente(cliente);

        return clienteService.findCliente(cliente.getIdentificacion());
    }


}
