package aed.avaliacao.periodica;

import aed.Comparacao;

public enum ComparacaoFilmeAnoTituloDesc implements Comparacao<Filme> {
    CRITERIO;

    @Override
    public int comparar(Filme o1, Filme o2) {
        int result = Integer.compare(o1.getAno(), o2.getAno());
        if (result == 0) {
            return o2.getTitulo().compareTo(o1.getTitulo());
        }

        return result;
    }
}