package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum CompararPontuacao implements Comparacao<Equipa> {
    CRITERIO;

    @Override
    public int comparar(Equipa o1, Equipa o2) {
        int resultado = Integer.compare(o2.getPontuacao(), o1.getPontuacao());
        if (resultado == 0) {
            resultado = Integer.compare(o2.getDiferencaGolos(), o1.getDiferencaGolos());
        }
        return resultado;
    }

}
