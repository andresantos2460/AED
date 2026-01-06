package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum ComparacaoDistanciaAsc implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        return Float.compare(o1.getDistanciaALeiria(),o2.getDistanciaALeiria());
    }
}
