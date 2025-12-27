package aed.analisecomplexidade.algoritmos;

import java.util.NoSuchElementException;

public class Torre {
    private String nome;
    private int[] BaseEDiscos;
    private int numeroDeDiscos;

    public Torre(String nome, int totalDeDiscos) {
        this.nome = nome;
        BaseEDiscos = new int[1 + totalDeDiscos];
        BaseEDiscos[0] = 3 * totalDeDiscos;
        numeroDeDiscos = 0;
    }

    public void preencher() {
        int tamanho = BaseEDiscos.length;
        for (int i = 1; i < tamanho; i++) {
            BaseEDiscos[i] = tamanho - i;
        }
        numeroDeDiscos = tamanho - 1;
        System.out.println("Torre " + nome + " preenchida com " + numeroDeDiscos + " discos");
    }

    public void MoverDisco(Torre destino) {
        if (numeroDeDiscos == 0) {
            throw new NoSuchElementException("Torre de origem vazia");
        }

        if (BaseEDiscos.length != destino.BaseEDiscos.length) {
            throw new IllegalArgumentException("Torre de origem e destino devem ter o mesmo tamanho");
        }

        if(destino.numeroDeDiscos == destino.BaseEDiscos.length - 1){
            throw new ArrayIndexOutOfBoundsException("Torre de destino cheia");
        }

        if( BaseEDiscos[numeroDeDiscos] >= destino.BaseEDiscos[destino.numeroDeDiscos]){
            throw new IllegalArgumentException("Disco de origem maior que o disco de destino");
        }

        destino.BaseEDiscos[++destino.numeroDeDiscos] = BaseEDiscos[numeroDeDiscos];
        BaseEDiscos[numeroDeDiscos--] = 0;
    }
}
