package aed.avaliacao.periodicanormal;

public class SomaParesNumIntervaloIterativa {
    public static long executar(int valorInicial, int valorFinal) {
        if(valorInicial > valorFinal)
        {
            throw new IllegalArgumentException("Valores invalidos");
        }

        if(valorInicial == valorFinal){
            if(valorInicial %2 ==0){
                return valorInicial;
            }
            return 0;
        }



        long soma=0;
        while (valorInicial <= valorFinal)
        {
            if(valorInicial % 2==0)
            {
            soma+=valorInicial;
            }
            valorInicial++;
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
