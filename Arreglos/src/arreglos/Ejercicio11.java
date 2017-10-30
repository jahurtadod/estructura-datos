package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Una empresa tiene diez almacenes y desea un programa que lea sus 
         * ventas mensuales,  calcule la media de las ventas y obtener un 
         * listado de los almacenes cuyas ventas  mensuales son superiores a 
         * la media. 
         */
        Operaciones op = new Operaciones();
        
        op.ingresarVentas();
        op.obtenerMedias();
        op.obtenerMayores();
        op.presentar();

    }

    public static class Operaciones {
        
        Scanner input = new Scanner(System.in);
        public double[][] ventas;
        public double[] media;
        public double media_total;
        public int[] mayores;

        //Constructor
        public Operaciones() {
            this.ventas = new double[10][12];
            this.media = new double[10];
        }

        public void ingresarVentas() {
            for (int i = 0; i < this.ventas.length; i++) {
                for (int j = 0; j < this.ventas[0].length; j++) {
                    System.out.printf("Ingrese las Ventas del %d almacen del mes %d: \n", i + 1, j + 1);
                    ventas[i][j] = input.nextDouble();
                }
            }
        }

        public void obtenerMedias() {
            for (int i = 0; i < this.ventas.length; i++) {
                double suma = 0;
                for (int j = 0; j < this.ventas[0].length; j++) {
                    suma += this.ventas[i][j];
                }
                this.media[i] = (suma / this.ventas[0].length);
            }
        }

        public double obtenerMediaTotal(double[] array) {
            double suma = 0;
            for (int i = 0; i < array.length; i++) {
                suma = suma + array[i];
            }
            double prom = suma / array.length;
            return prom;
        }

        public void obtenerMayores() {
            int cont = 0;
            media_total = this.obtenerMediaTotal(media);
            for (int i = 0; i < this.ventas.length; i++) {
                if (this.media[i] > this.media_total) {
                    cont++;
                }
            }
            this.mayores = new int[cont];
            int k = 0;
            for (int i = 0; i < this.ventas.length; i++) {
                if (this.media[i] > this.media_total) {
                    this.mayores[k] = i + 1;
                    k++;
                }
            }
        }

        public void presentar() {
            for (int i = 0; i < this.ventas.length; i++) {
                System.out.printf("\nAlmacen %d\n", i + 1);
                for (int j = 0; j < this.ventas[0].length; j++) {
                    System.out.printf("Las ventas en el mes %d son: %.2f\n", j + 1, this.ventas[i][j]);
                }
                System.out.printf("Su media en venta anual es de: %.2f\n", this.media[i]);
            }
            System.out.printf("\nLa media total en ventas de los almacenes es: %.2f\n"
                    + "Los almacenes que superan la media son:\n", this.media_total);
            for (int i = 0; i < this.mayores.length; i++) {
                System.out.printf(" Almacen %d \n", this.mayores[i]);
            }
        }
    }
}
