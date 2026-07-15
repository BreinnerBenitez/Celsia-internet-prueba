package com.celsia.internet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "cliente")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column (nullable = false, unique = true)
    private  String identificacion;
    @Column (name="nombres", nullable=false )
    private  String nombre;
    @Column (name="apellidos",nullable=false)
    private  String apellido;
    @Column ( nullable=false)
    private  String tipoIdentificacion;
    @Column ( nullable=false)
    private LocalDate fechaNacimiento ;
    @Column ( nullable=false)
    private  String  numeroCelular;
    @Column ( nullable=false)
    private   String   correoElectronico;
    @OneToMany(mappedBy = "cliente")
    private List<Servicio> servicios;


}
