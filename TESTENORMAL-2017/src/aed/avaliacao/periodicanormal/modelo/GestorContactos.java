package aed.avaliacao.periodicanormal.modelo;


import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashComIncrementoPorHash;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

public enum GestorContactos {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Contacto> ITERADOR_ITERAVEL_DUPLO = new ListaDuplaNaoOrdenada<Contacto>().iterador();
    private ListaDuplaOrdenada<Contacto> contactos;
    private TabelaHashComIncrementoPorHash<Integer,GestorContactosAno> contactosPorAno;
    GestorContactos() {
        contactos = new ListaDuplaOrdenada<>(ComparacaoDistanciaAsc.CRITERIO);
        contactosPorAno = new TabelaHashComIncrementoPorHash<>(4);
    }

    public IteradorIteravelDuplo<Contacto> getContactos() {
        //todo pergunta 3.a)
        return contactos.iterador();
    }

    public IteradorIteravelDuplo<Contacto> consultar(float distancia) {
        //todo pergunta 3.b)
        Contacto contacto1=new Contacto(null,null,0L,null,null,0F);
        Contacto contacto2=new Contacto(null,null,0L,null,null,distancia);
        return contactos.consultar(contacto1,contacto2);
    }

    public IteradorIteravelDuplo<Contacto> consultar(float distancia, int anoNascimento) {
        GestorContactosAno gestorDoAno = contactosPorAno.consultar(anoNascimento);

        return gestorDoAno==null? ITERADOR_ITERAVEL_DUPLO :gestorDoAno.consultar(distancia);
    }

    public void inserir(Contacto contacto) {
        contactos.inserir(contacto);
        int ano = contacto.getDataNascimento().getAno();
        GestorContactosAno gestorAno = contactosPorAno.consultar(ano);

        if(gestorAno==null){
            gestorAno=new GestorContactosAno(ano);
            contactosPorAno.inserir(ano,gestorAno);
        }
        gestorAno.inserir(contacto);
    }

}
