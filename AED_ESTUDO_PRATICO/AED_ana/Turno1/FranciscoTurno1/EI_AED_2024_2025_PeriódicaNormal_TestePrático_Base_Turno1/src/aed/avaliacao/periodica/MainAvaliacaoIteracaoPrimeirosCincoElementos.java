package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoIteracaoPrimeirosCincoElementos {
    public static void main(String[] args) {
        ListaDuplaNaoOrdenada<String> lista = new ListaDuplaNaoOrdenada<>();
        listarCincoPrimeirosElementos("Lista vazia", lista);

        lista.inserirNoFim("A");
        lista.inserirNoFim("B");
        lista.inserirNoFim("C");
        listarCincoPrimeirosElementos("Lista com 3 elementos", lista);

        lista.inserirNoFim("D");
        lista.inserirNoFim("E");
        lista.inserirNoFim("F");
        listarCincoPrimeirosElementos("Lista com 6 elementos", lista);
    }

    private static void listarCincoPrimeirosElementos(String titulo, ListaDuplaNaoOrdenada<String> lista) {
        System.out.println(titulo);
        System.out.println("para a frente");
        IteradorIteravelDuplo<String> iteradoredPrimeirosCincoElementos = lista.iteradorPrimeirosCincoElementos();
        for (String elemento : iteradoredPrimeirosCincoElementos) {
            System.out.println(elemento);
        }
        System.out.println();
        iteradoredPrimeirosCincoElementos.reiniciar();

        System.out.println("para trás");
        while (iteradoredPrimeirosCincoElementos.podeRecuar()) {
            System.out.println(iteradoredPrimeirosCincoElementos.recuar());
        }
        System.out.println();
    }
}
