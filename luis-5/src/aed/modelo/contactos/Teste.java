package aed.modelo.contactos;

import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class Teste implements Serializable {
	private static final long serialVersionUID = 1L;

	private Data dataNascimeento;
	private ListaDuplaOrdenada<Contacto> contactos;

	public Teste(Data dataNascimeento,ListaDuplaOrdenada<Contacto> contactos) {
		this.dataNascimeento = dataNascimeento;
		this.contactos = contactos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Teste obj = (Teste) o;
		return Objects.equals(dataNascimeento, obj.dataNascimeento) && Objects.equals(contactos, obj.contactos);
	}

	@Override
	public int hashCode () {
		return Objects.hash(dataNascimeento, contactos);
	}

	@Override
	public String toString() {
		return " (" + dataNascimeento + ", " + contactos + ")";
	}
}