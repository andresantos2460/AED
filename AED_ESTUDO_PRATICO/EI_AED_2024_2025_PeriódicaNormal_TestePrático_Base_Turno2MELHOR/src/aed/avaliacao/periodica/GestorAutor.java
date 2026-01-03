package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorAutor implements Serializable {
	private static final long serialVersionUID = 1L;

	private String autor;
	private ListaDuplaOrdenada<Livro> livros;

	public GestorAutor(String autor) {
		this.autor = autor;
		this.livros = new ListaDuplaOrdenada<>(CompararNumeroPaginas.CRITERIO);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorAutor obj = (GestorAutor) o;
		return Objects.equals(autor, obj.autor) && Objects.equals(livros, obj.livros);
	}

	@Override
	public int hashCode () {
		return Objects.hash(autor, livros);
	}

	@Override
	public String toString() {
		return " (" + autor + ", " + livros + ")";
	}
	public IteradorIteravelDuplo<Livro> getLivros() {
		return livros.iterador();
	}
	public void inserir(Livro livro) {
		livros.inserir(livro);
	}
}