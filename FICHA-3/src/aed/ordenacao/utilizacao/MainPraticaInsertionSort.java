package aed.ordenacao.utilizacao;

import aed.Comparacao;
import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.AlgoritmoOrdenacao;
import aed.ordenacao.algoritmos.InsertionSort;
import aed.utils.VetorDeInteiros;

public class MainPraticaInsertionSort {
    public static void main(String[] args) {

        InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.CRITERIO);

        insertionSort.apresentar(10, VetorDeInteiros.criarAleatorioInteger(10,-100,100,true));



    }
}
