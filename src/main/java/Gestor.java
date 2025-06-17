/**
 * Sistema gestor de notas
 *
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
* Listar los alumnos con su nota media
* Salir

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gestor {
    HashMap<String, ArrayList<Float>> notasAlumnos;

    public Gestor() {
        notasAlumnos = new HashMap<>();
    }

    /**
     * Función que construye el menú de la aplicación
     * @return String que contiene el menu de la aplicación a imprimir
     */
    public String menu() {
        String menu = "Escoge una opción:\n" +
                "1- Añadir un alumno\n" +
                "2- Elminar alumno\n" +
                "3- Añadir una nota\n" +
                "4- Modificar una nota\n" +
                "5- Eliminar una nota\n" +
                "6- Consultar notas alumno\n" +
                "7- Consultar medias alumno\n" +
                "8- Salir";
        return menu;
    }

    /**
     * Función que comprueba si existe alumno, y en caso de no
     * existir lo añade en el diccionario
     * @param nombre Nombre del alumno
     * @param notas Lista de notas del alumno
     * @throws IllegalArgumentException El alumno ya existe en el sistema
     */
    public String anadirAlumno(String nombre, ArrayList<Float> notas) {
        if (notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " ya existe");
        }
        notasAlumnos.put(nombre, notas);
        return "Alumno " + nombre + " añadido con éxito";
    }

    /**
     * Función para añadir una nota a un alumno que ya existe
     * @param nombre El nombre del alumno
     * @param nota La nota del alumno
     * @throws IllegalArgumentException Alumno no existente en sistema
     */
    public String anadirNota(String nombre, Float nota) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe");
        }
        notasAlumnos.get(nombre).add(nota);
        return "Nota " + nota + " añadida al alumno " + nombre + " con éxito";
    }

    /**
     * Función para mostrar las notas de un alumno
     * @param nombre Nombre del alumno
     * @return Mensaje de éxito
     * @throws IllegalArgumentException Alumno no existente en sistema
     */
    public String mostrarNotas(String nombre) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe");
        }
        String resultado = "Notas del alumno " + nombre + ": ";
        for (int i = 0; i < notasAlumnos.get(nombre).size(); i++) {
            resultado += notasAlumnos.get(nombre).get(i) + " ";
        }
        resultado = resultado.stripTrailing();
        return resultado;
    }

    /**
     * Función para eliminar alumno del sistema
     * @param nombre Nombre del alumno
     * @return Mensaje de éxito
     * @throws IllegalArgumentException Alumno no existente en sistema
     */
    public String eliminarAlumno(String nombre) {
        if (notasAlumnos.remove(nombre) == null) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe en el sistema");
        }
        return "Alumno " + nombre + " eliminado correctamente";
    }

    /**
     * Función para eliminar una nota de un alumno
     * @param nombre Nombre del alumno
     * @param posicion Posición de la nota a eliminar
     * @return nota eliminada
     * @throws IllegalArgumentException Alumno no existente en sistema
     * @throws ArrayIndexOutOfBoundsException Nota no existente en la lista del alumno
     */
    public float eliminarNotaAlumno(String nombre, int posicion) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe en el sistema");
        } else if (notasAlumnos.get(nombre).size() <= posicion) {
            throw new ArrayIndexOutOfBoundsException("No existe la posicion " + posicion + " en la lista de notas");
        }
        return notasAlumnos.get(nombre).remove(posicion);
    }

    /**
     * Función para modificar una nota de un alumno
     * @param nombre Nombre del alumno
     * @param posicion Posición de la nota a eliminar
     * @param nuevaNota Nota a substituir por un valor anterior
     * @return valor nota antes de modificación
     * @throws IllegalArgumentException Alumno no existente en sistema
     * @throws ArrayIndexOutOfBoundsException Nota no existente en la lista del alumno
     */
    public float modificarNotaAlumno(String nombre, int posicion, float nuevaNota) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " no existe en el sistema");
        } else if (notasAlumnos.get(nombre).size() <= posicion) {
            throw new ArrayIndexOutOfBoundsException("No existe la posicion " + posicion + " en la lista de notas");
        }
        return notasAlumnos.get(nombre).set(posicion, nuevaNota);
    }

    /**
     * Función que calcula la media de cada alumno
     * @return Diccionario con la media de las notas de cada alumno
     */
    public HashMap<String, Float> consultarMediasPorAlumno() {
        HashMap<String, Float> mediaNotas = new HashMap<>();
        for (String alumno : notasAlumnos.keySet()) {
            ArrayList<Float> notas = notasAlumnos.get(alumno);
            float total = 0;
            for (float nota : notas) {
                total += nota;
            }
            mediaNotas.put(alumno, total / notas.size());
        }
        return mediaNotas;
    }
}
