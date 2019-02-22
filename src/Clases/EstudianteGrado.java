/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class EstudianteGrado extends Estudiante {

    String titulo;
    Universidad uni;

    public EstudianteGrado(String nombre, String apellidos, String dni, String titulo, String expediente, Universidad uni) {
        super(nombre, apellidos, dni, expediente);
        this.uni = uni;
        this.uni.agregarEstudiante(this);
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return super.nombre+" "+super.apellidos+", "+super.dni+", Expediente: "+expediente.numeroExpediente+", Título: "+titulo;
    }
    
}
