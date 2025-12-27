package aed.ordenacao.utilizacao;

import aed.modelo.contactos.Contacto;
import aed.modelo.contactos.Data;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDesc;
import aed.modelo.contactos.comparadores.comparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDesc;
import aed.ordenacao.algoritmos.InsertionSort;

import java.util.Arrays;

public class MainPraticaOrdenacaoContactos {
    public static void main(String[] args) {
        Contacto[] contactos1 = {
                new Contacto("Ana", "Silva", 950000000L, "Rua de Leiria", new Data(1, 10, 1990)),
                new Contacto("Ana", "Rita", 990000000L, "Travessa 25 de Abril", new Data(15, 6, 2000)),
                new Contacto("Hugo", "Santos", 971234567L, "Avenida 1º de Maio", new Data(18, 3, 1994)),
                new Contacto("Teresa", "Silva", 950000001L, "Rua de Leiria", new Data(2, 10, 1990)),
                new Contacto("Eça", "Queiroz", 100000000L, "Praça do Almada", new Data(25, 11, 1845))
        };

        Contacto[] contactos2 = Arrays.copyOf(contactos1, contactos1.length);

        InsertionSort<Contacto> ordenadorTelefone = new InsertionSort<>(ComparacaoContactosPorNumeroTelefoneDesc.CRITERIO);
        System.out.println("=== Ordenação por Número de Telefone (Descendente) ===");
        ordenadorTelefone.apresentar(10,contactos1);

        InsertionSort<Contacto> ordenadorNome = new InsertionSort<>(comparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDesc.CRITERIO);
        System.out.println("\nOrdenação por Último Nome (Ascendente) e Data de Nascimento (Descendente)");
        ordenadorNome.apresentar(contactos2);
    }
}
