package aed.avaliacao.periodica;

import aed.Comparacao;

public enum ComparacaoFilmeTituloDesc implements Comparacao<Filme> {
    CRITERIO;

    @Override
    public int comparar(Filme o1, Filme o2) {
        return o2.getTitulo().compareTo(o1.getTitulo());
    }
}
