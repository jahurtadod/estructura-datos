package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Realice  un  programa  que  me  permita  realizar  el  ordenamiento 
         * de  una  matriz  bidireccional (el ordenamiento debe ser realizado 
         * en la misma matriz) 
         */
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el tamaño de la matriz:");
        int n = input.nextInt();

        Operaciones op = new Operaciones(n);

        op.ingresarMatriz();
        op.ordenarMatriz();
        op.presentarMatriz();

    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);

        int[][] matriz;

        //Constructor
        public Operaciones(int n) {
            this.matriz = new int[n][n];

        }

        public void ingresarMatriz() {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.printf("Ingrese un valor para la posición [%d, %d] de la matriz: ", i + 1, j + 1);
                    this.matriz[i][j] = input.nextInt();
                }
            }
        }

        public void ordenarMatriz() {
            int aux;
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    for (int x = 0; x < matriz.length; x++) {
                        for (int y = 0; y < matriz.length; y++) {
                            if (matriz[i][j] > matriz[x][y]) {
                                aux = matriz[i][j];
                                matriz[i][j] = matriz[x][y];
                                matriz[x][y] = aux;
                            }
                        }
                    }
                }
            }
        }

        public void presentarMatriz() {
            System.out.println("La matriz ordenada es:");
            for (int[] matriz1 : matriz) {
                for (int j = 0; j < matriz.length; j++) {
                    System.out.print(" " + matriz1[j]);
                }
                System.out.println("");
            }
        }
    }
}
