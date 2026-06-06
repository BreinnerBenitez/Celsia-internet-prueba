package com.celsia.internet.service;

import com.celsia.internet.dto.ServicioDTO;
import com.celsia.internet.model.Cliente;
import com.celsia.internet.model.Servicio;
import com.celsia.internet.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioService implements IServicioService {


    @Autowired
    private IServicioRepository servicioRepo;

    @Override
    public List<ServicioDTO> getServicio() {

        List<Servicio> listaServicio = servicioRepo.findAll();
        List <ServicioDTO> listaServicioDTO= new ArrayList<>();
        ServicioDTO serviDTO = new ServicioDTO();

        for (Servicio servi : listaServicio){

            serviDTO.setServicio(servi.getServicio());
            serviDTO.setIdentificacion(servi.getIdentificacion());
            serviDTO.setCliente(servi.getCliente());
            serviDTO.setUlitmoPago(servi.getUlitmoPago());
            serviDTO.setFechaInicio(servi.getFechaInicio());
            serviDTO.setIltimaFActuracion(servi.getUltimaFacturacion());
            serviDTO = new ServicioDTO();

        }


        return listaServicioDTO;
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
