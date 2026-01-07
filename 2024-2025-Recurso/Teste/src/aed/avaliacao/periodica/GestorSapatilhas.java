package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;

public enum GestorSapatilhas {
    INSTANCIA;
    private TabelaHashComIncrementoPorHash<Integer,GestorSapatilhasTamanho> sapatilhasPorTamanho;
    GestorSapatilhas() {
        this.sapatilhasPorTamanho=new TabelaHashComIncrementoPorHash<>(4);
    }


    public IteradorIteravelDuplo<Sapatilha> consultar(int tamanho) {
        GestorSapatilhasTamanho gestorTamanho=sapatilhasPorTamanho.consultar(tamanho);
        return gestorTamanho==null?new ListaDuplaNaoOrdenada<Sapatilha>().iterador():gestorTamanho.iterador();
    }

    public IteradorIteravelDuplo<Sapatilha> consultar(int tamanho,String marca) {
        //todo pergunta 3.b)
        GestorSapatilhasTamanho gestorTamanho=sapatilhasPorTamanho.consultar(tamanho);

        return gestorTamanho==null?new ListaDuplaNaoOrdenada<Sapatilha>().iterador():gestorTamanho.consultarComMarca(marca);
    }

    public IteradorIteravelDuplo<String> consultarMarcas(int tamanho) {
        //todo pergunta 3.c)
        //todo pergunta 3.b)
        GestorSapatilhasTamanho gestorTamanho=sapatilhasPorTamanho.consultar(tamanho);

        return gestorTamanho==null?new ListaDuplaNaoOrdenada<String>().iterador():gestorTamanho.consultarMarcas();
    }

    public void inserir(Sapatilha Sapatilha) {
       GestorSapatilhasTamanho gestorTamanho=sapatilhasPorTamanho.consultar(Sapatilha.getTamanho());
       if(gestorTamanho==null){
           gestorTamanho=new GestorSapatilhasTamanho(Sapatilha.getTamanho());
           sapatilhasPorTamanho.inserir(Sapatilha.getTamanho(),gestorTamanho);
       }
       gestorTamanho.inserir(Sapatilha);
    }

}