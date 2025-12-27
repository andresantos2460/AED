package aed.pesquisa.algoritmos;

import aed.Comparacao;

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {

    public PesquisaTernariaIterativa(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {


        if (elementos.length == 0 || criterio.comparar(elemento, elementos[0]) < 0 || criterio.comparar(elemento, elementos[elementos.length - 1]) > 0) {
            return NAO_ENCONTRADO;
        }
        int esq = 0;
        int dir = elementos.length - 1;

        do {
            int terco = (dir - esq) / 3;
            int terco1 = esq + terco;
            int cp = criterio.comparar(elemento, elementos[terco1]);

            if (cp < 0) {
                dir = terco1 - 1;
                continue;
            }
            //cp >=0
            if (cp == 0) {
                return terco1;
            }

            int terco2 = dir - terco;
            cp = criterio.comparar(elemento, elementos[terco2]);

            if (cp < 0) {
                esq = terco1 + 1;
                dir = terco2 - 1;
                continue;
            }

            if (cp == 0) {
                return terco2;
            }
            esq = terco2 + 1;
        } while (esq <= dir);
        return NAO_ENCONTRADO;
    }
}




