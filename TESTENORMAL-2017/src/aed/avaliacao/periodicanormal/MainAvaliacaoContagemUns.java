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
        // 1. Verificação de segurança (Corrigida: null primeiro para evitar erro)
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("Matriz invalida!");
        }

        int n = matriz.length;
        int contagem_de_uns = 0;

        // 2. Loop para percorrer cada linha
        for (int i = 0; i < n; i++) {
            contagem_de_uns+=contagem_por_linha(matriz[i]);
        }

        return contagem_de_uns;
    }
    private static int contagem_por_linha(int[] linha){
        int total=0;

        int inicio=0;
        int fim=linha.length-1;
        int indice_ultimo_um=-1;

        while (inicio<=fim){
            int meio=(inicio+fim)/2;
            if(linha[meio]==1){
                indice_ultimo_um=meio;
                inicio=meio+1;
            }else{
                fim=meio-1;
            }

        }

        return indice_ultimo_um+1;

    }
}








