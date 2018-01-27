/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class AVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AVLTreeRecursive avl = new AVLTreeRecursive();
        int opt;

        do {
            System.out.print(menuPrincipal());
            opt = input.nextInt();

            switch (opt) {
                case 1:
                    avl.insert(4);
                    break;
                case 2:
                    avl.insert(5);
                    break;
                case 3:
                    avl.insert(6);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
            }
        } while (opt != 0);
        System.out.println("Finalizando........");
    }

    public static String menuPrincipal() {
        // Menu principal
        return String.format(
                "\n\tMENU - LISTAS DOBLEMENTE ENLAZADAS\n"
                + "INGRESE EL NUMERO DE LA OPCION\n"
                + "1. Ingresar Nuevo Nodo - Inicio de la Lista.\n"
                + "2. Ingresar Nuevo Nodo - Final de la Lista.\n"
                + "3. Ingresar Nuevo Nodo - Posición Correspondiente.\n"
                + "4. Eliminar Nodo de la Lista\n"
                + "5. Recorrer la Lista desde Head\n"
                + "6. Recorrer la Lista desde Tail\n"
                + "0. Salir...\n"
                + (char) 27 + "[36m----> ");
    }

}
