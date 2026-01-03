package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.io.Serializable;

public class GestorLivroAutor implements Serializable {
    private final ListaDuplaOrdenada<Livro> livros;

    public GestorLivroAutor() {
        this.livros = new ListaDuplaOrdenada<>(CompararPaginaLivros.CRITERIO);
    }

    public IteradorIteravelDuplo<Livro> getLivros() {
        return livros.iterador();
    }

    public void inserir(Livro livro) {
        livros.inserir(livro);
    }
}