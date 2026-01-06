package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoGestorSapatilhas {
    public static void main(String[] args) {
        GestorSapatilhas gestor = GestorSapatilhas.INSTANCIA;

        // 1. Inserir dados para o teste (baseado no output da imagem)
        // Ordem sugerida: marca, cor, tamanho, stock
        gestor.inserir(new Sapatilha("Adidas", "Azul", 36, 10));
        gestor.inserir(new Sapatilha("Nike", "Creme", 36, 10));
        gestor.inserir(new Sapatilha("Nike", "Azul", 36, 8));
        gestor.inserir(new Sapatilha("Nike", "Vermelho", 36, 8));
        // Exemplo extra para garantir que filtros funcionam (tamanho diferente)
        gestor.inserir(new Sapatilha("Reebok", "Branco", 38, 5));

        // --- Teste Alínea a) ---
        System.out.println("Sapatilhas com número 36:");
        IteradorIteravelDuplo<Sapatilha> it36 = gestor.consultar(36);
        imprimirSapatilhas(it36);

        System.out.println();

        // --- Teste Alínea b) ---
        System.out.println("Sapatilhas com o número 36 da marca Nike:");
        IteradorIteravelDuplo<Sapatilha> it36Nike = gestor.consultar(36, "Nike");
        imprimirSapatilhas(it36Nike);

        System.out.println();

        // --- Teste Alínea c) ---
        System.out.println("Marcas com o número 36:");
        IteradorIteravelDuplo<String> itMarcas = gestor.consultarMarcas(36);
        if (itMarcas != null) {
            while (itMarcas.hasNext()) {
                System.out.println(itMarcas.next());
            }
        }
    }

    private static void imprimirSapatilhas(IteradorIteravelDuplo<Sapatilha> it) {
        if (it == null) return;
        while (it.hasNext()) {
            Sapatilha s = it.next();
            // Formato: tamanho, marca, cor, stock
            System.out.println(s.getTamanho() + ", " + s.getMarca() + ", " + s.getCor() + ", " + s.getStock());
        }
    }
}
