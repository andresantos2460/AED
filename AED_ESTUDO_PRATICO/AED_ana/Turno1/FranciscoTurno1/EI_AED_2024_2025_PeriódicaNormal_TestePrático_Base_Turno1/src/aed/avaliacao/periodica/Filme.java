package aed.avaliacao.periodica;

import java.io.Serializable;
import java.util.Objects;

public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private int ano;
    private int duracao;

    public Filme(String titulo, int ano, int duracao) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Filme filme = (Filme) o;
        return ano == filme.ano && duracao == filme.duracao && Objects.equals(titulo, filme.titulo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(titulo);
        result = 31 * result + ano;
        result = 31 * result + duracao;
        return result;
    }

    @Override
    public String toString() {
        return titulo + " " + ano + " " + duracao + "min";
    }
}