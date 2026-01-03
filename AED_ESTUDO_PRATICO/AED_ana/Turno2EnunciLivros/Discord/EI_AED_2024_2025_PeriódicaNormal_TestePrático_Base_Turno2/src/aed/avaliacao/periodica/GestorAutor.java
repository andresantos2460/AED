package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.io.Serializable;
import java.util.Objects;

public class GestorAutor implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Autor;
    private ListaDuplaOrdenada<Livro> livros;

    public GestorAutor(String autor){
        Autor = autor;
        livros = new ListaDuplaOrdenada<>(ComparacaoPaginDescTituAsc.CRITERIO);
    }

    public void inserir(Livro livro){
        livros.inserir(livro);
    }

    public IteradorIteravelDuplo<Livro> iterador(){
        return livros.iterador();
    }
}
