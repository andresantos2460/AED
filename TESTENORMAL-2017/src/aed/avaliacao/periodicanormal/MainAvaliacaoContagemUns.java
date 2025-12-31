package aed.avaliacao.periodicanormal;

public class MainAvaliacaoContagemUns {

    public static void main(String[] args) {
        int[][] matriz = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0}
        };

        System.out.println("Número de uns na matriz: " + getNumeroUns(matriz));
    }


    private static int getNumeroUns(int[][] matriz) {
       if(matriz.length==0||matriz==null){
           throw new IndexOutOfBoundsException("Matriz invalida!");
       }
       int n = matriz.length;



        return matriz.length;
    }
}








