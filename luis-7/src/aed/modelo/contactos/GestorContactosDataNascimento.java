package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDesc;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc;

import java.io.Serializable;
import java.util.Objects;

import static aed.modelo.contactos.GestorContactos.ITERADOR_CONTACTOS_VAZIO;

public class GestorContactosDataNascimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Data dataNascimento;
	private ListaDuplaOrdenada<Contacto> contactos;
    private TabelaHashComIncrementoPorHash <String, GestorContactosMorada> contactosPorMorada;

	public GestorContactosDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
		contactos = new ListaDuplaOrdenada<>(ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc.CRITERIO);
        contactosPorMorada = new TabelaHashComIncrementoPorHash<>(2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorContactosDataNascimento obj = (GestorContactosDataNascimento) o;
		return Objects.equals(dataNascimento, obj.dataNascimento);
	}

	@Override
	public int hashCode () {
		return Objects.hash(dataNascimento);
	}

	@Override
	public String toString() {
		return " (" + dataNascimento + ", " + contactos + ")";
	}

    public int compareTo(GestorContactosDataNascimento gestorContactosDataNascimento){
        return dataNascimento.compareTo(gestorContactosDataNascimento.dataNascimento);
    }

    public void inserir(Contacto contacto) {
        contactos.inserir(contacto);
        String morada = contacto.getMorada();
        GestorContactosMorada contactosMorada = contactosPorMorada.consultar(morada);

        if(contactosMorada == null){
            contactosMorada = new GestorContactosMorada(morada);
            contactosPorMorada.inserir(morada, contactosMorada);
        }
        contactosMorada.inserir(contacto);
    }

    public IteradorIteravelDuplo<Contacto> iterador(){
        return contactos.iterador();
    }

    public Contacto remover(Contacto contacto) {
        String morada = contacto.getMorada();
        GestorContactosMorada contactosMorada = contactosPorMorada.consultar(morada);

       if (contactosMorada == null) {
           return null;
       }
        Contacto contactoRemovido = contactosMorada.remover(contacto);
        if (contactosMorada.isVazio()) {
           return contactoRemovido;
       }
        return contactos.remover(contacto);
    }

    public boolean isVazio() {
        return contactos.isVazia();
    }

    public IteradorIteravel<String> getMoradas(){
        return contactosPorMorada.iteradorChaves();
    }

    public IteradorIteravelDuplo<Contacto> getContactos(String morada) {
        GestorContactosMorada contactosMorada = contactosPorMorada.consultar(morada);
        return contactosMorada == null ? ITERADOR_CONTACTOS_VAZIO : contactosMorada.iterador();
    }
}