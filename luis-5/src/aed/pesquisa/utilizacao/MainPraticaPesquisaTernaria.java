package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.QuickSort;
import aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import aed.utils.VetorDeInteiros;

import java.util.Random;

public class MainPraticaPesquisaTernaria {
    public static void main(String[] args) {
        Random random = new Random();
        int elemento = random.nextInt(21) - 10;

        Integer[] elementos = VetorDeInteiros.criarAleatorioInteger(10, -10, 10, true);
        new QuickSort<>(ComparacaoInteiros.CRITERIO).ordenar(elementos);
        //new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO).apresentar(10, elemento, elementos);
        new PesquisaTernariaIterativa<>(ComparacaoInteiros.CRITERIO).apresentar(10, elemento, elementos);
    }
}

