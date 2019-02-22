/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
class Titulaciones {

    /*
        No hemos encontrado la manera de iterar sobre un enum, por lo que hemos decidido optar por manejarlos así. 
     */
    private static String[] titulos = {"FÍSICA", "MATEMÁTICAS", "TURISMO", "MEDICINA", "FARMACIA", "INGENIERÍA_INFORMÁTICA", "FILOSOFÍA", "BELLAS_ARTES", "PSICOLOGÍA", "HISTORIA"};

    public String mostrarTitulaciones() {
        String resultado = "";

        for (int i = 0; i < titulos.length; i++) {
            resultado += i + 1 +" "+ titulos[i] + "\n";

        }
        return resultado;
    }

    public String obtenerTitulacion(int num) {

        return (String)titulos[num - 1];
    }

}
