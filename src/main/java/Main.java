import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Función principal del programa
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Gestor miGestor = new Gestor();
        while (opcion != 5) {
            System.out.println(miGestor.menu());
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
                    float nota = scanner.nextFloat();
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
                    try {
                        System.out.println(miGestor.mostrarNotas(nombre));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
            }
        }

    }
}
