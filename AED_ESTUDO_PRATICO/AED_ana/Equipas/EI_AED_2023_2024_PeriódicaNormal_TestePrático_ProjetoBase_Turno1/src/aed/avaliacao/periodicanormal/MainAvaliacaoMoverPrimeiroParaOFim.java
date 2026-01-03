package aed.avaliacao.periodicanormal;

public class MainAvaliacaoMoverPrimeiroParaOFim {
    public static void main(String[] args) {
        int[] ns = {0, 1, 2, 3};
        ListaSimplesNaoOrdenada<Integer> lista = new ListaSimplesNaoOrdenada<>();
        processar(lista);
        for (int n = 1; n < ns.length; n++) {
            lista.inserir(n);
            processar(lista);
        }
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
