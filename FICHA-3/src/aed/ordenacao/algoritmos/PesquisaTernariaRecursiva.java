package aed.ordenacao.algoritmos;

import aed.Comparacao;
import aed.pesquisa.algoritmos.AlgoritmoPesquisa;

public class PesquisaTernariaRecursiva<T>  extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(T elemento, T... elementos) {
        int indiceUltimoElemento=elementos.length-1;
        if (elementos.length == 0 ||
                criterio.comparar(elemento, elementos[0]) < 0 ||
                criterio.comparar(elemento, elementos[indiceUltimoElemento]) > 0) {
            return NAO_ENCONTRADO;
        }

        return pesquisarRecursivo(elemento,0,indiceUltimoElemento,elementos);
    }

    public int pesquisarRecursivo(T elemento, int esq, int dir, T... elementos) {
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }
        int terco = (dir - esq) / 3;
        int terco1 = esq + terco;
        int cp = criterio.comparar(elemento, elementos[terco1]);
        //i
        if (cp < 0) { // subsquência da esquerda
            return pesquisarRecursivo(elemento, esq,terco1-1, elementos);
        }
        //ii
        if (cp > 0) {
            int terco2 = dir - terco;
            cp = criterio.comparar(elemento, elementos[terco2]);
            //a)
            if(cp < 0) {
                return pesquisarRecursivo(elemento,terco1+1,terco2-1, elementos);
            }
            //b)
            if (cp > 0){
                return pesquisarRecursivo(elemento,terco2+1,dir,elementos);
            }
            //c
            return terco2;
        }
        //iii
        return terco1;
    }
}
