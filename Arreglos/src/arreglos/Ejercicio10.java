package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Cada  alumno  de  una  clase  de  20  estudiantes  tiene  notas
         * correspondientes  a  5  asignaturas diferentes, pudiendo no tener 
         * calificación en alguna asignatura. A cada  asignatura  le 
         * corresponde  un  determinado  coeficiente. 
         */

        Operaciones op = new Operaciones();

        op.mediaAlumno();
        op.mediaGeneralAsignatura();

    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        public int[][] notas;
        public int suma, media;
        public int suma_med, suma_asig;
        public int med_total, med_asig;
        public int faltas;

        //Constructor
        public Operaciones() {
            this.notas = new int[20][5];
        }

        public void mediaAlumno() {
            for (int i = 0; i < this.notas.length; i++) {
                System.out.println("Estudiante " + (i + 1));
                for (int j = 0; j < this.notas[i].length; j++) {
                    System.out.println("Introduzca la nota de la asignatura " + (j + 1) + ":");
                    this.notas[i][j] = input.nextInt();
                    this.suma += notas[i][j];
                }
                this.media = this.suma / 5;
                this.suma_med += media;
                System.out.println("La media del estudiante " + (i + 1) + " es: " + this.media);
            }
        }

        public void mediaGeneralAsignatura() {
            this.med_total = suma_med / 20;
            System.out.println("La media general de la clase es: " + this.med_total);
            // Proceso por asignatura y faltas
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 20; i++) {
                    this.suma_asig += notas[i][j];
                    if (notas[i][j] == 0) {
                        this.faltas++;
                    }
                }
                this.med_asig = suma_asig / 20;
                System.out.println("La media de la asignatura " + (j + 1) + " es: " + this.med_asig);
            }
            System.out.println("El porcentaje de faltas es: " + this.faltas + "%");
        }
    }
}
