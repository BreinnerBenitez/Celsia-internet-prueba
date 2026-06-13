package com.celsia.internet.dto;

import com.celsia.internet.model.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {
    private Long id;
    private String identificacion;
    private String servicio;
    private LocalDate fechaInicio;
    private LocalDate iltimaFActuracion;
    private Integer ulitmoPago;
    private Cliente cliente;

}
