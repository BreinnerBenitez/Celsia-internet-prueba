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
@Table ( name = "servicio")
public class Servicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  identificacion;
    private  String servicio;
    private LocalDate fechaInicio ;
    private LocalDate iltimaFActuracion;
    private   Integer ulitmoPago ;
    @OneToOne
    @JoinColumn(name="cliente", referencedColumnName = "identificacion")
    private   Cliente cliente;

}
