package aed.avaliacao.periodicanormal;

import aed.avaliacao.periodicanormal.modelo.Equipa;
import aed.avaliacao.periodicanormal.modelo.GestorEquipas;

public class MainAvaliacaoGestorEquipas {
    public static void main(String[] args) {
        Equipa[] equipas = {
                new Equipa("Guimarães", 18, 29, 26),
                new Equipa("Sporting", 21, 44, 14),
                new Equipa("Porto", 23, 42, 15),
                new Equipa("Braga", 18, 33, 25),
                new Equipa("Benfica", 23, 45, 21)
        };

        for (Equipa equipa : equipas) {
            GestorEquipas.INSTANCIA.inserir(equipa);
            System.out.println("Média das pontuações: " + GestorEquipas.INSTANCIA.getMediaPontuacoes());
        }

        System.out.println("\nTodas as equipas ordenadas por pontuação descendente seguido por diferença de golos descendente:");
        for (Equipa equipa : GestorEquipas.INSTANCIA.getEquipas()) {
            System.out.println(equipa);
        }

        System.out.println("\nEquipas com pontuação igual a 23 ordenadas por nome ascendente:");
        for (Equipa equipa : GestorEquipas.INSTANCIA.getEquipas(23)) {
            System.out.println(equipa);
        }

        System.out.println("\nEquipas com pontuação entre 15 e 22:");
        for (Equipa equipa : GestorEquipas.INSTANCIA.getEquipas(15, 22)) {
            System.out.println(equipa);
        }
    }

    private static void lixo(int i) {
        System.out.println("int");
    }

    private static void lixo(Integer i) {
        System.out.println("Integer");
    }
}
