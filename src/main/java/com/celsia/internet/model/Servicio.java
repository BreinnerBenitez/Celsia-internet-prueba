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
    private Long id;
    @Column (nullable = false)
    private String  identificacion;
    @Column ( nullable=false)
    private  String servicio;
    @Column ( nullable=false)
    private LocalDate fechaInicio ;
    @Column ( nullable=false)
    private LocalDate ultimaFacturacion;
    @Column ( nullable=false)
    private   Integer ultimoPago ;

    @ManyToOne
    @JoinColumn(name="cliente", referencedColumnName = "identificacion",nullable=false)
    private   Cliente cliente;

}
