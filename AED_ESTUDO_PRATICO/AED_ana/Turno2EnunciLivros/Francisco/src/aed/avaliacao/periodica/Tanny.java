package aed.avaliacao.periodica;

public class Tanny {
    public static int executar(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Valor introduzido invalido");
        }

        return executarRecursivo(n);
    }

    public static int executarRecursivo(int n) {
        if (n == 0 || n == 1) {
            return n + 1;
        }

        return executarRecursivo(n - executarRecursivo(n - 2)) + executarRecursivo(n - executarRecursivo(n - 1));
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

