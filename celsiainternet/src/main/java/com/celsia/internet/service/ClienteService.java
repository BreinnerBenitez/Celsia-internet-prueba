package com.celsia.internet.service;

import com.celsia.internet.model.Cliente;
import com.celsia.internet.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepo;


    @Override
    public List<Cliente> getCliente() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
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
