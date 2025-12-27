package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDesc;

import java.io.Serializable;
import java.util.Objects;

public class GestorContactosMorada implements Serializable {
	private static final long serialVersionUID = 1L;

	private String morada;
	private ListaDuplaOrdenadaOrdemDistinta<Contacto> contactos;

	public GestorContactosMorada(String morada) {
		this.morada = morada;
		this.contactos = new ListaDuplaOrdenadaOrdemDistinta<>(ComparacaoContactosPorNumeroTelefoneDesc.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorContactosMorada obj = (GestorContactosMorada) o;
		return Objects.equals(morada, obj.morada) ;
	}

	@Override
	public int hashCode () {
		return Objects.hash(morada);
	}

	@Override
	public String toString() {
		return " (" + morada + ", " + contactos + ")";
	}

    public void inserir(Contacto contacto) {
        contactos.inserir(contacto);
    }

    public IteradorIteravelDuplo<Contacto> iterador(){
        return contactos.iterador();
    }

    public Contacto remover(Contacto contacto) {
        return contactos.remover(contacto);
    }

    public boolean isVazio() {
        return contactos.isVazia();
    }

}