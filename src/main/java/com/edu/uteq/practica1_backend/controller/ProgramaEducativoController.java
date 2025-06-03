package com.edu.uteq.practica1_backend.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.edu.uteq.practica1_backend.model.repository.DivisionRepo;
import com.edu.uteq.practica1_backend.model.repository.ProgramaEducativoRepo;
import com.edu.uteq.practica1_backend.model.entity.Division;
import com.edu.uteq.practica1_backend.model.entity.ProgramaEducativo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/pe")
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoRepo repo;

    @Autowired
    private DivisionRepo dRepo;

    // Listar todos los programas educativos
    @GetMapping
    public List<ProgramaEducativo> buscarTodos(@RequestParam boolean soloActivos) {
        if (soloActivos) {
            return repo.findAll().stream().filter(ProgramaEducativo::isActivo).toList();
        } else {
            return repo.findAll();
        }
    }

    // post para crear un programa educativo
    @PostMapping
    public ResponseEntity<?> crear(@RequestParam int idDivision, @RequestBody ProgramaEducativo pe) {
        Optional<Division> opt = dRepo.findById(idDivision);
        if (opt.isPresent()) {
            Division d = opt.get();
            pe.setDivision(d);
            return ResponseEntity.ok(repo.save(pe));

        } else {
            return ResponseEntity.notFound().build();
        }


    }

}