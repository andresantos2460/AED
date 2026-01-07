package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoQuadratico;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;

import java.io.Serializable;
import java.util.Objects;

public class GestorSapatilhasTamanho implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tamanho;
	private ListaDuplaOrdenada<Sapatilha> sapatilhas;
	private TabelaHashComIncrementoPorHash<String, GestorSapatilhasMarca> sapatilhasPorMarca;

	public GestorSapatilhasTamanho(Integer tamanho) {
		this.tamanho = tamanho;
		this.sapatilhas = new ListaDuplaOrdenada<>(ComparacaoStockAscECorAsc.CRITERIO);
		this.sapatilhasPorMarca = new TabelaHashComIncrementoPorHash<>(4);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorSapatilhasTamanho obj = (GestorSapatilhasTamanho) o;
		return Objects.equals(tamanho, obj.tamanho);
	}

	@Override
	public int hashCode () {
		return Objects.hash(tamanho);
	}

	@Override
	public String toString() {
		return " (" + tamanho + ", " + sapatilhas + ", " + sapatilhasPorMarca + ")";
	}

	public IteradorIteravelDuplo<Sapatilha> iterador() {
		return sapatilhas.iterador();
	}

	public IteradorIteravelDuplo<Sapatilha> consultarComMarca(String marca) {
		GestorSapatilhasMarca gestorMarca=sapatilhasPorMarca.consultar(marca);

		return gestorMarca==null?new ListaDuplaNaoOrdenada<Sapatilha>().iterador():gestorMarca.iterador();
	}

	public IteradorIteravelDuplo<String> consultarMarcas() {
		// Se estiver vazia, retorna um iterador de uma lista vazia para evitar null
		if (sapatilhasPorMarca.isVazia()) {
			return new ListaDuplaNaoOrdenada<String>().iterador();
		}

		// Criamos uma lista ordenada para garantir a ordem alfabética (ascendente)
		// e para obtermos um IteradorIteravelDuplo
		ListaDuplaOrdenada<String> marcasOrdenadas = new ListaDuplaOrdenada<>(ComparacaoNomeAsc.CRITERIO);

		// Percorremos o iterador simples da Tabela Hash
		for (String marca : sapatilhasPorMarca.iteradorChaves()) {
			marcasOrdenadas.inserir(marca);
		}

		return marcasOrdenadas.iterador();
	}

	public void inserir(Sapatilha sapatilha) {
		sapatilhas.inserir(sapatilha);
		GestorSapatilhasMarca gestorMarca =sapatilhasPorMarca.consultar(sapatilha.getMarca());

		if(gestorMarca==null){
			gestorMarca=new GestorSapatilhasMarca(sapatilha.getMarca());
			sapatilhasPorMarca.inserir(sapatilha.getMarca(),gestorMarca);
		}
		gestorMarca.inserir(sapatilha);
	}
}