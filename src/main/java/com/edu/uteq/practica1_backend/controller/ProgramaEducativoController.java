package com.edu.uteq.practica1_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uteq.practica1_backend.model.repository.DivisionRepo;
import com.edu.uteq.practica1_backend.model.repository.ProgramaEducativoRepo;

@RestController
@RequestMapping("/api/pe")
public class ProgramaEducativoController {

    @Autowired
    private ProgramaEducativoRepo repo;

    @Autowired
    private DivisionRepo dRepo;

}