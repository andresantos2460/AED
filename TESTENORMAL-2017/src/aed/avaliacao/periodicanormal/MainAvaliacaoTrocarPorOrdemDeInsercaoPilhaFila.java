package aed.avaliacao.periodicanormal;


import aed.colecoes.naoiteraveis.estruturas.Fila;
import aed.colecoes.naoiteraveis.estruturas.Pilha;

public class MainAvaliacaoTrocarPorOrdemDeInsercaoPilhaFila {

    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<>();
        pilha.inserir(1);
        pilha.inserir(2);
        pilha.inserir(3);

        Fila<Integer> fila = new Fila<>();
        fila.inserir(11);
        fila.inserir(12);
        fila.inserir(13);

        System.out.println(pilha);
        System.out.println(fila);

        trocarPorOrdemDeInsercao(pilha, fila);

        System.out.println(pilha);
        System.out.println(fila);
    }

    private static <T> void trocarPorOrdemDeInsercao(Pilha<T> pilha, Fila<T> fila) {
        //todo pergunta 2.
    }
}
