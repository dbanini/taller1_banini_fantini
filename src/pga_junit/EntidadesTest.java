package pga_junit;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import pga_modelo.Alumno;
import pga_modelo.Asignatura;
import pga_modelo.Cursada;
import pga_modelo.Entidades;
import pga_modelo.Profesor;

public class EntidadesTest {
    private Entidades entidades;
    
    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    
    @Before
    public void setupEscenario() {
        entidades = new Entidades();
    }
    
    private void setupEscenario_1() {
        // Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        Asignatura quimica      = new Asignatura("ASI2345", "Quimica");
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        
        // Agregar alumnos.
        Alumno alumnoMartin = new Alumno("ALU1234", "Martin", "Mitre 1234", "martin@mitre");
        Alumno alumnoJose = new Alumno("ALU2345", "Jose", "Colon 2345", "jose@colon");
        Alumno alumnoJuan = new Alumno("ALU3456", "Juan", "Salta 3456", "juan@salta");
        Alumno alumnoPedro = new Alumno("ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy");
        alumnoJuan.getAprobadas().add(quimica);
        alumnoPedro.getAprobadas().add(matematica);
        entidades.addAlumno(alumnoMartin);
        entidades.addAlumno(alumnoJose);
        entidades.addAlumno(alumnoJuan);
        entidades.addAlumno(alumnoPedro);
    }
    
    private void setupEscenario_2() {
        Alumno alumnoMaria = new Alumno("ALU0123", "Maria", "Estrada 123", "maria@estrada");
        entidades.addAlumno(alumnoMaria);
    }
    
    private void setupEscenario_3() {
        // Alumnos = { }
    }
    
    private void setupEscenario_4() {
        // Agregar asignaturas habilitadas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        Asignatura quimica      = new Asignatura("ASI2345", "Quimica");
        Asignatura laboratorio  = new Asignatura("ASI4567", "Laboratorio");
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        entidades.addAsignatura(laboratorio);
        
        // Agregar profesores.
        Profesor profesorMartin = new Profesor("PRO1234", "Martin", "Mitre 1234", "12345678", "martin@mitre");
        Profesor profesorJose = new Profesor("PRO2345", "Jose", "Colon 2345", "23456789", "jose@colon");
        Profesor profesorJuan = new Profesor("PRO3456", "Juan", "Salta 3456", "34567890", "juan@salta");
        Profesor profesorPedro = new Profesor("PRO4567", "Pedro", "Jujuy 4567", "45678901", "pedro@jujuy");
        profesorJuan.getHabilitadas().add(quimica);
        profesorJuan.getHabilitadas().add(laboratorio);
        profesorPedro.getHabilitadas().add(matematica);
        entidades.addProfesor(profesorMartin);
        entidades.addProfesor(profesorJose);
        entidades.addProfesor(profesorJuan);
        entidades.addProfesor(profesorPedro);
    }
    
    private void setupEscenario_5() {
        Profesor profesorMaria = new Profesor("PRO0123", "Maria", "Estrada 123", "01234567", "maria@estrada");
        entidades.addProfesor(profesorMaria);
    }
    
    private void setupEscenario_6() {
        // Profesores = { }
    }
    
    private void setupEscenario_7() {
        // Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        Asignatura quimica      = new Asignatura("ASI2345", "Quimica");
        Asignatura estadistica  = new Asignatura("ASI3456", "Estadistica");
        Asignatura laboratorio  = new Asignatura("ASI4567", "Laboratorio");
        Asignatura computacion  = new Asignatura("ASI5678", "Computacion"); 
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        entidades.addAsignatura(estadistica);
        entidades.addAsignatura(laboratorio);
        entidades.addAsignatura(computacion);
        estadistica.getCorrelativas().add(matematica);
        laboratorio.getCorrelativas().add(quimica);
    }
    
    private void setupEscenario_8() {
        Asignatura fisica = new Asignatura("ASI0123", "Fisica"); 
        entidades.addAsignatura(fisica);
    }
    
    private void setupEscenario_9() {
        // Asignaturas = { }
    }
    
