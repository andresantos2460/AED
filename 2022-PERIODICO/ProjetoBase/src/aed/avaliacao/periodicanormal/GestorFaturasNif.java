package aed.avaliacao.periodicanormal;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseOrdemMaximaOrdenada;

import java.util.Objects;

public class GestorFaturasNif {
    private long nif;
    private ListaDuplaCircularBaseOrdemMaximaOrdenada<Fatura> faturas;
    private float totalFaturado;
    public GestorFaturasNif(long nif) {
        this.nif = nif;
        this.faturas=new ListaDuplaCircularBaseOrdemMaximaOrdenada<>(ComparacaoNifDesc.CRITERIO);
        totalFaturado=0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GestorFaturasNif that = (GestorFaturasNif) o;
        return nif == that.nif;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    public long getNif() {
        return nif;
    }

    public float getTotalFaturado() {
        return totalFaturado;
    }

    public IteradorIteravelDuplo<Fatura> iterador() {
        return faturas.iterador();
    }

    public void inserir(Fatura fatura) {
        faturas.inserir(fatura);
        totalFaturado+=fatura.getValor();
    }
}
