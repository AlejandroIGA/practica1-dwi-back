package com.edu.uteq.practica1_backend.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clave;
    private String nombre;
    private boolean activo;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    //@JoinColumn(name = "id_division")
    //private List<ProgramaEducativo> programasEducativos;
}
