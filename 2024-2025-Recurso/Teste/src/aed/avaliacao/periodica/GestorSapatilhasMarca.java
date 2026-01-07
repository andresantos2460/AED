package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorSapatilhasMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	private String marca;
	private ListaDuplaOrdenada<Sapatilha> sapatilhas;

	public GestorSapatilhasMarca(String marca) {
		this.marca = marca;
		this.sapatilhas = new ListaDuplaOrdenada<>(ComparacaoStockAscECorAsc.CRITERIO);

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorSapatilhasMarca obj = (GestorSapatilhasMarca) o;
		return Objects.equals(marca, obj.marca);
	}

	@Override
	public int hashCode () {
		return Objects.hash(marca);
	}

	@Override
	public String toString() {
		return " (" + marca + ", " + sapatilhas + ")";
	}

	public IteradorIteravelDuplo<Sapatilha> iterador() {
		return sapatilhas.iterador();
	}

	public void inserir(Sapatilha sapatilha) {
		sapatilhas.inserir(sapatilha);
	}
}