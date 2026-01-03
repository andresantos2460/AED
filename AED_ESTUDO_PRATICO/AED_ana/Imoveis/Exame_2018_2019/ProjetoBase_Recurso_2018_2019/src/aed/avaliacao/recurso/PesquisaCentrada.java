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
        if (indiceInicial < 0 || indiceInicial >= elementos.length) {
            throw new ArrayIndexOutOfBoundsException(indiceInicial);
        }
        if (criterio.comparar(elementos[indiceInicial], elemento) == 0) {
            return indiceInicial;
        }
        int esq = indiceInicial;
        int dir = indiceInicial;
        while (--esq > -1 && ++dir < elementos.length) {
            if (criterio.comparar(elementos[esq], elemento) == 0) {
                return esq;
            }
            if (criterio.comparar(elementos[dir], elemento) == 0) {
                return dir;
            }
        }
        while (esq > -1) {
            if (criterio.comparar(elementos[esq], elemento) == 0) {
                return esq;
            }
            --esq;
        }
        while (++dir < elementos.length) {
            if (criterio.comparar(elementos[dir], elemento) == 0) {
                return dir;
            }
        }
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
