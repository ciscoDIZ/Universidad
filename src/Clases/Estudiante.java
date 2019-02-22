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
public abstract class Estudiante extends Persona {

    Expediente expediente;

    public Estudiante(String nombre, String apellidos, String dni, String expediente) {
        super(nombre, apellidos, dni);
        this.expediente = new Expediente(nombre, expediente);
    }

    class Expediente {

        String nombreAlumno;
        String numeroExpediente;

        public Expediente(String nombreAlumno, String numeroExpediente) {
            if (!validarNumeroExpediente(numeroExpediente)) {
                throw new IllegalArgumentException("El numero de expediente no es valido");
            }

            this.nombreAlumno = nombreAlumno;
            this.numeroExpediente = numeroExpediente;
        }

        private boolean validarNumeroExpediente(String num) {
            return num.matches("([A-Z][0-9]{3}-[0-9]{3})");
        }

    }
}
