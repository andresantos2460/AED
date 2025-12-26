package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactosPorUltimoNomeAdcEDataNascimentoDesc  implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int comp=o1.getUltimoNome().compareToIgnoreCase(o2.getUltimoNome());
        if(comp!=0){
            return comp;
        }
        return o1.getDataNascimento().compareTo(o2.getDataNascimento());
    }
}
