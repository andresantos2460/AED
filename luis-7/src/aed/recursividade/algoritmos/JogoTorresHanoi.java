package aed.recursividade.algoritmos;

public class JogoTorresHanoi {
        public static void executar(int numeroDiscos){
            if (numeroDiscos < 1) {
                throw new IllegalArgumentException("JogoTorresHanoi ("+ numeroDiscos + ") - pelo menos 1 disco");
            }
            executarRecursivo(numeroDiscos, 'A', 'B', 'C');
        }

    private static void executarRecursivo(int numeroDiscos, char origem, char auxiliar, char destino) {
            if (numeroDiscos == 1) {
                moverDisco(origem, destino);
            }
            else {
                executarRecursivo(numeroDiscos - 1, origem, destino, auxiliar);
                moverDisco(origem, destino);
                executarRecursivo(numeroDiscos - 1, auxiliar, origem, destino);
            }
    }

    private static void moverDisco(char origem,char destino) {
        System.out.println("Mover disco de " + origem + " para " + destino);
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
