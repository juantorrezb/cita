package com.vetnova.cita.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Generated(value = "com.vetnova.cita.model.CitaIdGenerator")
    private Long idCita;

    @Column(nullable = false)
    private double fecha;

    @Column(length = 255, nullable = false)
    private String motivo;

    @Column(nullable = false)
    private Long idMascota;

    @Column(nullable = false)
    private Long idVeterinario;

    @Column(nullable = false)
    private Long idSede;
}
