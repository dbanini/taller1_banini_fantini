package pga_junit;

import java.util.ArrayList;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pga_controlador.Controlador;
import pga_controlador.ControladorListenerConfirmador;

import pga_modelo.Entidades;
import pga_modelo.Alumno;
import pga_modelo.Profesor;
import pga_modelo.Asignatura;
import pga_modelo.Cursada;

public class CoberturaTest {
    private Entidades entidades;
    private Controlador controlador;
    
    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    
    @Before
    public void setupEscenario() {
        entidades = new Entidades();
        controlador = new Controlador(entidades);
    }
    
    /***********
     * ALUMNOS *
     ***********/
    
    @Test (expected = IllegalArgumentException.class)
    public void testAAL1() {
    	controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	controlador.altaAlumno("ALU0001", "Jose", "Alvear 123", "jose@alvear", new ArrayList<Asignatura>());
    }
    
    @Test
    public void testAAL2() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	assertNotNull("No se dio de alta al alumno.", alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMAL1() {
    	controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	Alumno alumno = controlador.altaAlumno("ALU0002", "Jose", "Alvear 123", "jose@alvear", new ArrayList<Asignatura>());
    	controlador.modificarAlumno(alumno, "ALU0001", "Jose", "Alvear 123", "jose@alvear", new ArrayList<Asignatura>());
    }
    
    @Test
    public void testMAL2() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	boolean resultado = controlador.modificarAlumno(alumno, "ALU0001", "Jose", "Alvear 123", "jose@alvear", new ArrayList<Asignatura>());
    	assertTrue("No se modifico el alumno.", resultado);
    }
    
