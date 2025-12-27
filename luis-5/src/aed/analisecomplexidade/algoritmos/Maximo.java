package aed.analisecomplexidade.algoritmos;

import aed.utils.VetorDeInteiros;

public class Maximo {

    public static int executar(int[] valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("Pelo menos um valor");
        }
        int indiceMaximo=0;

        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > valores[indiceMaximo]) {
                indiceMaximo = i;
            }
        }

        return valores[indiceMaximo];
    }

    public static void apresentar(int[] valores) {
        try {
            System.out.println("O valor máximo é {");
            VetorDeInteiros.apresentar(30,valores);
            System.out.println("}" + executar(valores));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

