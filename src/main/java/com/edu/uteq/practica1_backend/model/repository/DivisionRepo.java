package com.edu.uteq.practica1_backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.uteq.practica1_backend.model.entity.Division;

public interface DivisionRepo extends JpaRepository<Division,Integer>{
    
}