    private void setupEscenario_7_10() {
        // Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        Asignatura quimica      = new Asignatura("ASI2345", "Quimica");
        Asignatura estadistica  = new Asignatura("ASI3456", "Estadistica");
        Asignatura laboratorio  = new Asignatura("ASI4567", "Laboratorio");
        Asignatura computacion  = new Asignatura("ASI5678", "Computacion"); 
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        entidades.addAsignatura(estadistica);
        entidades.addAsignatura(laboratorio);
        entidades.addAsignatura(computacion);
        estadistica.getCorrelativas().add(matematica);
        laboratorio.getCorrelativas().add(quimica);
        
        // Agregar alumnos y profesores (Que los necesita cursadas)
        Alumno alumnoJuan = new Alumno("ALU3456", "Juan", "Salta 3456", "juan@salta");
        alumnoJuan.getAprobadas().add(quimica);
        Profesor profesorJuan = new Profesor("PRO3456", "Juan", "Salta 3456", "34567890", "juan@salta");
        profesorJuan.getHabilitadas().add(quimica);
        profesorJuan.getHabilitadas().add(laboratorio);
        entidades.addAlumno(alumnoJuan);
        entidades.addProfesor(profesorJuan);
        
        // Agregar cursadas.
        Cursada cursadaMatematica1  = new Cursada("CUR1234", matematica,  "01-2017", "Lun", "12:00", "14:00");
        Cursada cursadaQuimica1     = new Cursada("CUR2345", quimica,     "01-2017", "Lun", "13:00", "15:00");
        Cursada cursadaMatematica2  = new Cursada("CUR3456", matematica,  "02-2017", "Jue", "16:00", "18:00");
        Cursada cursadaLaboratorio  = new Cursada("CUR4567", laboratorio, "02-2017", "Mié", "17:00", "19:00");
        Cursada cursadaComputacion  = new Cursada("CUR5678", computacion, "02-2017", "Jue", "15:00", "17:00");
        Cursada cursadaQuimica2     = new Cursada("CUR6789", quimica,     "02-2017", "Mié", "16:00", "18:00");
        cursadaLaboratorio.getProfesores().add(profesorJuan);
        cursadaComputacion.getAlumnos().add(alumnoJuan);
        entidades.addCursada(cursadaMatematica1);
        entidades.addCursada(cursadaQuimica1);
        entidades.addCursada(cursadaMatematica2);
        entidades.addCursada(cursadaLaboratorio);
        entidades.addCursada(cursadaComputacion);
        entidades.addCursada(cursadaQuimica2);
    }
    
    private void setupEscenario_7_11() {
        // Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        Asignatura quimica      = new Asignatura("ASI2345", "Quimica");
        Asignatura estadistica  = new Asignatura("ASI3456", "Estadistica");
        Asignatura laboratorio  = new Asignatura("ASI4567", "Laboratorio");
        Asignatura computacion  = new Asignatura("ASI5678", "Computacion"); 
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        entidades.addAsignatura(estadistica);
        entidades.addAsignatura(laboratorio);
        entidades.addAsignatura(computacion);
        estadistica.getCorrelativas().add(matematica);
        laboratorio.getCorrelativas().add(quimica);
        
        // Agregar cursadas.
        Cursada cursadaQuimica = new Cursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00");
        entidades.addCursada(cursadaQuimica);
    }
    
    private void setupEscenario_7_12() {
        // Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI1234", "Matematica");
        Asignatura quimica      = new Asignatura("ASI2345", "Quimica");
        Asignatura estadistica  = new Asignatura("ASI3456", "Estadistica");
        Asignatura laboratorio  = new Asignatura("ASI4567", "Laboratorio");
        Asignatura computacion  = new Asignatura("ASI5678", "Computacion"); 
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        entidades.addAsignatura(estadistica);
        entidades.addAsignatura(laboratorio);
        entidades.addAsignatura(computacion);
        estadistica.getCorrelativas().add(matematica);
        laboratorio.getCorrelativas().add(quimica);
        
        // Cursadas = {}
    }
    
