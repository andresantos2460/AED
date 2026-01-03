package aed.avaliacao.periodicanormal.modelo;

import aed.ComparacaoInteiros;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorEquipas {
    INSTANCIA;

    private class Iterador implements IteradorIteravelDuplo<Equipa> {

        private IteradorIteravelDuplo<GestorPontuacao> iteradorGestores;
        private IteradorIteravelDuplo<Equipa> iteradorEquipas;


        public Iterador(int pontuacaoInicial, int pontuacaoFinal) {
            iteradorGestores = equipasPorPontuacao.consultarValores(pontuacaoInicial,pontuacaoFinal);
            iteradorEquipas = ITERADOR_VAZIO;
        }

        @Override
        public boolean podeRecuar() {
            return iteradorEquipas.podeRecuar() || iteradorGestores.podeRecuar();
        }

        @Override
        public Equipa recuar() {
            if (!iteradorEquipas.podeRecuar()) {
                iteradorEquipas = iteradorGestores.recuar().getEquipas();
            }
            return iteradorEquipas.recuar();
        }

        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorEquipas = iteradorGestores.corrente().getEquipas();
        }

        @Override
        public Equipa corrente() {
            return iteradorEquipas.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorEquipas.podeAvancar() || iteradorGestores.podeAvancar();
        }

        @Override
        public Equipa avancar() {
            if (!iteradorEquipas.podeAvancar()) {
                iteradorEquipas = iteradorGestores.avancar().getEquipas();
            }
            return iteradorEquipas.avancar();
        }
    }




    public static final IteradorIteravelDuplo<Equipa> ITERADOR_VAZIO = new ListaDuplaNaoOrdenada<Equipa>().iterador();
    final ListaDuplaOrdenada<Equipa> equipas;
    final TabelaHashOrdenada<Integer, GestorPontuacao> equipasPorPontuacao;
    int totalEquipas = 0;
    int totalPontuacoes= 0;

    GestorEquipas() {
        equipas = new ListaDuplaOrdenada<>(CompararPontuacao.CRITERIO);
        equipasPorPontuacao = new TabelaHashOrdenada<>(ComparacaoInteiros.CRITERIO, 2);
    }

    public IteradorIteravelDuplo<Equipa> getEquipas() {
        //todo pergunta 3.a)
        return equipas.iterador();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacao) {
        //todo pergunta 3.b)
        GestorPontuacao gestorEquipaPontuacao = equipasPorPontuacao.consultar(pontuacao);
        if (gestorEquipaPontuacao == null) {
            return ITERADOR_VAZIO;
        }

        return gestorEquipaPontuacao.getEquipas();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacaoInicial, int pontuacaoFinal) {
        //todo pergunta 3.c)
        return new Iterador(pontuacaoInicial, pontuacaoFinal);
    }

    public float getMediaPontuacoes() {
        //todo pergunta 3.d)
        if (totalEquipas > 0) {
            return (float) totalPontuacoes / totalEquipas;
        }
        return 0;
    }

    public void inserir(Equipa equipa) {
        //todo pergunta 3.e)
        Integer pontuacao = equipa.getPontuacao();
        equipas.inserir(equipa);

        GestorPontuacao gestorEquipaPontuacao = equipasPorPontuacao.consultar(pontuacao);
        if (gestorEquipaPontuacao == null) {
            gestorEquipaPontuacao = new GestorPontuacao(pontuacao);
            equipasPorPontuacao.inserir(pontuacao, gestorEquipaPontuacao);
        }

        gestorEquipaPontuacao.inserir(equipa);


        totalEquipas ++;
        totalPontuacoes += equipa.getPontuacao();
    }

}
