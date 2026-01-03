package aed.avaliacao.periodica;

public class HofstadterQ {
    public static int executar(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Valores invalidos");
        }

        return executarRecursivo(n);
    }

    public static int executarRecursivo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return executarRecursivo(n - executarRecursivo(n - 1)) + executarRecursivo(n - executarRecursivo(n - 2));
    }

    public static void apresentar(int n) {
        System.out.print("Q(" + n + ") = ");

        try {
            long resultado = executar(n);
            System.out.println(resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
