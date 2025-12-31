package aed.avaliacao.recurso.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorImoveisConcelho implements Serializable {
	private static final long serialVersionUID = 1L;

	private String concelho;
	private ListaDuplaOrdenada<Imovel> imoveis;
	private TabelaHashComIncrementoPorHash<String,GestorImoveisMediaTipologia> ImvoviesTipologia;
	public GestorImoveisConcelho(String concelho) {
		this.concelho = concelho;
		this.imoveis = new ListaDuplaOrdenada<>(ComparacaoPrecoAsc.CRITERIO);
		ImvoviesTipologia =new TabelaHashComIncrementoPorHash<>(2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorImoveisConcelho obj = (GestorImoveisConcelho) o;
		return Objects.equals(concelho, obj.concelho);
	}

	@Override
	public int hashCode () {
		return Objects.hash(concelho);
	}

	@Override
	public String toString() {
		return " (" + concelho + ", " + imoveis + ")";
	}

	public IteradorIteravelDuplo<Imovel> iterador() {
		return imoveis.iterador();
	}

	public double consultarMedia(String tipologia) {
		GestorImoveisMediaTipologia imovelTipologia=ImvoviesTipologia.consultar(tipologia);

		return imovelTipologia==null?-1:imovelTipologia.getMedia();
	}
}