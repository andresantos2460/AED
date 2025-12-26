package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.Maximo;

import static aed.utils.VetorDeInteiros.criarAleatorioInt;

public class MainPraticaMaximo {

    public static void main(String[] args) {
        int[] vetor = criarAleatorioInt(5, -50, 50, true);

        Maximo.apresentar(vetor);
    }
}
