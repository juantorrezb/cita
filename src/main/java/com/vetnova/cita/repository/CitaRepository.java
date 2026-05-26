package com.vetnova.cita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetnova.cita.model.Cita;
import java.util.List;


@Repository
public interface CitaRepository extends JpaRepository<Cita, Long>{

    List<Cita> findByIdMascota(Long idMascota);

    List<Cita> findByIdVeterinario(Long idVeterinario);

    List<Cita> findByIdSede(Long idSede);

    void deleteById(Long idCita);
}


