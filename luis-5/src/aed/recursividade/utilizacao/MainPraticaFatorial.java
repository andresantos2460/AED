package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fatorial;
public class MainPraticaFatorial {

    public static void main(String[] args) {
        int[] ns = {5, 0, -5, 21};
        for (int n : ns) {
            Fatorial.apresentar(n);
        }
        for (int n = 0; n < 31; n++) {
            Fatorial.apresentar(n);
        }

        Fatorial.apresentar(5);
        Fatorial.apresentar(0);
        Fatorial.apresentar(-5);
        Fatorial.apresentar(21);
    }
}


