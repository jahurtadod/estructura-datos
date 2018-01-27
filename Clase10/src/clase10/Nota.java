/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase10;

/**
 *
 * @author jahur
 */
public class Nota {
    // Atributos
    private String asignatura;
    private int calificacion;
    // Constructor
    public Nota(String asignatura, int calificacion) {
        this.asignatura = asignatura;
        this.calificacion = calificacion;
    }
    
    //Getters and Setters
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    @Override
    public String toString() {
        return String.format("%d(%s) ", 
                this.getCalificacion(), this.getAsignatura());
    }
}
