package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoDataNascAsc;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc;

public enum GestorContactos {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Contacto> ITERADOR_CONTACTOS_VAZIOS =new ListaDuplaNaoOrdenada<Contacto>().iterador();
    public static final IteradorIteravel<String> ITERADOR_STRINGS_VAZIOS = new ListaSimplesNaoOrdenada<String>().iterador();
    private TabelaHashOrdenada<Data,GestorContactosDataNascimento>contactosPorDataNascimentos;
    private TabelaHashComIncrementoPorHash<Long,Contacto> contactosPorTelefone;

    GestorContactos() {
        contactosPorDataNascimentos=new TabelaHashOrdenada<>(ComparacaoDataNascAsc.CRITERIO,2);
        contactosPorTelefone = new TabelaHashComIncrementoPorHash<>(2);
    }
    public void inserir(Contacto contacto){
        contactosPorTelefone.inserir(contacto.getNumeroTelefone(),contacto);

        GestorContactosDataNascimento contactosDataNascimento=contactosPorDataNascimentos.consultar(contacto.getDataNascimento());

        if(contactosDataNascimento==null){
            contactosDataNascimento = new GestorContactosDataNascimento(contacto.getDataNascimento());
            contactosPorDataNascimentos.inserir(contacto.getDataNascimento(),contactosDataNascimento);
        }
        contactosDataNascimento.inserir(contacto);
    }
    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento) {
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimentos.remover(dataNascimento);
        if (contactosDataNascimento == null) {
            return ITERADOR_CONTACTOS_VAZIOS;
        }
        IteradorIteravelDuplo<Contacto> iterador = contactosDataNascimento.iterador();
        for (Contacto contacto : iterador) {
            contactosPorTelefone.remover(contacto.getNumeroTelefone());
        }
        iterador.reiniciar();
        return iterador;
    }



    public Contacto remover(Contacto contacto){
        long numeroTelefone = contacto.getNumeroTelefone();

        if(!contacto.equals(contactosPorTelefone.consultar(numeroTelefone))){
            return null;
        }
        Contacto contactoRemovido=contactosPorTelefone.remover(numeroTelefone);
        return removerDosContactosDataNascimento(contactoRemovido);


    }

    private Contacto removerDosContactosDataNascimento(Contacto contacto) {
        Data dataNascimento = contacto.getDataNascimento();
        GestorContactosDataNascimento contactosDataNascimento=contactosPorDataNascimentos.consultar(dataNascimento);
        contactosDataNascimento.remover(contacto);
        if (contactosDataNascimento.isVazio()) {
            contactosPorDataNascimentos.remover(dataNascimento);
        }
        return contacto;

    }

    public IteradorIteravelDuplo<Contacto> consultar(Data PdataNascimento){
            GestorContactosDataNascimento gestorPdataNascimento=contactosPorDataNascimentos.consultar(PdataNascimento);
            return gestorPdataNascimento==null?ITERADOR_CONTACTOS_VAZIOS:gestorPdataNascimento.iterador();
    }
    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicial,Data dataFinal){
        return new Iterador(dataInicial,dataFinal);
    }


    public Contacto consultar(long numeroTelefone){
        return contactosPorTelefone.consultar(numeroTelefone);
    }

    public Contacto remover(long numeroTelefone){
        Contacto contactoRemover = contactosPorTelefone.remover(numeroTelefone);

        return contactoRemover ==null? null:removerDosContactosDataNascimento(contactoRemover);

    }

    public IteradorIteravel<String> consultarMoradas(Data dataNascimento){
        GestorContactosDataNascimento contactosDataNascimento = new GestorContactosDataNascimento(dataNascimento);

        return contactosDataNascimento==null ? ITERADOR_STRINGS_VAZIOS:contactosDataNascimento.getMoradas();
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data data,String morada){
        GestorContactosDataNascimento contactosDataNascimento = new GestorContactosDataNascimento(data);

        return contactosDataNascimento == null? ITERADOR_CONTACTOS_VAZIOS:contactosDataNascimento.getContactos(morada);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto>{
        private IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestores;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataInicial, Data dataFinal) {
            iteradorGestores = contactosPorDataNascimentos.consultarValores(dataInicial,dataFinal);
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