    /***********
     * ALUMNOS *
     ***********/
    
    @Test
    public void testConsultaAlumno1_1() {
        setupEscenario_1();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU1234");
        assertNotNull(alumno);
        assertTrue("El alumno retornado no tiene el legajo correcto.", alumno.getLegajo().equals("ALU1234"));
        assertTrue("El alumno retornado no tiene el nombre correcto.", alumno.getNombre().equals("Martin"));
        assertTrue("El alumno retornado no tiene el domicilio correcto.", alumno.getDomicilio().equals("Mitre 1234"));
        assertTrue("El alumno retornado no tiene el mail correcto.", alumno.getMail().equals("martin@mitre"));
        assertTrue("El alumno retornado no tiene la lista de aprobadas correcta.", alumno.getAprobadas().isEmpty());
    }
    
    @Test
    public void testConsultaAlumno1_1_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        assertNotNull(alumno);
        assertTrue("El alumno retornado no tiene el legajo correcto.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("El alumno retornado no tiene el nombre correcto.", alumno.getNombre().equals("Maria"));
        assertTrue("El alumno retornado no tiene el domicilio correcto.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("El alumno retornado no tiene el mail correcto.", alumno.getMail().equals("maria@estrada"));
        assertTrue("El alumno retornado no tiene la lista de aprobadas correcta.", alumno.getAprobadas().isEmpty());
    }
    
    @Test
    public void testConsultaAlumno1_2() {
        setupEscenario_1();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        assertNull("Se encontro un alumno.", alumno);
    }
    
    @Test
    public void testConsultaAlumno1_2_VL() {
        setupEscenario_3();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        assertNull("Se encontro un alumno.", alumno);
    }
    
    @Test
    public void testUbicarAlumno1_1() {
        setupEscenario_1();
        ArrayList<Alumno> alumnos = entidades.buscaAlumno("Martin");
        assertTrue("No se encontro el alumno con ese nombre.", alumnos.size() == 1);
        Alumno alumno = alumnos.get(0);
        assertTrue("El alumno retornado no tiene el legajo correcto.", alumno.getLegajo().equals("ALU1234"));
        assertTrue("El alumno retornado no tiene el nombre correcto.", alumno.getNombre().equals("Martin"));
        assertTrue("El alumno retornado no tiene el domicilio correcto.", alumno.getDomicilio().equals("Mitre 1234"));
        assertTrue("El alumno retornado no tiene el mail correcto.", alumno.getMail().equals("martin@mitre"));
        assertTrue("El alumno retornado no tiene la lista de aprobadas correcta.", alumno.getAprobadas().isEmpty());
    }
    
    @Test
    public void testUbicarAlumno1_1_VL() {
        setupEscenario_2();
        ArrayList<Alumno> alumnos = entidades.buscaAlumno("Maria");
        assertTrue("No se encontro el alumno con ese nombre.", alumnos.size() == 1);
        Alumno alumno = alumnos.get(0);
        assertTrue("El alumno retornado no tiene el legajo correcto.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("El alumno retornado no tiene el nombre correcto.", alumno.getNombre().equals("Maria"));
        assertTrue("El alumno retornado no tiene el domicilio correcto.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("El alumno retornado no tiene el mail correcto.", alumno.getMail().equals("maria@estrada"));
        assertTrue("El alumno retornado no tiene la lista de aprobadas correcta.", alumno.getAprobadas().isEmpty());
    }
    
    @Test
    public void testUbicarAlumno1_2() {
        setupEscenario_1();
        ArrayList<Alumno> alumnos = entidades.buscaAlumno("Maria");
        assertTrue("Se encontro al menos un alumno con ese nombre.", alumnos.isEmpty());
    }
    
    @Test
    public void testUbicarAlumno1_2_VL() {
        setupEscenario_3();
        ArrayList<Alumno> alumnos = entidades.buscaAlumno("Maria");
        assertTrue("Se encontro al menos un alumno con ese nombre.", alumnos.isEmpty());
    }
    
    /**************
     * PROFESORES *
     **************/
    
    @Test
    public void testConsultaProfesor1_1() {
        setupEscenario_4();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
        assertNotNull(profesor);
        assertTrue("El profesor retornado no tiene el legajo correcto.", profesor.getLegajo().equals("PRO1234"));
        assertTrue("El profesor retornado no tiene el nombre correcto.", profesor.getNombre().equals("Martin"));
        assertTrue("El profesor retornado no tiene el domicilio correcto.", profesor.getDomicilio().equals("Mitre 1234"));
        assertTrue("El profesor retornado no tiene el mail correcto.", profesor.getMail().equals("martin@mitre"));
        assertTrue("El profesor retornado no tiene el telefono correcto.", profesor.getTelefono().equals("12345678"));
        assertTrue("El profesor retornado no tiene la lista de habilitadas correcta.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test
    public void testConsultaProfesor1_1_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        assertNotNull(profesor);
        assertTrue("El profesor retornado no tiene el legajo correcto.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("El profesor retornado no tiene el nombre correcto.", profesor.getNombre().equals("Maria"));
        assertTrue("El profesor retornado no tiene el domicilio correcto.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("El profesor retornado no tiene el mail correcto.", profesor.getMail().equals("maria@estrada"));
        assertTrue("El profesor retornado no tiene el telefono correcto.", profesor.getTelefono().equals("01234567"));
        assertTrue("El profesor retornado no tiene la lista de habilitadas correcta.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test
    public void testConsultaProfesor1_2() {
        setupEscenario_4();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        assertNull("Se encontro un profesor.", profesor);
    }
    
    @Test
    public void testConsultaProfesor1_2_VL() {
        setupEscenario_6();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        assertNull("Se encontro un profesor.", profesor);
    }
    
    @Test
    public void testUbicarProfesor1_1() {
        setupEscenario_4();
        ArrayList<Profesor> profesores = entidades.buscaProfesor("Martin");
        assertTrue("No se encontro el profesor con ese nombre.", profesores.size() == 1);
        Profesor profesor = profesores.get(0);
        assertTrue("El profesor retornado no tiene el legajo correcto.", profesor.getLegajo().equals("PRO1234"));
        assertTrue("El profesor retornado no tiene el nombre correcto.", profesor.getNombre().equals("Martin"));
        assertTrue("El profesor retornado no tiene el domicilio correcto.", profesor.getDomicilio().equals("Mitre 1234"));
        assertTrue("El profesor retornado no tiene el mail correcto.", profesor.getMail().equals("martin@mitre"));
        assertTrue("El profesor retornado no tiene el telefono correcto.", profesor.getTelefono().equals("12345678"));
        assertTrue("El profesor retornado no tiene la lista de habilitadas correcta.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test
    public void testUbicarProfesor1_1_VL() {
        setupEscenario_5();
        ArrayList<Profesor> profesores = entidades.buscaProfesor("Maria");
        assertTrue("No se encontro el profesor con ese nombre.", profesores.size() == 1);
        Profesor profesor = profesores.get(0);
        assertTrue("El profesor retornado no tiene el legajo correcto.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("El profesor retornado no tiene el nombre correcto.", profesor.getNombre().equals("Maria"));
        assertTrue("El profesor retornado no tiene el domicilio correcto.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("El profesor retornado no tiene el mail correcto.", profesor.getMail().equals("maria@estrada"));
        assertTrue("El profesor retornado no tiene el telefono correcto.", profesor.getTelefono().equals("01234567"));
        assertTrue("El profesor retornado no tiene la lista de habilitadas correcta.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test
    public void testUbicarProfesor1_2() {
        setupEscenario_4();
        ArrayList<Profesor> profesores = entidades.buscaProfesor("Maria");
        assertTrue("Se encontro al menos un profesor con ese nombre.", profesores.isEmpty());
    }
    
    @Test
    public void testUbicarProfesor1_2_VL() {
        setupEscenario_6();
        ArrayList<Profesor> profesores = entidades.buscaProfesor("Maria");
        assertTrue("Se encontro al menos un profesor con ese nombre.", profesores.isEmpty());
    }
    
    /***************
     * ASIGNATURAS *
     ***************/
    
    @Test
    public void testConsultaAsignatura1_1() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI2345");
        assertTrue("La asignatura retornada no tiene el Id correcto.", asignatura.getId().equals("ASI2345"));
        assertTrue("La asignatura retornada no tiene el nombre correcto.", asignatura.getNombre().equals("Quimica"));
        assertTrue("La asignatura retornada no tiene la lista de correlativas correcta.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test
    public void testConsultaAsignatura1_1_VL() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        assertTrue("La asignatura retornada no tiene el Id correcto.", asignatura.getId().equals("ASI0123"));
        assertTrue("La asignatura retornada no tiene el nombre correcto.", asignatura.getNombre().equals("Fisica"));
        assertTrue("La asignatura retornada no tiene la lista de correlativas correcta.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test
    public void testConsultaAsignatura1_2() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        assertNull("Se encontro una asignatura.", asignatura);
    }
    
    @Test
    public void testConsultaAsignatura1_2_VL() {
        setupEscenario_9();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        assertNull("Se encontro una asignatura.", asignatura);
    }
    
    @Test
    public void testUbicarAsignatura1_1() {
        setupEscenario_7();
        ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Quimica");
        assertTrue("No se encontro la asignatura con ese nombre.", asignaturas.size() == 1);
        Asignatura asignatura = asignaturas.get(0);
        assertTrue("La asignatura retornada no tiene el Id correcto.", asignatura.getId().equals("ASI2345"));
        assertTrue("La asignatura retornada no tiene el nombre correcto.", asignatura.getNombre().equals("Quimica"));
        assertTrue("La asignatura retornada no tiene la lista de correlativas correcta.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test
    public void testUbicarAsignatura1_1_VL() {
        setupEscenario_8();
        ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Fisica");
        assertTrue("No se encontro la asignatura con ese nombre.", asignaturas.size() == 1);
        Asignatura asignatura = asignaturas.get(0);
        assertTrue("La asignatura retornada no tiene el Id correcto.", asignatura.getId().equals("ASI0123"));
        assertTrue("La asignatura retornada no tiene el nombre correcto.", asignatura.getNombre().equals("Fisica"));
        assertTrue("La asignatura retornada no tiene la lista de correlativas correcta.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test
    public void testUbicarAsignatura1_2() {
        setupEscenario_7();
        ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Fisica");
        assertTrue("Se encontro al menos una asignatura con ese nombre.", asignaturas.isEmpty());
    }
    
    @Test
    public void testUbicarAsignatura1_2_VL() {
        setupEscenario_9();
        ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Fisica");
        assertTrue("Se encontro al menos una asignatura con ese nombre.", asignaturas.isEmpty());
    }
    
    /***************
     *  CURSADAS   *
     ***************/            
    
    @Test
    public void testConsultaCursada1_1() {
        setupEscenario_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        assertTrue("La cursada retornada no tiene el Id correcto.", cursada.getId().equals("CUR2345"));
        assertTrue("La cursada retornada no tiene la asignatura correcta.", cursada.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada retornada no tiene el periodo correcto.", cursada.getPeriodo().equals("01-2017"));
        assertTrue("La cursada retornada no tiene el dia correcto.", cursada.getDia().equals("Lun"));
        assertTrue("La cursada retornada no tiene la hora inicio correcta.", cursada.getHoraInicio().equals("13:00"));
        assertTrue("La cursada retornada no tiene la hora fin correcta.", cursada.getHoraFin().equals("15:00"));
        assertTrue("La cursada retornada no tiene la lista de alumnos correcta.", cursada.getAlumnos().isEmpty());
        assertTrue("La cursada retornada no tiene la lista de profesores correcta.", cursada.getAlumnos().isEmpty());
    }
    
    @Test
    public void testConsultaCursada1_1_VL() {
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        assertTrue("La cursada retornada no tiene el Id correcto.", cursada.getId().equals("CUR0123"));
        assertTrue("La cursada retornada no tiene la asignatura correcta.", cursada.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada retornada no tiene el periodo correcto.", cursada.getPeriodo().equals("02-2017"));
        assertTrue("La cursada retornada no tiene el dia correcto.", cursada.getDia().equals("Sab"));
        assertTrue("La cursada retornada no tiene la hora inicio correcta.", cursada.getHoraInicio().equals("08:00"));
        assertTrue("La cursada retornada no tiene la hora fin correcta.", cursada.getHoraFin().equals("11:00"));
        assertTrue("La cursada retornada no tiene la lista de alumnos correcta.", cursada.getAlumnos().isEmpty());
        assertTrue("La cursada retornada no tiene la lista de profesores correcta.", cursada.getProfesores().isEmpty());
    }
    
    @Test
    public void testConsultaCursada1_2(){
        setupEscenario_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        assertNull("Se encontro una cursada.", cursada);
    }
    
    @Test
    public void testConsultaCursada1_2_VL(){
        setupEscenario_7_12();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        assertNull("Se encontro una cursada.", cursada);
    }
    
    @Test
    public void testUbicarCursada1_1() {
        setupEscenario_7_10();
        ArrayList<Cursada> cursadas = entidades.buscaCursada("Quimica");
        assertTrue("No se encontraron las dos cursadas por el nombre.", cursadas.size() == 2);
        Cursada cursadaA = cursadas.get(0);
        Cursada cursadaB = cursadas.get(1);
        assertTrue("La cursada A retornada no tiene el Id correcto.", cursadaA.getId().equals("CUR2345"));
        assertTrue("La cursada A retornada no tiene la asignatura correcta.", cursadaA.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada A retornada no tiene el periodo correcto.", cursadaA.getPeriodo().equals("01-2017"));
        assertTrue("La cursada A retornada no tiene el dia correcto.", cursadaA.getDia().equals("Lun"));
        assertTrue("La cursada A retornada no tiene la hora inicio correcta.", cursadaA.getHoraInicio().equals("13:00"));
        assertTrue("La cursada A retornada no tiene la hora fin correcta.", cursadaA.getHoraFin().equals("15:00"));
        assertTrue("La cursada A retornada no tiene la lista de alumnos correcta.", cursadaA.getAlumnos().isEmpty());
        assertTrue("La cursada A retornada no tiene la lista de profesores correcta.", cursadaA.getProfesores().isEmpty());
        
        assertTrue("La cursada B retornada no tiene el Id correcto.", cursadaB.getId().equals("CUR6789"));
        assertTrue("La cursada B retornada no tiene la asignatura correcta.", cursadaB.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada B retornada no tiene el periodo correcto.", cursadaB.getPeriodo().equals("02-2017"));
        assertTrue("La cursada B retornada no tiene el dia correcto.", cursadaB.getDia().equals("Mié"));
        assertTrue("La cursada B retornada no tiene la hora inicio correcta.", cursadaB.getHoraInicio().equals("16:00"));
        assertTrue("La cursada B retornada no tiene la hora fin correcta.", cursadaB.getHoraFin().equals("18:00"));
        assertTrue("La cursada B retornada no tiene la lista de alumnos correcta.", cursadaB.getAlumnos().isEmpty());
        assertTrue("La cursada B retornada no tiene la lista de profesores correcta.", cursadaB.getProfesores().isEmpty());
    }
    
    @Test
    public void testUbicarCursada1_1_VL() {
        setupEscenario_7_11();
        ArrayList<Cursada> cursadas = entidades.buscaCursada("Quimica");
        assertTrue("No se encontro la cursada por el nombre.", cursadas.size() == 1);
        Cursada cursada = cursadas.get(0);
        assertTrue("La cursada retornada no tiene el Id correcto.", cursada.getId().equals("CUR0123"));
        assertTrue("La cursada retornada no tiene la asignatura correcta.", cursada.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada retornada no tiene el periodo correcto.", cursada.getPeriodo().equals("02-2017"));
        assertTrue("La cursada retornada no tiene el dia correcto.", cursada.getDia().equals("Sab"));
        assertTrue("La cursada retornada no tiene la hora inicio correcta.", cursada.getHoraInicio().equals("08:00"));
        assertTrue("La cursada retornada no tiene la hora fin correcta.", cursada.getHoraFin().equals("11:00"));
        assertTrue("La cursada retornada no tiene la lista de alumnos correcta.", cursada.getAlumnos().isEmpty());
        assertTrue("La cursada retornada no tiene la lista de profesores correcta.", cursada.getAlumnos().isEmpty());
    }
    
    @Test
    public void testUbicarCursada1_2() {
        setupEscenario_7_10();
        ArrayList<Cursada> cursadas = entidades.buscaCursada("Fisica");
        assertTrue("Se encontro al menos una cursada con ese nombre.", cursadas.isEmpty());
    }
    
    @Test
    public void testUbicarCursada1_2_VL() {
        setupEscenario_7_11();
        ArrayList<Cursada> cursadas = entidades.buscaCursada("Fisica");
        assertTrue("Se encontro al menos una cursada con ese nombre.", cursadas.isEmpty());
    }
    
    /***************
     *  NUEVO ID   *
     ***************/  
    @Test
    public void testNuevoIds() {
    	// Agregar asignaturas.
        Asignatura matematica   = new Asignatura("ASI0000", "Matematica");
        Asignatura quimica      = new Asignatura("ASI0001", "Quimica");
        Asignatura estadistica  = new Asignatura("ASI0003", "Estadistica"); 
        entidades.addAsignatura(matematica);
        entidades.addAsignatura(quimica);
        entidades.addAsignatura(estadistica);
        assertTrue("El nuevo Id de asignatura sugerido no es correcto.", entidades.nuevoIdAsignatura().equals("ASI0002"));
        
        // Agregar alumnos.
        Alumno alumnoMartin = new Alumno("ALU0000", "Martin", "Mitre 1234", "martin@mitre");
        Alumno alumnoJose = new Alumno("ALU0001", "Jose", "Colon 2345", "jose@colon");
        Alumno alumnoJuan = new Alumno("ALU0003", "Juan", "Salta 3456", "juan@salta");
        entidades.addAlumno(alumnoMartin);
        entidades.addAlumno(alumnoJose);
        entidades.addAlumno(alumnoJuan);
        assertTrue("El nuevo legajo de alumno sugerido no es correcto.", entidades.nuevoLegajoAlumno().equals("ALU0002"));
        
        // Agregar profesores.
        Profesor profesorMartin = new Profesor("PRO0000", "Martin", "Mitre 1234", "12345678", "martin@mitre");
        Profesor profesorJose = new Profesor("PRO0001", "Jose", "Colon 2345", "23456789", "jose@colon");
        Profesor profesorJuan = new Profesor("PRO0003", "Juan", "Salta 3456", "34567890", "juan@salta");
        entidades.addProfesor(profesorMartin);
        entidades.addProfesor(profesorJose);
        entidades.addProfesor(profesorJuan);
        assertTrue("El nuevo legajo de profesor sugerido no es correcto.", entidades.nuevoLegajoProfesor().equals("PRO0002"));
        
        // Agregar cursadas.
        Cursada cursadaMatematica1  = new Cursada("CUR0000", matematica,  "01-2017", "Lun", "12:00", "14:00");
        Cursada cursadaQuimica1     = new Cursada("CUR0001", quimica,     "01-2017", "Lun", "13:00", "15:00");
        Cursada cursadaMatematica2  = new Cursada("CUR0003", matematica,  "02-2017", "Jue", "16:00", "18:00");
        entidades.addCursada(cursadaMatematica1);
        entidades.addCursada(cursadaQuimica1);
        entidades.addCursada(cursadaMatematica2);
        assertTrue("El nuevo Id de cursada sugerido no es correcto.", entidades.nuevoIdCursada().equals("CUR0002"));
    }
}
