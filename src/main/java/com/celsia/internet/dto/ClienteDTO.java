package com.celsia.internet.dto;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private Long id;
    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotBlank(message = "El tipo de identificación es obligatorio")
    private String tipoIdentificacion;
    private LocalDate fechaNacimiento;
    @NotBlank(message = "El número celular es obligatorio")
    private String numeroCelular;
    @Email(message = "El correo no tiene un formato válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correoElectronico;

}
