package aed.analisecomplexidade.utilizacao;
import aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import aed.utils.Par;
import aed.utils.VetorDePoint2D;

import java.awt.geom.Point2D;

public class MainPraticaPontosMaisProximos {

    public static void main(String[] args) {

        Point2D[] pontos = {
                new Point2D.Double(1, 1),
                new Point2D.Double(4, 5),
                new Point2D.Double(1.5, 1.2),
                new Point2D.Double(8, 3),
                new Point2D.Double(2, 1.1)
        };

        Par<Point2D, Point2D> maisProximos = PontosMaisProximos.executar(pontos);

        // 3️⃣ Mostra os resultados
        System.out.println("Pontos mais próximos encontrados:");
        System.out.println("Ponto 1: " + maisProximos.getPrimeiro());
        System.out.println("Ponto 2: " + maisProximos.getSegundo());

        int[] ns = {15};
        for(int n : ns){
            PontosMaisProximos.apresentar(VetorDePoint2D.criarAleatorio(n));
        }

    }
}
