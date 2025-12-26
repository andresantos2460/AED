package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactosPorNumeroTelefoneDesc implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        return -Long.compare(o1.getNumeroTelefone(), o2.getNumeroTelefone());
    }



}
