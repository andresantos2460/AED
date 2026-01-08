package aed.avaliacao.recurso.modelo;

import aed.avaliacao.recurso.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;

public enum GestorImoveis {
    INSTANCIA;
    private ListaDuplaOrdenada<Imovel> imoveis;
    private TabelaHashComIncrementoPorHash<String,GestorImoveisConcelho> imoveisPorConcelho;
    GestorImoveis() {
        imoveis=new ListaDuplaOrdenada<>(ComparacaoPrecoAsc.CRITERIO);
        imoveisPorConcelho=new TabelaHashComIncrementoPorHash<>(4);
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis() {
        //TODO: PERGUNTA 3.a)
        return imoveis.iterador();
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis(String concelho) {
        GestorImoveisConcelho gestorConcelho=imoveisPorConcelho.consultar(concelho);

        return gestorConcelho==null?new ListaDuplaNaoOrdenada<Imovel>().iterador():gestorConcelho.iterador();
    }

    public Imovel consultarImovelComPrecoMaximo(String concelho) {
        //TODO: PERGUNTA 3.c)
        GestorImoveisConcelho gestorConcelho=imoveisPorConcelho.consultar(concelho);

        return gestorConcelho==null?null:gestorConcelho.iterador().recuar();
    }

    public double consultarPrecoMedioImoveis(String concelho, String tipologia) {
        GestorImoveisConcelho gestorConcelho=imoveisPorConcelho.consultar(concelho);
        return gestorConcelho==null?-1:gestorConcelho.consultarMedia(tipologia);
    }

    public void inserir(Imovel imovel) {
        imoveis.inserir(imovel);
        String concelho = imovel.getConcelho();
        GestorImoveisConcelho gestorConcelho=imoveisPorConcelho.consultar(concelho);

        if(gestorConcelho==null){
            gestorConcelho=new GestorImoveisConcelho(concelho);
            imoveisPorConcelho.inserir(concelho,gestorConcelho);
        }
        gestorConcelho.inserir(imovel);

    }

}
