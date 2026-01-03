package aed.avaliacao.periodicanormal;

public class MainAvaliacaoMoverPrimeiroParaOFim {
    public static void main(String[] args) {
        int[] ns = {2, 1, 3};
        ListaSimplesNaoOrdenada<Integer> lista = new ListaSimplesNaoOrdenada<>();
//        processar(lista);
        for (int n : ns) {
            lista.inserir(n);

        }
        processar(lista);
    }

    private static void processar(ListaSimplesNaoOrdenada<Integer> lista) {
        System.out.println("-----------------------------");
        System.out.println("Lista Inicial");
        System.out.println(lista);
        lista.moverPrimeiroParaOFim();
        System.out.println("Lista Alterada");
        System.out.println(lista);
    }
}
