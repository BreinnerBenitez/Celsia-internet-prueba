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


    private final IClienteRepository clienteRepo;

    public ClienteService(IClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public List<ClienteDTO> getCliente() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        List<ClienteDTO> listaClientesDTO = new ArrayList<>();
        ClienteDTO cliDTO = new ClienteDTO();
        for (Cliente cli : listaClientes){

            cliDTO.setId(cli.getId());
            cliDTO.setNombre(cli.getNombre());
            cliDTO.setApellido(cli.getApellido());
            cliDTO.setIdentificacion(cli.getIdentificacion());
            cliDTO.setTipoIdentificacion(cli.getTipoIdentificacion());
            cliDTO.setNumeroCelular(cli.getNumeroCelular());
            cliDTO.setCorreoElectronico(cli.getCorreoElectronico());
            cliDTO.setFechaNacimiento(cli.getFechaNacimiento());
            listaClientesDTO.add(cliDTO);
            cliDTO = new ClienteDTO();

        }

        return listaClientesDTO;
    }



    @Override
    public void saveCliente(ClienteDTO cliDTO) {

        if(clienteRepo.existsByIdentificacion(
                cliDTO.getIdentificacion())){

            throw new RuntimeException(
                    "El registro ya existe");
        }
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(cliDTO.getIdentificacion());
        cliente.setNombre(cliDTO.getNombre());
        cliente.setApellido(cliDTO.getApellido());
        cliente.setTipoIdentificacion(cliDTO.getTipoIdentificacion());
        cliente.setFechaNacimiento(cliDTO.getFechaNacimiento());
        cliente.setNumeroCelular(cliDTO.getNumeroCelular());
        cliente.setCorreoElectronico(cliDTO.getCorreoElectronico());

        clienteRepo.save(cliente);


    }

    @Override
    public void deleteCliente(String identificacion) {

        Cliente cliente = clienteRepo
                .findByIdentificacion(identificacion)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Cliente no encontrado"));

        clienteRepo.delete(cliente);


    }

    @Override
    public Cliente findCliente(String identificacion) {

        return clienteRepo.findByIdentificacion(identificacion)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Cliente no encontrado"));
    }

    @Override
    public void editCliente(ClienteDTO clienteDTO) {


        Cliente cliente = findCliente(
                clienteDTO.getIdentificacion());

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setTipoIdentificacion(clienteDTO.getTipoIdentificacion());
        cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        cliente.setNumeroCelular(clienteDTO.getNumeroCelular());
        cliente.setCorreoElectronico(clienteDTO.getCorreoElectronico());

        clienteRepo.save(cliente);

    }
}
