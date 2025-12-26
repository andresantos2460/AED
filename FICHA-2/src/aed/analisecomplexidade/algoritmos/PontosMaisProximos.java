package aed.analisecomplexidade.algoritmos;

import aed.utils.Par;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class PontosMaisProximos {


    public static Par<Point2D,Point2D> executar(Point2D... pontos){

        if(pontos.length<2){
            throw new IllegalArgumentException("Devem existir pelo menos 2 elemntos");

        }
        if(pontos.length==2){
           return new Par<>(pontos[0],pontos[1]);

        }
        double distancia=Double.MAX_VALUE;
        int indice1=-1;
        int indice2=-2;

        for (int i = 0; i < pontos.length-1; i++) {

            for (int j = i+1; j < pontos.length; j++) {

                double dist=pontos[i].distance(pontos[j]);
                if(dist<distancia){
                    distancia=dist;
                    indice1=i;
                    indice2=j;
                }
            }
        }

        return new Par<>(pontos[indice1],pontos[indice2]);


    }

    public static void apresentar(Point2D... pontos) {
        try {
            // Guarda o resultado do método executar
            Par<Point2D, Point2D> resultado = executar(pontos);

            // Imprime o array de pontos e o par encontrado
            System.out.println("Pontos fornecidos: " + Arrays.toString(pontos));
            System.out.println("Par mais próximo: " + resultado);
            System.out.println("=======================");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


}
