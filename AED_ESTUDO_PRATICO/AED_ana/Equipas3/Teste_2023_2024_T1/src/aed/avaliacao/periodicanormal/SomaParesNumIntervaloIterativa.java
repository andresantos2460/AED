package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloIterativa {
    public static long executar(int valorInicial, int valorFinal) {
        //todo pergunta 1.b)
        // Verifica se o intervalo é inválido
        if (valorInicial > valorFinal) {
            return 0; // Pode lançar uma exceção, se preferir
        }

        long soma = 0; // Inicializa a soma

        // Itera pelo intervalo
        for (int i = valorInicial; i <= valorFinal; i++) {
            if (i % 2 == 0) { // Verifica se o número é par
                soma += i; // Adiciona o número par à soma
            }
        }

        return soma;
    }

    public static void apresentar(int valorInicial, int valorFinal) {
        try {
            //executar o algoritmo
            long soma = executar(valorInicial, valorFinal);
            //apresentar o soma
            System.out.println("somaPares(" + valorInicial + ", " + valorFinal + ") = " + soma);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
