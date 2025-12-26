package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;

public class ListaDuplaNaoOrdenada<T>  implements ColecaoIteravelLinearNaoOrdenada<T> {

    private static final long serialVersionUID = 1L;
    protected No noInicial;
    protected No noFinal;
    protected int  numeroElementos;

    public ListaDuplaNaoOrdenada() {
        noInicial = null;
        noFinal = null;
        numeroElementos = 0;
    }

    @Override
    public void inserirNoInicio(T elem) {
        if(++numeroElementos==1) {
            noInicial = noFinal = new No(elem);
        }else{
            noInicial=new No(elem,noInicial);
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal=new No(elem);
        if (++numeroElementos == 1) {
            noInicial = noFinal;
        }
    }


    public class No implements Serializable{
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No anterior;
        protected No seguinte;

        public No(T elemento) {
            this.elemento = elemento;
            anterior=noFinal;
            seguinte=null;

            if(noFinal!=null){
                noFinal.seguinte=this;
            }
        }
        // Criação de nó com elemento elem e inserção antes o nó seg (!= null)
        protected No(T elem,No seg) {
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            seg.anterior = this;

            if (anterior != null) {
                anterior.seguinte = this;
            }
        }

    }

}


