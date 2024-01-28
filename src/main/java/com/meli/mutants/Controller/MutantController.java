package com.meli.mutants.Controller;

import com.meli.mutants.Model.Mutant;
import com.meli.mutants.Model.Stats;
import com.meli.mutants.Service.MutantDetectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    private final MutantDetectorService mutantDetectorService;

    public MutantController(MutantDetectorService mutantDetectorService) {
        this.mutantDetectorService = mutantDetectorService;
    }

    /*
    * Metodo principal en el cual se ingresa un ADN y devuelve una respuesta con
    * "Es mutante" o "Es humano", y tambien guarda la prueba en la base de datos
    * */
    @PostMapping
    public ResponseEntity<String> detectMutant(@RequestBody Mutant request) {
        if (mutantDetectorService.isMutant(request.getDna())) {
            return new ResponseEntity<>("Mutant detected!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Human detected!", HttpStatus.FORBIDDEN);
        }
    }

    //Metodo que muestra las estadisticas de las entradas de la base de datos
    @RequestMapping("/stats")
    public Stats getStats() {
        return mutantDetectorService.getStats();
    }
}


