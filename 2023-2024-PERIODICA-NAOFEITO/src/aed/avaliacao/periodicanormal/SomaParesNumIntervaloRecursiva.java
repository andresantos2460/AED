package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloRecursiva {
    public static long executar(int valorInicial, int valorFinal) {
        if(valorInicial>valorFinal){
            return 0;
        }
        if(valorInicial%2!=0){
            return executar(valorInicial+1,valorFinal);
        }
        return valorInicial + executar(valorInicial+1,valorFinal);
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
