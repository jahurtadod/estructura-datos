package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Calcular la suma de los elementos de la diagonal principal 
         * de una matriz de n X n.
         */
        
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la matriz: ");
        int lim = input.nextInt();
        
        Operaciones op = new Operaciones(lim);
        
        op.llenar();
        op.calcularSuma();

    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        public int sumaDiag;
        public int[][] matriz;

        //Constructor
        public Operaciones(int lim) {
            this.sumaDiag = 0;
            this.matriz = new int[lim][lim];
        }

        public void llenar() {
            System.out.println("Llenar la matriz");
            for (int i = 0; i < this.matriz.length; i++) {
                for (int j = 0; j < this.matriz.length; j++) {
                    System.out.printf("Ingrese el valor posición [%d,%d] : ", i, j);
                    matriz[i][j] = input.nextInt();
                }
            }
        }

        public void calcularSuma() {
            for (int i = 0; i < this.matriz.length; i++) {
                for (int j = 0; j < this.matriz.length; j++) {
                    if (i == j) {
                        this.sumaDiag += matriz[i][j];
                    }
                }
            }
            System.out.println("La suma de la diagonal principal es: " + sumaDiag);
        }
    }
}