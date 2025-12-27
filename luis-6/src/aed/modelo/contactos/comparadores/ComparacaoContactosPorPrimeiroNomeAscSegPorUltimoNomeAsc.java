package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1,  Contacto o2) {
        int comp = o1.getPrimeiroNome().compareTo(o2.getPrimeiroNome());
        if (comp != 0) {
            return comp;
        }
        return o1.getUltimoNome().compareTo(o2.getUltimoNome());
    }
}
