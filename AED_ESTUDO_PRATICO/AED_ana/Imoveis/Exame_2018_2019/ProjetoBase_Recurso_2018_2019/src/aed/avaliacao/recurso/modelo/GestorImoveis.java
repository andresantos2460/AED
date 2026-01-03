package aed.avaliacao.recurso.modelo;

import aed.avaliacao.recurso.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;

public enum GestorImoveis {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Imovel> ITERADOR_IMOVEIS_VAZIO = new ListaDuplaNaoOrdenada<Imovel>().iterador();
    private ListaDuplaOrdenada<Imovel> imoveis;
    private TabelaHashComIncrementoPorHash<String, GestorImoveisConcelho> imoveisPorConcelho;

    GestorImoveis() {
        imoveis = new ListaDuplaOrdenada<>(ComparacaoImoveisPorPrecoAsc.CRITERIO);
        imoveisPorConcelho = new TabelaHashComIncrementoPorHash<>(2);
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis() {
        //TODO: PERGUNTA 3.a)
        return imoveis.iterador();
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis(String concelho) {
        //TODO: PERGUNTA 3.b)
        GestorImoveisConcelho imoveisConcelho = imoveisPorConcelho.consultar(concelho);
        return imoveisConcelho == null ? ITERADOR_IMOVEIS_VAZIO : imoveisConcelho.getImoveis();
    }

    public Imovel consultarImovelComPrecoMaximo(String concelho) {
        //TODO: PERGUNTA 3.c)
        GestorImoveisConcelho imoveisConcelho = imoveisPorConcelho.consultar(concelho);
        return imoveisConcelho == null ? null : imoveisConcelho.getImovelComPrecoMaximo();
    }

    public double consultarPrecoMedioImoveis(String concelho, String tipologia) {
        //TODO: PERGUNTA 3.d)
        GestorImoveisConcelho imoveisConcelho = imoveisPorConcelho.consultar(concelho);
        return imoveisConcelho == null ? 0D : imoveisConcelho.consultarPrecoMedioImoveis(tipologia);
    }

    public void inserir(Imovel imovel) {
        //TODO: PERGUNTA 3.e)
        imoveis.inserir(imovel);
        String concelho = imovel.getConcelho();
        GestorImoveisConcelho imoveisConcelho = imoveisPorConcelho.consultar(concelho);
                if(imoveisConcelho == null){
                    imoveisConcelho = new GestorImoveisConcelho(concelho);
                    imoveisPorConcelho.inserir(concelho,imoveisConcelho);
                }
                imoveisConcelho.inserir(imovel);
    }

}
