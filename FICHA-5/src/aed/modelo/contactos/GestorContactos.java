package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc;

public enum GestorContactos {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Contacto> ITERADOR_CONTACTOS_VAZIOS =new ListaDuplaNaoOrdenada<Contacto>().iterador();
    private ListaDuplaOrdenadaOrdemDistinta<GestorContactosDataNascimento>contactosPorDataNascimentos;

    GestorContactos() {
        contactosPorDataNascimentos=new ListaDuplaOrdenadaOrdemDistinta<>(ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc.CRITERIO);
    }
    public void inserir(Contacto contacto){
        GestorContactosDataNascimento contactosDataNascimentoTemporario=new GestorContactosDataNascimento(contacto.getDataNascimento());
        GestorContactosDataNascimento contactosDataNascimento=contactosPorDataNascimentos.consultarDistinto(contactosDataNascimentoTemporario);

        if(contactosDataNascimento==null){
            contactosDataNascimento=contactosDataNascimentoTemporario;
            contactosPorDataNascimentos.inserir(contactosDataNascimento);
        }

        contactosDataNascimento.inserir(contacto);
    }

    public Contacto remover(Contacto contacto){

        GestorContactosDataNascimento contactosDataNascimento=contactosPorDataNascimentos.consultarDistinto(new GestorContactosDataNascimento(contacto.getDataNascimento()));

        if(contactosDataNascimento==null){
            return null;
        }
        Contacto contactoRemovido=contactosDataNascimento.remover(contacto);
        if(contactosDataNascimento.isVazio()){
            contactosPorDataNascimentos.remover(contactosDataNascimento);
        }

        return contactoRemovido;
    }
}
