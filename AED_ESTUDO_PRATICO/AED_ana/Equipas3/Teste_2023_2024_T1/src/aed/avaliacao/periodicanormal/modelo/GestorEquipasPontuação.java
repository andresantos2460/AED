package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;

public class GestorEquipasPontuação {
    private Integer Pontuacao;
    private ListaDuplaNaoOrdenada<Equipa> equipas;
    private ListaDuplaOrdenada<Equipa> equipasNomeAsc = new ListaDuplaOrdenada<>(ComparacaoEquipasNomeAsc.CRITERIO) ;


    public GestorEquipasPontuação(Integer pontuacao) {
        Pontuacao = pontuacao;
        equipas = new ListaDuplaNaoOrdenada<>();
    }

    public void inserir(Equipa equipa) {
        equipas.inserir(equipa);
        for (Equipa e : equipas) {
            equipasNomeAsc.inserir(e);
        }
    }

    public IteradorIteravelDuplo<Equipa> getEquipas() {
        return equipasNomeAsc.iterador();
    }
}
