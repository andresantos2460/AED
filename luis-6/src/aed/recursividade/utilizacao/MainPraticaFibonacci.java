package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fatorial;
import aed.recursividade.algoritmos.Fibonacci;

public class MainPraticaFibonacci {
    public static void main(String[] args) {
        int[] ns = {5, 0, -10, 40,45};
        for (int n : ns) {
            Fibonacci.apresentar(n);
        }
        for (int n = 5; n < 21; n+=3) {
            Fibonacci.apresentar(n);
        }

//        Fibonacci.apresentar(5);
//        Fibonacci.apresentar(0);
//        Fibonacci.apresentar(-10);
//        Fibonacci.apresentar(40);
//        Fibonacci.apresentar(45);
    }
}
