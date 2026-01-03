package aed.avaliacao.periodica;

import aed.ComparacaoInteiros;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorVideoteca {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Filme> ITERADOR_FILMES_VAZIO = new ListaDuplaNaoOrdenada<Filme>().iterador();
    ListaDuplaOrdenada<Filme> filmes;
    private TabelaHashOrdenada<Integer, GestorFilmeAno> filmesAno;

    GestorVideoteca() {
        filmes = new ListaDuplaOrdenada<>(ComparacaoFilmeAnoDesc.CRITERIO);
        filmesAno = new TabelaHashOrdenada<>(ComparacaoInteiros.CRITERIO,2);
    }

    public void inserir(Filme filme) {
        int ano = filme.getAno();
        filmes.inserir(filme);

        GestorFilmeAno gestor = filmesAno.consultar(ano);
        if(gestor == null){
            gestor = new GestorFilmeAno(ano);
            filmesAno.inserir(ano, gestor);

        }

        gestor.inserir(filme);
    }

    public IteradorIteravelDuplo<Filme> getFilmes() {
        return filmes.iterador();
    }

    public IteradorIteravelDuplo<Filme> getFilmes(int ano) {
        GestorFilmeAno gestorFilmeAno = filmesAno.consultar(ano);
        if (gestorFilmeAno == null) {
            return ITERADOR_FILMES_VAZIO;
        }

        return gestorFilmeAno.getFilmes();
    }

    public IteradorIteravelDuplo<Filme> getFilmes(int anoInicial, int anoFinal) {
        ListaDuplaOrdenada<Filme> filmesEntreAno= new ListaDuplaOrdenada<>(ComparacaoFilmeAnoTituloDesc.CRITERIO);
        for(Filme filme: filmes) {
            if(filme.getAno() >= anoInicial && filme.getAno() <= anoFinal) {
                filmesEntreAno.inserir(filme);
            }

        }
        return filmesEntreAno.iterador();
    }

    public float getMediaDuracoes() {
        float media;
        int duracoes =0;

        for(Filme filme: filmes) {
            duracoes += filme.getDuracao();
        }

        media= (float)duracoes/filmes.getNumeroElementos();

        return media;
    }
}