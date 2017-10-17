/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

import java.util.Scanner;

/**
 *
 * @author jahur
 */
public class Algoritmos {

    private int lim;
    private int A[];
    public static Scanner input = new Scanner(System.in);

    public Algoritmos() {

    }

    public void pedirTamaño() {
        System.out.print("Ingrese el tamaño del arreglo: ");
        this.lim = input.nextInt();
    }

    public void pedirDatos() {
        this.A = new int[this.lim];
        for (int i = 0; i < this.lim; i++) {
            System.out.print("Ingrese el valor de la " + (i + 1) + " posición: ");
            this.A[i] = input.nextInt();
        }
    }

    public void presentarArreglo() {
        System.out.print("\nSu arreglo es : ");
        for (int i = 0; i < this.lim; i++) {
            System.out.print(this.A[i] + " ");
        }
    }

    public void buscarNumero() {
        boolean bandera = false;
        int posicion = 0;

        System.out.print("\nIngrese el valor a buscar : ");
        int num = input.nextInt();
        for (int i = 0; i < this.lim; i++) {
            if (num == this.A[i]) {
                bandera = true;
                posicion = i;
            }
        }
        if (bandera) {
            System.out.printf("Su valor se encuentra en la posición: %d\n", posicion + 1);
        } else {
            System.out.printf("El numero no esta en el arreglo\n");
        }
    }

    public void bubbleSort() {
        boolean seguir;
        int n = this.lim - 1;
        int aux;
        do {
            seguir = false;
            for (int i = 0; i < n; i++) {
                if (this.A[i] > this.A[i + 1]) {
                    aux = this.A[i];
                    this.A[i] = this.A[i + 1];
                    this.A[i + 1] = aux;
                    seguir = true;
                }
            }
            n--;
        } while (seguir);
        System.out.print("\nOrdenando....: ");
        presentarArreglo();
    }

    public void eliminarDato() {
        System.out.println("\nIngrese la posición a eliminar: ");
        int num = input.nextInt() - 1 ;
        if (num < this.lim) {
            for (int i = num; i < this.lim - 1; i++) {
                this.A[i] = this.A[i + 1];
            }
            this.lim--;
        } else {
            System.out.println("El valor ingresado no se encuentra: ");
        }
    }

public void modificarDato() {
        System.out.println("Ingrese la posicion que quiere modificar: ");
        int i = input.nextInt() - 1;
        if (i < lim) {
            System.out.println("Ingrese el nuevo numero: ");
            int num = input.nextInt();
            this.A[i] = num;
            presentarArreglo();
        } else {
            System.out.println("La posicion ingresada no corresponde a ninguna del arreglo");
        }
    }

    public void insertarDato() {
        System.out.println("\nIngrese el numero a insertar en el arreglo: ");
        int num = input.nextInt();
        this.lim = this.lim + 1;
        int[] aux = new int[this.lim];
        aux[this.lim - 1] = num;
        for (int i = 0; i < this.lim - 1; i++) {
            aux[i] = this.A[i];
        }
        this.A = new int[lim];
        for (int i = 0; i < lim; i++) {
            this.A[i] = aux[i];
        }
        presentarArreglo();
    }

}
