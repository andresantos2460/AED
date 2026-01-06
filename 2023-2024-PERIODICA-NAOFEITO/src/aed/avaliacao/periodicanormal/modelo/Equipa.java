package aed.avaliacao.periodicanormal.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Equipa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int pontuacao;
    private int golosMarcados;
    private int golosSofridos;
    private int diferencaGolos;

    public Equipa(String nome, int pontuacao, int golosMarcados, int golosSofridos) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.golosMarcados = golosMarcados;
        this.golosSofridos = golosSofridos;
        diferencaGolos = golosMarcados - golosSofridos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getGolosMarcados() {
        return golosMarcados;
    }

    public int getGolosSofridos() {
        return golosSofridos;
    }

    public int getDiferencaGolos() {
        return diferencaGolos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Equipa equipa = (Equipa) o;

        return Objects.equals(nome, equipa.nome);
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return nome + "\tP: " + pontuacao + "\tGM: " + golosMarcados + "\tGS: " + golosSofridos + "\tDG: " + diferencaGolos;
    }
}
