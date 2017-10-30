package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Se dispone de un arreglo de n elementos. Se desea diseñar un 
         * algoritmo que permita  insertar  el  valor  x  en  la  posición 
         * k‐ésima  de  la  lista,  debiendo  desplazarse  los  elementos hacia 
         * la derecha para dar lugar al nuevo elemento y desechando el último  
         * elemento sobrante.  
         */
        Scanner input = new Scanner(System.in);
        System.out.printf("Ingrese el número de elementos del arreglo : ");
        int n = input.nextInt();
        Operaciones op = new Operaciones(n);
        
        op.ingresarArreglo();
        op.insertarArreglo();
        op.presentarArreglo();
        
    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        int[] A;

        //Constructor
        public Operaciones(int n) {
            this.A = new int[n];
        }
        
        public void ingresarArreglo() {
            System.out.println("INGRESO DE LOS VALORES DEL ARREGLO");
            for (int i = 0; i < this.A.length; i++) {
                System.out.printf("Ingrese el valor de la %d posicion: ", i + 1);
                this.A[i] = input.nextInt();
            }
        }        

        public void insertarArreglo() {
            int pos;
            System.out.println("INSERTAR EL NUEVO VALOR");
            do {
                System.out.printf("Ingrese una posición valida (1 a %d) : ", this.A.length);
                pos = this.input.nextInt() - 1;
            } while (pos < 0 || pos > this.A.length);
            for (int i = this.A.length - 1; i > pos; i--) {
                this.A[i] = A[i - 1];
            }
            System.out.print("Ingrese el nuevo valor x: ");
            A[pos] = this.input.nextInt();
        }

        public void presentarArreglo() {
            System.out.println("Su arreglo es : ");
            for (int i = 0; i < A.length; i++) {
                System.out.printf(" %d ", A[i]);
            }
        }
    }
}