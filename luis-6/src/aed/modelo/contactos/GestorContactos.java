package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.modelo.contactos.comparadores.ComparacaoDatasPorDataAsc;


public enum GestorContactos {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Contacto> ITERADOR_CONTACTOS_VAZIO = new ListaDuplaNaoOrdenada<Contacto>().iterador();
    private TabelaHashOrdenada<Data, GestorContactosDataNascimento> contactosPorDataNascimento;
    GestorContactos() {
        contactosPorDataNascimento = new TabelaHashOrdenada<>(ComparacaoDatasPorDataAsc.CRITERIO, 2);
    }

    public void inserir(Contacto contacto) {
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.consultar(contacto.getDataNascimento());

        if (contactosDataNascimento == null) {
            contactosDataNascimento = new GestorContactosDataNascimento(contacto.getDataNascimento());
            contactosPorDataNascimento.inserir(contacto.getDataNascimento(), contactosDataNascimento);

        }
        contactosDataNascimento.inserir(contacto);
    }

    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento) {
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.remover(dataNascimento);
        return contactosPorDataNascimento == null ? ITERADOR_CONTACTOS_VAZIO : contactosDataNascimento.iterador();
    }

    public Contacto remover(Contacto contacto) {
        Data dataNascimento = contacto.getDataNascimento();
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.consultar(dataNascimento);
        if (contactosDataNascimento == null) {
            return null;
        }
        Contacto contactoRemovido = contactosDataNascimento.remover(contacto);
        if (contactosDataNascimento.isVazio()) {
            contactosPorDataNascimento.remover(dataNascimento);
        }
        return contactoRemovido;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data data) {
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.consultar(data);
        return contactosDataNascimento == null ? ITERADOR_CONTACTOS_VAZIO : contactosDataNascimento.iterador();
    }

    public Contacto consultar(long numeroTelefone) {
        Contacto contactoConsultado = null;

        return contactoConsultado;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicial, Data dataFinal) {
        return new Iterador(dataInicial, dataFinal);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        private IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestores;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataInicial, Data dataFinal) {
            iteradorGestores = contactosPorDataNascimento.consultarValores(dataInicial, dataFinal);
            iteradorContactos = ITERADOR_CONTACTOS_VAZIO;

        }

        @Override
        public boolean podeRecuar() {
            return iteradorContactos.podeRecuar() || iteradorGestores.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if (!iteradorContactos.podeRecuar()) {
                iteradorContactos = iteradorGestores.recuar().iterador();
            }
            return iteradorContactos.recuar();
        }

        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorContactos = ITERADOR_CONTACTOS_VAZIO;
        }

        @Override
        public Contacto corrente() {
            return iteradorContactos.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactos.podeAvancar() || iteradorGestores.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            if (!iteradorContactos.podeAvancar()) {
                iteradorContactos = iteradorGestores.avancar().iterador();
            }
            return iteradorContactos.avancar();
        }
    }
}