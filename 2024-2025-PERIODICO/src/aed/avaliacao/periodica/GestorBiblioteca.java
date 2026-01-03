package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public enum GestorBiblioteca {
    INSTANCIA;

    GestorBiblioteca() {
    }

    public void inserir(Livro livro) {
        //todo pergunta 3.e)
    }

    public IteradorIteravelDuplo<Livro> getLivros() {
        //todo pergunta 3.a)
        return null;
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autor) {
        //todo pergunta 3.b)
        return null;
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autorInicial, String autorFinal) {
        //todo pergunta 3.c)
        return null;
    }

    public float getMediaNumerosPaginas() {
        //todo pergunta 3.d)
        return 0;
    }

}