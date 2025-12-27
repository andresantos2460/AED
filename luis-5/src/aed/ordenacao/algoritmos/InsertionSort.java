package aed.ordenacao.algoritmos;

import aed.Comparacao;
import aed.utils.Vetor;

import java.util.Arrays;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {
    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(T[] elementos) {
        for (int i = 1; i < elementos.length; i++) {
            T elemento = elementos[i];
            int j = i - 1;
            while (j >= 0 && criterio.comparar(elemento, elementos[j]) < 0) {
                elementos[j + 1] = elementos[j];
                j--;
            }
            elementos[j + 1] = elemento;
        }
    }

    public void apresentar(T[] elementos){
        Vetor.apresentar(elementos.length, elementos);
       super.apresentar(elementos.length, elementos);
    }
}
