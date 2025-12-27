package aed.modelo.contactos;

import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoNumeroTelefoneDesc;

import java.io.Serializable;
import java.util.Objects;

public class GestorContactoMorada implements Serializable {
	private static final long serialVersionUID = 1L;

	private String morada;
	private ListaDuplaOrdenadaOrdemDistinta<Contacto> contactos;

	public GestorContactoMorada(String morada) {
		this.morada = morada;
		this.contactos =new ListaDuplaOrdenadaOrdemDistinta<>(ComparacaoNumeroTelefoneDesc.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorContactoMorada obj = (GestorContactoMorada) o;
		return Objects.equals(morada, obj.morada);
	}

	@Override
	public int hashCode () {
		return Objects.hash(morada, contactos);
	}

	@Override
	public String toString() {
		return " (" + morada + ", " + contactos + ")";
	}
}