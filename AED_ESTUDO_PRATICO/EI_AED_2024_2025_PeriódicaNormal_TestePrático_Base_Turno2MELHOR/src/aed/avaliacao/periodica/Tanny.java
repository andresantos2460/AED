package aed.avaliacao.periodica;

public class Tanny {
    public static int executar(int n){
        if(n < 0){
            throw new IllegalArgumentException("Valor introduzido invalido");
        }

        return executarRecursivo(n);
    }

    public static int executarRecursivo(int n){
        if(n == 0 || n == 1){
            return n + 1;
        }

        return executarRecursivo(n - executarRecursivo(n -2) + executarRecursivo(n - executarRecursivo(n - 1)));
    }

    public static void apresentar(int n) {
        System.out.print("Algoritmo de tanny para o valor " + n + " = ");

        try {
            long result = executar(n);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }

}

/*
No teste da disciplina Algoritmos e estrutura de dados "java", tenho este exercicio para fazer:

Função Area
A função area é uma funçao recursiva para calculo de areas(contagem do numero de posicoes), onde numa matriz de caracteres e dada uma posicao(linhaInicial, colunaInicial) se coloca um 'X' neessa posicao incrementado o valor da area. Deve, ainda, proceder de forma semelhante para todos os vizinhos dessa posicao (posicoes a Norte, Sul, Este e Oeste) que contiverem o mesmo carater que estava originalmente na posicao dada.
Implemente a funcao void executar(char[][]matriz, int linhaInicial, int colunaInicial) na classe Area.

 */
