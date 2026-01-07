package aed.avaliacao.periodicanormal;

import aed.Comparacao;

public enum ComparacaoNifAscEidentificacaoAsc implements Comparacao<Fatura> {
    CRITERIO;

    @Override
    public int comparar(Fatura o1, Fatura o2) {
        int comp= Long.compare(o1.getNifCliente(),o2.getNifCliente());

        if(comp!=0){
            return comp;
        }
        return o1.getIdentificacao().compareTo(o2.getIdentificacao());
    }
}
