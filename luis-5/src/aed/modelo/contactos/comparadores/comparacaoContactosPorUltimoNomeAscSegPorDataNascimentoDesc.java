package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum comparacaoContactosPorUltimoNomeAscSegPorDataNascimentoDesc implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {

        int comparacaoNome = o1.getUltimoNome().compareTo(o2.getUltimoNome());
        if (comparacaoNome != 0) {
            return comparacaoNome;
        }

        return -o1.getDataNascimento().compareTo(o2.getDataNascimento());

    }
}