package aed.recursividade.utilizacao;

import aed.analisecomplexidade.algoritmos.Maximo;
import aed.utils.VetorDeInteiros;

public class MainPraticaMaximo {
    public static void main(String[] args) {
        int[] tamanhos = {5,10};
        for (int tamanho : tamanhos) {
            Maximo.apresentar(VetorDeInteiros.criarAleatorioInt( tamanho,-50, 50, true));
        }
    }
}
