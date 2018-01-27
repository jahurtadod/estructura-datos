/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jahurtadod
 */
public class Ejecutora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Se crea las variables
        String nombres, apellidos;
        int nota1, nota2;
        ArrayList<Estudiante> listEstudiante = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese los Nombres del Estudiante : ");
            nombres = input.nextLine();
            System.out.println("Ingrese los Apellidos del Estudiante : ");
            apellidos = input.nextLine();
            System.out.println("Ingrese su Nota de Matemáticas : ");
            nota1 = Integer.parseInt(input.nextLine());
            System.out.println("Ingrese su Nota de Ingles : ");
            nota2 = Integer.parseInt(input.nextLine());
            ArrayList<Nota> listNotas = new ArrayList<>();
            // Creamos el listado de notas
            listNotas.add(new Nota("Matemáticas", nota1));
            listNotas.add(new Nota("Ingles", nota2));
            // Creamos el listado de Estudiantes
            listEstudiante.add(new Estudiante(nombres, apellidos, listNotas));
        }
        // Se muestra los resultados
        System.out.println("\nLISTADO DE ESTUDIANTES : \n");
        System.out.println(" Nombres Apellidos Nota1 Nota2 Promedio ");
        for (Estudiante estudiante: listEstudiante) {
            System.out.println(estudiante);
        }
        
        CrearArchivoTexto arch = new CrearArchivoTexto();
        arch.abrirArchivo();
        arch.agregarRegistros(listEstudiante);
        arch.cerrarArchivo();
                
        
    }

}
