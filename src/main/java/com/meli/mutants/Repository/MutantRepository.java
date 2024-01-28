package com.meli.mutants.Repository;

import com.meli.mutants.Model.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Anotacion para indicar que esta interfaz es un bean de repositorio de Spring
@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long> {
    //Extiende a JpaRepository que proporciona operaciones básicas de CRUD para la entidad Mutant
}
