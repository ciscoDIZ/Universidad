/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Estudiante.Expediente;
import Clases.Persona.DNI;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class Universidad {

    HashSet<Departamento> departamentos;
    HashSet<Estudiante> estudiantes;
    HashSet<Trabajador> trabajadores;
    String nombre;
    String ciudad;

    public Universidad(String nombres, String ciudad) {
        this.departamentos = new HashSet<>();
        this.estudiantes = new HashSet<>();
        this.trabajadores = new HashSet<>();
        this.nombre = nombres;
        this.ciudad = ciudad;
    }

    public void agregarTrabajador(Trabajador t) {
        this.trabajadores.add(t);
    }

    public void agregarEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }

    public void agregarDepartamento(Departamento d) {
        this.departamentos.add(d);
    }

    public boolean borrarTrabajador(String dni) {
        boolean ret=false;
        for (Iterator<Trabajador> it = trabajadores.iterator(); it.hasNext();) {
            Trabajador t = (Trabajador) it.next();
            if (t.dni.getDniNum().equals(dni)) {
                it.remove();
                ret=true;
            }
        }
        return ret;
    }

    public boolean borrarEstudiante(String dni) {
        boolean ret=false;
        for (Iterator<Estudiante> iterator = estudiantes.iterator(); iterator.hasNext();) {
            Estudiante next = iterator.next();
            if (next.dni.getDniNum().equals(dni)) {
                iterator.remove();
                ret=true;
            }
        }
        return ret;
    }
    

    public boolean borrarDepartamento(String nombre) {
        boolean ret=false;
        for (Iterator<Departamento> iterator = departamentos.iterator(); iterator.hasNext();) {
            Departamento next = iterator.next();
            if (next.getNombre().equals(nombre)) {
                iterator.remove();
                ret=true;
            }
        }
        return ret;
    }

    public Estudiante crearEstudianteGrado(String nombre, String apellidos, String dni,
            String t, String exp) {
        return new EstudianteGrado(nombre, apellidos, dni, t, exp, this);
    }

    public Trabajador crearTrabajador(String nombre, String apellidos, String dni) {
        return new Trabajador(nombre, apellidos, dni, this);
    }

    public Departamento crearDepartamento(String nombre) {
        return new Departamento(nombre);
    }

    public HashSet<Departamento> getDepartamentos() {
        return departamentos;
    }

    public HashSet<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public HashSet<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    class Departamento {

        String nombre;
        HashSet<String> titulacionesDisponibles;

        public Departamento(String nombre) {
            this.nombre = nombre;
            this.titulacionesDisponibles = new HashSet<>();
        }

        public void addTitulo(String titulo) {
            this.titulacionesDisponibles.add(titulo);
        }

        /**
         *
         * @param titulo
         * @return true si se ha realizado con exito , false de lo contrario .
         * controlar en el main
         */
        public boolean quitarTitulo(String titulo) {
            boolean res = false;

//            Titulaciones borrar = titulacionesDisponibles.stream()
//                    .filter(p -> p.toString().equals(titulo))
//                    .findFirst()
//                    .orElse(null);
//            if (borrar != null) {
//                res = true;
//                for (Iterator it = titulacionesDisponibles.iterator(); it.hasNext();) {
//                    Titulaciones t = (Titulaciones) it.next();
//                    if (t == borrar) {
//                        it.remove();
//                    }
//                }
//            }
            for (Iterator<String> iterator = titulacionesDisponibles.iterator(); iterator.hasNext();) {
                String next = iterator.next();
                if (next.equals(titulo)) {
                    iterator.remove();
                    res = true;
                }

            }
            return res;
        }

        public String mostrarTitulaciones() {
            String resultado = "";
            for (String titulacionesDisponible : titulacionesDisponibles) {
                resultado += titulacionesDisponible + "\n";
            }
            return resultado;
        }

        public String getNombre() {
            return nombre;
        }

        public HashSet<String> getTitulacionesDisponibles() {
            return titulacionesDisponibles;
        }

    }

}
