package aed.avaliacao.periodicanormal;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseOrdemMaximaOrdenada;

public enum GestorFaturas {
    INSTANCIA;
    private ListaDuplaCircularBaseOrdemMaximaOrdenada<Fatura> faturas;
    private TabelaHashPorSondagemComIncrementoPorHash<Long,GestorFaturasNif> faturasPorNif;
    GestorFaturas() {
        faturas=new ListaDuplaCircularBaseOrdemMaximaOrdenada<>(ComparacaoNifAscEidentificacaoAsc.CRITERIO);
        faturasPorNif=new TabelaHashPorSondagemComIncrementoPorHash<>(4);
    }

    public IteradorIteravelDuplo<Fatura> getFaturas() {
        return faturas.iterador();
    }

    public IteradorIteravelDuplo<Fatura> getFaturas(long nifCliente) {
        //todo pergunta 3.b)
        GestorFaturasNif gestorNif=faturasPorNif.consultar(nifCliente);
        return gestorNif==null? new ListaDuplaCircularBaseNaoOrdenada<Fatura>().iterador():gestorNif.iterador();
    }

    public float getTotalFaturado(long nifCliente) {
        GestorFaturasNif gestorNif=faturasPorNif.consultar(nifCliente);

        return gestorNif==null? -1:gestorNif.getTotalFaturado();
    }

    public void inserir(Fatura fatura) {
        faturas.inserir(fatura);
        GestorFaturasNif gestorFatura=faturasPorNif.consultar(fatura.getNifCliente());
        if(gestorFatura==null){
            gestorFatura=new GestorFaturasNif(fatura.getNifCliente());
            faturasPorNif.inserir(fatura.getNifCliente(),gestorFatura);
        }
        gestorFatura.inserir(fatura);
    }
}
