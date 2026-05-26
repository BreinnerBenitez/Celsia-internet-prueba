package com.celsia.internet.dto;


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
public class ClienteDTO {
    private Long identificacion;
    private String nombre;
    private String apellido;
    private String tipoIdentificacion;
    private LocalDate FechaNacimiento;
    private String numeroCelular;
    private String correoElectronico;

}
