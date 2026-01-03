package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoGestorVideoteca {
    public static void main(String[] args) {
        Filme[] filmes = {
                new Filme("Pulp Fiction", 1994, 154),
                new Filme("Forrest Gump", 1994, 142),
                new Filme("Inside Out 2", 2024, 96),
                new Filme("Dune: Part Two", 2024, 166),
                new Filme("The Godfather", 1972, 175),
                new Filme("Interstellar", 2014, 169)
        };

        for (Filme filme : filmes) {
            GestorVideoteca.INSTANCIA.inserir(filme);
            System.out.println("Média das durações: " + GestorVideoteca.INSTANCIA.getMediaDuracoes() + "min");
        }

        System.out.println("\nTodos os filmes:");
        for (Filme filme : GestorVideoteca.INSTANCIA.getFilmes()) {
            System.out.println(filme);
        }

        System.out.println("\nFilmes de 2024:");
        for (Filme filme : GestorVideoteca.INSTANCIA.getFilmes(2024)) {
            System.out.println(filme);
        }

        System.out.println("\nFilmes de 1990 a 2020:");
        IteradorIteravelDuplo<Filme> filmesDe1990A2020 = GestorVideoteca.INSTANCIA.getFilmes(1990, 2020);
        while (filmesDe1990A2020.podeRecuar()) {
            System.out.println(filmesDe1990A2020.recuar());
        }
    }
}
