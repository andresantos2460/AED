package aed.avaliacao.periodica;

import aed.Comparacao;

public enum ComparacaoStockAscECorAsc implements Comparacao<Sapatilha> {
    CRITERIO;

    @Override
    public int comparar(Sapatilha o1, Sapatilha o2) {
        int comp=-(o1.getStock().compareTo(o2.getStock()));
        if(comp!=0){
            return comp;
        }
        return o1.getCor().compareTo(o2.getCor());
    }
}
