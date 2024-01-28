package com.meli.mutants.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

/*
@Entity indica que Mutant es una entidad JPA
y se mapeara a una tabla
@JsonIgnoreProperties(ignoreUnknown = true) le dice al serializador que ignore cualquier campo desconocido
*/
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mutant {

    //Anotaciones para que id sea clave primaria en la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Anotacion necesaria para que se permita una entrada unica por ADN
    @Column(unique = true)
    private String[] dna;
    private boolean isMutant;

    // Constructores

    public Mutant() {
        // Constructor vacío necesario para JPA
    }

    public Mutant(String[] dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }

    // Getters y setters

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}


