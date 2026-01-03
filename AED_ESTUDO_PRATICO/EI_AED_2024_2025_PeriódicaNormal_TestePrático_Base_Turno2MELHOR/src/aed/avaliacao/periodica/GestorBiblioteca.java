package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorBiblioteca {
    INSTANCIA;

    private class Iterador implements IteradorIteravelDuplo<Livro> {

        private IteradorIteravelDuplo<GestorAutor> iteradorGestores;
        private IteradorIteravelDuplo<Livro> iteradorFilmes;


        public Iterador(String autorInicial, String autorFinal) {
            iteradorGestores = livrosPorAutor.consultarValores(autorInicial,autorFinal);
            iteradorFilmes = ITERADOR_VAZIO;
        }

        @Override
        public boolean podeRecuar() {
            return iteradorFilmes.podeRecuar() || iteradorGestores.podeRecuar();
        }

        @Override
        public Livro recuar() {
            if (!iteradorFilmes.podeRecuar()) {
                iteradorFilmes = iteradorGestores.recuar().getLivros();
            }
            return iteradorFilmes.recuar();
        }

        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorFilmes = iteradorGestores.corrente().getLivros();
        }

        @Override
        public Livro corrente() {
            return iteradorFilmes.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorFilmes.podeAvancar() || iteradorGestores.podeAvancar();
        }

        @Override
        public Livro avancar() {
            if (!iteradorFilmes.podeAvancar()) {
                iteradorFilmes = iteradorGestores.avancar().getLivros();
            }
            return iteradorFilmes.avancar();
        }
    }




    public static final IteradorIteravelDuplo<Livro> ITERADOR_VAZIO = new ListaDuplaNaoOrdenada<Livro>().iterador();
    final ListaDuplaOrdenada<Livro> livros;
    final TabelaHashOrdenada<String, GestorAutor> livrosPorAutor;
    int totalLivros = 0;
    int totalPaginas= 0;

    GestorBiblioteca() {
        livros = new ListaDuplaOrdenada<>(CompararNumeroPaginas.CRITERIO);
        livrosPorAutor = new TabelaHashOrdenada<>(CompararPorString.CRITERIO, 2);
    }

    public void inserir(Livro livro) {
        //todo pergunta 3.e)
        String autor = livro.getAutor();
        livros.inserir(livro);

        GestorAutor gestorLivroAutor = livrosPorAutor.consultar(autor);
        if (gestorLivroAutor == null) {
            gestorLivroAutor = new GestorAutor(autor);
            livrosPorAutor.inserir(autor, gestorLivroAutor);
        }

        gestorLivroAutor.inserir(livro);


        totalLivros ++;
        totalPaginas += livro.getNumeroPaginas();
    }

    public IteradorIteravelDuplo<Livro> getLivros() {
        //todo pergunta 3.a)
        return livros.iterador();
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autor) {
        //todo pergunta 3.b)
        GestorAutor gestorLivroAutor = livrosPorAutor.consultar(autor);
        if (gestorLivroAutor == null) {
            return ITERADOR_VAZIO;
        }

        return gestorLivroAutor.getLivros();
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autorInicial, String autorFinal) {
        //todo pergunta 3.c)
        return new Iterador(autorInicial, autorFinal);
    }

    public float getMediaNumerosPaginas() {
        //todo pergunta 3.d)
        if (totalLivros > 0) {
            return (float) totalPaginas / totalLivros;
        }
        return 0;
    }

}