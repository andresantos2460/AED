package aed.modelo.contactos;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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
        return "Data{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }

    public int compareTo(Data data){
        //comparar a data THIS com a data DATA

        int comp = Integer.compare(ano,data.ano);
        if(comp!=0){
            return comp;
        }

        comp = Integer.compare(mes,data.mes);
        if(comp!=0){
            return comp;
        }

        return Integer.compare(dia,data.dia);
    }
}
