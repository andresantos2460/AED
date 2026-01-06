package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorEquipasPontuacao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer pontuacao;
	private ListaDuplaOrdenada<Equipa> equipas;

	public GestorEquipasPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
		this.equipas = new ListaDuplaOrdenada<>(ComparacaoNomeAsc.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorEquipasPontuacao obj = (GestorEquipasPontuacao) o;
		return Objects.equals(pontuacao, obj.pontuacao) ;
	}

	@Override
	public int hashCode () {
		return Objects.hash(pontuacao);
	}

	@Override
	public String toString() {
		return " (" + pontuacao + ", " + equipas + ")";
	}

	public IteradorIteravelDuplo<Equipa> iterador() {
		return equipas.iterador();
	}

	public void inserir(Equipa equipa) {
		equipas.inserir(equipa);
	}
}