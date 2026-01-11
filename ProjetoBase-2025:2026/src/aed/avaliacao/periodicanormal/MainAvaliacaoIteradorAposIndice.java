package aed.avaliacao.periodicanormal;


public class MainAvaliacaoIteradorAposIndice {
    public static void main(String[] args) {
        ListaDuplaNaoOrdenada<Integer> elementos = new ListaDuplaNaoOrdenada<>();

        for (int i = 0; i < 10; i++) {
            elementos.inserir(i);
        }

        System.out.println("Iterador completo");
        for (Integer elemento : elementos) {
            System.out.println(elemento);
        }

        System.out.println("Iterador após índice 3 exclusivo");
        for (Integer i : elementos.consultarApos(3)) {
            System.out.println(i);
        }
    }
}
