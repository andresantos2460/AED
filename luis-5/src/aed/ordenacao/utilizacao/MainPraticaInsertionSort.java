package aed.ordenacao.utilizacao;

import aed.ComparacaoInteiros;
import aed.analisecomplexidade.algoritmos.Maximo;
import aed.ordenacao.algoritmos.InsertionSort;
import aed.utils.VetorDeInteiros;

public class MainPraticaInsertionSort {
    public static void main(String[] args) {
       InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.CRITERIO);
//   Ex B     insertionSort.apresentar(6, 5,2,4,6,1,3);
        insertionSort.apresentar(VetorDeInteiros.criarAleatorioInteger( 100,-100, 50, true));
        }
}