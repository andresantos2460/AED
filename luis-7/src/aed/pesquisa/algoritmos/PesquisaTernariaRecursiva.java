package aed.pesquisa.algoritmos;

import aed.Comparacao;

public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {

    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {
        return pesquisarRecursivo(0, elementos.length - 1, elemento, elementos);
    }

    private int pesquisarRecursivo(int esq, int dir, T elemento, T[] elementos) {
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }

        if (esq <= dir) {
            int terco = (dir - esq) / 3;
            int terco1 = esq + terco;
            int cp = criterio.comparar(elemento, elementos[terco1]);

            if (cp < 0) {
                return pesquisarRecursivo(esq, terco - 1, elemento, elementos);
            }
            //cp >=0
            if (cp == 0) {
                return terco1;
            }

            int terco2 = dir - terco;
            cp = criterio.comparar(elemento, elementos[terco2]);

            if (cp < 0) {
                return pesquisarRecursivo(terco1 + 1, terco2 - 1, elemento, elementos);
            }

            if (cp == 0) {
                return terco2;
            }

            return pesquisarRecursivo(terco2 + 1, dir, elemento, elementos);
        }
        return 0;
    }
}




