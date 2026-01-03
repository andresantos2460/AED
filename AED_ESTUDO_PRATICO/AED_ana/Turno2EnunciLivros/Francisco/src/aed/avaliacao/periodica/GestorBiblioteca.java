package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorBiblioteca {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Livro> ITERADOR_VAZIO = new ListaDuplaNaoOrdenada<Livro>().iterador();
    final ListaDuplaOrdenada<Livro> livros;
    final TabelaHashOrdenada<String, GestorLivroAutor> livrosPorAutor;
     //para fazer a media
    int totalPaginas = 0;
    int totalLivros = 0;


    GestorBiblioteca() {
        livros = new ListaDuplaOrdenada<>(CompararPaginaLivros.CRITERIO);
        livrosPorAutor = new TabelaHashOrdenada<>(CompararStrings.CRITERIO, 2);
    }
//e
    public void inserir(Livro livro) {
        String autor = livro.getAutor();
        livros.inserir(livro);

        GestorLivroAutor gestorLivroAutor = livrosPorAutor.consultar(autor);
        if (gestorLivroAutor == null) {
            gestorLivroAutor = new GestorLivroAutor();
            livrosPorAutor.inserir(autor, gestorLivroAutor);
        }

        gestorLivroAutor.inserir(livro);
        //FAZER D MEDIA
        totalLivros ++;
        totalPaginas += livro.getNumeroPaginas();
    }
//a
    public IteradorIteravelDuplo<Livro> getLivros() {

        return livros.iterador();
    }
//b
    public IteradorIteravelDuplo<Livro> getLivros(String autor) {
        GestorLivroAutor gestorLivroAutor = livrosPorAutor.consultar(autor);
        if (gestorLivroAutor == null) {
            return ITERADOR_VAZIO;
        }

        return gestorLivroAutor.getLivros();
    }
    //c - 0

    public IteradorIteravelDuplo<Livro> getLivros(String autorInicial, String autorFinal) {
        ListaDuplaOrdenada<Livro> livrosFiltrados = new ListaDuplaOrdenada<>(CompararPaginaLivros.CRITERIO);

        for (Livro livro : livros) {
            String autor = livro.getAutor();
            if (autor.compareTo(autorInicial) >= 0 && autor.compareTo(autorFinal) <= 0) {
                livrosFiltrados.inserir(livro);
            }
        }

        return livrosFiltrados.iterador();
    }
//d - 0
    public float getMediaNumerosPaginas() {
        //Media fazer no inserir - obter os numeros
        //A media so pode possuir a conta

        if (totalLivros > 0) {
            return (float) totalPaginas / totalLivros;
        }

        return 0;
    }

}