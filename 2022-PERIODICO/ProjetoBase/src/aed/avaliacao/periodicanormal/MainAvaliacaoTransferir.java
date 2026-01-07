package aed.avaliacao.periodicanormal;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoTransferir {
    public static void main(String[] args) {
        ListaDuplaCircularBaseNaoOrdenada<Integer> lista, outra;


        System.out.println("=======================================");
        System.out.println("AMBAS AS LISTAS COM ELEMENTOS");
        lista = new ListaDuplaCircularBaseNaoOrdenada<>();
        lista.inserir(3);
        lista.inserir(1);
        lista.inserir(5);
        outra = new ListaDuplaCircularBaseNaoOrdenada<>();
        outra.inserir(4);
        outra.inserir(2);
        transferirEApresentar(lista, outra);

        System.out.println("=======================================");
        System.out.println("LISTA COM ELEMENTOS E OUTRA VAZIA");
        lista = new ListaDuplaCircularBaseNaoOrdenada<>();
        lista.inserir(3);
        lista.inserir(1);
        lista.inserir(5);
        outra = new ListaDuplaCircularBaseNaoOrdenada<>();
        transferirEApresentar(lista, outra);

        System.out.println("=======================================");
        System.out.println("LISTA VAZIA E OUTRA COM ELEMENTOS");
        lista = new ListaDuplaCircularBaseNaoOrdenada<>();
        outra = new ListaDuplaCircularBaseNaoOrdenada<>();
        outra.inserir(3);
        outra.inserir(1);
        outra.inserir(5);
        transferirEApresentar(lista, outra);
    }

    private static void transferirEApresentar(ListaDuplaCircularBaseNaoOrdenada<Integer> lista, ListaDuplaCircularBaseNaoOrdenada<Integer> outra) {
        System.out.println("Listas antes de transferir");
        System.out.println("LISTA => " + lista);
        System.out.println("OUTRA => " + outra);

        lista.transferir(outra);
        System.out.println("Listas depois de transferir");
        System.out.println("LISTA => " + lista);
        System.out.println("OUTRA => " + outra);

        System.out.println("Listagem dos elementos da LISTA por ordem inversa");
        IteradorIteravelDuplo<Integer> iterador = lista.iterador();
        while (iterador.podeRecuar()) {
            System.out.println(iterador.recuar());
        }
    }
}
