package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Se dispone de un arreglo T de n números diferentes de 0, 
         * (puede ser llenada por un  procedimiento que genere números 
         * aleatorios distintos de cero); crear un nuevo  arreglo en el que 
         * todos sus elementos resulten de dividir los elementos del arreglo T 
         * por el elemento T[i], siendo i un valor leído por teclado. 
         */
        Operaciones op = new Operaciones();

        double[][] matriz = {{1, -1, 2, 0}, {2, 1, 3, 1}, {3, 1, 4, 3},{2, 1, 7, 0}};
        double d;

        d = op.determinante(matriz);
        
        System.out.println("La determinante es: ");
        System.out.println(d);
    }

    public static class Operaciones {

        //Constructor
        public Operaciones() {}

        public double determinante(double[][] matriz) {

            int longitud = matriz.length;
            double suma = 0;
            int cnt = 0;
            double[][] aux = new double[longitud - 1][longitud - 1];

            if (longitud == 2) {
                suma = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
                System.out.println("suma"+suma);
                return suma;
            }
            for (int d1 = 0; d1 < longitud; d1++) {
                for (int d2 = 0; d2 < longitud - 1; d2++) {
                    for (int d3 = 0; d3 < longitud; d3++) {
                        if (d3 == d1) {
                            continue;
                        }
                        aux[d2][cnt] = matriz[d2 + 1][d3];
                        System.out.println(aux[d2][cnt]);
                        cnt++;
                    }
                    cnt = 0;
                }
                System.out.println("corte");
                if (d1 % 2 == 0) {
                    suma += matriz[0][d1] * determinante(aux);
                    System.out.println("d1:" +d1);
                    System.out.println("suma2: "+suma);
                } else {
                    System.out.println("d1:" +d1);
                    suma -= matriz[0][d1] * determinante(aux);
                    System.out.println("suma2: "+suma);
                }
            }
            return suma;
        }
    }
}
