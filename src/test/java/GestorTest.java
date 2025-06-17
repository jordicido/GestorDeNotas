import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GestorTest {
    static Gestor miGestor;

    @BeforeEach
    public void configuracion() {
        miGestor = new Gestor();
        String nombre = "Jordi";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(10f);
        notas.add(10f);
        notas.add(10f);
        miGestor.anadirAlumno(nombre, notas);
    }

    @Test
    public void imprimirMenu() {
        String menu = "Escoge una opción:\n" +
                "1- Añadir un alumno\n" +
                "2- Elminar alumno\n" +
                "3- Añadir una nota\n" +
                "4- Modificar una nota\n" +
                "5- Eliminar una nota\n" +
                "6- Consultar notas alumno\n" +
                "7- Consultar medias alumno\n" +
                "8- Salir";
        assertEquals(menu, miGestor.menu());
    }

    @Test
    public void anadirAlumnoCorrectamente() {
        String resultado = "Alumno Kenneth añadido con éxito";
        String nombre = "Kenneth";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(8f);
        notas.add(7f);
        notas.add(6f);
        assertEquals(resultado, miGestor.anadirAlumno(nombre, notas));
    }

    @Test
    public void anadirNotaCorrectamente() {
        String nombre = "Jordi";
        miGestor.anadirNota(nombre, 10f);
        assertTrue(miGestor.notasAlumnos.get(nombre).size() == 4);
    }

    @Test
    public void mostrarNotasAlumno() {
        String resultado = "Notas del alumno Jordi: 10.0 10.0 10.0";
        assertEquals(resultado, miGestor.mostrarNotas("Jordi"));
    }

    @Test
    public void mostrarNotasAlumnoNoExistente() {
        assertThrows(IllegalArgumentException.class, () -> miGestor.mostrarNotas("Victor"));
    }

    @Test
    public void eliminarAlumnoCorrectamente() {
        String resultado = "Alumno Jordi eliminado correctamente";
        assertEquals(resultado, miGestor.eliminarAlumno("Jordi"));
    }

    @Test
    public void eliminarNotaAlumnoExistente() {
        float resultado = 10f;
        assertEquals(resultado, miGestor.eliminarNotaAlumno("Jordi", 0));
    }

    @Test
    public void eliminarNotaNoExistenteDeAlumno() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            miGestor.eliminarNotaAlumno("Jordi", 4);
        });
    }

    @Test
    public void comprobarMediasPorAlumno() {
        HashMap<String, Float> resultado = new HashMap<>();
        resultado.put("Jordi", 10f);
        assertEquals(resultado, miGestor.consultarMediasPorAlumno());
    }

    @AfterEach
    public void cerrarConfiguraciones() {
        miGestor.notasAlumnos.clear();
    }


}