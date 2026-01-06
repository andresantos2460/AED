package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum ComparacaoPontuacaoAsc implements Comparacao<Integer> {
    CRITERIO;

    @Override
    public int comparar(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
