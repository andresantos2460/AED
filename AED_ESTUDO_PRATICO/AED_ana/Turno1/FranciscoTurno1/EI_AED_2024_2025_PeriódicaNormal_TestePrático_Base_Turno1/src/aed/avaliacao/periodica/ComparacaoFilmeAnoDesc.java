package aed.avaliacao.periodica;

import aed.Comparacao;

public enum ComparacaoFilmeAnoDesc implements Comparacao<Filme> {
    CRITERIO;

    @Override
    public int comparar(Filme o1, Filme o2) {
        int result = Integer.compare(o2.getAno(), o1.getAno());
        if (result == 0) {
            return o1.getTitulo().compareTo(o2.getTitulo());
        }

        return result;
    }
}
