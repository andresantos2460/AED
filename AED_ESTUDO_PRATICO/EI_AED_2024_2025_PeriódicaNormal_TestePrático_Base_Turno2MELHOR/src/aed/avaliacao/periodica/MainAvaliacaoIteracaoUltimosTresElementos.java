package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoIteracaoUltimosTresElementos {
    public static void main(String[] args) {
        ListaDuplaNaoOrdenada<String> lista = new ListaDuplaNaoOrdenada<>();
        listarUltimosTresElementos("Lista vazia", lista);

        lista.inserirNoFim("A");
        lista.inserirNoFim("B");
        listarUltimosTresElementos("Lista com 2 elementos", lista);

        lista.inserirNoFim("C");
        lista.inserirNoFim("D");
        listarUltimosTresElementos("Lista com 4 elementos", lista);
    }

    private static void listarUltimosTresElementos(String titulo, ListaDuplaNaoOrdenada<String> lista) {
        System.out.println(titulo);
        System.out.println("para a frente");
        IteradorIteravelDuplo<String> iteradorUltimosTresElementos = lista.iteradorUltimosTresElementos();
        for (String elemento : iteradorUltimosTresElementos) {
            System.out.println(elemento);
        }
        System.out.println();
        iteradorUltimosTresElementos.reiniciar();

        System.out.println("para trás");
        while (iteradorUltimosTresElementos.podeRecuar()) {
            System.out.println(iteradorUltimosTresElementos.recuar());
        }
        System.out.println();
    }
}
