package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoDataNascAsc;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc;

public enum GestorContactos {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Contacto> ITERADOR_CONTACTOS_VAZIOS =new ListaDuplaNaoOrdenada<Contacto>().iterador();
    private TabelaHashOrdenada<Data,GestorContactosDataNascimento>contactosPorDataNascimentos;

    GestorContactos() {
        contactosPorDataNascimentos=new TabelaHashOrdenada<>(ComparacaoDataNascAsc.CRITERIO,2);
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
    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento){
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimentos.remover(new GestorContactosDataNascimento(dataNascimento));
        return contactosDataNascimento == null ? ITERADOR_CONTACTOS_VAZIOS : contactosDataNascimento.iterador();
    }


    public IteradorIteravelDuplo<Contacto> consultar(Data PdataNascimento){
            GestorContactosDataNascimento gestorPdataNascimento=contactosPorDataNascimentos.consultarDistinto(new GestorContactosDataNascimento(PdataNascimento));
            return gestorPdataNascimento==null?ITERADOR_CONTACTOS_VAZIOS:gestorPdataNascimento.iterador();
    }
    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicial,Data dataFinal){
        return new Iterador(dataInicial,dataFinal);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto>{
        private IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestores;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataInicial, Data dataFinal) {
            iteradorGestores = contactosPorDataNascimentos.consultar(new GestorContactosDataNascimento(dataInicial),new GestorContactosDataNascimento(dataFinal));
            iteradorContactos=ITERADOR_CONTACTOS_VAZIOS;
        }

        @Override
        public boolean podeRecuar() {
            if(iteradorGestores.podeRecuar()||iteradorContactos.podeRecuar()){
                return true;
            }
            return false;
        }

        @Override
        public Contacto recuar() {
            if(!iteradorContactos.podeRecuar()){
                iteradorContactos=iteradorGestores.recuar().iterador();
            }
            return iteradorContactos.recuar();
        }

        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorContactos=ITERADOR_CONTACTOS_VAZIOS;
        }

        @Override
        public Contacto corrente() {

            return iteradorContactos.corrente();
        }

        @Override
        public boolean podeAvancar() {
            if(iteradorContactos.podeAvancar()||iteradorGestores.podeAvancar()){
                return true;
            }
            return false;
        }

        @Override
        public Contacto avancar() {
            if(!iteradorContactos.podeAvancar()){
                iteradorContactos = iteradorGestores.avancar().iterador();
            }
            return  iteradorContactos.avancar();
        }
    }


}
