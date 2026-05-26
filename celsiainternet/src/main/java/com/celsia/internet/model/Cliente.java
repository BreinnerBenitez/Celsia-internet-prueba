package com.celsia.internet.model;

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
@Entity
@Table (name= "cliente")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long identificacion;
    @Column (name="nombres")
    private  String nombre;
    @Column (name="apellidos")
    private  String apellido;
    private  String tipoIdentificacion;
    private LocalDate FechaNacimiento ;
    private  String  numeroCelular;
    private   String   correoElectronico;


}
