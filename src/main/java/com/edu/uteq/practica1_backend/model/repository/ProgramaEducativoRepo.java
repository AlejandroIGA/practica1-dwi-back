package com.edu.uteq.practica1_backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.uteq.practica1_backend.model.entity.ProgramaEducativo;

public interface ProgramaEducativoRepo extends JpaRepository<ProgramaEducativo, Integer> {
    
}
