package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloRecursiva {
    public static long executar(int valorInicial, int valorFinal) {
        //todo pergunta 1.a)
        return 0;
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
