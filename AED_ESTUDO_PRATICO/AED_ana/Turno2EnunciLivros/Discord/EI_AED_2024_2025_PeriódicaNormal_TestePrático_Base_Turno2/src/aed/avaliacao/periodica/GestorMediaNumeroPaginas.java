package aed.avaliacao.periodica;

import java.io.Serializable;
import java.util.Objects;

public class GestorMediaNumeroPaginas implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer quantidade;
    private Float media;
    private Float soma;

    public GestorMediaNumeroPaginas(){
        quantidade = 0;
        media = 0f;
        soma = 0f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestorMediaNumeroPaginas obj = (GestorMediaNumeroPaginas) o;
        return Objects.equals(media, obj.media);
    }

    @Override
    public int hashCode () {
        return Objects.hash(quantidade, media, soma);
    }

    @Override
    public String toString() {
        return " (" + quantidade + ", " + media + ", " + soma + ")";
    }

    public float getMedia (){
        return media;
    }

    public void inserir(Livro livro){
        quantidade ++;
        soma += livro.getNumeroPaginas();
        media = soma / quantidade;
    }

}
