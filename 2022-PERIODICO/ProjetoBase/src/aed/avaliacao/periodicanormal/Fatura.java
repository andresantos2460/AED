package aed.avaliacao.periodicanormal;

import java.util.Objects;

public class Fatura {
    private String identificacao;
    private long nifCliente;
    private float valor;

    public Fatura(String identificacao, long nifCliente, float valor) {
        this.identificacao = identificacao;
        this.nifCliente = nifCliente;
        this.valor = valor;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public long getNifCliente() {
        return nifCliente;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Fatura: " + identificacao + " " + valor + "€\t" + nifCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fatura fatura = (Fatura) o;
        return nifCliente == fatura.nifCliente && Float.compare(fatura.valor, valor) == 0 && Objects.equals(identificacao, fatura.identificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacao, nifCliente, valor);
    }
}
