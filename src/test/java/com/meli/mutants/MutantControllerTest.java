package com.meli.mutants;

import com.meli.mutants.Controller.MutantController;
import com.meli.mutants.Model.Mutant;
import com.meli.mutants.Model.Stats;
import com.meli.mutants.Service.MutantDetectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MutantControllerTest {

    @Mock
    private MutantDetectorService mutantDetectorService;

    @InjectMocks
    private MutantController mutantController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDetectMutant() {
        // Simular la lógica de detección de mutantes según tu implementación actual
        Mutant mutant = new Mutant();
        mutant.setDna(new String[]{
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        });

        // Cuando se llame al método isMutant, retornar true
        when(mutantDetectorService.isMutant(mutant.getDna())).thenReturn(true);

        // Verificar el resultado
        ResponseEntity<String> responseEntity = mutantController.detectMutant(mutant);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Mutant detected!", responseEntity.getBody());
    }

    @Test
    public void testGetStats() {
        // Simular las estadísticas
        Stats stats = new Stats(1, 2, 0.5);
        when(mutantDetectorService.getStats()).thenReturn(stats);

        // Obtener las estadísticas y verificar la respuesta
        Stats responseStats = mutantController.getStats();
        assertEquals(stats, responseStats);
    }
}
