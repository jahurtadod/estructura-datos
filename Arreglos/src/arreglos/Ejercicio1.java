package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Leer una matriz de n X m elementos y calcular la suma de cada una 
         * de sus filas y  columnas, dejando dichos resultados en dos vectores, 
         * uno de la suma de filas y otro de  columnas.
         */
        Scanner input = new Scanner(System.in);
        int n, m;

        System.out.printf("Ingrese el número de filas: ");
        n = input.nextInt();
        System.out.printf("Ingrese el número de columnas: ");
        m = input.nextInt();

        Operaciones op = new Operaciones(n, m);
        
        op.leerMatriz();
        op.sumaFilas();
        op.sumaColumnas();
        
    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);

        int[][] matriz;
        int[] sumaFil, sumaCol;
        int n, m;

        //Constructor
        public Operaciones(int n, int m) {
            this.n = n;
            this.m = m;
            this.matriz = new int[n][m];
            this.sumaFil = new int[n];
            this.sumaCol = new int[m];
        }

        public void leerMatriz() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("Ingrese el valor posición [%d,%d] : ", i, j);
                    matriz[i][j] = input.nextInt();
                }
            }
        }

        public void sumaFilas() {
            int suma = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    suma = suma + this.matriz[i][j];
                }
                this.sumaFil[i] = suma;
                suma = 0;
            }
            System.out.println("Suma - Filas");
            presentarFil(this.sumaFil);
        }

        public void sumaColumnas() {
            int suma = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    suma = suma + this.matriz[j][i];
                }
                this.sumaCol[i] = suma;
                suma = 0;
            }
            System.out.println("Suma - Columnas");
            presentarCol(this.sumaCol);
        }

        public void presentarFil(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("\tFila %d : %d \n", i, arr[i]);
            }
        }
        
        public void presentarCol(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("\tColumna %d : %d \n", i, arr[i]);
            }
        }
    }
}