package aed.avaliacao.periodicanormal.modelo;


import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;

public enum GestorContactos {
    INSTANCIA;

    GestorContactos() {
    }

    public IteradorIteravelDuplo<Contacto> getContactos() {
        //todo pergunta 3.a)
        return null;
    }

    public IteradorIteravelDuplo<Contacto> consultar(float distancia) {
        //todo pergunta 3.b)
        return null;
    }

    public IteradorIteravelDuplo<Contacto> consultar(float distancia, int anoNascimento) {
        //todo pergunta 3.c)
        return null;
    }

    public void inserir(Contacto contacto) {
        //todo pergunta 3.d)
    }

}
