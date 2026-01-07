package aed.avaliacao.periodicanormal;

public class Perrin {
    public static int executar(int n){
        if (n<0){
            throw new IllegalArgumentException("valor invalido");
        }
        if(n==3){
            return 0;
        }

        if(n==0){
            return 1;

        }
        if(n==2){
            return 2;
        }

        return executar(n-2)+executar(n-3);
    }

    public static void apresentar(int n){
        try{
            System.out.println("Resultado de "+ n +" é "+executar(n));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
