package com.vetnova.cita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vetnova.cita.model.Cita;
import com.vetnova.cita.repository.CitaRepository;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }
    public Optional<Cita> obtenerCitaPorId(Long idCita) {
        return citaRepository.findById(idCita);
    }
    public List<Cita> findByMascotaId (Long idMascota){
        return citaRepository.findByIdMascota(idMascota);
    }
    public List<Cita> findByVeterinarioId (Long idVeterinario){
        return citaRepository.findByIdVeterinario(idVeterinario);
    }
    public List<Cita> findBySedeId (Long idSede){
        return citaRepository.findByIdSede(idSede);
    }
}
