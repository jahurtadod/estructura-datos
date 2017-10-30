package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Realice un programa que me permita realizar operaciones con matrices
         */
        Scanner input = new Scanner(System.in);
        Operaciones op = new Operaciones();

        int op1;
        do {
            System.out.print(op.menuPrincipal());
            op1 = input.nextInt();
            switch (op1) {
                case 1:
                    op.ingresoMatrices();
                    break;
                case 2:
                    op.multiplicacionMatrices();
                    break;
                case 3:
                    op.sumaMatrices();
                    break;
                case 4:
                    op.restaMatrices();
                    break;
                case 5:
                    op.escalarMatrices();
                    break;
                case 6:
                    op.traspuestaMatrices();
                    break;
                default:
                    break;
            }
        } while (op1 != 0);
        System.out.println("Finalizando........");
    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        int[][] A, B;
        int filas_A, columnas_A, filas_B, columnas_B;

        //Constructor
        public Operaciones() {
            this.ingresoTamaño();
            this.A = new int[this.filas_A][this.columnas_A];
            this.B = new int[this.filas_B][this.columnas_B];
        }

        public String menuPrincipal() {
            // Menu principal
            return String.format(
                    "\tOPERACIONES-MATRICES\n"
                    + "INGRESE EL NUMERO DE LA OPCION\n"
                    + "1. Ingresar Matrices\n"
                    + "2. La Multiplicación de dos Matrices\n"
                    + "3. Suma de Matrices\n"
                    + "4. Resta de Matrices\n"
                    + "5. Multiplicación por un Escalar\n"
                    + "6. Traspuesta de una matriz\n"
                    + "0. Salir\n"
                    + "----> ");
        }

        private void ingresoTamaño() {
            //Se pide el tamaño de las matrices
            System.out.println("Ingrese el numero de filas de la primera matriz: ");
            this.filas_A = input.nextInt();
            System.out.println("Ingrese el numero de columnas de la primera matriz: ");
            this.columnas_A = input.nextInt();
            System.out.println("Ingrese el numero de filas de la segunda matriz: ");
            this.filas_B = input.nextInt();
            System.out.println("Ingrese el numero de columnas de la segunda matriz: ");
            this.columnas_B = input.nextInt();
        }

        public void ingresoMatrices() {
            for (int i = 0; i < this.A.length; i++) {
                for (int j = 0; j < this.A[i].length; j++) {
                    System.out.printf("Ingrese un valor para la posición [%d, %d] de la primera matriz: ", i + 1, j + 1);
                    this.A[i][j] = input.nextInt();
                }
            }
            for (int i = 0; i < this.B.length; i++) {
                for (int j = 0; j < this.B[i].length; j++) {
                    System.out.printf("Ingrese un valor para la posición [%d, %d] de la segunda matriz: ", i + 1, j + 1);
                    this.B[i][j] = input.nextInt();
                }
            }
        }

        public void multiplicacionMatrices() {
            if (this.columnas_A == this.filas_B) {
                int[][] AB = new int[this.filas_A][this.columnas_B];
                for (int i = 0; i < this.filas_A; i++) {
                    for (int j = 0; j < this.columnas_B; j++) {
                        for (int k = 0; k < this.columnas_A; k++) {
                            AB[i][j] = AB[i][j] + (this.A[i][k] * this.B[k][j]);
                        }

                    }
                }
                this.presentarMatriz(AB);
            }else{
                System.out.println("Las matrices dadas no se pueden multiplicar");
            }            
        }

        public void sumaMatrices() {
            if (this.filas_A == this.filas_B && this.columnas_A == this.columnas_B) {
                int[][] C = new int[this.filas_A][this.filas_A];
                for (int i = 0; i < this.filas_A; i++) {
                    for (int j = 0; j < this.filas_A; j++) {
                        C[i][j] = (this.A[i][j] + this.B[i][j]);
                    }
                }
                this.presentarMatriz(C);
            } else {
                System.out.println("Las matrices dadas no se pueden sumar o restar");
            }
        }

        public void restaMatrices() {
            if (this.filas_A == this.filas_B && this.columnas_A == this.columnas_B) {
                int[][] C = new int[this.filas_A][this.filas_A];
                for (int i = 0; i < this.filas_A; i++) {
                    for (int j = 0; j < this.filas_A; j++) {
                        C[i][j] = (this.A[i][j] - this.B[i][j]);
                    }
                }
                this.presentarMatriz(C);
            } else {
                System.out.println("Las matrices dadas no se pueden sumar o restar");
            }
        }

        public void multiEscalar(int[][] arreglo, int filas, int columnas) {
            int escalar;
            System.out.println("Ingrese el escalar ha multiplicar");
            escalar = input.nextInt();
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    arreglo[i][j] = arreglo[i][j] * escalar;
                }
            }
            presentarMatriz(arreglo);
        }

        public void escalarMatrices() {
            System.out.println("Cual matriz desea trabajar:\n1. Primera\n2. Segunda");
            int op2 = input.nextInt();
            if (op2 == 1) {
                this.multiEscalar(A, filas_A, columnas_A);
            } else {
                this.multiEscalar(B, filas_B, columnas_B);
            }
        }

        public void traspuestaMatrices() {
            System.out.println("Cual matriz desea trabajar:\n1. Primera\n2. Segunda");
            int op2 = input.nextInt();
            if (op2 == 1) {
                this.sacarTraspuesta(A, filas_A, columnas_A);
            } else {
                this.sacarTraspuesta(B, filas_B, columnas_B);
            }
        }

        public void sacarTraspuesta(int[][] arreglo, int filas, int columnas) {
            int[][] arreglot = new int[columnas][filas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    arreglot[j][i] = arreglo[i][j];
                }
            }
            presentarMatriz(arreglot);
        }

        public void presentarMatriz(int[][] arreglo) {
            System.out.println("La matriz obtenida es : ");
            for (int[] arreglo1 : arreglo) {
                for (int j = 0; j < arreglo1.length; j++) {
                    System.out.print("  |" + arreglo1[j] + "|  ");
                }
                System.out.println(" ");
            }
        }
    }
}