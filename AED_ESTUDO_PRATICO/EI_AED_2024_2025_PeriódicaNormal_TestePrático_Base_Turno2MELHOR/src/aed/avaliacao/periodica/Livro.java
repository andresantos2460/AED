package aed.avaliacao.periodica;

import java.io.Serializable;
import java.util.Objects;

public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String autor;
    private String titulo;
    private int numeroPaginas;

    public Livro(String autor, String titulo, int numeroPaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Livro livro = (Livro) o;
        return numeroPaginas == livro.numeroPaginas && Objects.equals(autor, livro.autor) && Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(autor);
        result = 31 * result + Objects.hashCode(titulo);
        result = 31 * result + numeroPaginas;
        return result;
    }

    @Override
    public String toString() {
        return autor + ", " + titulo + ", " + numeroPaginas + " páginas";
    }
}