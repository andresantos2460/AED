package aed.recursividade.algoritmos;

public class Fibonacci {
        public static int executar(int n){
            if (n < 0) {
                throw new IllegalArgumentException("Fibonacci ("+ n + ") = argumento invalido");
            }
            return executarRecursivo(n);
        }

        private static int executarRecursivo(int n) {
            if(n <= 1){
                return n;
            }
            return executarRecursivo(n-2) + executarRecursivo(n-1);
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
