package aed.avaliacao.periodica;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorBiblioteca {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Livro> ITERADOR_ITERAVEL_DUPLO = new ListaDuplaNaoOrdenada<Livro>().iterador();
    private ListaDuplaOrdenada<Livro> livros;
    private TabelaHashOrdenada<String,GestorBibliotecaAutor> livrosPorAutor;
    private float media;
    private int totalPaginas;


    GestorBiblioteca() {
        livros=new ListaDuplaOrdenada<>(ComparacaoPorNumeroPaginasDescEAutorAsc.CRITERIO);
        livrosPorAutor = new TabelaHashOrdenada<>(ComparacaoPorAutorAsc.CRITERIO,2);
        media=0;
        totalPaginas=0;
    }

    public void inserir(Livro livro) {
        livros.inserir(livro);
        totalPaginas += livro.getNumeroPaginas();
        media = (float) totalPaginas / livros.getNumeroElementos();

        String autor = livro.getAutor();
        GestorBibliotecaAutor GestorAutor=livrosPorAutor.consultar(autor);
        if(GestorAutor==null){
            GestorAutor=new GestorBibliotecaAutor(autor);
            livrosPorAutor.inserir(autor, GestorAutor);
        }
        GestorAutor.inserir(livro);
    }

    public IteradorIteravelDuplo<Livro> getLivros() {
      return livros.iterador();
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autor) {
        GestorBibliotecaAutor gestorAutor=livrosPorAutor.consultar(autor);

        return gestorAutor==null? ITERADOR_ITERAVEL_DUPLO :gestorAutor.iterador();
    }

    public IteradorIteravelDuplo<Livro> getLivros(String autorInicial, String autorFinal) {
        return new Iterador(autorInicial,autorFinal);
    }

    public float getMediaNumerosPaginas() {
        return media;
    }

    private class Iterador implements IteradorIteravelDuplo<Livro>{
        private IteradorIteravelDuplo<GestorBibliotecaAutor> iteradorGestores;
        private IteradorIteravelDuplo<Livro> iteradorLivros;

        public Iterador(String autorInicial, String autorFinal) {
            iteradorGestores = livrosPorAutor.consultarValores(autorInicial,autorFinal);
            iteradorLivros=ITERADOR_ITERAVEL_DUPLO;
        }

        @Override
        public boolean podeRecuar() {
            if(iteradorGestores.podeRecuar()||iteradorLivros.podeRecuar()){
                return true;
            }
            return false;
        }

        @Override
        public Livro recuar() {
            if(!iteradorLivros.podeRecuar()){
                iteradorLivros=iteradorGestores.recuar().iterador();
            }
            return iteradorLivros.recuar();
        }

        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorLivros=ITERADOR_ITERAVEL_DUPLO;
        }

        @Override
        public Livro corrente() {

            return iteradorLivros.corrente();
        }

        @Override
        public boolean podeAvancar() {
            if(iteradorLivros.podeAvancar()||iteradorGestores.podeAvancar()){
                return true;
            }
            return false;
        }

        @Override
        public Livro avancar() {
            if(!iteradorLivros.podeAvancar()){
                iteradorLivros = iteradorGestores.avancar().iterador();
            }
            return  iteradorLivros.avancar();
        }
    }

}