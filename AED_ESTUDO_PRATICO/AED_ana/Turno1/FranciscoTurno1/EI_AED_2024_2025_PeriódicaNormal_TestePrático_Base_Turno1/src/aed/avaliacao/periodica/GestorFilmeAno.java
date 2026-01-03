package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.io.Serializable;

public class GestorFilmeAno implements Serializable {

    private static final long serialVersionUID = 1L;
    private int ano;
    private ListaDuplaOrdenada<Filme> filmes;

    public GestorFilmeAno(int ano) {
        this.ano = ano;
        filmes = new ListaDuplaOrdenada<>(ComparacaoFilmeTituloDesc.CRITERIO);
    }

    public IteradorIteravelDuplo<Filme> getFilmes() {
        return filmes.iterador();
    }

    public void inserir(Filme filme) {
        filmes.inserir(filme);
    }
}
