package aed.avaliacao.periodicanormal.modelo;

import aed.Comparacao;

public enum CompEquipasPontDesDifDes implements Comparacao<Equipa>
{

    CRITERIO;

    @Override
    public int comparar(Equipa o1, Equipa o2) {
        int pontuacao=Integer.compare(o2.getPontuacao(), o1.getPontuacao());

        if(pontuacao==0){
            return Integer.compare(o2.getDiferencaGolos(), o1.getDiferencaGolos());
        }
        return pontuacao;

    }




}
