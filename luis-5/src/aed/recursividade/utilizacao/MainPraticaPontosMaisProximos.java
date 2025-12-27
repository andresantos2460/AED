package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.PontosMaisProximos;
import aed.utils.VetorDePoint2D;

public class MainPraticaPontosMaisProximos {
    public static void main(String[] args) {
        int[] tamanhos = {5,10,15};
        for (int tamanho : tamanhos) {
            PontosMaisProximos.apresentar(VetorDePoint2D.criarAleatorio( tamanho));
        }
    }
}
