package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorPontuacao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer pontuacao;
	private ListaDuplaOrdenada<Equipa> equipas;

	public GestorPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
		this.equipas = new ListaDuplaOrdenada<>(CompararNomeAsc.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorPontuacao obj = (GestorPontuacao) o;
		return Objects.equals(pontuacao, obj.pontuacao) && Objects.equals(equipas, obj.equipas);
	}

	@Override
	public int hashCode () {
		return Objects.hash(pontuacao, equipas);
	}

	@Override
	public String toString() {
		return " (" + pontuacao + ", " + equipas + ")";
	}
	public IteradorIteravelDuplo<Equipa> getEquipas() {
		return equipas.iterador();
	}
	public void inserir(Equipa equipa) {
		equipas.inserir(equipa);
	}
}