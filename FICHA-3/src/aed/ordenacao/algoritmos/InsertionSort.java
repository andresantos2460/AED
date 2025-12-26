package aed.ordenacao.algoritmos;

import aed.Comparacao;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> {

    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(T... elementos) {
        int indiceUltimaTroca = elementos.length;

        for(int i = 1; i < indiceUltimaTroca; i++){
            T aux = elementos[i];
            int j = i - 1;
            while (j>=0&&criterio.comparar(aux,elementos[j])<0){
                elementos[j+1] = elementos[j];
                j--;
            }
            elementos[j + 1] = aux;
        }
    }

    @Override
    public void apresentar(int numeroElementosApresentar, T... elementos) {
        super.apresentar(numeroElementosApresentar, elementos);
    }
}
