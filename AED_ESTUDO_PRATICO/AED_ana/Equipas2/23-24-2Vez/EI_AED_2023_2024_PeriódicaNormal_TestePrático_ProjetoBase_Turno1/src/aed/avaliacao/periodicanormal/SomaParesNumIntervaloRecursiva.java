package aed.avaliacao.periodicanormal;


public class SomaParesNumIntervaloRecursiva {
    public static long executar(int valorInicial, int valorFinal) {
        //todo pergunta 1.a)

        if(valorInicial > valorFinal){
            throw new IllegalArgumentException("Valores invalidos");
        }
        if(valorInicial == valorFinal){
            if(valorInicial%2 == 0){
                return valorInicial;
            }
            return 0;
        }
        return executarRecursivo(valorInicial,valorFinal,0);
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

    public static long executarRecursivo(int valorInicial, int valorFinal,long soma) {

        if(valorInicial<=valorFinal){
            if(valorInicial % 2 == 0){
                soma+=valorInicial;
                return executarRecursivo(valorInicial+1, valorFinal, soma);
            }else {
                return executarRecursivo(valorInicial+1, valorFinal, soma);
            }
        }
        return soma;
    }
}
