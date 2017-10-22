/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodearreglos;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class UsoDeArreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion1, opcion2, num;
        Operaciones op = new Operaciones();

        do {
            System.out.print(op.menuPrincipal());
            opcion1 = input.nextInt();
            switch (opcion1) {
                case 1:
                    op.ingresarArreglo();
                    break;
                case 2:
                    op.presentarArreglo();
                    break;
                case 3:
                    op.ordenarArreglo();
                    op.presentarArreglo();
                    break;
                case 4:
                    op.insertarArreglo();
                    break;
                case 5:
                    System.out.print(op.menuBusqueda());
                    do {
                        System.out.print((char) 27 + "[36m----> ");
                        opcion2 = input.nextInt();
                    } while (opcion2 < 0 || opcion2 > 2);
                    switch (opcion2) {
                        case (1):
                            System.out.print("Ingrese el numero a buscar: \n" + (char) 27 + "[36m----> ");
                            num = input.nextInt();
                            System.out.println(op.busquedaLineal(num));
                            input.nextLine();
                            input.nextLine();
                            break;
                        case (2):
                            System.out.print("Ingrese el numero a buscar: \n" + (char) 27 + "[36m----> ");
                            num = input.nextInt();
                            System.out.println(op.busquedaBinaria(num));
                            input.nextLine();
                            input.nextLine();
                            break;
                    }
                    break;
                case 6:
                    op.eliminarElemento();
                    break;
                case 7:
                    System.out.printf("El total de espacios vacios son: %d\n"
                            + "El total de espacios ocupados son: %d", op.getLibre(), op.getOcupado());
                    input.nextLine();
                    input.nextLine();
                    break;
            }
        } while (opcion1 != 0);
        System.out.println("Finalizando........");
    }
}
