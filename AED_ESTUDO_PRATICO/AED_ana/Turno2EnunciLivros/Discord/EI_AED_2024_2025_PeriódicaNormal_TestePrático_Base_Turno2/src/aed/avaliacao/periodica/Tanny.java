package aed.avaliacao.periodica;

import java.sql.SQLOutput;

public class Tanny {
    public static long executar(long n){
        if(n < 0){
            throw new IllegalArgumentException("O número deve ser positivo");
        }
        return Tanny(n);
    }

    public static long Tanny(long n){
        if(n == 0 || n == 1){
            return n + 1;
        }

        return Tanny(n - Tanny(n - 2)) + Tanny(n - Tanny(n - 1));
    }

    public static void apresentar(long n){
        try{
            System.out.println("Tanny(" + n +  ") = " + executar(n));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
