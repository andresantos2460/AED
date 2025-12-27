package aed.analisecomplexidade.algoritmos;

public class JogoTorresHanoi {
        public static void executar(int numeroDiscos){
            if (numeroDiscos < 1) {
                throw new IllegalArgumentException("JogoTorresHanoi ("+ numeroDiscos + ") - pelo menos 1 disco");
            }
            Torre torreA = new Torre("A", numeroDiscos);
            Torre torreB = new Torre("B", numeroDiscos);
            Torre torreC = new Torre("C", numeroDiscos);
            torreA.preencher();
            executarRecursivo(numeroDiscos, torreA, torreB, torreC);
        }

    private static void executarRecursivo(int numeroDiscos, Torre origem, Torre auxiliar, Torre destino) {
            if (numeroDiscos == 1) {
                moverDisco(origem, destino);
            }
            else {
                executarRecursivo(numeroDiscos - 1, origem, destino, auxiliar);
                moverDisco(origem, destino);
                executarRecursivo(numeroDiscos - 1, auxiliar, origem, destino);
            }
    }

    private static void moverDisco(Torre origem, Torre destino) {
        System.out.println("Mover disco de " + origem + " para " + destino);
        origem.MoverDisco(destino);
    }

    public static void apresentar(int numeroDiscos){
        try {
            System.out.println("Jogo Hanoi para " + numeroDiscos);
            executar(numeroDiscos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
