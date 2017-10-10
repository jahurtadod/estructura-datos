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
public class Arreglo {

    private int lim;
    private int A[]; 
    public static Scanner input = new Scanner(System.in);
    
    public Arreglo() {
        
    }
    
    public void pedirTamaño () {
        System.out.print("Ingrese el tamaño del arreglo: ");
        this.lim = input.nextInt();
    }
    
    public void pedirDatos () {
        A = new int[this.lim];
        for (int i = 0 ; i < this.lim ; i++) {
            System.out.print("Ingrese el valor de la "+(i+1)+" posición: ");
            A[i] = input.nextInt();
        }
    }
    
    public void presentarArreglo () {
        System.out.print("Su arreglo es : ");
        for (int i = 0 ; i < this.lim ; i++) {
            System.out.print(A[i]+" ");
        }
    }
    
    public void buscarNumero () {
        System.out.print("\nIngrese el valor a buscar : ");
        int num = input.nextInt();
        for (int i = 0 ; i < this.lim ; i++) {
            if (num == A[i]){
                System.out.print("Su valor se encuentra en la posición: "+(i+1));
            }
        }
    }
}
