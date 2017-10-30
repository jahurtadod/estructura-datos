package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Dada una lista L de n X m elementos, diseñar un programa que 
         * calcule la suma de  números pares e impares contenidos en ella. 
         */
        Scanner input = new Scanner(System.in);
        int n, m;

        System.out.printf("Ingrese el número de filas: ");
        n = input.nextInt();
        System.out.printf("Ingrese el número de columnas: ");
        m = input.nextInt();

        Operaciones op = new Operaciones(n, m);
        op.ingresarArreglo();
        op.calcularSumas();

    }

    public static class Operaciones {
        
        Scanner input = new Scanner(System.in);
        int[][] L;
        int sumaPar, sumaImp;

        //Constructor
        public Operaciones(int n, int m) {
            this.L = new int[n][m];
            this.sumaPar = 0;
            this.sumaImp = 0;
        }

        public void ingresarArreglo() {
            for (int i = 0; i < this.L.length; i++) {
                for (int j = 0; j < this.L[i].length; j++) {
                    System.out.printf("Ingrese el valor en la posicion [%d,%d] : ", i+1, j+1);
                    this.L[i][j] = input.nextInt();
                }
            }
        }

        public void calcularSumas() {
            for (int[] L1 : L) {
                for (int j = 0; j < L1.length; j++) {
                    if ((L1[j] % 2) == 0) {
                        this.sumaPar += L1[j];
                    } else {
                        this.sumaImp += L1[j];
                    }
                }
            }
            // Salida de datos
            System.out.println("La suma de los numeros pares es:   " + sumaPar);
            System.out.println("La suma de los numeros impares es: " + sumaImp);
        }
    }
}