    @Test
    public void testMAL3() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	boolean resultado = controlador.modificarAlumno(alumno, "ALU0002", "Jose", "Alvear 123", "jose@alvear", new ArrayList<Asignatura>());
    	assertTrue("No se modifico el alumno.", resultado);
    }
    
    @Test
    public void testMAL4() {
    	Asignatura fisica1 = controlador.altaAsignatura("ASI0001", "Fisica 1", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
    	correlativas.add(fisica1);
    	Asignatura fisica2 = controlador.altaAsignatura("ASI0002", "Fisica 2", correlativas);
    	Cursada cursada = controlador.altaCursada("CUR0001", fisica2, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
    	aprobadas.add(fisica1);
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    	controlador.altaCursadaAlumno(cursada, alumno);
    	boolean resultado = controlador.modificarAlumno(alumno, "ALU0002", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	assertFalse("Se modifico al alumno.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.modificarAlumno(alumno, "ALU0002", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	assertTrue("No se modifico al alumno luego de confirmar la accion.", resultado);
    }
    
    @Test
    public void testMAL5() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	Asignatura fisica1 = controlador.altaAsignatura("ASI0001", "Fisica 1", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", fisica1, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaAlumno(cursada, alumno);
    	boolean resultado = controlador.modificarAlumno(alumno, "ALU0002", "Jose", "Alvear 123", "jose@alvear", new ArrayList<Asignatura>());
    	assertTrue("No se modifico el alumno.", resultado);
    }
    
    @Test
    public void testUAL1() {
    	ArrayList<Alumno> alumnos = entidades.buscaAlumno("Martin Perez");
    	assertTrue("Se encontro al menos un alumno.", alumnos.isEmpty());
    }
    
    @Test
    public void testUAL2() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Martin Perez", "Alvear 2343", "martin@alvear", new ArrayList<Asignatura>());
    	ArrayList<Alumno> alumnos = entidades.buscaAlumno("Martin Perez");
    	assertTrue("No se encontro al alumno.", alumnos.contains(alumno));
    }
    
    @Test
    public void testUAL3() {
    	controlador.altaAlumno("ALU0001", "Martin Perez", "Alvear 2343", "martin@alvear", new ArrayList<Asignatura>());
    	ArrayList<Alumno> alumnos = entidades.buscaAlumno("Martin Gomez");
    	assertTrue("Se encontro al menos un alumno.", alumnos.isEmpty());
    }
    
    @Test
    public void testBAPL2() {
    	Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0001");
    	assertNull("Se encontro un alumno.", alumno);
    }
    
    @Test
    public void testBAPL4() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	Alumno encontrado = entidades.buscaAlumnoPorLegajo("ALU0001");
    	assertTrue("No se encontro el alumno.", encontrado == alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBA1() {
    	Alumno alumno = new Alumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com");
    	controlador.bajaAlumno(alumno);
    }
    
    @Test
    public void testBA2() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	boolean resultado = controlador.bajaAlumno(alumno);
    	assertTrue("El alumno no se dio de baja.", resultado);
    }
    
    @Test
    public void testBA3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    	alumnos.add(alumno);
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", alumnos, new ArrayList<Profesor>());
    	boolean resultado = controlador.bajaAlumno(alumno);
    	assertFalse("El alumno se dio de baja.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.bajaAlumno(alumno);
    	assertTrue("No se dio de baja al alumno luego de confirmar la accion.", resultado);
    }
    
    /**************
     * PROFESORES *
     **************/
    
    @Test (expected = IllegalArgumentException.class)
    public void testAP1() {
    	controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "34325432", new ArrayList<Asignatura>());
    	controlador.altaProfesor("PRO0001", "Jose", "Alvear 123", "jose@alvear", "4323564", new ArrayList<Asignatura>());
    }
    
    @Test
    public void testAP2() {
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "4554354", new ArrayList<Asignatura>());
    	assertNotNull("No se dio de alta al profesor.", profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMP1() {
    	controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	Profesor profesor = controlador.altaProfesor("PRO0002", "Jose", "Alvear 123", "jose@alvear", "432435", new ArrayList<Asignatura>());
    	controlador.modificarProfesor(profesor, "PRO0001", "Jose", "Alvear 123", "jose@alvear", "432445", new ArrayList<Asignatura>());
    }
    
    @Test
    public void testMP2() {
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	boolean resultado = controlador.modificarProfesor(profesor, "PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	assertTrue("No se modifico el profesor.", resultado);
    }
    
    @Test
    public void testMP3() {
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	boolean resultado = controlador.modificarProfesor(profesor, "PRO0002", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	assertTrue("No se modifico el profesor.", resultado);
    }
    
    @Test
    public void testMP4() {
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", a1, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(a1);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", habilitadas);
    	controlador.altaCursadaProfesor(cursada, profesor);
    	boolean resultado = controlador.modificarProfesor(profesor, "PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	assertFalse("Se modifico el profesor.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.modificarProfesor(profesor, "PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", new ArrayList<Asignatura>());
    	assertTrue("No se modifico al profesor al confirmar la accion.", resultado);
    }
    
    @Test
    public void testMP5() {
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", a1, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(a1);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Maria", "Estrada 123", "maria@estrada", "4324324", habilitadas);
    	controlador.altaCursadaProfesor(cursada, profesor);
    	boolean resultado = controlador.modificarProfesor(profesor, "PRO0001", "Jose", "Alvear 123", "jose@alvear", "4354324", habilitadas);
    	assertTrue("No se modifico el profesor.", resultado);
    }
    
    @Test
    public void testUP1() {
    	ArrayList<Profesor> profesores = entidades.buscaProfesor("Martin Perez");
    	assertTrue("Se encontro al menos un profesor.", profesores.isEmpty());
    }
    
    @Test
    public void testUP2() {
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Martin Perez", "Alvear 2343", "martin@alvear", "432434", new ArrayList<Asignatura>());
    	ArrayList<Profesor> profesores = entidades.buscaProfesor("Martin Perez");
    	assertTrue("No se encontro al profesor.", profesores.contains(profesor));
    }
    
    @Test
    public void testUP3() {
    	controlador.altaProfesor("PRO0001", "Martin Perez", "Alvear 2343", "martin@alvear", "432434", new ArrayList<Asignatura>());
    	ArrayList<Profesor> profesores = entidades.buscaProfesor("Martin Gomez");
    	assertTrue("Se encontro al menos un profesor.", profesores.isEmpty());
    }
    
    @Test
    public void testBPPL2() {
    	Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0001");
    	assertNull("Se encontro un profesor.", profesor);
    }
    
    @Test
    public void testBPPL4() {
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", new ArrayList<Asignatura>());
    	Profesor encontrado = entidades.buscaProfesorPorLegajo("PRO0001");
    	assertTrue("No se encontro el profesor.", encontrado == profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBP1() {
    	Profesor profesor = new Profesor("PRO0001", "Leonel Guccione", "Calle 123", "2235555555", "mail@gmail.com");
    	controlador.bajaProfesor(profesor);
    }
    
    @Test
    public void testBP2() {
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", new ArrayList<Asignatura>());
    	boolean resultado = controlador.bajaProfesor(profesor);
    	assertTrue("El profesor no se dio de baja.", resultado);
    }
    
    @Test
    public void testBP3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(asignatura);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    	profesores.add(profesor);
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), profesores);
    	boolean resultado = controlador.bajaProfesor(profesor);
    	assertFalse("El profesor se dio de baja.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.bajaProfesor(profesor);
    	assertTrue("El profesor no se dio de baja al confirmar la accion.", resultado);
    }
    
    /***************
     * ASIGNATURAS *
     ***************/
    
    @Test (expected = IllegalArgumentException.class)
    public void testAAS1() {
    	controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	controlador.altaAsignatura("ASI0001", "Quimica", new ArrayList<Asignatura>());
    }
    
    @Test
    public void testAAS2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	assertNotNull("No se dio de alta la asignatura.", asignatura);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMAS1() {
    	controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	Asignatura asignatura = controlador.altaAsignatura("ASI0002", "Quimica", new ArrayList<Asignatura>());
    	controlador.modificarAsignatura(asignatura, "ASI0001", "Quimica", new ArrayList<Asignatura>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMAS2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
    	correlativas.add(asignatura);
    	controlador.modificarAsignatura(asignatura, "ASI0002", "Matematica", correlativas);
    }
    
    @Test
    public void testMAS3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	boolean resultado = controlador.modificarAsignatura(asignatura, "ASI0001", "Matematica", new ArrayList<Asignatura>());
    	assertTrue("No se modifico la asignatura.", resultado);
    }
    
    @Test
    public void testMAS4() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	boolean resultado = controlador.modificarAsignatura(asignatura, "ASI0002", "Matematica", new ArrayList<Asignatura>());
    	assertTrue("No se modifico la asignatura.", resultado);
    }
    
    @Test
    public void testMAS5() {
    	ArrayList<Asignatura> alu2_aprobadas = new ArrayList<Asignatura>();
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	Asignatura a2 = controlador.altaAsignatura("ASI0002", "Quimica", new ArrayList<Asignatura>());
    	alu2_aprobadas.add(a2);
    	controlador.altaCursada("CUR0000", a2, "01-2017", "Mar", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	Cursada cursada = controlador.altaCursada("CUR0001", a1, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	Alumno alu1 = controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", new ArrayList<Asignatura>());
    	Alumno alu2 = controlador.altaAlumno("ALU0003", "Jose", "Alvear 123", "jose@alvear", alu2_aprobadas);
    	controlador.altaCursadaAlumno(cursada, alu1);
    	controlador.altaCursadaAlumno(cursada, alu2);
    	ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
    	correlativas.add(a2);
    	boolean resultado = controlador.modificarAsignatura(a1, "ASI0003", "Matematica", correlativas);
    	assertFalse("Se modifico la asignatura.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.modificarAsignatura(a1, "ASI0003", "Matematica", correlativas);
    	assertTrue("No se modifico la asignatura al confirmar la accion.", resultado);
    }
    
    @Test
    public void testMAS6() {
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Matematica", new ArrayList<Asignatura>());
    	Asignatura a2 = controlador.altaAsignatura("ASI0002", "Quimica", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> alu1_aprobadas = new ArrayList<Asignatura>();
    	ArrayList<Asignatura> alu2_aprobadas = new ArrayList<Asignatura>();
    	alu1_aprobadas.add(a1);
    	alu2_aprobadas.add(a1);
    	alu2_aprobadas.add(a2);
    	controlador.altaAlumno("ALU0001", "Maria", "Estrada 123", "maria@estrada", alu1_aprobadas);
    	controlador.altaAlumno("ALU0003", "Jose", "Alvear 123", "jose@alvear", alu2_aprobadas);
    	ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
    	correlativas.add(a2);
    	boolean resultado = controlador.modificarAsignatura(a1, "ASI0003", "Matematica", correlativas);
    	assertFalse("Se modifico la asignatura.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.modificarAsignatura(a1, "ASI0003", "Matematica", correlativas);
    	assertTrue("No se modifico la asignatura al confirmar la accion.", resultado);
    }
    
    @Test
    public void testUAS1() {
    	ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Fisica1");
    	assertTrue("Se encontro al menos una asignatura.", asignaturas.isEmpty());
    }
    
    @Test
    public void testUAS2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Fisica1", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Fisica1");
    	assertTrue("No se encontro la asignatura.", asignaturas.contains(asignatura));
    }
    
    @Test
    public void testUAS3() {
    	controlador.altaAsignatura("ASI0001", "Fisica1", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Quimica1");
    	assertTrue("Se encontro al menos una asignatura.", asignaturas.isEmpty());
    }
    
    @Test
    public void testBAPI2() {
    	Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0001");
    	assertNull("Se encontro una asignatura.", asignatura);
    }
    
    @Test
    public void testBAPI4() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Asignatura encontrado = entidades.buscaAsignaturaPorId("ASI0001");
    	assertTrue("No se encontro la asignatura.", encontrado == asignatura);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBAS1() {
    	Asignatura asignatura = new Asignatura("ASI0001", "Mate A");
    	controlador.bajaAsignatura(asignatura);
    }
    
    @Test
    public void testBAS2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	boolean resultado = controlador.bajaAsignatura(asignatura);
    	assertTrue("La asignatura no se dio de baja.", resultado);
    }
    
    @Test
    public void testBAS4() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
    	aprobadas.add(asignatura);
    	controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", aprobadas);
    	boolean resultado = controlador.bajaAsignatura(asignatura);
    	assertFalse("La asignatura se dio de baja.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.bajaAsignatura(asignatura);
    	assertTrue("No se dio de baja la asignatura al confirmar la accion.", resultado);
    }
    
    @Test
    public void testBAS5() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(asignatura);
    	controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	boolean resultado = controlador.bajaAsignatura(asignatura);
    	assertFalse("La asignatura se dio de baja.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.bajaAsignatura(asignatura);
    	assertTrue("No se dio de baja la asignatura al confirmar la accion.", resultado);
    }
    
    @Test
    public void testBAS6() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
    	correlativas.add(asignatura);
    	controlador.altaAsignatura("ASI0002", "Mate B", correlativas);
    	boolean resultado = controlador.bajaAsignatura(asignatura);
    	assertFalse("La asignatura se dio de baja.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.bajaAsignatura(asignatura);
    	assertTrue("No se dio de baja la asignatura al confirmar la accion.", resultado);
    }
    
    @Test
    public void testBAS7() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	controlador.altaCursada("CUR0001", asignatura, "02-2017", "Jue", "09:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	boolean resultado = controlador.bajaAsignatura(asignatura);
    	assertFalse("La asignatura se dio de baja.", resultado);
    	controlador.setListener(new ControladorListenerConfirmador());
    	resultado = controlador.bajaAsignatura(asignatura);
    	assertTrue("No se dio de baja la asignatura al confirmar la accion.", resultado);
    }
    
    /***************
     *  CURSADAS   *
     ***************/
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC1() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursada("CUR0001", asignatura, "02-2017", "Mar", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test
    public void testAC2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	assertNotNull("No se dio de alta la cursada.", cursada);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC3() {
    	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    	Asignatura programacion1 = controlador.altaAsignatura("ASI3432", "Programacion 1", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
    	correlativas.add(programacion1);
    	Asignatura programacion2 = controlador.altaAsignatura("ASI3433", "Programacion 2", correlativas);
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	alumnos.add(alumno);
    	controlador.altaCursada("CUR0001", programacion2, "01-2017", "Lun", "10:00", "14:00", alumnos, new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC4() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    	alumnos.add(new Alumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com"));
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", alumnos, new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC5() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    	profesores.add(new Profesor("PRO0001", "Leonel Guccione", "Calle 123", "2235555555", "mail@gmail.com"));
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), profesores);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC6() {
    	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    	Asignatura programacion1 = controlador.altaAsignatura("ASI3432", "Programacion 1", new ArrayList<Asignatura>());
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", new ArrayList<Asignatura>());
    	profesores.add(profesor);
    	controlador.altaCursada("CUR0001", programacion1, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), profesores);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC7() {
    	ArrayList<Profesor> profesores1 = new ArrayList<Profesor>();
    	ArrayList<Profesor> profesores2 = new ArrayList<Profesor>();
    	ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
    	Asignatura programacion1 = controlador.altaAsignatura("ASI3432", "Programacion 1", new ArrayList<Asignatura>());
    	asignaturas.add(programacion1);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", asignaturas);
    	profesores1.add(profesor);
    	profesores2.add(profesor);
    	controlador.altaCursada("CUR0001", programacion1, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), profesores1);
    	controlador.altaCursada("CUR0002", programacion1, "01-2017", "Lun", "12:00", "16:00", new ArrayList<Alumno>(), profesores2);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAC8() {
    	ArrayList<Alumno> alumnos1 = new ArrayList<Alumno>();
    	ArrayList<Alumno> alumnos2 = new ArrayList<Alumno>();
    	Asignatura programacion1 = controlador.altaAsignatura("ASI3432", "Programacion 1", new ArrayList<Asignatura>());
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	alumnos1.add(alumno);
    	alumnos2.add(alumno);
    	controlador.altaCursada("CUR0001", programacion1, "01-2017", "Lun", "10:00", "14:00", alumnos1, new ArrayList<Profesor>());
    	controlador.altaCursada("CUR0002", programacion1, "01-2017", "Lun", "12:00", "16:00", alumnos2, new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMC1() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	Cursada cursada = controlador.altaCursada("CUR0002", asignatura, "01-2017", "Mar", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.modificarCursada(cursada, "CUR0001", asignatura, "01-2017", "Mar", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test
    public void testMC2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.modificarCursada(cursada, "CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test
    public void testMC3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI3432", "Programacion", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.modificarCursada(cursada, "CUR0002", asignatura, "01-2017", "Lun", "10:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test
    public void testUC1() {
    	ArrayList<Cursada> cursadas = entidades.buscaCursada("Comision1Fisica1");
    	assertTrue("Se encontro al menos una cursada.", cursadas.isEmpty());
    }
    
    @Test
    public void testUC2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Fisica1", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "12:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	ArrayList<Cursada> cursadas = entidades.buscaCursada("Fisica1");
    	assertTrue("No se encontro la cursada.", cursadas.contains(cursada));
    }
    
    @Test
    public void testUC3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Fisica1", new ArrayList<Asignatura>());
    	controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "12:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	ArrayList<Cursada> cursadas = entidades.buscaCursada("Quimica1");
    	assertTrue("Se encontro al menos una cursada.", cursadas.isEmpty());
    }
    
    @Test
    public void testBCPI2() {
    	Cursada cursada = entidades.buscaCursadaPorId("CUR0001");
    	assertNull("Se encontro una cursada.", cursada);
    }
    
    @Test
    public void testBCPI4() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	Cursada encontrado = entidades.buscaCursadaPorId("CUR0001");
    	assertTrue("No se encontro la cursada.", encontrado == cursada);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBC1() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = new Cursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00");
    	controlador.bajaCursada(cursada);
    }
    
    @Test
    public void testBC2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.bajaCursada(cursada);
    	assertFalse("La cursada no se dio de baja.", entidades.getCursadas().contains(cursada));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACA1() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaAlumno(cursada, null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACA2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	Alumno alumno = new Alumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com");
    	controlador.altaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACA3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    	alumnos.add(alumno);
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", alumnos, new ArrayList<Profesor>());
    	controlador.altaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACA4() {
    	ArrayList<Asignatura> a2_correlativas = new ArrayList<Asignatura>();
    	ArrayList<Asignatura> a3_correlativas = new ArrayList<Asignatura>();
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	a2_correlativas.add(a1);
    	Asignatura a2 = controlador.altaAsignatura("ASI0002", "Mate B", a2_correlativas);
    	a3_correlativas.add(a1);
    	a3_correlativas.add(a2);
    	Asignatura a3 = controlador.altaAsignatura("ASI0003", "Mate C", a3_correlativas);
    	ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
    	aprobadas.add(a1);
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", aprobadas);
    	Cursada cursada = controlador.altaCursada("CUR0001", a3, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACA5() {
    	ArrayList<Asignatura> a2_correlativas = new ArrayList<Asignatura>();
    	ArrayList<Asignatura> a3_correlativas = new ArrayList<Asignatura>();
    	ArrayList<Asignatura> a4_correlativas = new ArrayList<Asignatura>();
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	a2_correlativas.add(a1);
    	Asignatura a2 = controlador.altaAsignatura("ASI0002", "Mate B", a2_correlativas);
    	a3_correlativas.add(a1);
    	a3_correlativas.add(a2);
    	Asignatura a3 = controlador.altaAsignatura("ASI0003", "Mate C", a3_correlativas);
    	a4_correlativas.add(a1);
    	Asignatura a4 = controlador.altaAsignatura("ASI0004", "Fisica 1", a4_correlativas);
    	ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
    	aprobadas.add(a1);
    	aprobadas.add(a2);
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", aprobadas);
    	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    	alumnos.add(alumno);
    	Cursada c1 = controlador.altaCursada("CUR0001", a4, "01-2017", "Lun", "15:00", "17:00", alumnos, new ArrayList<Profesor>());
    	Cursada c2 = controlador.altaCursada("CUR0002", a3, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaAlumno(c2, alumno);
    }
    
    @Test
    public void testACA6() {
    	ArrayList<Asignatura> a2_correlativas = new ArrayList<Asignatura>();
    	ArrayList<Asignatura> a3_correlativas = new ArrayList<Asignatura>();
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	a2_correlativas.add(a1);
    	Asignatura a2 = controlador.altaAsignatura("ASI0002", "Mate B", a2_correlativas);
    	a3_correlativas.add(a1);
    	a3_correlativas.add(a2);
    	Asignatura a3 = controlador.altaAsignatura("ASI0003", "Mate C", a3_correlativas);
    	ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
    	aprobadas.add(a1);
    	aprobadas.add(a2);
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", aprobadas);
    	Cursada cursada = controlador.altaCursada("CUR0001", a3, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaAlumno(cursada, alumno);
    	assertTrue("El alumno no fue dado de alta a la cursada.", cursada.getAlumnos().contains(alumno));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACP1() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaProfesor(cursada, null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACP2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	Profesor profesor = new Profesor("PRO0001", "Leonel Guccione", "Calle 123", "2235555555", "mail@gmail.com");
    	controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACP3() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(asignatura);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    	profesores.add(profesor);
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), profesores);
    	controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACP4() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testACP5() {
    	Asignatura a1 = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Asignatura a2 = controlador.altaAsignatura("ASI0002", "Algebra A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(a1);
    	habilitadas.add(a2);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    	profesores.add(profesor);
    	controlador.altaCursada("CUR0001", a1, "01-2017", "Lun", "15:00", "17:00", new ArrayList<Alumno>(), profesores);
    	Cursada c2 = controlador.altaCursada("CUR0002", a2, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaProfesor(c2, profesor);
    }
    
    @Test
    public void testACP6() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(asignatura);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.altaCursadaProfesor(cursada, profesor);
    	assertTrue("El profesor no fue dado de alta a la cursada.", cursada.getProfesores().contains(profesor));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBCA1() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.bajaCursadaAlumno(cursada, alumno);
    }
    
    @Test
    public void testBCA2() {
    	Alumno alumno = controlador.altaAlumno("ALU0001", "Dario Banini", "Calle 123", "mail@gmail.com", new ArrayList<Asignatura>());
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    	alumnos.add(alumno);
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", alumnos, new ArrayList<Profesor>());
    	controlador.bajaCursadaAlumno(cursada, alumno);
    	assertFalse("El alumno no fue dado de baja de la cursada.", cursada.getAlumnos().contains(alumno));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBCP1() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(asignatura);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    	controlador.bajaCursadaProfesor(cursada, profesor);
    }
    
    @Test
    public void testBCP2() {
    	Asignatura asignatura = controlador.altaAsignatura("ASI0001", "Mate A", new ArrayList<Asignatura>());
    	ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
    	habilitadas.add(asignatura);
    	Profesor profesor = controlador.altaProfesor("PRO0001", "Leonel Guccione", "Calle 123", "mail@gmail.com", "2235555555", habilitadas);
    	ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    	profesores.add(profesor);
    	Cursada cursada = controlador.altaCursada("CUR0001", asignatura, "01-2017", "Lun", "14:00", "16:00", new ArrayList<Alumno>(), profesores);
    	controlador.bajaCursadaProfesor(cursada, profesor);
    	assertFalse("El profesor no fue dado de baja de la cursada.", cursada.getProfesores().contains(profesor));
    }
    
    /**************
     * CONTENEDOR *
     **************/
    @Test 
    public void testContenedor() {
    	entidades.setAlumnos(new ArrayList<Alumno>());
    	entidades.setProfesores(new ArrayList<Profesor>());
    	entidades.setAsignaturas(new ArrayList<Asignatura>());
    	entidades.setCursadas(new ArrayList<Cursada>());
    }
}
