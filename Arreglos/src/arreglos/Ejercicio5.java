package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio5 {

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
        Scanner input = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del arreglo: ");
        int lim = input.nextInt();
        
        Operaciones op = new Operaciones(lim);
        
        op.Presentar();
        
        System.out.print("\nIngrese la posicion T[i]: ");
        int t_i = input.nextInt();
        
        op.newArray(t_i);

    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        public double[] T1;
        public double[] T2;
        
        //Constructor
        public Operaciones(int lim) {
            this.T1 = new double[lim];
            this.T2 = new double[lim];
        }

        public void Presentar() {
            System.out.println("Arreglo Originado Aleatoriamente: ");
            for (int i = 0; i < this.T1.length; i++) {
                this.T1[i] = (int) (Math.random() * 100) + 1;
                System.out.print(this.T1[i] + " ");
            }
        }

        public void newArray(int t_i) {
            System.out.println("Nuevo Arreglo");
            for (int i = 0; i < this.T1.length; i++) {
                T2[i] = T1[i] / T1[t_i - 1];
                System.out.print(this.T2[i] + " , ");
            }
        }
    }
}
