package com.celsia.internet.service;

import com.celsia.internet.dto.ClienteDTO;
import com.celsia.internet.model.Cliente;

import java.util.List;

public interface IClienteService {


    List<ClienteDTO> getCliente();


    void saveCliente(ClienteDTO clienteDTO);


    void deleteCliente(String identificaicon);


    Cliente findCliente(String identificacion);


    void editCliente(ClienteDTO clienteDTO);

}
