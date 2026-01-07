package aed.avaliacao.periodicanormal;

import aed.Comparacao;

public enum ComparacaoNifDesc implements Comparacao<Fatura> {
    CRITERIO;

    @Override
    public int comparar(Fatura o1, Fatura o2) {
        return -Float.compare(o1.getValor(),o2.getValor());
    }
}
