import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /**
     * Función principal del programa
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Gestor miGestor = new Gestor();
        while (opcion != 8) {
            System.out.println(miGestor.menu());
            opcion = scanner.nextInt();
            scanner.nextLine();
            String nombre = "";
            float nota = 0f;
            int posicion = 0;
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
                        System.out.println(miGestor.anadirAlumno(nombre, notas));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    try {
                        System.out.println(miGestor.eliminarAlumno(nombre));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    System.out.println("Inserta la nota del alumno:");
                    nota = scanner.nextFloat();
                    scanner.nextLine();
                    try {
                        System.out.println(miGestor.anadirNota(nombre, nota));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    System.out.println("Inserta posición de la nota a modificar:");
                    posicion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserta la nota del alumno:");
                    nota = scanner.nextFloat();
                    try {
                        System.out.println("Se ha modificado la nota " + miGestor.modificarNotaAlumno(nombre, posicion, nota) + " por la nota " + nota);
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    System.out.println("Inserta posición de la nota a eliminar:");
                    posicion = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        System.out.println("Se ha eliminado la nota " + miGestor.eliminarNotaAlumno(nombre, posicion));
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = scanner.nextLine();
                    try {
                        System.out.println(miGestor.mostrarNotas(nombre));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 7:
                    HashMap<String, Float> mediaNotas = miGestor.consultarMediasPorAlumno();
                    for (String alumno : mediaNotas.keySet()) {
                        System.out.println("Alumno: " + alumno + " Media: " + mediaNotas.get(alumno));
                    }
                    break;
            }
        }

    }
}
