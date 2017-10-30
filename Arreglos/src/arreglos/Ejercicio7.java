package arreglos;

/**
 *
 * @author jahur
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Escribir un programa que permita calcular el cuadrado de los 100 
         * primeros números  enteros y a continuación escribir un arreglo que 
         * contenga dichos resultados. 
         */
        Operaciones op = new Operaciones();
        
        op.calculaNuevoArreglo();
        op.presentar();

    }

    public static class Operaciones {

        int[] arreglo;

        //Constructor
        public Operaciones() {
            this.arreglo = new int[100];
        }

        public void calculaNuevoArreglo() {
            for (int i = 0; i < 100; i++) {
                this.arreglo[i] = (i*i);
            }
        }

        public void presentar() {
            System.out.println("ELEVADOS AL CUADRADO: ");
            for (int i = 0; i < this.arreglo.length; i++) {
                System.out.printf(" %d ", this.arreglo[i]);
            }
        }
    }
}
