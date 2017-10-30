package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Diseñe un programa que me permita implementar el algoritmo del
         * “cuadrado mágico”  de un número de filas y columnas ingresado
         *  por teclado. 
         */
        Scanner input = new Scanner(System.in);
        System.out.printf("Ingrese el tamaño del cuadrado mágico : ");
        int num = input.nextInt();
        Operaciones op = new Operaciones(num);

        if (num % 2 == 0) {
            op.llenarMagicoPar();
        } else {
            op.llenarMagicoImpar();
        }

    }

    public static class Operaciones {

        int num;
        int[][] matrizMagica;
        int constanteMagica;

        //CONSTRUCTOR
        public Operaciones(int num) {
            this.matrizMagica = new int[num][num];
            this.num = num;
        }

        public void calcularConstante() {
            this.constanteMagica = (this.num * (((int) Math.pow(this.num, 2)) + 1)) / 2;
        }

        public void llenarMatrizCeros() {
            for (int i = 0; i < this.num; i++) {
                for (int j = 0; j < this.num; j++) {
                    this.matrizMagica[i][j] = 0;
                }
            }
        }

        public void llenarMatriz() {
            int temp = 0;
            for (int i = 0; i < this.num; i++) {
                for (int j = 0; j < this.num; j++) {
                    temp += 1;
                    this.matrizMagica[i][j] = temp;
                }
            }
        }

        public void llenarMagicoImpar() {
            llenarMatrizCeros();
            calcularConstante();
            int start = this.num / 2;
            int i = 0, j = start;
            int i_ant = 0, j_ant = 0;

            for (int temp = 1; temp <= (num * num); temp++) {
                if (this.matrizMagica[i][j] == 0) {
                    this.matrizMagica[i][j] = temp;
                } else {
                    i = i_ant + 1;
                    j = j_ant;
                    this.matrizMagica[i][j] = temp;
                }
                //Se guarda la posicion anterior
                i_ant = i;
                j_ant = j;
                //Se crea el movimiento uno arriba y uno derecha
                i--;
                j++;
                //Reglas para la siguiente condicion
                if (i < 0 && j == this.num) {
                    i = this.num - 1;
                    j = 0;
                } else if (i < 0) {
                    i = i + this.num;
                } else if (j == this.num) {
                    j = 0;
                }
            }
            presentarCuadrado();
        }

        public void llenarMagicoPar() {
            calcularConstante();
            llenarMatriz();
            int cuadrado = this.num / 2;
            int cuadrado2 = cuadrado / 2;
            int temp, k = this.num - (cuadrado2 + 1), l = this.num - 1;
            
            for (int i = 0; i < cuadrado2; i++) {
                for (int j = cuadrado2; j < (this.num - cuadrado2); j++) {
                    temp = this.matrizMagica[i][j];
                    this.matrizMagica[i][j] = this.matrizMagica[l][k];
                    this.matrizMagica[l][k] = temp;
                    k--;
                }
                l--;
                k = this.num - (cuadrado2 + 1);
            }
            
            k = this.num - (cuadrado2 + 1); l = this.num - 1;
            for (int i = 0; i < cuadrado2; i++) {
                for (int j = cuadrado2; j < (this.num - cuadrado2); j++) {
                    temp = this.matrizMagica[i][j];
                    this.matrizMagica[j][i] = this.matrizMagica[k][l];
                    this.matrizMagica[k][l] = temp;
                    k--;
                }
                l--;
                k = this.num - (cuadrado2 + 1);
            }
            presentarCuadrado();
        }

        public void presentarCuadrado() {
            System.out.println("La constante mágica de es: " + this.constanteMagica);
            for (int i = 0; i < this.num; i++) {
                for (int j = 0; j < this.num; j++) {
                    if (this.matrizMagica[i][j] > 99) {
                        System.out.print("  |" + this.matrizMagica[i][j] + "|  ");
                    } else if (this.matrizMagica[i][j] > 9) {
                        System.out.print("  |" + this.matrizMagica[i][j] + " |  ");
                    } else if (this.matrizMagica[i][j] > 0) {
                        System.out.print("  |" + this.matrizMagica[i][j] + "  |  ");
                    }
                }
                System.out.println(" ");
            }
        }
    }

}
