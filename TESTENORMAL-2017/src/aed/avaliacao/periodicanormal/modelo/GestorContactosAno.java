package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorContactosAno implements Serializable {
	private static final long serialVersionUID = 1L;

	private int ano;
	private ListaDuplaOrdenada<Contacto> contactos;

	public GestorContactosAno(int ano) {
		this.ano = ano;
		this.contactos = new ListaDuplaOrdenada<>(ComparacaoDistanciaAsc.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorContactosAno obj = (GestorContactosAno) o;
		return Objects.equals(ano, obj.ano);
	}

	@Override
	public int hashCode () {
		return Objects.hash(ano);
	}

	@Override
	public String toString() {
		return " (" + ano + ", " + contactos + ")";
	}

	public IteradorIteravelDuplo<Contacto> consultar(float distancia) {
		Contacto contacto1=new Contacto(null,null,0L,null,null,0F);
		Contacto contacto2=new Contacto(null,null,0L,null,null,distancia);
		return contactos.consultar(contacto1,contacto2);
	}

	public void inserir(Contacto contacto) {
		contactos.inserir(contacto);
	}
}