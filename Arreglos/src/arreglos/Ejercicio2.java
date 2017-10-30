package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Calcular el número de elementos negativos, cero y positivos de 
         * un vector dado de n  elementos. 
         */        
        Scanner input = new Scanner(System.in);
        int lim;

        System.out.print("Ingrese el tamaño del arreglo: ");
        lim = input.nextInt();

        Operacion op= new Operacion(lim);

        op.llenarArreglo();
        op.clasiNumeros();
    }

    public static class Operacion {

        Scanner input = new Scanner(System.in);

        public int A[];
        public int negativos;
        public int positivos;
        public int cero;

        //Constructor
        public Operacion(int lim) {
            this.A = new int[lim];
            this.negativos = 0;
            this.positivos = 0;
            this.cero = 0;
        }

        public void llenarArreglo() {
            for (int i = 0; i < this.A.length; i++) {
                System.out.print("Ingrese un valor: ");
                A[i] = input.nextInt();
            }
        }

        public void clasiNumeros() {
            for (int i = 0; i < this.A.length; i++) {
                if (A[i] < 0) {
                    negativos += 1;
                } else if (A[i] > 0) {
                    positivos += 1;
                } else {
                    cero += 1;
                }
            }
            System.out.println("Negativos: " + this.negativos);
            System.out.println("Positivos: " + this.positivos);
            System.out.println("Ceros:     " + this.cero);
        }
    }
}
