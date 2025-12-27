package aed.modelo.contactos;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int dia;
    private final int mes;
    private final int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static Data valueOf(String data) {
        String[] partes = data.split("/");
        return new Data(Integer.valueOf(partes[0]), Integer.valueOf(partes[1]), Integer.valueOf(partes[2]));
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public int compareTo(Data data) {
        int comparacao = Integer.compare(ano, data.ano);
        if (comparacao != 0) {
            return comparacao;
        }

        comparacao = Integer.compare(mes, data.mes);
        if (comparacao != 0) {
            return comparacao;
        }

        return Integer.compare(dia, data.dia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return dia == data.dia &&
                mes == data.mes &&
                ano == data.ano;
    }

    @Override
    public int hashCode() {

        return Objects.hash(dia, mes, ano);
    }
}
