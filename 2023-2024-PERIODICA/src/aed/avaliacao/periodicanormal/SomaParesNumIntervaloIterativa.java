package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloIterativa {
    public static long executar(int valorInicial, int valorFinal) {
        if(valorInicial>valorFinal){
           throw new IllegalArgumentException("Intervalo inválido");
        }
        int soma=0;
        for (int i = valorInicial; i <= valorFinal; i++) {
            if(i%2!=0){
                continue;
            }

            soma+=i;
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
