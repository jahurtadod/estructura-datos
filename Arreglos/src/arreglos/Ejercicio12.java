package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Se dispone de una lista de n nombres de alumnos. Escribir un 
         * programa que solicite el  nombre de un alumno y busque en la lista 
         * si el nombre está o no. 
         */
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del arreglo:");
        int n = input.nextInt();

        Operaciones op = new Operaciones(n);

        op.ingresarNombres();
        op.buscarNombre();

    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);

        public String[] nombres;
        public String nombre;

        //Constructor
        public Operaciones(int n) {
            this.nombres = new String[n];
            this.nombre = "";

        }

        public void ingresarNombres() {
            for (int i = 0; i < nombres.length; i++) {
                System.out.printf("Introduzca el nombre %d\n", i + 1);
                this.nombres[i] = input.nextLine().toUpperCase();
            }
        }

        public void buscarNombre() {
            System.out.println("Ingrese el nombre a buscar: ");
            boolean bandera = false;
            nombre = input.nextLine().toUpperCase();
            for (int i = 0; i < this.nombres.length; i++) {
                if (nombre == nombres[i]) {
                    System.out.printf("El nombre de %s se encuentra en la posicion: %d\n", nombre, i + 1);
                    bandera = true;
                } else {
                    bandera = false;
                }
            }
            if (bandera = false) {
                System.out.printf("El nombre de %s no se encuentra en la lista\n", nombre);
            }
        }
    }
}
