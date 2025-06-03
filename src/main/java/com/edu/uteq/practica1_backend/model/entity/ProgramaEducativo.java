package com.edu.uteq.practica1_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProgramaEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clave;
    private String programa_educativo;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "id_division" )
    @JsonIgnoreProperties(value = {"programasEducativos","activo","clave"} )
    private Division division;

}
