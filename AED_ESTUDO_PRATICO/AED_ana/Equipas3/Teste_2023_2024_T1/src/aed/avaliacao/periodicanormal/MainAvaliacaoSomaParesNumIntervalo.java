package aed.avaliacao.periodicanormal;


public class MainAvaliacaoSomaParesNumIntervalo {
    public static void main(String[] args) {
        int ns[][] = {
                {-2, 10},
                {10, 7},
                {1, 9},
                {9, 9}
        };

//        for(int intervalo[] : ns){
//            System.out.println(intervalo[0]);
//        }



        for (int intervalo[] : ns) {
            SomaParesNumIntervaloRecursiva.apresentar(intervalo[0], intervalo[1]);
            SomaParesNumIntervaloIterativa.apresentar(intervalo[0], intervalo[1]);
        }

    }
}
