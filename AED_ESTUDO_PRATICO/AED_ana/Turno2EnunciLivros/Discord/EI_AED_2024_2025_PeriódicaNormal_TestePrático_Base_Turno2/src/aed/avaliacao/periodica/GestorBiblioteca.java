package aed.avaliacao.periodica;

import aed.ComparacaoInteiros;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;


public enum GestorBiblioteca {
    INSTANCIA;

    private IteradorIteravelDuplo<Livro> ITERADOR_LIVROS_VAZIO = new ListaDuplaNaoOrdenada<Livro>().iterador();
    private ListaDuplaOrdenada<Livro> livros;
     private TabelaHashComIncrementoPorHash<String, GestorAutor> livrosPorAutor;
    GestorMediaNumeroPaginas mediaNumeroPaginas;

    GestorBiblioteca() {
        livros = new ListaDuplaOrdenada<>(ComparacaoPaginDescTituAsc.CRITERIO);
        livrosPorAutor = new TabelaHashComIncrementoPorHash<>(100);
        mediaNumeroPaginas  = new GestorMediaNumeroPaginas();

    }

    public void inserir(Livro livro) {
        livros.inserir(livro);
        String autor = livro.getAutor();
        GestorAutor livrosAutor = livrosPorAutor.consultar(autor);
        if(livrosAutor == null) {
            livrosAutor = new GestorAutor(autor);
            livrosPorAutor.inserir(autor, livrosAutor);
        }

        livrosAutor.inserir(livro);
        mediaNumeroPaginas.inserir(livro);
    }

    public IteradorIteravelDuplo<Livro> getLivros() {
        return livros.iterador();
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autor) {
        GestorAutor gestor = livrosPorAutor.consultar(autor);
        return gestor == null ? ITERADOR_LIVROS_VAZIO : gestor.iterador();
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autorInicial, String autorFinal) {
        //todo pergunta 3.c)
        ListaDuplaNaoOrdenada<Livro> livrosEntreAutores = new ListaDuplaNaoOrdenada<>();
        for(Livro livro: livros){
            if(livro.getAutor().compareTo(autorInicial) >= 0  && livro.getAutor().compareTo(autorFinal) <= 0){
                livrosEntreAutores.inserir(livro);
            }
        }
        return livrosEntreAutores.iterador();
    }

    public float getMediaNumerosPaginas() {
        return mediaNumeroPaginas.getMedia();
    }

}