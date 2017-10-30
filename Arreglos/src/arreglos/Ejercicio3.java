package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Escriba un programa que me permita almacenar en un arreglo B el 
         * factorial de 10  números almacenados previamente en un arreglo A.
         */
        Operaciones op = new Operaciones();
        
        op.ingresarArreglo();
        op.calculoFactoriales();
        
    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        int[] A, B;

        //Constructor
        public Operaciones() {
            this.A = new int[10];
            this.B = new int[10];
        }

        public void ingresarArreglo() {
            System.out.println("INGRESO DE LOS VALORES DEL ARREGLO A");
            for (int i = 0; i < this.A.length; i++) {
                System.out.printf("Ingrese el valor de la %d posicion: ", i + 1);
                this.A[i] = input.nextInt();
            }
        }

        public void calculoFactoriales() {
            for (int i = 0; i < this.A.length; i++) {
                this.B[i] = factorial(this.A[i]);
            }
            presentar(this.B);
        }

        public int factorial(int num) {
            if (num == 1 || num == 0) {
                return 1;
            } else {
                return num * factorial(num - 1);
            }
        }

        public void presentar(int[] arr) {
            System.out.println("VALORES DEL ARREGLO B");
            for (int i = 0; i < arr.length; i++) {
                System.out.printf(" %d ", arr[i]);
            }
        }
    }
}