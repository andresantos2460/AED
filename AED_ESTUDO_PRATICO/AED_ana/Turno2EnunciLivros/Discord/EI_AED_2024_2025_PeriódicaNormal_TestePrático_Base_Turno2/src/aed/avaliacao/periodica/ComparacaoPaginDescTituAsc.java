package aed.avaliacao.periodica;

import aed.Comparacao;

public enum ComparacaoPaginDescTituAsc implements Comparacao<Livro> {
    CRITERIO;

    @Override
    public int comparar(Livro l1, Livro l2) {
        int comp = -Integer.compare(l1.getNumeroPaginas(), l2.getNumeroPaginas());
        if(comp != 0) return comp;
        return l1.getTitulo().compareTo(l2.getTitulo());
    }
}
