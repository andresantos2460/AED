package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum ComparcaoNomeEPontuacaoDescEDiferencaGolosDesc implements Comparacao<Equipa> {
    CRITERIO;

    @Override
    public int comparar(Equipa o1, Equipa o2) {

        int r = o1.getNome().compareTo(o2.getNome());
        if (r == 0)
            return 0;

        // 🔵 REGRA DE ORDENAÇÃO
        r = Integer.compare(o2.getPontuacao(), o1.getPontuacao());
        if (r != 0)
            return r;

        r = Integer.compare(o2.getDiferencaGolos(), o1.getDiferencaGolos());
        if (r != 0)
            return r;

        return o1.getNome().compareTo(o2.getNome());
    }
}
