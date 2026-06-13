package com.celsia.internet.service;

import com.celsia.internet.dto.ServicioDTO;
import com.celsia.internet.model.Cliente;
import com.celsia.internet.model.Servicio;

import java.util.List;

public interface IServicioService {


    public List<ServicioDTO> getServicio();


    public void saveServicio(Servicio servicio);


    public void deleteServicio(Long id);


    public Servicio findServicio(Long id);


    public void editServicio(Servicio Servicio);

}
