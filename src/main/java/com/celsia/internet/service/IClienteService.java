package com.celsia.internet.service;

import com.celsia.internet.model.Cliente;

import java.util.List;

public interface IClienteService {


    //para traer la infomraicon
    public List<Cliente> getCliente();

    // para guardar la informacion
    public void saveCliente(Cliente cliente);

    //  para borar informacion
    public void deleteCliente(Long id);

    //lectura de un solo objeto
    public Cliente findCliente(Long id);

    //edición/modificación
    public void editCliente (Cliente cliente);

}
