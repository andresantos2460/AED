package aed.avaliacao.periodica;

import aed.Comparacao;

public enum CompararPorString implements Comparacao<String> {
    CRITERIO;

    @Override
    public int comparar(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
