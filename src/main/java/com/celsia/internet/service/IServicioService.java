package com.celsia.internet.service;

import com.celsia.internet.model.Cliente;
import com.celsia.internet.model.Servicio;

import java.util.List;

public interface IServicioService  {


    //para traer la infomraicon
    public List<Servicio> getServicio();

    // para guardar la informacion
    public void saveServicio(Servicio servicio);

    //  para borar informacion
    public void deleteServicio(Long id);

    //lectura de un solo objeto
    public Servicio findServicio(Long id);

    //edición/modificación
    public void editServicio (Servicio Servicio);

}
