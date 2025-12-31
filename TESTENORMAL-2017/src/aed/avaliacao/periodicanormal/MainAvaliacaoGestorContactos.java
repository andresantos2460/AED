package aed.avaliacao.periodicanormal;

import aed.avaliacao.periodicanormal.modelo.GestorContactos;
import aed.avaliacao.periodicanormal.modelo.Contacto;
import aed.avaliacao.periodicanormal.modelo.Data;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public class MainAvaliacaoGestorContactos {

    public static void main(String[] args) {
        Contacto[] contactos = {
                new Contacto("Manuel", "Silva", 910000000, "Lisboa",
                        new Data(1, 1, 2010), 130.4f),
                new Contacto("Maria", "Silva", 920000000, "Torres Novas",
                        new Data(10, 1, 2000), 40.1f),
                new Contacto("José", "Santos", 960000000, "Porto",
                        new Data(10, 12, 2000), 180.7f),
                new Contacto("Ana", "Campos", 930000000, "Marinha Grande",
                        new Data(20, 05, 2001), 13.2f)
        };

        for (Contacto contacto : contactos) {
            GestorContactos.INSTANCIA.inserir(contacto);
        }

        System.out.println("Todos os contactos:");
        apresentar(GestorContactos.INSTANCIA.getContactos());

        System.out.println("\nContactos que residem até 100 km de Leiria");
        apresentar(GestorContactos.INSTANCIA.consultar(100));

        System.out.println("\nContactos que residem até 100 km de Leiria e nascidos em 2000");
        apresentar(GestorContactos.INSTANCIA.consultar(100, 2000));
    }

    private static void apresentar(IteradorIteravelDuplo<Contacto> iteradorContactos) {
        for (Contacto contacto : iteradorContactos) {
            System.out.print("(" + String.format("%.1f", contacto.getDistanciaALeiria()) + " km) " + contacto);
        }
    }
}
