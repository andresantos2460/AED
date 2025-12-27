package aed.analisecomplexidade.utilizacao;

import aed.analisecomplexidade.algoritmos.JogoTorresHanoi;
import aed.analisecomplexidade.algoritmos.Maximo;

public class MainPraticaJogoTorresHanoi {
    public static void main(String[] args) {
        int[] ns = {10, 1, 4, 5};
        for (int n : ns) {
            JogoTorresHanoi.executar(n);
        }
    }
}
