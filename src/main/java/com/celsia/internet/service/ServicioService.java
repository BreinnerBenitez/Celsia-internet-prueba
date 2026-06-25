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
    private final IClienteRepository clienteRepo;

    public ServicioService(IServicioRepository servicioRepo, IClienteRepository clienteRepo) {

        this.servicioRepo = servicioRepo;
        this.clienteRepo = clienteRepo;
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


        Servicio servicio = servicioRepo
                .findByIdentificacion(identificacion)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Servicio no encontrado"));

        return convertirDTO(servicio);


    }

    @Override
    public void saveServicio(ServicioDTO servicioDTO) {

        if (servicioRepo.existsByIdentificacion(
                servicioDTO.getIdentificacion())) {

            throw new RuntimeException(
                    "El servicio ya existe");
        }

        Cliente cliente = clienteRepo
                .findByIdentificacion(
                        servicioDTO.getIdentificacionCliente())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Cliente no encontrado"));

        Servicio servicio = convertirEntidad(
                servicioDTO,
                cliente);

        servicioRepo.save(servicio);


    }

    @Override
    public void editServicio(ServicioDTO servicioDTO) {


        Servicio servicio = servicioRepo
                .findByIdentificacion(
                        servicioDTO.getIdentificacion())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Servicio no encontrado"));

        Cliente cliente = clienteRepo
                .findByIdentificacion(
                        servicioDTO.getIdentificacionCliente())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Cliente no encontrado"));

        servicio.setServicio(
                servicioDTO.getServicio());

        servicio.setFechaInicio(
                servicioDTO.getFechaInicio());

        servicio.setUltimaFacturacion(
                servicioDTO.getUltimaFacturacion());

        servicio.setUltimoPago(
                servicioDTO.getUltimoPago());

        servicio.setCliente(cliente);

        servicioRepo.save(servicio);

    }

    @Override
    public void deleteServicio(String identificacion) {

        Servicio servicio = servicioRepo
                .findByIdentificacion(identificacion)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Servicio no encontrado"));

        servicioRepo.delete(servicio);

    }

    @Override
    public List<ServicioDTO> getServiciosCliente(String identificacionCliente) {
        List<Servicio> servicios =
                servicioRepo.findByClienteIdentificacion(
                        identificacionCliente);

        List<ServicioDTO> listaDTO =
                new ArrayList<>();

        for (Servicio servicio : servicios) {

            listaDTO.add(
                    convertirDTO(servicio));
        }

        return listaDTO;
    }


    private ServicioDTO convertirDTO(Servicio servicio) {

        ServicioDTO dto = new ServicioDTO();

        dto.setId(servicio.getId());
        dto.setIdentificacion(servicio.getIdentificacion());
        dto.setServicio(servicio.getServicio());
        dto.setFechaInicio(servicio.getFechaInicio());
        dto.setUltimaFacturacion(servicio.getUltimaFacturacion());
        dto.setUltimoPago(servicio.getUltimoPago());

        dto.setIdentificacionCliente(
                servicio.getCliente().getIdentificacion());

        return dto;
    }

    private Servicio convertirEntidad(
            ServicioDTO servicioDTO,
            Cliente cliente) {

        Servicio servicio = new Servicio();

        servicio.setIdentificacion(
                servicioDTO.getIdentificacion());

        servicio.setServicio(
                servicioDTO.getServicio());

        servicio.setFechaInicio(
                servicioDTO.getFechaInicio());

        servicio.setUltimaFacturacion(
                servicioDTO.getUltimaFacturacion());

        servicio.setUltimoPago(
                servicioDTO.getUltimoPago());

        servicio.setCliente(cliente);

        return servicio;
    }

}
