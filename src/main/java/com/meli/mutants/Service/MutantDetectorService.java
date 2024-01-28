package com.meli.mutants.Service;

import com.meli.mutants.Model.Mutant;
import com.meli.mutants.Model.Stats;
import com.meli.mutants.Repository.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantDetectorService {

    //Anotacion Autowired para inyeccion de dependencias de MutantRepository
    @Autowired
    private MutantRepository mutantRepository;
    // Contadores para stats
    private long countMutantDna = 0;
    private long countHumanDna = 0;

    //Metodo principal para analizar si un adn es mutante
    public boolean isMutant(String[] dna) {
        int n = dna.length;

        // Verifica horizontal y verticalmente
        for (int i = 0; i < n; i++) {
            if (checkSequence(dna[i]) || checkSequence(getVerticalSequence(dna, i))) {
                saveMutantResult(dna, true);
                countMutantDna++;
                return true;
            }
        }

        // Verifica diagonalmente
        for (int i = 0; i < n; i++) {
            if (checkSequence(getDiagonalSequence(dna, i, 0)) || checkSequence(getDiagonalSequence(dna, 0, i))) {
                saveMutantResult(dna, true);
                countMutantDna++;
                return true;
            }
        }
        // Si no se encuentra ninguna secuencia mutante, se guarda el resultado como no mutante
        saveMutantResult(dna, false);
        countHumanDna++;
        return false;
    }

    //Metodo que verifica si una secuencia contiene una cadena mutante
    private boolean checkSequence(String sequence) {
        return sequence.contains("AAAA") || sequence.contains("TTTT") || sequence.contains("CCCC") || sequence.contains("GGGG");
    }

    // Metodo que obtiene la secuencia vertical de un ADN
    private String getVerticalSequence(String[] dna, int col) {
        StringBuilder verticalSequence = new StringBuilder();
        for (String row : dna) {
            verticalSequence.append(row.charAt(col));
        }
        return verticalSequence.toString();
    }

    // Metodo que obtiene la secuencia diagonal de un ADN
    private String getDiagonalSequence(String[] dna, int row, int col) {
        StringBuilder diagonalSequence = new StringBuilder();
        int n = dna.length;
        while (row < n && col < n) {
            diagonalSequence.append(dna[row++].charAt(col++));
        }
        return diagonalSequence.toString();
    }

    //Metodo que guarda el resultado de la verificación en la base de datos
    private void saveMutantResult(String[] dna, boolean isMutant) {
        // Guardar el resultado en la base de datos utilizando el repositorio
        // Puedes adaptar esto según tu modelo de datos y estructura del repositorio
        String dnaSequence = String.join(",", dna);
        mutantRepository.save(new Mutant(dna, isMutant));
    }

    //Metodo que devuelve las estadísticas de mutantes y humanos
    public Stats getStats() {
        double ratio = (countHumanDna == 0) ? 1.0 : (double) countMutantDna / countHumanDna;
        return new Stats(countMutantDna, countHumanDna, ratio);
    }
}



