package aed.modelo.contactos;

public class Contacto {
    String primeiroNome;
    String ultimoNome;
    long numeroTelefone;
    String morada;
    Data dataNascimento;

    public Contacto(String primeiroNome, String ultimoNome, long numeroTelefone, String morada, Data dataNascimento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
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

    public Data getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", numeroTelefone=" + numeroTelefone +
                ", morada='" + morada + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
