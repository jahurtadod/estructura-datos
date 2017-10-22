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
public class Operaciones {

    Scanner input = new Scanner(System.in);
    public int[] arreglo;
    private int libre, ocupado;

    public Operaciones() {
        //Adecuamos el arreglo para iniciar a trabajar
        System.out.print("Ingrese el limite del arreglo: ");
        this.arreglo = new int[input.nextInt()];
        this.libre = this.arreglo.length;
        this.ocupado = 0;
    }

    public String menuPrincipal() {
        // Menu principal
        return String.format(
                "\n\tMENU - ARREGLOS\n"
                + "INGRESE EL NUMERO DE LA OPCION\n"
                + "1. Ingresar Arreglo\n"
                + "2. Presentar Arreglo\n"
                + "3. Ordenar Arreglo\n"
                + "4. Insertar Elemento\n"
                + "5. Buscar Elemento\n"
                + "6. Eliminar Elemento\n"
                + "7. Espacios Libres - Ocupados\n"
                + "0. Salir...\n"
                + ((char) 27 + "[36m----> "));
    }

    public String menuBusqueda() {
        // Menu de Busquedad
        return String.format(
                "SELECCIONE EL TIPO DE BUSQUEDA\n"
                + "1. Busqueda Lineal\n"
                + "2. Busqueda Binaria (arreglo ordenado)\n"
                + "0. Salir...\n");
    }

    public void ingresarArreglo() {
        for (int i = 0; i < this.arreglo.length; i++) {
            System.out.printf("Desea ingresar un valor en la posicion: %d\n"
                    + "1.Si\n"
                    + "2.No\n"
                    + "0.Terminar el ingreso\n"
                    + ((char) 27 + "[36m----> "), i + 1);
            int ingreso = input.nextInt();
            switch (ingreso) {
                case 1:
                    System.out.printf("Ingrese el valor de la %dª posición: \n" + ((char) 27 + "[36m----> "), i + 1);
                    this.arreglo[i] = this.input.nextInt();
                    this.libre--;
                    this.ocupado++;
                    break;
                case 2:
                    this.arreglo[i] = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public void presentarArreglo() {
        System.out.print("Su arreglo es : ");
        for (int i = 0; i < this.arreglo.length; i++) {
            System.out.printf("%d ", this.arreglo[i]);
        }
        input.nextLine();
        input.nextLine();
    }

    public void ordenarArreglo() {
        //Metodo Burbuja
        for (int i = 0; i < this.arreglo.length - 1; i++) {
            for (int j = 0; j < this.arreglo.length - i - 1; j++) {
                if (this.arreglo[j] > this.arreglo[j + 1]) {
                    int temp = this.arreglo[j];
                    this.arreglo[j] = this.arreglo[j + 1];
                    this.arreglo[j + 1] = temp;
                }
            }
        }
    }

    public void insertarArreglo() {
        int pos;
        do {
            System.out.printf("Ingrese una posición valida (1 a %d)\n" + (char) 27 + "[36m----> ", this.arreglo.length);
            pos = this.input.nextInt() - 1;
        } while (pos < 0 || pos > this.arreglo.length);
        //Ocupados - Libres
        if (this.arreglo[this.arreglo.length - 1] == 0) {
            this.libre--;
            this.ocupado++;
        }
        for (int i = this.arreglo.length - 1; i > pos; i--) {
            this.arreglo[i] = arreglo[i - 1];
        }
        System.out.print("Ingrese el nuevo elemento: \n" + (char) 27 + "[36m----> ");
        arreglo[pos] = this.input.nextInt();

    }

    public String busquedaLineal(int num) {
        for (int i = 0; i < this.arreglo.length; i++) {
            if (num == arreglo[i]) {
                return String.format("El numero esta en la posicion %d", i + 1);
            }
        }
        return String.format("El numero no se encuentra en el arreglo");
    }

    public String busquedaBinaria(int num) {
        int fin = this.arreglo.length - 1, ini = 0, medio;
        while (ini <= fin) {
            medio = (fin + ini) / 2;
            if (this.arreglo[medio] == num) {
                return String.format("El numero esta en la posicion %d", medio + 1);
            } else {
                if (num < this.arreglo[medio]) {
                    fin = medio - 1;
                } else {
                }
                ini = medio + 1;
            }
        }
        return String.format("El numero no se encuentra en el arreglo");
    }

    public void eliminarElemento() {
        int pos;
        do {
            System.out.printf("Ingrese una posición valida (1 a %d)\n" + (char) 27 + "[36m----> ", this.arreglo.length);
            pos = this.input.nextInt() - 1;
        } while (pos < 0 || pos > this.arreglo.length);
        //Ocupados - Libres
        if (this.arreglo[pos] != 0) {
            this.libre++;
            this.ocupado--;
        }
        for (int i = pos; i < this.arreglo.length - 1; i++) {
            this.arreglo[i] = arreglo[i + 1];
        }
        this.arreglo[this.arreglo.length - 1] = 0;
    }

    public int getLibre() {
        return libre;
    }

    public int getOcupado() {
        return ocupado;
    }

}
