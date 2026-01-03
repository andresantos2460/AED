package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoGestorBiblioteca {
    public static void main(String[] args) {
        Livro[] livros = {
                new Livro("J.R.R. Tolkien", "O Hobbit", 310),
                new Livro("J.R.R. Tolkien", "O Silmarillion", 480),
                new Livro("Suzanne Collins", "Jogos Vorazes", 374),
                new Livro("Suzanne Collins", "Gregor", 288),
                new Livro("Toni Morrison", "Beloved", 374),
                new Livro("Luís Vaz de Camões", "Os Lusíadas", 559)
        };

        for (Livro livro : livros) {
            GestorBiblioteca.INSTANCIA.inserir(livro);
            System.out.println("Média dos números de páginas: " + GestorBiblioteca.INSTANCIA.getMediaNumerosPaginas() + " páginas");
        }

        System.out.println("\nTodos os livros:");
        for (Livro livro : GestorBiblioteca.INSTANCIA.getLivros()) {
            System.out.println(livro);
        }

        System.out.println("\nLivros de Suzanne Collins:");
        for (Livro livro : GestorBiblioteca.INSTANCIA.getLivros("Suzanne Collins")) {
            System.out.println(livro);
        }

        System.out.println("\nLivros de autores entre C e R:");
        IteradorIteravelDuplo<Livro> LivrosDeAutoresEntreCeM = GestorBiblioteca.INSTANCIA.getLivros("Suzanne Collins", "Toni Morrison");
        while (LivrosDeAutoresEntreCeM.podeRecuar()) {
            System.out.println(LivrosDeAutoresEntreCeM.recuar());
        }
    }
}
