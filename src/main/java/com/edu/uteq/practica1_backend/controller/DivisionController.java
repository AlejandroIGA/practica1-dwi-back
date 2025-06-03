package com.edu.uteq.practica1_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Division d) {
        Optional<Division> opt = repo.findById(id);
        if (opt.isPresent()){
            Division entity = opt.get();
            entity.setClave(d.getClave());
            entity.setNombre(d.getNombre());
            entity.setActivo(d.isActivo());

            return ResponseEntity.ok(repo.save(entity));
        }        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        Optional<Division> opt = repo.findById(id);
        if(opt.isPresent()){
            repo.deleteById(id);    
            return ResponseEntity.noContent().build();    
        }
        return ResponseEntity.notFound().build();
    }
}
