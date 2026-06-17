package com.celsia.internet.service;

import com.celsia.internet.dto.ServicioDTO;
import com.celsia.internet.model.Cliente;
import com.celsia.internet.model.Servicio;
import com.celsia.internet.repository.IClienteRepository;
import com.celsia.internet.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioService implements IServicioService {



    private final IServicioRepository servicioRepo;

      public ServicioService (IServicioRepository servicioRepo){

          this.servicioRepo = servicioRepo;
      }




    @Override
    public List<ServicioDTO> getServicios() {
        List<Servicio> listaServicios = servicioRepo.findAll();

        List<ServicioDTO> listaServiciosDTO = new ArrayList<>();

        for (Servicio servicio : listaServicios) {

            ServicioDTO dto = new ServicioDTO();

            dto.setId(servicio.getId());
            dto.setIdentificacion(servicio.getIdentificacion());
            dto.setServicio(servicio.getServicio());
            dto.setFechaInicio(servicio.getFechaInicio());
            dto.setUltimaFacturacion(servicio.getUltimaFacturacion());
            dto.setUltimoPago(servicio.getUltimoPago());

            dto.setIdentificacionCliente(
                    servicio.getCliente().getIdentificacion());

            listaServiciosDTO.add(dto);
        }

        return listaServiciosDTO;
    }

    @Override
    public ServicioDTO findServicio(String identificacion) {
        return null;
    }

    @Override
    public void saveServicio(ServicioDTO servicioDTO) {

    }

    @Override
    public void editServicio(ServicioDTO servicioDTO) {

    }

    @Override
    public void deleteServicio(String identificacion) {

    }

    @Override
    public List<ServicioDTO> getServiciosCliente(String identificacionCliente) {
        return List.of();
    }
}
