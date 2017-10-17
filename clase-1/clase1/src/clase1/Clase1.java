/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

import javax.swing.JOptionPane;

/**
 *
 * @author jahur
 */
public class Clase1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Algoritmos algoritmo = new Algoritmos();

        
        algoritmo.pedirTamaño();
        algoritmo.pedirDatos();
        algoritmo.presentarArreglo();
        algoritmo.buscarNumero();
        algoritmo.modificarDato();
        algoritmo.insertarDato();
        algoritmo.eliminarDato();
        algoritmo.bubbleSort();
    }
    
}
