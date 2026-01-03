package aed.avaliacao.periodica;
import aed.Comparacao;
public enum CompararNumeroPaginas implements Comparacao<Livro> {
    CRITERIO;

    @Override
    public int comparar(Livro o1, Livro o2) {
        int resultado = Integer.compare(o2.getNumeroPaginas(), o1.getNumeroPaginas());
        if(resultado==0){
            resultado = o1.getTitulo().compareTo(o2.getTitulo());
        }
        return resultado;
    }
}
