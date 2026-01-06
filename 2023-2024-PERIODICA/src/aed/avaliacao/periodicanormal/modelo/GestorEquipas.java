package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;

public enum GestorEquipas {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Equipa> ITERADOR_ITERAVEL_DUPLO = new ListaDuplaNaoOrdenada<Equipa>().iterador();
    private ListaDuplaOrdenadaOrdemDistinta<Equipa>equipas;
    private TabelaHashOrdenada<Integer,GestorEquipasPontuacao> equipasPorPontucao;
    private float media;
    private int totalPontuacao;
    GestorEquipas() {
        equipas=new ListaDuplaOrdenadaOrdemDistinta<>(ComparcaoNomeEPontuacaoDescEDiferencaGolosDesc.CRITERIO);
        equipasPorPontucao= new TabelaHashOrdenada<>(ComparacaoPontuacaoAsc.CRITERIO,4);
        media=0;
        totalPontuacao=0;
    }

    public IteradorIteravelDuplo<Equipa> getEquipas() {
        //todo pergunta 3.a)
        return equipas.iterador();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacao) {
       GestorEquipasPontuacao gestorPontucao =equipasPorPontucao.consultar(pontuacao);

        return gestorPontucao==null? ITERADOR_ITERAVEL_DUPLO :gestorPontucao.iterador();
    }

    public IteradorIteravelDuplo<Equipa> getEquipas(int pontuacaoInicial, int pontuacaoFinal) {
        //todo pergunta 3.c)
        return new Iterador(pontuacaoInicial,pontuacaoFinal);
    }

    public float getMediaPontuacoes() {
        //todo pergunta 3.d)
        return media;
    }

    public void inserir(Equipa equipa) {
        equipas.inserir(equipa);
        int pontuacao = equipa.getPontuacao();
        totalPontuacao+= pontuacao;
        media=(float)totalPontuacao/equipas.getNumeroElementos();

        GestorEquipasPontuacao gestorPontuacao=equipasPorPontucao.consultar(pontuacao);

        if(gestorPontuacao==null){
            gestorPontuacao=new GestorEquipasPontuacao(pontuacao);
            equipasPorPontucao.inserir(pontuacao,gestorPontuacao);
        }
        gestorPontuacao.inserir(equipa);
    }



    private class Iterador implements IteradorIteravelDuplo<Equipa>{
        private IteradorIteravelDuplo<GestorEquipasPontuacao> iteradorGestores;
        private IteradorIteravelDuplo<Equipa> iteradorEquipas;

        public Iterador(int pontuacaoInicial, int pontuacaoFinal) {
            iteradorGestores = equipasPorPontucao.consultarValores(pontuacaoInicial,pontuacaoFinal);
            iteradorEquipas=ITERADOR_ITERAVEL_DUPLO;
        }

        @Override
        public boolean podeRecuar() {
            if(iteradorGestores.podeRecuar()||iteradorEquipas.podeRecuar()){
                return true;
            }
            return false;
        }

        @Override
        public Equipa recuar() {
            if(!iteradorEquipas.podeRecuar()){
                iteradorEquipas=iteradorGestores.recuar().iterador();
            }
            return iteradorEquipas.recuar();
        }

        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorEquipas=ITERADOR_ITERAVEL_DUPLO;
        }

        @Override
        public Equipa corrente() {

            return iteradorEquipas.corrente();
        }

        @Override
        public boolean podeAvancar() {
            if(iteradorEquipas.podeAvancar()||iteradorGestores.podeAvancar()){
                return true;
            }
            return false;
        }

        @Override
        public Equipa avancar() {
            if(!iteradorEquipas.podeAvancar()){
                iteradorEquipas = iteradorGestores.avancar().iterador();
            }
            return  iteradorEquipas.avancar();
        }
    }


}
