package aed.recursividade.algoritmos;

public class Fatorial {
    public static double executar(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci ("+ n + ") = argumento invalido");
        }
        return executarRecursivo(n);
    }

    private static double executarRecursivo(int n) {
        if(n <= 1){
            return 1;
        }
        return n * executarRecursivo(n - 1);
    }

    public static void apresentar(int n){
        try {
            System.out.println(executar(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
        }

    }
}
