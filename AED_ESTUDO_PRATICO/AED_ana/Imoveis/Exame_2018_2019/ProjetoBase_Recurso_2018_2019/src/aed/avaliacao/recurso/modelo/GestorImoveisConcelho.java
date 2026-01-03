package aed.avaliacao.recurso.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.io.Serializable;
import java.util.Objects;

public class GestorImoveisConcelho implements Serializable {
    private static final long serialVersionUID = 1L;

    private String concelho;
    private ListaDuplaOrdenada<Imovel> imoveis;
    private TabelaHashComIncrementoPorHash<String, GestorPrecoMedio> precosMedio;

    //TODO Shift f6 - Alterar precosMedio para precoMedioPorTipologia (não alterei para não estragar o IDS)
    public GestorImoveisConcelho(String concelho) {
        this.concelho = concelho;
        imoveis = new ListaDuplaOrdenada<>(ComparacaoImoveisPorPrecoAsc.CRITERIO);
        precosMedio = new TabelaHashComIncrementoPorHash<>(2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestorImoveisConcelho that = (GestorImoveisConcelho) o;
        return Objects.equals(concelho, that.concelho);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(concelho);
    }

    @Override
    public String toString() {
        return " (" + concelho + ", " + imoveis + ", " + precosMedio + ")";
    }

    public IteradorIteravelDuplo<Imovel> getImoveis() {
        return imoveis.iterador();
    }

    public Imovel getImovelComPrecoMaximo() {
        return imoveis.consultarPorIndice(imoveis.getNumeroElementos() - 1);
    }

    public double consultarPrecoMedioImoveis(String tipologia) {
        GestorPrecoMedio precoMedio = precosMedio.consultar(tipologia);
        return precoMedio == null ? 0D : precoMedio.getMedia();
    }

    public void inserir(Imovel imovel) {
        imoveis.inserir(imovel);
        String tipologia = imovel.getTipologia();
        GestorPrecoMedio precoMedio = precosMedio.consultar(tipologia);
        if (precoMedio == null) {
            precoMedio = new GestorPrecoMedio(tipologia);
            precosMedio.inserir(tipologia,precoMedio);
        }
        precoMedio.inserir(imovel);
    }
}