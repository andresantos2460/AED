package aed.avaliacao.periodica;

import java.util.concurrent.ExecutionException;

public class Tanny {


    public static int executar(int n){
        if(n<0){
            throw new IllegalArgumentException("Valor negativo não são permitidos;");
        }
       return executarTanny(n);
    }
    public static int executarTanny(int n) {
        if(n==0||n==1){
            return n+1;
        }
        return executarTanny((n-executarTanny(n-2)))+executarTanny((n-executarTanny(n-1)));
    }


    public static void apresentar(int p_valor){
        try {
            System.out.println("Resultado:"+executar(p_valor));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}




