package aed.avaliacao.periodica;

import aed.colecoes.naoiteraveis.estruturas.Fila;

public class MainAvaliacaoDescompressaoFila {

    public static void main(String[] args) {
        MainAvaliacaoDescompressaoFila app = new MainAvaliacaoDescompressaoFila();
        Fila<Integer> entrada = new Fila<>();

        // Dados do exemplo da Figura 2:
        // entrada => 4, 1, 4, 3, 7, 7, 2, 1, 3, 3, 1, 8
        int[] dadosEntrada = {4, 1, 4, 3, 7, 7, 2, 1, 3, 3, 1, 8};

        for (int valor : dadosEntrada) {
            entrada.inserir(valor);
        }

        System.out.println("--- Fila de Entrada ---");
        System.out.println(entrada);

        // Executar a descompressão
        Fila<Integer> resultado = app.descomprimir(entrada);

        System.out.println("--- Fila de Saída (Descomprimida) ---");
        System.out.println(resultado);

        // Verificação final da entrada (deve estar vazia segundo o enunciado)
        System.out.println("Entrada está vazia? " + entrada.isVazia());
    }

    private Fila<Integer> descomprimir(Fila<Integer> entrada) {
        Fila<Integer> novaFila = new Fila<>();

        while (!entrada.isVazia()){
            int vezesAMostrar= entrada.remover();
            int valorAMostar= entrada.remover();

            for (int i = 0; i <vezesAMostrar ; i++) {
                novaFila.inserir(valorAMostar);
            }
        }
        return novaFila;
    }
}
