package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorBibliotecaAutor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String autor;
	private ListaDuplaOrdenada<Livro> livros;

	public GestorBibliotecaAutor(String autor) {
		this.autor = autor;
		this.livros = new ListaDuplaOrdenada<>(ComparacaoPorNumeroPaginasDescEAutorAsc.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorBibliotecaAutor obj = (GestorBibliotecaAutor) o;
		return Objects.equals(autor, obj.autor);
	}

	@Override
	public int hashCode () {
		return Objects.hash(autor);
	}

	@Override
	public String toString() {
		return " (" + autor + ", " + livros + ")";
	}

	public IteradorIteravelDuplo<Livro> iterador() {
		return livros.iterador();
	}

	public void inserir(Livro livro) {
		livros.inserir(livro);
	}
}