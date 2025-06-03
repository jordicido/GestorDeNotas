/**
 * Sistema gestor de notas
 * @author Jordi Cido
 * @version 1.0.0
 */

/*
Sistema gestor de notas:
Tenemos un diccionario de (String[nombre alumno],Arraylist(double)[notas curso]).
Nuestro producto ha de permitir hacer lo siguiente:
* Añadir una nota a un alumno
* Añadir un alumno al diccionario
* Modificar una nota de un alumno
* Eliminar una nota de un alumno
* Eliminar un alumno del diccionario
* Listar las notas de un alumno
* Listar los alumnos con su nota
* Salir

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gestor {
    static HashMap<String, ArrayList<Float>> notasAlumnos = new HashMap<>();

    /**
     * Función principal del programa
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 4) {
            System.out.println(menu());
            opcion = scanner.nextInt();
            scanner.nextLine();
            String nombre = "";
            switch (opcion) {
                case 1:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    System.out.println("Inserta las notas del alumno separadas por espacio:");
                    ArrayList<Float> notas = new ArrayList<>();
                    String[] notasInput = scanner.nextLine().split(" ");
                    for (int i = 0; i < notasInput.length; i++) {
                        notas.add(Float.parseFloat(notasInput[i]));
                    }
                    try {
                        anadirAlumno(nombre, notas);
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    System.out.println("Inserta la nota del alumno:");
                    float nota = scanner.nextFloat();
                    scanner.nextLine();
                    try {
                        anadirNota(nombre, nota);
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    try {
                        mostrarNotas(nombre);
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
            }
        }

    }

    /**
     * Función que construye el menú de la aplicación
     * @return menu - String que contiene el menu de la aplicación a imprimir
     */
    public static String menu() {
        String menu = "Escoge una opción:\n " +
                "1- Añadir un alumno\n " +
                "2- Añadir una nota\n " +
                "3- Consultar notas alumno\n " +
                "4- Salir";
        return menu;
    }

    /**
     * Función que comprueba si existe alumno, y en caso de no
     * existir lo añade en el diccionario
     * @param nombre - Nombre del alumno
     * @param notas - Lista de notas del alumno
     * @throws IllegalArgumentException - El alumno ya existe en el sistema
     */
    public static void anadirAlumno(String nombre, ArrayList<Float> notas) {
        if (notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " ya existe");
        }
        notasAlumnos.put(nombre, notas);
        System.out.printf("Alumno %s añadido con éxito\n", nombre);
    }

    /**
     * Función para añadir una nota a un alumno que ya existe
     * @param nombre - El nombre del alumno
     * @param nota - La nota del alumno
     * @throws IllegalArgumentException - Alumno no existente en sistema
     */
    public static void anadirNota(String nombre, Float nota) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe");
        }
        notasAlumnos.get(nombre).add(nota);
        System.out.printf("Nota %.2f añadida al alumno %s con éxito\n", nota, nombre);
    }

    /**
     * Función para mostrar las notas de un alumno
     * @param nombre - Nombre del alumno
     * @throws IllegalArgumentException - Alumno no existente en sistema
     */
    public static void mostrarNotas(String nombre) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe");
        }
        System.out.print("Notas del alumno " + nombre + ": ");
        for (int i = 0; i < notasAlumnos.get(nombre).size(); i++) {
            System.out.print(notasAlumnos.get(nombre).get(i) + " ");
        }
        System.out.println();
    }
}
