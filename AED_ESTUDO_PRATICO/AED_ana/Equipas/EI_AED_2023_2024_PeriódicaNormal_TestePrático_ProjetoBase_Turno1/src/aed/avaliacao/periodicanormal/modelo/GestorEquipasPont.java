package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.io.Serializable;

public class GestorEquipasPont implements Serializable {

    private static final long serialVersionUID = 1L;
    private int pontuacao;
    private ListaDuplaOrdenada<Equipa> equipas;

public GestorEquipasPont(int pontuacao) {
    this.pontuacao = pontuacao;
    equipas= new ListaDuplaOrdenada<>(CompNomeAsc.CRITERIO);
}

public IteradorIteravelDuplo<Equipa> getEquipas() {
    return equipas.iterador();
}

    public void inserir(Equipa equipa) {

        equipas.inserir(equipa);
    }
}
