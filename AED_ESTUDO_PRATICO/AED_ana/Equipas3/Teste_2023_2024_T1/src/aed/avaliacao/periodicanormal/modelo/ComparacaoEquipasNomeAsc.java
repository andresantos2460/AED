package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum ComparacaoEquipasNomeAsc implements Comparacao<Equipa> {
    CRITERIO;

    @Override
    public int comparar(Equipa e1, Equipa e2) {

    return e1.getNome().compareTo(e2.getNome());
    }
}
