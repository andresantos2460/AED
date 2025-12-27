package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;
import aed.modelo.contactos.GestorContactos;
import aed.modelo.contactos.GestorContactosDataNascimento;

public enum ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc implements Comparacao<GestorContactosDataNascimento> {
    CRITERIO;

    public int comparar(GestorContactosDataNascimento o1, GestorContactosDataNascimento o2) {
        return o1.compareTo(o2);
    }
}