package aed.analisecomplexidade.algoritmos;

import java.util.Arrays;

public class Maximo {

    public static int executar(int [] numeros){

        int ArrayLength = numeros.length;
        if(ArrayLength ==0){
            throw new IllegalArgumentException("Array Vazio");
        }
        int ultimoNumero=numeros[0];


        for (int i = 1; i < ArrayLength; i++) {
            if (numeros[i]>ultimoNumero){
                ultimoNumero=numeros[i];
            }
        }

        return ultimoNumero;

    }

    public static void apresentar(int... inteiros){
        try{
            System.out.println("máximo(" + Arrays.toString(inteiros) + ") = " + executar(inteiros));
            System.out.println("=======================");
            executar(inteiros);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
