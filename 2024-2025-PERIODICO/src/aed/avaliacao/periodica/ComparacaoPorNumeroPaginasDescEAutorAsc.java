package aed.avaliacao.periodica;

import aed.Comparacao;

public enum ComparacaoPorNumeroPaginasDescEAutorAsc implements Comparacao<Livro> {
    CRITERIO;

    @Override
    public int comparar(Livro o1, Livro o2) {
        int cmp=o2.getNumeroPaginas()-o1.getNumeroPaginas();

        if(cmp!=0){
            return cmp;
        }
        return o1.getTitulo().compareTo(o2.getTitulo());

    }
}
