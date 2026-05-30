package com.celsia.internet.service;

import com.celsia.internet.dto.ClienteDTO;
import com.celsia.internet.model.Cliente;

import java.util.List;

public interface IClienteService {


    //para traer la infomraicon
     List<ClienteDTO> getCliente();

    // para guardar la informacion
     void saveCliente(Cliente cliente);

    //  para borar informacion
     void deleteCliente(Long id);

    //lectura de un solo objeto
    Cliente findCliente(Long id);

    //edición/modificación
     void editCliente (Cliente cliente);

}
