/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Universidad;
import Clases.Universidad.Departamento;
import java.util.Scanner;

/**
 *
 * @author Manuel Alejandro Perez Benitez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Titulaciones t = new Titulaciones();
        String nombre;
        int num;
        Scanner sc = new Scanner(System.in);
        Scanner cd = new Scanner(System.in);
        int opt = 0, opt2 = 0;

        Universidad ull = new Universidad("Universidad de La Laguna", "San Cristóbal de La Laguna");
        do {
            System.out.println("\n1) Administrar departamentos\n"
                    + "2) Administrar trabajadores\n"
                    + "3) Administrar estudiantes\n"
                    + "4) Salir");
            opt = cd.nextInt();
            switch (opt) {

                case 1:
                    do {
                        System.out.println("\n1) Agregar departamento\n"
                                + "2) Mostrar departamentos\n"
                                + "3) Ver titulaciones en departamento\n"
                                + "4) Borrar departamento\n"
                                + "5) Agregar titulación\n"
                                + "6) Mostrar titulaciones\n"
                                + "7) Borrar titulación\n"
                                + "8) Salir");
                        opt2 = cd.nextInt();
                        switch (opt2) {
                            case 1:
                                System.out.println("Introduzca el nombre del departamento a añadir");

                                nombre = sc.nextLine();
                                try {
                                    ull.agregarDepartamento(ull.crearDepartamento(nombre));
                                } catch (Exception ex) {
                                    System.out.println("No se ha podido crear el departamento");
                                }
                                System.out.println("Departamento " + nombre + " creado correctamente");
                                break;

                            case 2:
                                System.out.println("\n-- Departamentos --");
                                ull.getDepartamentos().stream()
                                        .map(p -> p.nombre)
                                        .forEach(System.out::println);

                                break;

                            case 3:
                                System.out.println("Introduce el nombre del departamento a buscar");
                                nombre = sc.nextLine();
//                                ull.getDepartamentos().stream()
//                                        .filter(p -> p.getNombre().equals(nombre))
//                                        .map(p -> p.mostrarTitulaciones())
//                                        .forEach(System.out::println);
//                                ;

                                for (Departamento dep : ull.getDepartamentos()) {

                                    if (dep.getNombre().equals(nombre)) {
                                        System.out.println("Departamento " + dep.getNombre() + "\n Titulaciones disponibles:");
                                        for (String titulo : dep.titulacionesDisponibles) {
                                            System.out.println(titulo);
                                        }
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Introduce el nombre del departamento a borrar");

                                nombre = sc.nextLine();
                                System.out.println(ull.borrarDepartamento(nombre) ? "Departamento " + nombre + " borrado" : "No se ha encontrado el departamento");

                                break;

                            case 5:
                                System.out.println("Escribe el nombre del departamento");

                                nombre = sc.nextLine();
                                for (Departamento dep : ull.getDepartamentos()) {
                                    if (dep.getNombre().equals(nombre)) {
                                        System.out.println("Titulaciones disponibles");
                                        System.out.println(t.mostrarTitulaciones());
                                        System.out.println("Elige que titulación quieres agregar");
                                        num = sc.nextInt();
                                        dep.addTitulo(t.obtenerTitulacion(num));
                                        System.out.println("Titulación " + t.obtenerTitulacion(num) + " agregada a " + dep.getNombre());
                                    }
                                }

                                break;

                            case 6:
                                System.out.println("-- TITULACIONES --");
                                System.out.println(t.mostrarTitulaciones());
                                break;

                            case 7:
                                System.out.println("Escribe el nombre del departamento");
                                nombre = sc.nextLine();
                                for (Departamento dep : ull.getDepartamentos()) {
                                    if (dep.getNombre().equals(nombre)) {
                                        for (String titulo : dep.titulacionesDisponibles) {
                                            System.out.println(titulo);
                                        }
                                        System.out.println("Elige que titulación quieres borrar");

                                        nombre = sc.nextLine();
                                        if (dep.quitarTitulo(nombre)) {
                                            System.out.println("Titulación " + nombre + " eliminada correctamente");
                                        } else {
                                            System.out.println("No se encuentra la titulación");
                                        }
                                    }
                                }
                                break;

                            default:
                                System.out.println("Introduce una opción correcta");
                                break;
                        }

                    } while (opt2 != 8);
                    break;

                case 2:
                    do {
                        System.out.println("\n1) Agregar trabajador\n"
                                + "2) Mostrar trabajadores\n"
                                + "3) Buscar trabajador\n"
                                + "4) Borrar trabajador\n"
                                + "5) Salir");
                        opt2 = cd.nextInt();
                        switch (opt2) {
                            case 1:
                                System.out.println("Introduce nombre");
                                nombre = sc.nextLine();
                                System.out.println("Introduce apellidos");
                                String apellidos = sc.nextLine();
                                System.out.println("Introduce DNI");
                                String dni = sc.nextLine();
                                try {
                                    ull.agregarTrabajador(ull.crearTrabajador(nombre, apellidos, dni));
                                    System.out.println("Trabajador agregado");
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                                break;

                            case 2:
                                System.out.println("-- TRABAJADORES --");
                                ull.getTrabajadores().stream()
                                        .map(p -> p.toString())
                                        .forEach(System.out::println);
                                break;

                            case 3:
                                System.out.println("Introduce el DNI del trabajador");
                                dni = sc.nextLine();

                                for (Trabajador tra : ull.getTrabajadores()) {

                                    if (tra.getDni().getDniNum().equals(dni)) {
                                        System.out.println(tra.toString());

                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Introduce el DNI del trabajador a borrar");

                                dni = sc.nextLine();
                                System.out.println(ull.borrarTrabajador(dni) ? "Trabajador con DNI " + dni + " borrado" : "No se ha encontrado el trabajador");

                                break;

                            case 5:
                                break;
                            default:
                                System.out.println("Introduce una opción correcta");
                                break;
                        }

                    } while (opt2 != 5);
                    break;

                case 3:
                    do {
                        System.out.println("\n1) Agregar estudiante\n"
                                + "2) Mostrar estudiantes\n"
                                + "3) Buscar estudiante\n"
                                + "4) Borrar estudiante\n"
                                + "5) Salir");
                        opt2 = cd.nextInt();
                        switch (opt2) {
                            case 1:
                                System.out.println("Introduce nombre");
                                nombre = sc.nextLine();
                                System.out.println("Introduce apellidos");
                                String apellidos = sc.nextLine();
                                System.out.println("Introduce DNI");
                                String dni = sc.nextLine();
                                System.out.println("Introduce num expediente");
                                String expediente = sc.nextLine();
                                System.out.println("-- TITULACIONES --");
                                System.out.println(t.mostrarTitulaciones());
                                System.out.println("Elige una titulación");
                                num = sc.nextInt();

                                try {
                                    ull.agregarEstudiante(ull.crearEstudianteGrado(nombre, apellidos, dni, t.obtenerTitulacion(num), expediente));
                                    System.out.println("Trabajador agregado");
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                                break;

                            case 2:
                                System.out.println("-- ESTUDIANTES --");
                                ull.getEstudiantes().stream()
                                        .map(p -> p.toString())
                                        .forEach(System.out::println);
                                break;

                            case 3:
                                System.out.println("Introduce el DNI del estudiante");
                                dni = sc.nextLine();

                                for (Estudiante est : ull.getEstudiantes()) {

                                    if (est.getDni().getDniNum().equals(dni)) {
                                        System.out.println(est.toString());

                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Introduce el nombre del estudiante a borrar");
                                dni = sc.nextLine();
                                System.out.println(ull.borrarEstudiante(dni) ? "Estudiante con DNI " + dni + " borrado" : "No se ha encontrado el estudiante");
                                break;

                            case 5:
                                break;
                            default:
                                System.out.println("Introduce una opción correcta");
                                break;
                        }

                    } while (opt2 != 5);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Introduce una opción correcta");
                    break;
            }

        } while (opt != 4);

    }
}
