package com.vetnova.cita.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255, nullable = false)
    private String motivo;

    @Column(nullable = false)
    private Long idMascota;

    @Column(nullable = false)
    private Long idVeterinario;

    @Column(nullable = false)
    private Long idSede;
}
