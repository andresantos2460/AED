package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataNascimentoAsc;

import java.io.Serializable;
import java.util.Objects;

public class GestorContactosDataNascimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Data dataNascimento;
	private ListaDuplaOrdenada<Contacto> contactos;

	public GestorContactosDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
		this.contactos = new ListaDuplaOrdenada<>(ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc.CRITERIO);
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
	}

	public Contacto remover(Contacto contacto) {
		return contactos.remover(contacto);
	}

	public boolean isVazio() {
		return  contactos.isVazia();
	}

    public IteradorIteravelDuplo<Contacto> iterador() {
		return contactos.iterador();
    }
}