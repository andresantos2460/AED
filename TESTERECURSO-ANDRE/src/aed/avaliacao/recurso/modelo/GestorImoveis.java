package aed.avaliacao.recurso.modelo;

import aed.avaliacao.recurso.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;

public enum GestorImoveis {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Imovel> ITERADOR_IMOVEIS_VAZIO = new ListaDuplaNaoOrdenada<Imovel>().iterador();
    private ListaDuplaOrdenada<Imovel> imoveis;
    private TabelaHashComIncrementoPorHash<String,GestorImoveisConcelho> imoveisPorConcelho;

    GestorImoveis() {
        imoveis = new ListaDuplaOrdenada<>(ComparacaoImoveisPrecoAsc.CRITERIO);
        imoveisPorConcelho = new TabelaHashComIncrementoPorHash<>(2);
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis() {
        return imoveis.iterador();
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis(String concelho) {
        GestorImoveisConcelho imvoveisConcelho = imoveisPorConcelho.consultar(concelho);

            return imvoveisConcelho==null?ITERADOR_IMOVEIS_VAZIO:imvoveisConcelho.iterador();
    }

    public Imovel consultarImovelComPrecoMaximo(String concelho) {

        GestorImoveisConcelho imvoveisConcelho = imoveisPorConcelho.consultar(concelho);
        return imvoveisConcelho==null?null:imvoveisConcelho.iterador().recuar();
    }

    public double consultarPrecoMedioImoveis(String concelho, String tipologia) {
        GestorImoveisConcelho imoveisConcelho = imoveisPorConcelho.consultar(concelho);

        return imoveisConcelho==null? -1:imoveisConcelho.consultarPrecoMedio(tipologia);
    }

    public void inserir(Imovel imovel) {
        imoveis.inserir(imovel);
        String concelho = imovel.getConcelho();
        GestorImoveisConcelho gestorConcelho = imoveisPorConcelho.consultar(concelho);

        if (gestorConcelho==null){
            gestorConcelho = new GestorImoveisConcelho(concelho);
            imoveisPorConcelho.inserir(concelho,gestorConcelho);
        }
        gestorConcelho.inserir(imovel);
    }

}
