package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.avaliacao.periodicanormal.modelo.Equipa;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.util.List;

public enum GestorEquipas {
    INSTANCIA;

    private ListaDuplaNaoOrdenada<Equipa> equipas;
    private TabelaHashComIncrementoPorHash<Integer,GestorEquipasPontuação> equipasPorPontuação;
    private IteradorIteravelDuplo<Equipa> ITERADOR_EQUIPAS_VAZIO = new ListaDuplaNaoOrdenada<Equipa>().iterador();
    private Float media = 0F;
    private Float totalEquipas = 0F;

    GestorEquipas() {
        equipas = new ListaDuplaNaoOrdenada<>();
        equipasPorPontuação = new TabelaHashComIncrementoPorHash<>(2);
    }

    public IteradorIteravelDuplo<Equipa> getEquipas() {
        //todo pergunta 3.a)
        ListaDuplaOrdenada<Equipa> equipasOrdenadas = new ListaDuplaOrdenada<>(ComparacaoEquipasPontDesc.CRITERIO);
        for(Equipa equipa : equipas) {
            equipasOrdenadas.inserir(equipa);
        }
        return equipasOrdenadas.iterador();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacao) {
        //todo pergunta 3.b)
        GestorEquipasPontuação equipasPontuação = equipasPorPontuação.consultar(pontuacao);
        return equipasPontuação == null ? ITERADOR_EQUIPAS_VAZIO : equipasPontuação.getEquipas();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacaoInicial, int pontuacaoFinal) {
        //todo pergunta 3.c)
        ListaDuplaOrdenada equipasPontuacao = new ListaDuplaOrdenada<>(ComparacaoEquipasNomeAsc.CRITERIO);
        for (Equipa equipa : equipas) {
            if(equipa.getPontuacao() > pontuacaoInicial && equipa.getPontuacao() < pontuacaoFinal) {
                equipasPontuacao.inserir(equipa);
            }
        }
        return equipasPontuacao.iterador();
    }

    public float getMediaPontuacoes() {
        //todo pergunta 3.d)
        Integer soma = 0;
        for(Equipa equipa : equipas) {
            soma += equipa.getPontuacao();
        }
        media = soma/ totalEquipas;
        return media;
    }

    public void inserir(Equipa equipa) {
        //todo pergunta 3.e)
        equipas.inserir(equipa);
        Integer pontuacao = equipa.getPontuacao();
        GestorEquipasPontuação equipasPontuação = equipasPorPontuação.consultar(pontuacao) ;
        if(equipasPontuação == null){
            equipasPontuação = new GestorEquipasPontuação(pontuacao);
            equipasPorPontuação.inserir(pontuacao,equipasPontuação);
        }
        equipasPontuação.inserir(equipa);
        totalEquipas++;
    }

}
