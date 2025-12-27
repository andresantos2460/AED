package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc;

import java.util.NoSuchElementException;

public enum GestorContactos {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Contacto> ITERADOR_CONTACTOS_VAZIO = new ListaDuplaNaoOrdenada<Contacto>().iterador();
    private ListaDuplaOrdenadaOrdemDistinta<GestorContactosDataNascimento> contactosPorDataNascimento;

    GestorContactos(){
         contactosPorDataNascimento = new ListaDuplaOrdenadaOrdemDistinta<>(ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc.CRITERIO);
    }
    public void inserir(Contacto contacto){
        GestorContactosDataNascimento contactosDataNascimentoVazio = new GestorContactosDataNascimento(contacto.getDataNascimento());
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.consultarDistinto(contactosDataNascimentoVazio);

        if (contactosDataNascimento == null) {
            contactosDataNascimento = contactosDataNascimentoVazio;
            contactosPorDataNascimento.inserir(contactosDataNascimento);
        }
        contactosDataNascimento.inserir(contacto);
    }
    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento){
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.remover(new GestorContactosDataNascimento(dataNascimento));
        return contactosPorDataNascimento == null ? ITERADOR_CONTACTOS_VAZIO : contactosDataNascimento.iterador();
    }

    public Contacto remover(Contacto contacto) {
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.consultarDistinto(new GestorContactosDataNascimento(contacto.getDataNascimento()));
       if (contactosPorDataNascimento == null){
           return null;
       }
        Contacto contactoRemovido = contactosDataNascimento.remover(contacto);
      if (contactosDataNascimento.isVazio()){
          contactosPorDataNascimento.remover(contactosDataNascimento);
      }
       return contactoRemovido;
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento) {
        GestorContactosDataNascimento contactosDataNascimento = contactosPorDataNascimento.consultarDistinto(new GestorContactosDataNascimento(dataNascimento));
        return contactosDataNascimento == null ? ITERADOR_CONTACTOS_VAZIO : contactosDataNascimento.iterador();
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicial, Data dataNascimentoFinal) {
        return new Iterador(dataNascimentoInicial,dataNascimentoFinal);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        private IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestores;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;
        public Iterador(Data dataNascimentoInicial, Data dataNascimentoFinal) {
           iteradorGestores = contactosPorDataNascimento.consultar(new GestorContactosDataNascimento(dataNascimentoInicial),new GestorContactosDataNascimento(dataNascimentoFinal));
           iteradorContactos = ITERADOR_CONTACTOS_VAZIO;
        }

        @Override
        public boolean podeRecuar() {
            if (iteradorContactos.podeRecuar() || iteradorGestores.podeRecuar()) {
                return true;
            }
            return false;
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
            if (iteradorContactos.podeAvancar() || iteradorGestores.podeAvancar()) {
                return true;
            }
            
            return false;
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
