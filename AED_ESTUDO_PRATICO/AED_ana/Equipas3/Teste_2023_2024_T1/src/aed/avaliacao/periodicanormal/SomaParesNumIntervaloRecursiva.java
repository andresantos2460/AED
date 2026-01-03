package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloRecursiva {
    public static long executar(int valorInicial, int valorFinal) {
        //todo pergunta 1.a)
        // Verifica se o intervalo é inválido
        if (valorInicial > valorFinal) {
            return 0; // Pode lançar uma exceção, se preferir
        }

        // Verifica se o número inicial é par
        if (valorInicial % 2 == 0) {
            // Soma o número atual e chama recursivamente com o próximo número
            return valorInicial + executar(valorInicial + 1, valorFinal);
        } else {
            // Apenas continua para o próximo número
            return executar(valorInicial + 1, valorFinal);
        }
    }

    public static void apresentar(int valorInicial, int valorFinal) {
        try {
            //executar o algoritmo
            long soma = executar(valorInicial, valorFinal);
            //apresentar o soma
            System.out.println("somaPares(" + valorInicial + ", " + valorFinal +  ") = " + soma);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
