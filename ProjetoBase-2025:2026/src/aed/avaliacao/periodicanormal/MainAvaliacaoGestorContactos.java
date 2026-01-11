package aed.avaliacao.periodicanormal;

import aed.avaliacao.periodicanormal.modelo.Contacto;
import aed.avaliacao.periodicanormal.modelo.GestorContactos;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoGestorContactos {
    public static void main(String[] args) {
        Contacto[] contactos = {
                new Contacto("Fernando", "Faria", 910000003, "R. Flores", 170),
                new Contacto("Ana", "Silva", 960000001, "R. Leiria", 160),
                new Contacto("Joana", "Melo", 930000001, "R. de Lá", 170),
                new Contacto("Ana", "Mendes", 910000001, "R. Flores", 170),
                new Contacto("Tiago", "Pais", 930000003, "Av. Liberdade", 183),
                new Contacto("Ana", "Pais", 930000002, "R. de Lá", 173),

        };

        for (Contacto contacto : contactos) {
            GestorContactos.INSTANCIA.inserir(contacto);
            System.out.println("Amplitude das alturas: " + GestorContactos.INSTANCIA.getAmplitudeAlturas() + "cm");
        }

        System.out.println("\nTodos os contactos:");
        for (Contacto contacto : GestorContactos.INSTANCIA.getContactos()) {
            System.out.println(contacto);
        }

        System.out.println("\nContactos com 170cm:");
        for (Contacto contacto : GestorContactos.INSTANCIA.getContactos(170)) {
            System.out.println(contacto);
        }

        System.out.println("\nContactos com altura de 170cm a 175cm:");
        IteradorIteravelDuplo<Contacto> contactosDe170a175 = GestorContactos.INSTANCIA.getContactos(170,175);
        while (contactosDe170a175.podeRecuar()) {
            System.out.println(contactosDe170a175.recuar());
        }

    }
}
