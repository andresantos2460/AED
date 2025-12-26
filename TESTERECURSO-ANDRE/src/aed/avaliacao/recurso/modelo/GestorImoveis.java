package aed.avaliacao.recurso.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public enum GestorImoveis {
    INSTANCIA;

    GestorImoveis() {
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis() {
        //TODO: PERGUNTA 3.a)
        return null;
    }

    public IteradorIteravelDuplo<Imovel> consultarImoveis(String concelho) {
        //TODO: PERGUNTA 3.b)
        return null;
    }

    public Imovel consultarImovelComPrecoMaximo(String concelho) {
        //TODO: PERGUNTA 3.c)
        return null;
    }

    public double consultarPrecoMedioImoveis(String concelho, String tipologia) {
        //TODO: PERGUNTA 3.d)
        return -1;
    }

    public void inserir(Imovel imovel) {
        //TODO: PERGUNTA 3.e)
    }

}
