package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum ComparacaoEquipasPontDesc implements Comparacao<Equipa> {
    CRITERIO;

    @Override
    public int comparar(Equipa e1, Equipa e2) {
        int comp = -Integer.compare(e1.getPontuacao(), e2.getPontuacao());
        if(comp != 0){
            return comp;
        }
        return -Integer.compare(e1.getDiferencaGolos(), e2.getDiferencaGolos());
    }
}
