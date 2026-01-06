package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloRecursiva {
    public static long executar(int valorInicial, int valorFinal) {
        if(valorInicial>valorFinal){
            throw new IllegalArgumentException("Intervalo inválido");
        }
        return executarRecursivo(valorInicial,valorFinal);
    }
    public static long executarRecursivo(int valorInicial, int valorFinal) {

        if(valorInicial>valorFinal){
            return 0;
        }
        if(valorInicial%2!=0){
            return executarRecursivo(valorInicial+1,valorFinal);
        }
        return (valorInicial + executarRecursivo(valorInicial+1,valorFinal));
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
