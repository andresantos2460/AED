package aed.avaliacao.recurso.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoQuadratico;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorImoveisConcelho implements Serializable {
	private static final long serialVersionUID = 1L;

	private String concelho;
	private ListaDuplaOrdenada<Imovel> imoveis;
	private TabelaHashComIncrementoPorHash<String, GestorImoveisConcelhoTipologia> imoveisTipologia;

	public GestorImoveisConcelho(String concelho) {
		this.concelho = concelho;
		this.imoveis = new ListaDuplaOrdenada<>(ComparacaoPrecoAsc.CRITERIO);
		this.imoveisTipologia = new TabelaHashComIncrementoPorHash<>(4);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorImoveisConcelho obj = (GestorImoveisConcelho) o;
		return Objects.equals(concelho, obj.concelho) ;
	}

	@Override
	public int hashCode () {
		return Objects.hash(concelho);
	}

	@Override
	public String toString() {
		return " (" + concelho + ", " + imoveis + ", " + imoveisTipologia + ")";
	}

	public IteradorIteravelDuplo<Imovel> iterador() {
		return imoveis.iterador();
	}

	public double consultarMedia(String tipologia) {
		GestorImoveisConcelhoTipologia gestorTipologia=imoveisTipologia.consultar(tipologia);

		return gestorTipologia==null?-1:gestorTipologia.getMedia();
	}

	public void inserir(Imovel imovel) {
		imoveis.inserir(imovel);
		String tipologia = imovel.getTipologia();
		GestorImoveisConcelhoTipologia gestorTipologia=imoveisTipologia.consultar(tipologia);

		if(gestorTipologia==null){
			gestorTipologia=new GestorImoveisConcelhoTipologia(tipologia);
			imoveisTipologia.inserir(tipologia,gestorTipologia);
		}
		gestorTipologia.inserir(imovel);
	}
}