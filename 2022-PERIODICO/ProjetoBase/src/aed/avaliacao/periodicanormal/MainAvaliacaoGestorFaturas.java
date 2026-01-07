package aed.avaliacao.periodicanormal;

public class MainAvaliacaoGestorFaturas {
    public static void main(String[] args) {
        long[] nifsClientes = {111111111, 222222222, 333333333};

        GestorFaturas.INSTANCIA.inserir(new Fatura("F1/2022", nifsClientes[0], 17.5f));
        GestorFaturas.INSTANCIA.inserir(new Fatura("F2/2022", nifsClientes[1], 12.5f));
        GestorFaturas.INSTANCIA.inserir(new Fatura("F3/2022", nifsClientes[1], 10.5f));
        GestorFaturas.INSTANCIA.inserir(new Fatura("F4/2022", nifsClientes[0], 10.5f));
        GestorFaturas.INSTANCIA.inserir(new Fatura("F5/2022", nifsClientes[2], 17.5f));

        System.out.println("Todas as faturas");
        for (Fatura fatura : GestorFaturas.INSTANCIA.getFaturas()) {
            System.out.println(fatura);
        }

        for (long nifCliente : nifsClientes) {
            System.out.println("================================================");
            System.out.println("Faturas do cliente com NIF: " + nifCliente);
            for (Fatura fatura : GestorFaturas.INSTANCIA.getFaturas(nifCliente)) {
                System.out.println(fatura);
            }
        }

        System.out.println("================================================");
        System.out.print("Total faturado ao cliente com NIF: " + nifsClientes[0] + " = ");
        System.out.println(GestorFaturas.INSTANCIA.getTotalFaturado(nifsClientes[0]) + "€");
    }
}
