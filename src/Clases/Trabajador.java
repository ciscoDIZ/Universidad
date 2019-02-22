/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.time.LocalDateTime;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class Trabajador extends Persona{
    protected final LocalDateTime FECHA_INICIO_TRABAJO;
    Universidad uni;

    public Trabajador(String nombre, String apellidos, String dni,Universidad universidad) {
        super(nombre, apellidos, dni);
        FECHA_INICIO_TRABAJO=LocalDateTime.now();
        this.uni=universidad;
        this.uni.agregarTrabajador(this);
    }

    @Override
    public String toString() {
        return super.nombre+" "+super.apellidos+","+super.dni+","+uni.nombre+", Fecha inicio: "+FECHA_INICIO_TRABAJO;
    }
    
    
}
