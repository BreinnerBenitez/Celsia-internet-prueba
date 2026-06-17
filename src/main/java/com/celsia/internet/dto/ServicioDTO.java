package com.celsia.internet.dto;

import com.celsia.internet.model.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "La identificación del servicio es obligatoria")
    private String identificacion;
    @NotBlank(message = "El nombre del servicio es obligatorio")
    private String servicio;
    private LocalDate fechaInicio;
    private LocalDate ultimaFacturacion;
    private Integer ultimoPago;
    @NotBlank(message = "La identificación del cliente es obligatoria")
    private String identificacionCliente;

}
