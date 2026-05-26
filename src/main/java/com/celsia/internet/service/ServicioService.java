package com.celsia.internet.service;

import com.celsia.internet.model.Cliente;
import com.celsia.internet.model.Servicio;
import com.celsia.internet.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService implements IServicioService {


    @Autowired
    private IServicioRepository servicioRepo;

    @Override
    public List<Servicio> getServicio() {

        List<Servicio> listaServicio = servicioRepo.findAll();
        return listaServicio;
    }

    @Override
    public void saveServicio(Servicio servicio) {
        servicioRepo.save(servicio);
    }

    @Override
    public void deleteServicio(Long id) {
        servicioRepo.deleteById(id);
    }

    @Override
    public Servicio findServicio(Long id) {
        return servicioRepo.findById(id).orElse(null);


    }

    @Override
    public void editServicio(Servicio Servicio) {
        this.saveServicio(Servicio);
    }
}
