package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum CompararNomeAsc implements Comparacao<Equipa> {
    CRITERIO;

    @Override
    public int comparar(Equipa o1, Equipa o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
