package com.celsia.internet.service;

import com.celsia.internet.dto.ClienteDTO;
import com.celsia.internet.model.Cliente;
import com.celsia.internet.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;


    @Override
    public List<ClienteDTO> getCliente() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        List<ClienteDTO> listaClientesDTO = new ArrayList<>();
        ClienteDTO cliDTO = new ClienteDTO();
        for (Cliente cli : listaClientes){
            cliDTO.setNombre(cli.getNombre());
            cliDTO.setApellido(cli.getApellido());
            cliDTO.setIdentificacion(cli.getIdentificacion());
            cliDTO.setNumeroCelular(cli.getNumeroCelular());
            cliDTO.setCorreoElectronico(cli.getCorreoElectronico());
            cliDTO.setFechaNacimiento(cli.getFechaNacimiento());
            cliDTO = new ClienteDTO();

        }

        return listaClientesDTO;
    }



    @Override
    public void saveCliente(Cliente cliente) {

        clienteRepo.save(cliente);

    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {

        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Cliente cliente) {

        this.saveCliente(cliente);

    }
}
