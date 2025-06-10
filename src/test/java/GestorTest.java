import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorTest {
    static Gestor miGestor;

    @BeforeEach
    public void configuracionTest() {
        miGestor = new Gestor();
        String nombre = "Jordi";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(10f);
        notas.add(10f);
        notas.add(10f);
        miGestor.anadirAlumno(nombre, notas);
    }

    @Test
    public void menuTest() {
        String menu = "Escoge una opción:\n " +
                "1- Añadir un alumno\n " +
                "2- Elminar alumno\n" +
                "3- Añadir una nota\n " +
                "4- Consultar notas alumno\n " +
                "5- Salir";
        assertEquals(menu, miGestor.menu());
    }

    @Test
    public void anadirAlumnoCorrectamenteTest() {
        String resultado = "Alumno Kenneth añadido con éxito";
        String nombre = "Kenneth";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(8f);
        notas.add(7f);
        notas.add(6f);
        assertEquals(resultado, miGestor.anadirAlumno(nombre, notas));
    }

    @Test
    public void anadirNotaCorrectamenteTest() {
        String nombre = "Jordi";
        miGestor.anadirNota(nombre, 10f);
        assertTrue(miGestor.notasAlumnos.get(nombre).size() == 4);
    }

    @Test
    public void mostrarNotasAlumnoTest() {
        String resultado = "Notas del alumno Jordi: 10.0 10.0 10.0";
        assertEquals(resultado, miGestor.mostrarNotas("Jordi"));
    }

    @Test
    public void eliminarAlumnoCorrectamenteTest() {
        String resultado = "Alumno Jordi eliminado correctamente";
        assertEquals(resultado, miGestor.eliminarAlumno("Jordi"));
    }

    @AfterEach
    public void cerrarConfiguracionesTest() {
        miGestor.notasAlumnos.clear();
    }


}