package aed.avaliacao.periodicanormal.modelo;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorContactos {
    INSTANCIA;

    GestorContactos() {

    }

    public IteradorIteravelDuplo<Contacto> getContactos() {
        // todo 3.a)
      return null;
    }

    public IteradorIteravelDuplo<Contacto> getContactos(int altura) {
            //todo 3.b)
        return null;
    }

    public IteradorIteravelDuplo<Contacto> getContactos(int alturaInicial, int alturaFinal) {
        // todo 3.c)
        return null;
    }

    public int getAmplitudeAlturas() {


        return -1;
    }

    public void inserir(Contacto contacto) {
        // todo 3.e)

    }

}
