package arreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Se desea realizar un programa que permita controlar las reservas 
         * de plazas de un  vuelo Quito‐Loja, de acuerdo con las siguientes 
         * normas de la compañía aérea. 
         */
        Scanner input = new Scanner(System.in);

        Operaciones op = new Operaciones();
        int op1;
        do {
            System.out.print(op.menuPrincipal());
            op1 = input.nextInt();
            switch (op1) {
                case 1:
                    op.numeroPlazas();
                    break;
                case 2:
                    op.plazasDisponibles();
                    break;
                case 3:
                    op.realizarReserva();
                    break;
                case 4:
                    op.cancelarReserva();
                    break;
                default:
                    break;
            }
        } while (op1 != 0);
        System.out.println("Finalizando........");
    }

    public static class Operaciones {

        Scanner input = new Scanner(System.in);
        int[] plazas;
        int libre, ocupado;
        int libref, ocupadof;

        //Constructor
        public Operaciones() {
            this.plazas = new int[100];
            this.libre = 70;
            this.libref = 30;
            this.ocupado = 0;
            this.ocupadof = 0;
        }

        public String menuPrincipal() {
            // Menu principal
            return String.format(
                    "\n\tVuelo: QUITO-LOJA\n"
                    + "INGRESE EL NUMERO DE LA OPCION\n"
                    + "1. Número de Plazas\n"
                    + "2. Plazas Disponibles\n"
                    + "3. Relizar Reserva\n"
                    + "4. Cancelar Reserva\n"
                    + "0. Salir...\n"
                    + ((char) 27 + "[36m----> "));
        }

        public void numeroPlazas() {
            System.out.println(" Número de plazas del avión: " + this.plazas.length);
        }

        public void plazasDisponibles() {
            System.out.println(" Hay " + (this.libref + this.libre) + " plazas disponibles");
            System.out.println("\t" + this.libre + " para no fumadores");
            System.out.println("\t" + this.libref + " para fumadores");
        }

        public void realizarReserva() {
            if (this.libref != 0 && this.libre != 0) {
                int pos;
                System.out.println("1. Zona para Fumadores\n2. Zona para no Fumadores");
                int op2 = input.nextInt();
                switch (op2) {
                    case 1:
                        do {
                            System.out.printf("Ingrese un número de asiento valido (1 a 30)\n" + (char) 27 + "[36m----> ", this.plazas.length);
                            pos = this.input.nextInt() - 1;
                        } while (pos < 0 || pos >= 30);
                        if (this.plazas[pos] == 0) {
                            this.plazas[pos] = 1000 + (int) (Math.random() * 4000);
                            System.out.println("Su reserva se a realizado con éxito");
                            System.out.println("Su boleto es :" + this.plazas[pos] + " (NO OLVIAR)");
                            this.libref--;
                            this.ocupadof++;
                        } else {
                            System.out.println("El puesto seleccionado ya ha sido reservado");
                        }
                        break;
                    case 2:
                        do {
                            System.out.printf("Ingrese un número de asiento valido (31 a 100)\n" + (char) 27 + "[36m----> ", this.plazas.length);
                            pos = this.input.nextInt() - 1;
                        } while (pos < 31 || pos > this.plazas.length);
                        if (this.plazas[pos] == 0) {
                            this.plazas[pos] = 1000 + (int) (Math.random() * 4000);
                            System.out.println("Su reserva se a realizado con éxito");
                            System.out.println("Su boleto es :" + this.plazas[pos] + " (NO OLVIAR)");
                            this.libre--;
                            this.ocupado++;
                        } else {
                            System.out.println("El puesto seleccionado ya ha sido reservado");
                        }
                        break;
                    default:
                        System.out.println("No ha seleccionado la zona correctamente - Vuelva ha intentar");
                        break;
                }
            } else {
                System.out.println("No hay vuelos disponibles o el vuelo ya ha salido");
            }
        }

        public void cancelarReserva() {
            int pos;
            int boleto;
            do {
                System.out.printf("Ingrese un número de asiento valido (1 a 100)\n" + (char) 27 + "[36m----> ", this.plazas.length);
                pos = this.input.nextInt() - 1;
            } while (pos < 0 || pos > 100);
            if (this.plazas[pos] == 0) {
                System.out.println("El asiento seleccionado no ha sido reservado");
            } else {
                System.out.println("Ingrese su boleto: ");
                boleto = input.nextInt();
                if (boleto == this.plazas[pos]) {
                    System.out.println("Su reserva ha sido eliminada con éxito");
                    this.plazas[pos] = 0;
                    if (pos > 30) {
                        this.libre++;
                        this.ocupado--;
                    } else {
                        this.libref++;
                        this.ocupadof--;
                    }
                } else {
                    System.out.println("El boleto no corresponde a la reserva");
                }
            }
        }
    }
}