package com.vetnova.cita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetnova.cita.model.Cita;
import com.vetnova.cita.service.CitaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> getCitas() {
        List<Cita> citas = citaService.listarCitas();
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaService.guardarCita(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCita (@PathVariable Long id) {
        Cita buscarCita = citaService.obtenerCitaPorId(id);
        if (buscarCita == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buscarCita, HttpStatus.OK);
    }
    
    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<List<Cita>> getCitaPorId(@PathVariable Long idMascota) {
        List<Cita> citas = citaService.findByMascotaId(idMascota);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    @GetMapping("/veterinario/{idVeterinario}")
    public ResponseEntity<List<Cita>> getCitaPorVeterinarioId(@PathVariable Long idVeterinario) {
        List<Cita> citas = citaService.findByVeterinarioId(idVeterinario);
        if (citas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(citas, HttpStatus.OK);
    
    }

    @PostMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        Cita cita = citaService.obtenerCitaPorId(id);
        if (cita == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        citaService.eliminarCita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
