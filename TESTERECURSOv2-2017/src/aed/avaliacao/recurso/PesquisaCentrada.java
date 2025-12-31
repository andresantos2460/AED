package aed.avaliacao.recurso;

import aed.Comparacao;
import aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import aed.utils.Vetor;

import java.util.Random;

public class PesquisaCentrada<T> extends AlgoritmoPesquisa<T> {
    public PesquisaCentrada(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(int indiceInicial, T elemento, T... elementos) {
        //TODO: PERGUNTA 1
        return NAO_ENCONTRADO;
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {
        return pesquisar(new Random().nextInt(elementos.length), elemento, elementos);
    }

    @Override
    public void apresentar(int indiceInicial, T elemento, T... elementos) {
        System.out.println("Índice inicial: " + indiceInicial);
        int indice = pesquisar(indiceInicial, elemento, elementos);
        System.out.print(elemento + " pesquisado por " + getClass().getSimpleName()
                + (indice != NAO_ENCONTRADO ? (" encontrado no índice " + indice) : " não encontrado") + " : ");
        Vetor.apresentar(10, elementos);
    }
}
