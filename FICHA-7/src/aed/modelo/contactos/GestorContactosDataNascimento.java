package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc;

import java.io.Serializable;
import java.util.Objects;

import static aed.modelo.contactos.GestorContactos.ITERADOR_CONTACTOS_VAZIOS;

public class GestorContactosDataNascimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Data dataNascimento;
	private ListaDuplaOrdenada<Contacto> contactos;
	private TabelaHashComIncrementoPorHash<String,GestorContactoMorada>contactosPorMorada;
	public GestorContactosDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
		this.contactos = new ListaDuplaOrdenada<>(ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc.CRITERIO);
		this.contactosPorMorada = new TabelaHashComIncrementoPorHash<>(2);
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

	public int compareTo(GestorContactosDataNascimento gestorContactosDataNascimento) {
		return dataNascimento.compareTo(gestorContactosDataNascimento.dataNascimento);
	}

	public void inserir(Contacto contacto) {
		contactos.inserir(contacto);
		String morada = contacto.getMorada();
		GestorContactoMorada contactoMorada =contactosPorMorada.consultar(morada);
		if(contactoMorada==null){
			contactoMorada = new GestorContactoMorada(morada);
			contactosPorMorada.inserir(morada,contactoMorada);
		}
		contactoMorada.inserir(contacto);

	}

	public Contacto remover(Contacto contacto) {
		String morada = contacto.getMorada();
		GestorContactoMorada contactoMorada = contactosPorMorada.consultar(morada);

		if(contactoMorada==null){
			return null;
		}
		Contacto contactoRemovido = contactoMorada.remover(contacto);
		if(contactoMorada.isVazio()){
			contactosPorMorada.remover(morada);
		}
		return contactoRemovido;

	}

	public boolean isVazio() {
		return  contactos.isVazia();
	}

    public IteradorIteravelDuplo<Contacto> iterador() {
		return contactos.iterador();
    }

	public IteradorIteravel<String> getMoradas() {
		return contactosPorMorada.iteradorChaves();
	}

	public IteradorIteravelDuplo<Contacto> getContactos(String morada) {
		GestorContactoMorada contactoMorada = contactosPorMorada.consultar(morada);

		return contactoMorada == null ? ITERADOR_CONTACTOS_VAZIOS : contactoMorada.iterador();
	}
}