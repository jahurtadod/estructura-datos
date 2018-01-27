/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase10;

import java.util.ArrayList;

/**
 *
 * @author jahur
 */
public class Estudiante {
    //Atributos
    private String nombres, apellidos;
    private ArrayList<Nota> lista_notas;
    //Constructor
    public Estudiante(String nombres, String apellidos, ArrayList<Nota> lista_notas) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.lista_notas = lista_notas;
    }

    //Getters and Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getLista_notas() {
        // Creamos una cadena que mostra las dos notas
        String resultado = "";
        for (Nota nota : this.lista_notas) {
            resultado += nota.toString();
        }
        return resultado;
    }

    public void setLista_notas(ArrayList<Nota> lista_notas) {
        this.lista_notas = lista_notas;
    }
    
    public double getProm() {
        double resultado = 0;
        // Calculamos el promedio de las dos notas
        for (Nota nota : this.lista_notas) {
            resultado += nota.getCalificacion();
        }
        return (resultado / 2);
    }
    
    /* Cramos un metodo que nos permite mostrar una tabla cuadrada
    public String formato(String cadena) { 
        if (cadena.length() == 10) {
            return cadena; 
        } else {
            // Se recorta el nombre si es muy largo
            if (cadena.length() > 10) {
                String temp = "";
                for (int i = 0; i < 10; i++) {
                    temp += cadena.charAt(i);
                }
                temp += ".";
                return temp;
            }
        }
        // Se agranda el nombre si es muy pequeño
        for (int i = cadena.length(); i <= 10; i++) {
            cadena += " ";
        }
        return cadena;
    }
    */

    @Override
    public String toString() {
        return String.format("%s %s %s%.2f \n",
                this.getNombres(), this.getApellidos(), this.getLista_notas(), this.getProm());
    }

}
