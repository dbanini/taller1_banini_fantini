package pga_junit;

import java.util.ArrayList;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pga_controlador.Controlador;

import pga_modelo.Entidades;
import pga_modelo.Alumno;
import pga_modelo.Profesor;
import pga_modelo.Asignatura;
import pga_modelo.Cursada;

public class ControladorTest {
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
    
    private void setupEscenario_1_7() {
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
    
    private void setupEscenario_4_7() {
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
    
    private void setupEscenario_1_7_10() {
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
        Alumno alumnoMartin = new Alumno("ALU1234", "Martin", "Mitre 1234", "martin@mitre");
        Alumno alumnoJose = new Alumno("ALU2345", "Jose", "Colon 2345", "jose@colon");
        Alumno alumnoJuan = new Alumno("ALU3456", "Juan", "Salta 3456", "juan@salta");
        Alumno alumnoPedro = new Alumno("ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy");
        alumnoJuan.getAprobadas().add(quimica);
        alumnoPedro.getAprobadas().add(matematica);
        Profesor profesorJuan = new Profesor("PRO3456", "Juan", "Salta 3456", "34567890", "juan@salta");
        profesorJuan.getHabilitadas().add(quimica);
        profesorJuan.getHabilitadas().add(laboratorio);
        entidades.addAlumno(alumnoMartin);
        entidades.addAlumno(alumnoJose);
        entidades.addAlumno(alumnoJuan);
        entidades.addAlumno(alumnoPedro);
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
    
    private void setupEscenario_4_7_10() {
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
        Profesor profesorMartin = new Profesor("PRO1234", "Martin", "Mitre 1234", "12345678", "martin@mitre");
        Profesor profesorJose = new Profesor("PRO2345", "Jose", "Colon 2345", "23456789", "jose@colon");
        Profesor profesorJuan = new Profesor("PRO3456", "Juan", "Salta 3456", "34567890", "juan@salta");
        Profesor profesorPedro = new Profesor("PRO4567", "Pedro", "Jujuy 4567", "45678901", "pedro@jujuy");
        profesorJuan.getHabilitadas().add(quimica);
        profesorJuan.getHabilitadas().add(laboratorio);
        profesorPedro.getHabilitadas().add(matematica);
        entidades.addAlumno(alumnoJuan);
        entidades.addProfesor(profesorMartin);
        entidades.addProfesor(profesorJose);
        entidades.addProfesor(profesorJuan);
        entidades.addProfesor(profesorPedro);
        
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
    
    private void setupEscenario_1_4_7_10() {
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
        Alumno alumnoMartin = new Alumno("ALU1234", "Martin", "Mitre 1234", "martin@mitre");
        Alumno alumnoJose = new Alumno("ALU2345", "Jose", "Colon 2345", "jose@colon");
        Alumno alumnoJuan = new Alumno("ALU3456", "Juan", "Salta 3456", "juan@salta");
        Alumno alumnoPedro = new Alumno("ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy");
        alumnoJuan.getAprobadas().add(quimica);
        alumnoPedro.getAprobadas().add(matematica);
        Profesor profesorMartin = new Profesor("PRO1234", "Martin", "Mitre 1234", "12345678", "martin@mitre");
        Profesor profesorJose = new Profesor("PRO2345", "Jose", "Colon 2345", "23456789", "jose@colon");
        Profesor profesorJuan = new Profesor("PRO3456", "Juan", "Salta 3456", "34567890", "juan@salta");
        Profesor profesorPedro = new Profesor("PRO4567", "Pedro", "Jujuy 4567", "45678901", "pedro@jujuy");
        profesorJuan.getHabilitadas().add(quimica);
        profesorJuan.getHabilitadas().add(laboratorio);
        profesorPedro.getHabilitadas().add(matematica);
        entidades.addAlumno(alumnoMartin);
        entidades.addAlumno(alumnoJose);
        entidades.addAlumno(alumnoJuan);
        entidades.addAlumno(alumnoPedro);
        entidades.addProfesor(profesorMartin);
        entidades.addProfesor(profesorJose);
        entidades.addProfesor(profesorJuan);
        entidades.addProfesor(profesorPedro);
        
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
    
    /***********
     * ALUMNOS *
     ***********/
    
    @Test
    public void testAltaAlumno1_1() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumno = controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "maria@estrada", aprobadas);
        assertTrue("No se dio de alta al alumno.", entidades.getAlumnos().contains(alumno));
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test
    public void testAltaAlumno1_1_VL() {
        setupEscenario_3();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumno = controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "maria@estrada", aprobadas);
        assertTrue("No se dio de alta al alumno.", entidades.getAlumnos().contains(alumno));
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_2() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("PRO0123", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_3() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALUMARI", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_4() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_4_VL() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU012", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_5() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU01234567", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_5_VL() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU01234", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_6() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU1234", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_7() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno(null, "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_8() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU-123", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_9() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test
    public void testAltaAlumno2_1_VL() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumno = controlador.altaAlumno("ALU0123", "M", "Estrada 123", "maria@estrada", aprobadas);
        assertTrue("No se dio de alta al alumno.", entidades.getAlumnos().contains(alumno));
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("M"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno2_2() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno2_3() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", null, "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno2_4() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "M@ria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test
    public void testAltaAlumno3_1_VL() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumno = controlador.altaAlumno("ALU0123", "Maria", "E", "maria@estrada", aprobadas);
        assertTrue("No se dio de alta al alumno.", entidades.getAlumnos().contains(alumno));
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("E"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno3_2() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno3_3() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", null, "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno3_4() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "Estrad@ 123", "maria@estrada", aprobadas);
    }
    
    @Test
    public void testAltaAlumno4_1_VL() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumno = controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "m@e", aprobadas);
        assertTrue("No se dio de alta al alumno.", entidades.getAlumnos().contains(alumno));
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("m@e"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_2() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_3() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "maria@", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_4() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "mariaestrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_5() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_6() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", null, aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno5_1() {
        setupEscenario_1();
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "maria@estrada", null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno5_2() {
        setupEscenario_1();
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        aprobadas.add(null);
        controlador.altaAlumno("ALU0123", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test
    public void testBajaAlumno_1_1() {
        setupEscenario_1();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU1234");
        controlador.bajaAlumno(alumno);
        assertNotNull("No se encontro el alumno en la coleccion.", alumno);
        assertFalse("No se dio de baja al alumno.", entidades.getAlumnos().contains(alumno));
    }
    
    @Test
    public void testBajaAlumno_1_1_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        controlador.bajaAlumno(alumno);
        assertNotNull("No se encontro el alumno en la coleccion.", alumno);
        assertFalse("No se dio de baja al alumno.", entidades.getAlumnos().contains(alumno));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAlumno_1_2() {
        setupEscenario_1();
        Alumno alumno = new Alumno("ALU0123", "Maria", "Estrada 123", "maria@estrada");
        controlador.bajaAlumno(alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAlumno_1_2_VL() {
        setupEscenario_3();
        Alumno alumno = new Alumno("ALU0123", "Maria", "Estrada 123", "maria@estrada");
        controlador.bajaAlumno(alumno);
    }
    
    @Test
    public void testModificarAlumno1_1() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 456", "maria@estrada", aprobadas);
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 456"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_2() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "PRO0123", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_3() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALUMARI", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_4() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_4_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU012", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_5() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU01234567", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_5_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU01234", "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_6() {
        setupEscenario_1();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU1234");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU2345", "Martin", "Mitre 1234", "martin@mitre", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_7() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, null, "Maria", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test
    public void testModificarAlumno2_1_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "M", "Estrada 123", "maria@estrada", aprobadas);
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("M"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno2_2() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "", "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno2_3() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", null, "Estrada 123", "maria@estrada", aprobadas);
    }
    
    @Test
    public void testModificarAlumno3_1_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "E", "maria@estrada", aprobadas);
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("E"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("maria@estrada"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno3_2() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "", "maria@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno3_3() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", null, "maria@estrada", aprobadas);
    }
    
    @Test
    public void testModificarAlumno4_1_VL() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 123", "m@e", aprobadas);
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU0123"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("m@e"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_2() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 123", "@estrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_3() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 123", "maria@", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_4() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 123", "mariaestrada", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_5() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 123", "", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_6() {
        setupEscenario_2();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU0123");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        controlador.modificarAlumno(alumno, "ALU0123", "Maria", "Estrada 123", null, aprobadas);
    }
    
    @Test
    public void testModificarAlumno5_1() {
        setupEscenario_1_7();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU4567");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        Asignatura estadistica = entidades.buscaAsignaturaPorId("ASI3456");
        assertNotNull(matematica);
        assertNotNull(estadistica);
        aprobadas.add(matematica);
        aprobadas.add(estadistica);
        controlador.modificarAlumno(alumno, "ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy", aprobadas);
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU4567"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Pedro"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Jujuy 4567"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("pedro@jujuy"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().containsAll(aprobadas));
    }
    
    @Test
    public void testModificarAlumno5_1_VL() {
        setupEscenario_1_7();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU1234");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        assertNotNull(matematica);
        aprobadas.add(matematica);
        controlador.modificarAlumno(alumno, "ALU1234", "Martin", "Mitre 1234", "martin@mitre", aprobadas);
        assertTrue("No se modifico el legajo.", alumno.getLegajo().equals("ALU1234"));
        assertTrue("No se modifico el nombre.", alumno.getNombre().equals("Martin"));
        assertTrue("No se modifico el domicilio.", alumno.getDomicilio().equals("Mitre 1234"));
        assertTrue("No se modifico el mail.", alumno.getMail().equals("martin@mitre"));
        assertTrue("No se modificaron las aprobadas.", alumno.getAprobadas().containsAll(aprobadas));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_2() {
        setupEscenario_1_7();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU4567");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        assertNotNull(matematica);
        aprobadas.add(matematica);
        aprobadas.add(new Asignatura("ASI0123", "Fisica"));
        controlador.modificarAlumno(alumno, "ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_3() {
        setupEscenario_1_7();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU4567");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        Asignatura laboratorio = entidades.buscaAsignaturaPorId("ASI4567");
        assertNotNull(matematica);
        assertNotNull(laboratorio);
        aprobadas.add(matematica);
        aprobadas.add(laboratorio);
        controlador.modificarAlumno(alumno, "ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy", aprobadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_4() {
        setupEscenario_1_7();
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU4567");
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        assertNotNull(matematica);
        aprobadas.add(matematica);
        aprobadas.add(null);
        controlador.modificarAlumno(alumno, "ALU4567", "Pedro", "Jujuy 4567", "pedro@jujuy", aprobadas);
    }
    
    /**************
     * PROFESORES *
     **************/
    
    @Test
    public void testAltaProfesor1_1() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Profesor profesor = controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se dio de alta al profesor.", entidades.getProfesores().contains(profesor));
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test
    public void testAltaProfesor1_1_VL() {
        setupEscenario_6();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Profesor profesor = controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se dio de alta al profesor.", entidades.getProfesores().contains(profesor));
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_2() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("ALU0123", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_3() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PROMARI", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_4() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_4_VL() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO012", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_5() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO01234567", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_5_VL() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO01234", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_6() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO1234", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_7() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor(null, "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor1_8() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO-234", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testAltaProfesor2_1_VL() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Profesor profesor = controlador.altaProfesor("PRO0123", "M", "Estrada 123", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se dio de alta al profesor.", entidades.getProfesores().contains(profesor));
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("M"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor2_2() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor2_3() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", null, "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testAltaProfesor3_1_VL() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Profesor profesor = controlador.altaProfesor("PRO0123", "Maria", "E", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se dio de alta al profesor.", entidades.getProfesores().contains(profesor));
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("E"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor3_2() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor3_3() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", null, "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testAltaProfesor4_1_VL() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Profesor profesor = controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "m@e", "01234567", habilitadas);
        assertTrue("No se dio de alta al profesor.", entidades.getProfesores().contains(profesor));
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("m@e"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor4_2() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor4_3() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor4_4() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "mariaestrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor4_5() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor4_6() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", null, "01234567", habilitadas);
    }
    
    @Test
    public void testAltaProfesor5_1_VL() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Profesor profesor = controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", "0", habilitadas);
        assertTrue("No se dio de alta al profesor.", entidades.getProfesores().contains(profesor));
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("0"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor5_2() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", "", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor5_3() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", null, habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor6_1() {
        setupEscenario_4();
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", "01234567", null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesor6_2() {
        setupEscenario_4();
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        habilitadas.add(null);
        controlador.altaProfesor("PRO0123", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testBajaProfesor_1_1() {
        setupEscenario_4();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
        controlador.bajaProfesor(profesor);
        assertNotNull("No se encontro el profesor en la coleccion.", profesor);
        assertFalse("No se dio de baja al profesor.", entidades.getProfesores().contains(profesor));
    }
    
    @Test
    public void testBajaProfesor_1_1_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        controlador.bajaProfesor(profesor);
        assertNotNull("No se encontro el profesor en la coleccion.", profesor);
        assertFalse("No se dio de baja al profesor.", entidades.getProfesores().contains(profesor));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaProfesor_1_2() {
        setupEscenario_4();
        Profesor profesor = new Profesor("PRO0123", "Maria", "Estrada 123", "01234567", "maria@estrada");
        controlador.bajaProfesor(profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaProfesor_1_2_VL() {
        setupEscenario_6();
        Profesor profesor = new Profesor("PRO0123", "Maria", "Estrada 123", "01234567", "maria@estrada");
        controlador.bajaProfesor(profesor);
    }
    
    @Test
    public void testModificarProfesor1_1() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 456", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 456"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_2() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "ALU0123", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_3() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PROMARI", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_4() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_4_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO012", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_5() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO01234567", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_5_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO01234", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_6() {
        setupEscenario_4();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO2345", "Martin", "Mitre 1234", "martin@mitre", "12345678", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor1_7() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, null, "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testModificarProfesor2_1_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "M", "Estrada 123", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("M"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor2_2() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "", "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor2_3() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", null, "Estrada 123", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testModificarProfesor3_1_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "E", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("E"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor3_2() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "", "maria@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor3_3() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", null, "maria@estrada", "01234567", habilitadas);
    }
    
    @Test
    public void testModificarProfesor4_1_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "m@e", "01234567", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("m@e"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("01234567"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor4_2() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "@estrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor4_3() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "maria@", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor4_4() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "mariaestrada", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor4_5() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "", "01234567", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor4_6() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", null, "01234567", habilitadas);
    }
    
    @Test
    public void testModificarProfesor5_1_VL() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "maria@estrada", "0", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("maria@estrada"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("0"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor5_2() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "maria@estrada", "", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor5_3() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "maria@estrada", null, habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor5_4() {
        setupEscenario_5();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO0123");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "maria@estrada", "34234,543543", habilitadas);
    }
    
    @Test
    public void testModificarProfesor6_1() {
        setupEscenario_4_7();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO4567");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        assertNotNull(matematica);
        assertNotNull(quimica);
        habilitadas.add(matematica);
        habilitadas.add(quimica);
        controlador.modificarProfesor(profesor, "PRO4567", "Pedro", "Jujuy 4567", "pedro@jujuy", "45678901", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO4567"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Pedro"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Jujuy 4567"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("pedro@jujuy"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("45678901"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().containsAll(habilitadas));
    }
    
    @Test
    public void testModificarProfesor6_1_VL() {
        setupEscenario_4_7();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        assertNotNull(matematica);
        habilitadas.add(matematica);
        controlador.modificarProfesor(profesor, "PRO1234", "Martin", "Mitre 1234", "martin@mitre", "12345678", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO1234"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Martin"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Mitre 1234"));
        assertTrue("No se modifico el mail.", profesor.getMail().equals("martin@mitre"));
        assertTrue("No se modifico el telefono.", profesor.getTelefono().equals("12345678"));
        assertTrue("No se modificaron las habilitadas.", profesor.getHabilitadas().containsAll(habilitadas));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor6_2() {
        setupEscenario_4_7();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO4567");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        assertNotNull(matematica);
        habilitadas.add(matematica);
        habilitadas.add(new Asignatura("ASI0123", "Fisica"));
        controlador.modificarProfesor(profesor, "PRO4567", "Pedro", "Jujuy 4567", "pedro@jujuy", "45678901", habilitadas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarProfesor6_3() {
        setupEscenario_4_7();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO4567");
        ArrayList<Asignatura> habilitadas = new ArrayList<Asignatura>();
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        assertNotNull(matematica);
        habilitadas.add(matematica);
        habilitadas.add(null);
        controlador.modificarProfesor(profesor, "PRO4567", "Pedro", "Jujuy 4567", "pedro@jujuy", "45678901", habilitadas);
    }
    
    /***************
     * ASIGNATURAS *
     ***************/
    
    @Test
    public void testAltaAsignatura1_1(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        Asignatura asignatura = controlador.altaAsignatura("ASI0123", "Fisica", correlativas);
        assertTrue("No se dio de alta la asignatura.", entidades.getAsignaturas().contains(asignatura));
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI0123"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("Fisica"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test
    public void testAltaAsignatura1_1_VL(){
        setupEscenario_9();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        Asignatura asignatura = controlador.altaAsignatura("ASI0123", "Fisica", correlativas);
        assertTrue("No se dio de alta la asignatura.", entidades.getAsignaturas().contains(asignatura));
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI0123"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("Fisica"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_2(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("CUR0123", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_3(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASIFISI", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_4(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_4_VL(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI012", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_5(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI01234567", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_5_VL(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI01234", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_6(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura(null, "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura1_7(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI-123", "Fisica", correlativas);
    }
    
    @Test
    public void testAltaAsignatura2_1_VL(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        Asignatura asignatura = controlador.altaAsignatura("ASI0123", "F", correlativas);
        assertTrue("No se dio de alta la asignatura.", entidades.getAsignaturas().contains(asignatura));
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI0123"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("F"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura2_2(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI0123", "", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura2_3(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI0123", null, correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura2_4(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.altaAsignatura("ASI0123", "F!sica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura3_1(){
        setupEscenario_7();
        controlador.altaAsignatura("ASI0123", "Fisica", null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAsignatura3_2(){
        setupEscenario_7();
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        correlativas.add(null);
        controlador.altaAsignatura("ASI0123", "Fisica", correlativas);
    }
    
    @Test
    public void testBajaAsignatura1_1() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI3456");
        controlador.bajaAsignatura(asignatura);
        assertNotNull(asignatura);
        assertFalse(entidades.getAsignaturas().contains(asignatura));
    }
    
    @Test
    public void testBajaAsignatura1_1_VL() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        controlador.bajaAsignatura(asignatura);
        assertNotNull(asignatura);
        assertFalse(entidades.getAsignaturas().contains(asignatura));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAsignatura1_2() {
        setupEscenario_7();
        Asignatura asignatura = new Asignatura("ASI0123", "Fisica");
        controlador.bajaAsignatura(asignatura);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAsignatura1_2_VL() {
        setupEscenario_9();
        Asignatura asignatura = new Asignatura("ASI0123", "Fisica");
        controlador.bajaAsignatura(asignatura);
    }
    
    @Test
    public void testModificarAsignatura1_1(){
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI2345", "Quimica", correlativas);
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI2345"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("Quimica"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_2() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "CUR0123", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_3() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASIFISI", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_4() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_4_VL() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI012", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_5() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI01234567", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_5_VL() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI01234", "Fisica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_6() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI1234");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI2345", "Matematica", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_7() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, null, "Fisica", correlativas);
    }
    
    @Test
    public void testModificarAsignatura2_1_VL(){
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI0123", "F", correlativas);
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI0123"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("F"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura2_2() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI0123", "", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura2_3() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI0123", null, correlativas);
    }
    
    @Test
    public void testModificarAsignatura3_1(){
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI4567");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        Asignatura asignaturaQuimica = entidades.buscaAsignaturaPorId("ASI2345");
        Asignatura asignaturaMatematica = entidades.buscaAsignaturaPorId("ASI1234");
        correlativas.add(asignaturaQuimica);
        correlativas.add(asignaturaMatematica);
        controlador.modificarAsignatura(asignatura, "ASI4567", "Laboratorio", correlativas);
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI4567"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("Laboratorio"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().containsAll(correlativas));
    }
    
    @Test
    public void testModificarAsignatura3_1_VL(){
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI2345");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        Asignatura asignaturaMatematica = entidades.buscaAsignaturaPorId("ASI1234");
        correlativas.add(asignaturaMatematica);
        controlador.modificarAsignatura(asignatura, "ASI2345", "Quimica", correlativas);
        assertTrue("No se modifico el Id.", asignatura.getId().equals("ASI2345"));
        assertTrue("No se modifico el nombre.", asignatura.getNombre().equals("Quimica"));
        assertTrue("No se modificaron las correlativas.", asignatura.getCorrelativas().containsAll(correlativas));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura3_2() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI4567");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        Asignatura fisica = new Asignatura("ASI0123", "Fisica");
        correlativas.add(entidades.buscaAsignaturaPorId("ASI2345"));
        correlativas.add(fisica);
        controlador.modificarAsignatura(asignatura, "ASI0123", "Laboratorio", correlativas);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura3_3() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI4567");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        correlativas.add(entidades.buscaAsignaturaPorId("ASI2345"));
        correlativas.add(null);
        controlador.modificarAsignatura(asignatura, "ASI0123", "Laboratorio", correlativas);
    }
    
    /***************
     *  CURSADAS   *
     ***************/            
    @Test
    public void testAltaCursada1_1(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        Cursada nuevaCursada = controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
        assertTrue("No se dio de alta la cursada.", entidades.getCursadas().contains(nuevaCursada));
        assertTrue("No se asigno el Id.", nuevaCursada.getId().equals("CUR0123"));
        assertTrue("No se asigno la asignatura.", nuevaCursada.getAsignatura() == quimica);
        assertTrue("No se asigno el periodo.", nuevaCursada.getPeriodo().equals("02-2017"));
        assertTrue("No se asigno el dia.", nuevaCursada.getDia().equals("Sab"));
        assertTrue("No se asigno la hora inicio.", nuevaCursada.getHoraInicio().equals("08:00"));
        assertTrue("No se asigno la hora fin.", nuevaCursada.getHoraFin().equals("11:00"));
        assertTrue("No se asigno la lista de alumnos.", nuevaCursada.getAlumnos().isEmpty());
        assertTrue("No se asigno la lista de profesores.", nuevaCursada.getProfesores().isEmpty());
    }
    
    @Test
    public void testAltaCursada1_1_VL(){
        setupEscenario_7_12();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        Cursada nuevaCursada = controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
        assertTrue("No se dio de alta la cursada.", entidades.getCursadas().contains(nuevaCursada));
        assertTrue("No se asigno el Id.", nuevaCursada.getId().equals("CUR0123"));
        assertTrue("No se asigno la asignatura.", nuevaCursada.getAsignatura() == quimica);
        assertTrue("No se asigno el periodo.", nuevaCursada.getPeriodo().equals("02-2017"));
        assertTrue("No se asigno el dia.", nuevaCursada.getDia().equals("Sab"));
        assertTrue("No se asigno la hora inicio.", nuevaCursada.getHoraInicio().equals("08:00"));
        assertTrue("No se asigno la hora fin.", nuevaCursada.getHoraFin().equals("11:00"));
        assertTrue("No se asigno la lista de alumnos.", nuevaCursada.getAlumnos().isEmpty());
        assertTrue("No se asigno la lista de profesores.", nuevaCursada.getProfesores().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_2(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("ASI0123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_3(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CURFISI", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_4(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_4_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR012", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_5(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR01234567", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_5_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR01234", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_6(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR1234", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_7(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada(null, quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada1_8(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR-123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada2_2(){
        setupEscenario_7_10();
        Asignatura fisica = new Asignatura("ASI0123", "Fisica");
        controlador.altaCursada("CUR0123", fisica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada2_3(){
        setupEscenario_7_10();
        controlador.altaCursada("CUR0123", null, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_2(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "55-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_3(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02+2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_4(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-ANIO", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_5(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_5_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-201", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_6(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-20172017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_6_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-20177", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_7(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-1800", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada3_8(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2500", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_2(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "HH:00", "HH:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_3(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:MM", "11:MM", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_4(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08/00", "11/00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_5(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "30:00", "40:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_5_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "24:00", "24:01", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_6(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:90", "11:90", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_6_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:60", "11:60", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_7(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08", "11", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_7_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:0", "11:0", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_8(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00:00", "11:00:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_8_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:000", "11:000", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_9(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "13:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_9_VL(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "11:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_10(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "-8:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_11(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:-1", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada4_12(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "30:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada6_2(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Dia", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada6_3(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", null, "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada7_1(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00", null, new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada7_2(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(null);
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00", alumnos, new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada8_1(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaCursada8_2(){
        setupEscenario_7_10();
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        profesores.add(null);
        controlador.altaCursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), profesores);
    }
    
    @Test
    public void testBajaCursada1_1() {
        setupEscenario_7_10();
        Cursada cursadaQuimica = entidades.buscaCursadaPorId("CUR2345");
        controlador.bajaCursada(cursadaQuimica);
        assertNotNull(cursadaQuimica);
        assertFalse(entidades.getCursadas().contains(cursadaQuimica));
    }
    
    @Test
    public void testBajaCursada1_1_VL() {
        setupEscenario_7_11();
        Cursada cursadaQuimica = entidades.buscaCursadaPorId("CUR0123");
        controlador.bajaCursada(cursadaQuimica);
        assertNotNull(cursadaQuimica);
        assertFalse(entidades.getCursadas().contains(cursadaQuimica));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaCursada1_2() {
        setupEscenario_7_10();
        Asignatura quimica = new Asignatura("ASI2345", "Quimica");
        Cursada cursadaQuimica = new Cursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00");
        controlador.bajaCursada(cursadaQuimica);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaCursada1_2_VL() {
        setupEscenario_7_12();
        Asignatura quimica = new Asignatura("ASI2345", "Quimica");
        Cursada cursadaQuimica = new Cursada("CUR0123", quimica, "02-2017", "Sab", "08:00", "11:00");
        controlador.bajaCursada(cursadaQuimica);
    }
    
    @Test
    public void testModificarCursada1_1(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        controlador.modificarCursada(cursada, "CUR1234", matematica, "01-2017", "Lun", "12:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
        assertTrue("No se modifico el Id.", cursada.getId().equals("CUR1234"));
        assertTrue("No se modifico la asignatura.", cursada.getAsignatura() == matematica);
        assertTrue("No se modifico el periodo.", cursada.getPeriodo().equals("01-2017"));
        assertTrue("No se modifico el dia.", cursada.getDia().equals("Lun"));
        assertTrue("No se modifico la hora inicio.", cursada.getHoraInicio().equals("12:00"));
        assertTrue("No se modifico la hora fin.", cursada.getHoraFin().equals("14:00"));
        assertTrue("No se modifico la lista de alumnos.", cursada.getAlumnos().isEmpty());
        assertTrue("No se modifico la lista de profesores.", cursada.getProfesores().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_2(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "ASI0123", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_3(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CURFISI", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_4(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_4_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR012", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_5(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR01234567", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_5_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR01234", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_6(){
        setupEscenario_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR1234");
        Asignatura matematica = entidades.buscaAsignaturaPorId("ASI1234");
        controlador.modificarCursada(cursada, "CUR2345", matematica, "01-2017", "Lun", "12:00", "14:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_7(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, null, quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada2_2(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura fisica = new Asignatura("ASI0123", "Fisica");
        controlador.modificarCursada(cursada, "CUR0123", fisica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_2(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "55-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_3(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02+2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_4(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-ANIO", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_5(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_5_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-201", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_6(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-20172017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada3_6_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-20177", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test
    public void testModificarCursada4_1_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "23:58", "23:59", new ArrayList<Alumno>(), new ArrayList<Profesor>());
        assertTrue("No se modifico el Id.", cursada.getId().equals("CUR0123"));
        assertTrue("No se modifico la asignatura.", cursada.getAsignatura() == quimica);
        assertTrue("No se modifico el periodo.", cursada.getPeriodo().equals("02-2017"));
        assertTrue("No se modifico el dia.", cursada.getDia().equals("Sab"));
        assertTrue("No se modifico la hora inicio.", cursada.getHoraInicio().equals("23:58"));
        assertTrue("No se modifico la hora fin.", cursada.getHoraFin().equals("23:59"));
        assertTrue("No se modifico la lista de alumnos.", cursada.getAlumnos().isEmpty());
        assertTrue("No se modifico la lista de profesores.", cursada.getProfesores().isEmpty());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_2(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "HH:00", "HH:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_3(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08:MM", "11:MM", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_4(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08/00", "11/00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_5(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "30:00", "40:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_5_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "24:00", "24:01", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_6(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08:90", "11:90", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_6_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08:60", "11:60", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_7(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08", "11", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_7_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08:0", "11:0", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_8(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08:00:00", "11:00:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_8_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "08:000", "11:000", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_9(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "13:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_9_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "11:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada6_2(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Dia", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada6_3(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", null, "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
    }
    
    @Test
    public void testAltaAlumnoCursada_1_1() {
        setupEscenario_1_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR4567");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU3456");
        controlador.altaCursadaAlumno(cursada, alumno);
        assertTrue("El alumno no fue agregado a la cursada.", cursada.getAlumnos().contains(alumno));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumnoCursada_1_2() {
        setupEscenario_1_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR4567");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU4567");
        controlador.altaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumnoCursada_1_3() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR5678");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU3456");
        controlador.altaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumnoCursada_1_4() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR3456");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU3456");
        controlador.altaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumnoCursada_1_5() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        controlador.altaCursadaAlumno(cursada, null);
    }
    
    @Test
    public void testBajaAlumnoCursada_1_1() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR5678");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU3456");
        controlador.bajaCursadaAlumno(cursada, alumno);
        assertNotNull(cursada);
        assertNotNull(alumno);
        assertFalse("El alumno no fue quitado a la cursada.", cursada.getAlumnos().contains(alumno));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAlumnoCursada_1_2() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR5678");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU1234");
        controlador.bajaCursadaAlumno(cursada, alumno);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAlumnoCursada_1_2_VL() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        Alumno alumno = entidades.buscaAlumnoPorLegajo("ALU3456");
        controlador.bajaCursadaAlumno(cursada, alumno);
    }
    
    @Test
    public void testAltaProfesorCursada_1_1() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO3456");
        controlador.altaCursadaProfesor(cursada, profesor);
        assertTrue("El profesor no fue agregado a la cursada.", cursada.getProfesores().contains(profesor));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesorCursada_1_2() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO4567");
        controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesorCursada_1_3() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR4567");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO3456");
        controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesorCursada_1_4() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR6789");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO3456");
        controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesorCursada_1_5() {
        setupEscenario_1_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        controlador.altaCursadaProfesor(cursada, null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesorCursada_1_6() {
    	setupEscenario_4_7_10();
    	Cursada cursada = controlador.altaCursada("CUR5342", entidades.buscaAsignaturaPorId("ASI2345"), "02-2017", "Mié", "17:00", "20:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO3456");
        controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaProfesorCursada_1_7() {
    	setupEscenario_4_7_10();
    	Cursada cursada = controlador.altaCursada("CUR5342", entidades.buscaAsignaturaPorId("ASI2345"), "02-2017", "Mié", "18:00", "19:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO3456");
        controlador.altaCursadaProfesor(cursada, profesor);
    }
    
    @Test
    public void testBajaProfesorCursada_1_1() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR4567");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO3456");
        controlador.bajaCursadaProfesor(cursada, profesor);
        assertNotNull(cursada);
        assertNotNull(profesor);
        assertFalse("El profesor no fue quitado a la cursada.", cursada.getAlumnos().contains(profesor));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaProfesorCursada_1_2() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR4567");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
        controlador.bajaCursadaProfesor(cursada, profesor);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaProfesorCursada_1_2_VL() {
        setupEscenario_4_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
        controlador.bajaCursadaProfesor(cursada, profesor);
    }
}
