package aed.avaliacao.recurso.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorImoveis {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Imovel> ITERADOR_LISTA_VAZIA = new ListaDuplaNaoOrdenada<Imovel>().iterador();
    private ListaDuplaOrdenada<Imovel> imoveis;
    private TabelaHashComIncrementoPorHash<String,GestorImoveisConcelho> imoveisPorConcelho;

    GestorImoveis() {
        imoveis = new ListaDuplaOrdenada<>(ComparacaoPrecoAsc.CRITERIO);
        imoveisPorConcelho=new TabelaHashComIncrementoPorHash<>(2);
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis() {
        return imoveis.iterador();
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis(String concelho) {
        GestorImoveisConcelho GestorConcelho = imoveisPorConcelho.consultar(concelho);

        return GestorConcelho==null? ITERADOR_LISTA_VAZIA:GestorConcelho.iterador();
    }

    public Imovel consultarImovelComPrecoMaximo(String concelho) {
        GestorImoveisConcelho GestorConcelho = imoveisPorConcelho.consultar(concelho);

        return GestorConcelho==null? null:GestorConcelho.iterador().recuar();
    }

    public double consultarPrecoMedioImoveis(String concelho, String tipologia) {
        GestorImoveisConcelho GestorConcelho = imoveisPorConcelho.consultar(concelho);
        return GestorConcelho==null? -1:GestorConcelho.consultarMedia(tipologia);
    }

    public void inserir(Imovel imovel) {
        //TODO: PERGUNTA 3.e)
    }

}
