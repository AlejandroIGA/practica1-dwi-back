package com.edu.uteq.practica1_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uteq.practica1_backend.model.repository.DivisionRepo;

@RestController
@RequestMapping("/api/division")
public class DivisionController {
    @Autowired
    private DivisionRepo repo;
}
