package aed.avaliacao.periodicanormal.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String primeiroNome;
    private String ultimoNome;
    private long numeroTelefone;
    private String morada;
    private int altura; //em cm

    public Contacto(String primeiroNome, String ultimoNome, long numeroTelefone, String morada, int altura) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.altura = altura;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getMorada() {
        return morada;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contacto contacto = (Contacto) o;
        return numeroTelefone == contacto.numeroTelefone && altura == contacto.altura && Objects.equals(primeiroNome, contacto.primeiroNome) && Objects.equals(ultimoNome, contacto.ultimoNome) && Objects.equals(morada, contacto.morada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiroNome, ultimoNome, numeroTelefone, morada, altura);
    }

    @Override
    public String toString() {
        return primeiroNome + " " + ultimoNome +
                " - Nº: " + numeroTelefone +
                " - " + morada +
                " - " + altura;
    }

}
