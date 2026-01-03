package aed.avaliacao.periodicanormal.modelo;

import aed.ComparacaoInteiros;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorEquipas {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Equipa> ITERADOR_EQUIPAS_VAZIO = new ListaDuplaNaoOrdenada<Equipa>().iterador();
    private ListaDuplaOrdenada<Equipa> equipas;
    private TabelaHashOrdenada<Integer, GestorEquipasPont> equipasPontuacao;
    private int teste;
    GestorEquipas() {
        equipas= new ListaDuplaOrdenada<>(CompEquipasPontDesDifDes.CRITERIO);
        equipasPontuacao= new TabelaHashOrdenada<>(ComparacaoInteiros.CRITERIO,2);
    }

    public IteradorIteravelDuplo<Equipa> getEquipas() {
        //todo pergunta 3.a)
        return equipas.iterador();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacao) {
        //todo pergunta 3.b)
        GestorEquipasPont gestor= equipasPontuacao.consultar(pontuacao);
        return gestor==null ? ITERADOR_EQUIPAS_VAZIO : gestor.getEquipas();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacaoInicial, int pontuacaoFinal) {
        //todo pergunta 3.c)
        ListaDuplaOrdenada equipasEntrePontuacao= new ListaDuplaOrdenada<>(CompEquipasPontDesDifDes.CRITERIO);
        for(Equipa equipa: equipas) {
            if(equipa.getPontuacao()>= pontuacaoInicial && equipa.getPontuacao()<= pontuacaoFinal) {
                equipasEntrePontuacao.inserir(equipa);
            }

        }
        return equipasEntrePontuacao.iterador();

    }

    public float getMediaPontuacoes() {
        float media;
        int pontuacoes=0;
        for(Equipa equipa: equipas) {
            pontuacoes+= equipa.getPontuacao();
        }
        media= (float)pontuacoes/equipas.getNumeroElementos();
        return media;
    }


    public void inserir(Equipa equipa) {
        //TODO: PERGUNTA 3.e)
        int pontuacao = equipa.getPontuacao();
        equipas.inserir(equipa);

        GestorEquipasPont gestor = equipasPontuacao.consultar(pontuacao);
        if(gestor == null){
            gestor = new GestorEquipasPont(pontuacao);
            equipasPontuacao.inserir(pontuacao,gestor);

        }
        gestor.inserir(equipa);

    }

}
