package com.edu.uteq.practica1_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uteq.practica1_backend.model.entity.Division;
import com.edu.uteq.practica1_backend.model.repository.DivisionRepo;

@RestController
@RequestMapping("/api/division")
public class DivisionController {
    @Autowired
    private DivisionRepo repo;

    @GetMapping()
    // Busqueda para todos los datos
    public List<Division> buscarTodos(@RequestParam boolean soloActivos) {
        if (soloActivos) {
            return repo.findAll().stream().filter(Division::isActivo).toList();
        }
        return repo.findAll();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Insertar
    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody Division d) {
        Division entity = repo.save(d);
        return ResponseEntity.ok(entity);
    }

}
