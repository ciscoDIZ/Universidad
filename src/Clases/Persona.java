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
public abstract class Persona {

    protected String nombre;
    protected DNI dni;
    protected String apellidos;

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.dni = new DNI(dni);
        this.apellidos = apellidos;
    }

    public DNI getDni() {
        return dni;
    }

    class DNI {

        protected static final String LETRAS_POSIBLRES = "TRWAGMYFPDXBNJZSQVHLCKE";
        private final String dniNum;

        public DNI(String dniNum) {
            this.dniNum = dniNum;
            int num = Integer.parseInt(dniNum.substring(0, 8));
            char letra = dniNum.charAt(dniNum.length() - 1);
            if (!(calcularLetra(num) == (letra))) {
                throw new IllegalArgumentException("Letra del DNI incorrecta");

//            if (!validarDni(dniNum.substring(0, 8))
//                    .equals(dniNum.toUpperCase().charAt(8))) {
//                
//            }
            }
        }

        @Override
        public String toString() {
            return "DNI: " + dniNum;
        }

        private char calcularLetra(int num) {
            return LETRAS_POSIBLRES.charAt(num % 23);
        }

        public String getDniNum() {
            return dniNum;
        }

    }

}
