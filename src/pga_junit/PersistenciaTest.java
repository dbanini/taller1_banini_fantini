package pga_junit;

import org.junit.Test;

import pga_modelo.Alumno;
import pga_modelo.Asignatura;
import pga_modelo.Cursada;
import pga_modelo.Entidades;
import pga_modelo.Profesor;
import pga_xml.SerializadorXML;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PersistenciaTest {
	private Entidades entidades;
	
	@Before
    public void setupEscenario() {
		entidades = new Entidades();
		
        // Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        entidades.addAsignatura(matematica);
        
        // Agregar alumnos y profesores (Que los necesita cursadas)
        Alumno alumnoMartin = new Alumno("ALU1234", "Martin", "Mitre 1234", "martin@mitre");
        alumnoMartin.getAprobadas().add(matematica);
        Profesor profesorPedro = new Profesor("PRO4567", "Pedro", "Jujuy 4567", "45678901", "pedro@jujuy");
        profesorPedro.getHabilitadas().add(matematica);
        entidades.addAlumno(alumnoMartin);
        entidades.addProfesor(profesorPedro);
        
        // Agregar cursadas.
        Cursada cursadaMatematica  = new Cursada("CUR1234", matematica,  "01-2017", "Lun", "12:00", "14:00");
        cursadaMatematica.getProfesores().add(profesorPedro);
        cursadaMatematica.getAlumnos().add(alumnoMartin);
        entidades.addCursada(cursadaMatematica);
    }
	
	@Test
    public void testGuardaCarga() {
		final String TEST_PATH = "persistencia.xml";
		try {
			SerializadorXML.escribe(entidades, TEST_PATH);
		} catch (Exception e) {
			fail();
		}
		
		try {
			entidades = (Entidades) SerializadorXML.lee(TEST_PATH);
		} catch (Exception e) {
			fail();
		}
		
		assertTrue("No esta la misma cantidad de asignaturas.", entidades.getAsignaturas().size() == 1);
		
		// TODO: Mas asertos.
	}
}
