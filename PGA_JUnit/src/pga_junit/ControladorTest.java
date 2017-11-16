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
    Entidades entidades;
    Controlador controlador;
    
    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------
    
    @Before
    public void setupEscenario() {
            entidades = new Entidades();
            controlador = new Controlador(entidades);
    }
    
    /*
    private void setupEscenario1(){
        
        //Colecciones entidades
        ArrayList<Asignatura> aprobadasAlumno3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno4 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI2345","Quimica");
        Asignatura asignatura2 = new Asignatura("ASI1234","Matematica");
        
        //Agrega a colecciones
        aprobadasAlumno3.add(asignatura1);
        aprobadasAlumno4.add(asignatura2);
        
        //Alumnos
        Alumno alumno1 = new Alumno("ALU1234","Martin","Mitre 1234","martin@mitre");
        Alumno alumno2 = new Alumno("ALU2345","Jose","Color 2345","jose@colon");
        Alumno alumno3 = new Alumno("ALU3456","Juan","Salta 3456","juan@salta",aprobadasAlumno3);
        Alumno alumno4 = new Alumno("ALU4567","Pedro","Jujuy 4567","pedro@jujuy",aprobadasAlumno4);
        
        //Profesores

        //Cursadas
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
        entidades.addAsignatura(asignatura2);
        entidades.addAlumno(alumno1);
        entidades.addAlumno(alumno2);
        entidades.addAlumno(alumno3);
        entidades.addAlumno(alumno4);
    }
    
    private void setupEscenario2(){
        
        //Alumnos
        Alumno alumno1 = new Alumno("ALU0123","Maria","Estrada 123","maria@estrada");
        
        //Agregar a entidades
        entidades.addAlumno(alumno1);
    }
    
    private void setupEscenario3(){
        
    }
    
    private void setupEscenario4() {
	
        //Colecciones Entidades
        ArrayList<Asignatura> habilitadasProfesor3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> habilitadasProfesor4 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI2345","Quimica");
        Asignatura asignatura2 = new Asignatura("ASI1234","Matematica");
        Asignatura asignatura3 = new Asignatura("ASI4567","Laboratorio");
        
        //Agrega a colecciones
        habilitadasProfesor3.add(asignatura1);
        habilitadasProfesor3.add(asignatura3);
        habilitadasProfesor4.add(asignatura2);
        
        //Alumnos
        
        //Profesores
        Profesor profesor1 = new Profesor("PRO1234","Martin","Mitre 1234","12345678","martin@mitre");
        Profesor profesor2 = new Profesor("PRO2345","Jose","Color 2345","23456789","jose@colon");
        Profesor profesor3 = new Profesor("PRO3456","Juan","Salta 3456","34567890","juan@salta",habilitadasProfesor3);
        Profesor profesor4 = new Profesor("PRO4567","Pedro","Jujuy 4567","45678901","pedro@jujuy",habilitadasProfesor4);
        
        //Cursadas
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
        entidades.addAsignatura(asignatura2);
        entidades.addAsignatura(asignatura3);
        entidades.addProfesor(profesor1);
        entidades.addProfesor(profesor2);
        entidades.addProfesor(profesor3);
        entidades.addProfesor(profesor4);
    }
    
    private void setupEscenario5(){
        
        //Profesores
        Profesor profesor1 = new Profesor("PRO0123","Maria","Estrada 123","01234567","maria@estrada");
        
        //Agregar a entidades
        entidades.addProfesor(profesor1);
    }
    
    private void setupEscenario6(){
        
    }

    private void setupEscenario7(){
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura4 = new ArrayList<Asignatura>();     
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI1234","Matematica");
        Asignatura asignatura2 = new Asignatura("ASI2345","Quimica");
        
        correlativasAsignatura3.add(asignatura1);
        correlativasAsignatura4.add(asignatura2);
        
        Asignatura asignatura3 = new Asignatura("ASI3456","Estadistica",correlativasAsignatura3);
        Asignatura asignatura4 = new Asignatura("ASI4567","Laboratorio",correlativasAsignatura4);
        Asignatura asignatura5 = new Asignatura("ASI5678","Computacion");
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
        entidades.addAsignatura(asignatura2);
        entidades.addAsignatura(asignatura3);
        entidades.addAsignatura(asignatura4);
        entidades.addAsignatura(asignatura5);
    }
    
    private void setupEscenario8(){
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI0123","Fisica");
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
    }
    
    private void setupEscenario9(){
        
    }

    private void setupEscenario10(){
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura4 = new ArrayList<Asignatura>();
        ArrayList<Profesor> profesoresCursada4 = new ArrayList<Profesor>();
        ArrayList<Profesor> profesoresCursada5 = new ArrayList<Profesor>();
        ArrayList<Alumno> alumnosCursada4 = new ArrayList<Alumno>();
        ArrayList<Alumno> alumnosCursada5 = new ArrayList<Alumno>();
        ArrayList<Asignatura> habilitadasProfesor3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno3 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI1234","Matematica");
        Asignatura asignatura2 = new Asignatura("ASI2345","Quimica");
        
        correlativasAsignatura3.add(asignatura1);
        correlativasAsignatura4.add(asignatura2);
        
        Asignatura asignatura3 = new Asignatura("ASI3456","Estadistica",correlativasAsignatura3);
        
        Asignatura asignatura4 = new Asignatura("ASI4567","Laboratorio",correlativasAsignatura4);
        Asignatura asignatura5 = new Asignatura("ASI5678","Computacion");
        
        habilitadasProfesor3.add(asignatura1);
        habilitadasProfesor3.add(asignatura3);
        aprobadasAlumno3.add(asignatura2);
        
        //Agrega a colecciones
        aprobadasAlumno3.add(asignatura1);
        
        //Alumnos
        Alumno alumno3 = new Alumno("ALU3456","Juan","Salta 3456","juan@salta",aprobadasAlumno3);
        
        //Profesores
        Profesor profesor3 = new Profesor("PRO3456","Juan","Salta 3456","34567890","juan@salta",habilitadasProfesor3);

        //Cursadas
        profesoresCursada4.add(profesor3);
        alumnosCursada5.add(alumno3);
        
        Cursada cursada1 = new Cursada("CUR1234",asignatura1,"01-2017","Lun","12:00","14:00");
        Cursada cursada2 = new Cursada("CUR2345",asignatura2,"01-2017","Lun","13:00","15:00");
        Cursada cursada3 = new Cursada("CUR3456",asignatura1,"02-2017","Jue","16:00","18:00");
        Cursada cursada4 = new Cursada("CUR4567",asignatura4,"02-2017","Mie","17:00","19:00",profesoresCursada4,alumnosCursada4);
        Cursada cursada5 = new Cursada("CUR5678",asignatura5,"02-2017","Jue","15:00","17:00",profesoresCursada5,alumnosCursada5);
        Cursada cursada6 = new Cursada("CUR6789",asignatura2,"02-2017","Mie","16:00","18:00");
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
        entidades.addAsignatura(asignatura2);
        entidades.addAsignatura(asignatura4);
        entidades.addAsignatura(asignatura5);
        entidades.addProfesor(profesor3);
        entidades.addAlumno(alumno3);
        entidades.addCursada(cursada1);
        entidades.addCursada(cursada2);
        entidades.addCursada(cursada3);
        entidades.addCursada(cursada4);
        entidades.addCursada(cursada5);
        entidades.addCursada(cursada6);
    }
    
    private void setupEscenario11(){
        
        //Asignaturas
        Asignatura asignatura2 = new Asignatura("ASI2345","Quimica");
        
        //Cursadas
        Cursada cursada1 = new Cursada("CUR0123",asignatura2,"02-2017","Sab","08:00","11:00");
        
        //Agregar a entidades
        entidades.addCursada(cursada1);
    }
    
    private void setupEscenario12() {
        
    }
*/
    
    /**
     * Nuevo formato de escenarios.
     */
    private void setupEscenario_1() {
        // todo
    }
    
    private void setupEscenario_2() {
        // todo
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
        Cursada cursadaLaboratorio  = new Cursada("CUR4567", laboratorio, "02-2017", "Mi�", "17:00", "19:00");
        Cursada cursadaComputacion  = new Cursada("CUR5678", computacion, "02-2017", "Jue", "15:00", "17:00");
        Cursada cursadaQuimica2     = new Cursada("CUR6789", quimica,     "02-2017", "Mi�", "16:00", "18:00");
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
        Cursada cursadaLaboratorio  = new Cursada("CUR4567", laboratorio, "02-2017", "Mi�", "17:00", "19:00");
        Cursada cursadaComputacion  = new Cursada("CUR5678", computacion, "02-2017", "Jue", "15:00", "17:00");
        Cursada cursadaQuimica2     = new Cursada("CUR6789", quimica,     "02-2017", "Mi�", "16:00", "18:00");
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
        Cursada cursadaLaboratorio  = new Cursada("CUR4567", laboratorio, "02-2017", "Mi�", "17:00", "19:00");
        Cursada cursadaComputacion  = new Cursada("CUR5678", computacion, "02-2017", "Jue", "15:00", "17:00");
        Cursada cursadaQuimica2     = new Cursada("CUR6789", quimica,     "02-2017", "Mi�", "16:00", "18:00");
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
        Cursada cursadaLaboratorio  = new Cursada("CUR4567", laboratorio, "02-2017", "Mi�", "17:00", "19:00");
        Cursada cursadaComputacion  = new Cursada("CUR5678", computacion, "02-2017", "Jue", "15:00", "17:00");
        Cursada cursadaQuimica2     = new Cursada("CUR6789", quimica,     "02-2017", "Mi�", "16:00", "18:00");
        cursadaLaboratorio.getProfesores().add(profesorJuan);
        cursadaComputacion.getAlumnos().add(alumnoJuan);
        entidades.addCursada(cursadaMatematica1);
        entidades.addCursada(cursadaQuimica1);
        entidades.addCursada(cursadaMatematica2);
        entidades.addCursada(cursadaLaboratorio);
        entidades.addCursada(cursadaComputacion);
        entidades.addCursada(cursadaQuimica2);
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /*
    @Test
    public void testCrearAlumnoVacio(){
        setupEscenario1();
        Assert.assertNotNull(controlador.crearAlumnoVacio());
    }
    
    // -----------------------------------------------------------------
    // Alta alumnos (22)
    // -----------------------------------------------------------------
            
    @Test
    public void testAltaAlumno1_1(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        assertTrue(entidades.getAlumnos().contains(alumnoAgregado));
    }
    
    @Test
    public void testAltaAlumno1_1_VL(){
        setupEscenario3();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        assertTrue(entidades.getAlumnos().contains(alumnoAgregado));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_2(){
        setupEscenario1();
        String legajo="PRO0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_3(){
        setupEscenario1();
        String legajo="ALUMARI";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_4(){
        setupEscenario1();
        String legajo="ALU";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_4_VL(){
        setupEscenario1();
        String legajo="ALU012";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_5(){
        setupEscenario1();
        String legajo="ALU01234567";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_5_VL(){
        setupEscenario1();
        String legajo="ALU01234";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_6(){
        setupEscenario1();
        String legajo="ALU1234";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno1_7(){
        setupEscenario1();
        String legajo=null;
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test
    public void testAltaAlumno2_1_VL(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="M";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        assertTrue(entidades.getAlumnos().contains(alumnoAgregado));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno2_2(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="";
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno2_3(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre=null;
        String domicilio="Estrada 123";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test
    public void testAltaAlumno3_1_VL(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="E";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        assertTrue(entidades.getAlumnos().contains(alumnoAgregado));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno3_2(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="";
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno3_3(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio=null;
        String mail="maria@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test
    public void testAltaAlumno4_1_VL(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="m@e";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        assertTrue(entidades.getAlumnos().contains(alumnoAgregado));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_2(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="@estrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_3(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="maria@";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_4(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="mariaestrada";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_5(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail="";
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testAltaAlumno4_6(){
        setupEscenario1();
        String legajo="ALU0123";
        String nombre="Maria";
        String domicilio="Estrada 123";
        String mail=null;
        ArrayList<Asignatura> aprobadas = new ArrayList<Asignatura>();
        Alumno alumnoAgregado=controlador.altaAlumno(legajo, nombre, domicilio, mail, aprobadas);
        entidades.getAlumnos().contains(alumnoAgregado);
    }
    
    // -----------------------------------------------------------------
    // Baja alumnos (4)
    // -----------------------------------------------------------------
    
    @Test
    public void testBajaAlumno1_1(){
        setupEscenario1();
        Alumno alumnoBaja=entidades.getAlumnos().get(0);
        
        assertTrue (controlador.bajaAlumno(alumnoBaja));
    }
    
    @Test 
    public void testBajaAlumno1_1_VL(){
        setupEscenario2();
        Alumno alumnoBaja=entidades.getAlumnos().get(0);
        
        assertTrue (controlador.bajaAlumno(alumnoBaja));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAlumno1_2(){
        setupEscenario1();
        Alumno alumnoBaja=new Alumno();
        
        controlador.bajaAlumno(alumnoBaja);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testBajaAlumno1_2_VL(){
        setupEscenario3();
        Alumno alumnoBaja=new Alumno();
        
        controlador.bajaAlumno(alumnoBaja);
    }
    
    // -----------------------------------------------------------------
    // Modificar alumno (31)
    // -----------------------------------------------------------------
    
    @Test
    public void testModificarAlumno1_1(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_2(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="PRO123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_3(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALUMARI";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_4(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_4_VL(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU012";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_5(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU01234567";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_5_VL(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU01234";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_6(){
        setupEscenario1();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU2345";
        String nombreNuevo="Martin";
        String domicilioNuevo="Mitre 1234";
        String mailNuevo="martin@mitre";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno1_7(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo=null;
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test
    public void testModificarAlumno2_1_VL(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="M";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno2_2(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno2_3(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo=null;
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test
    public void testModificarAlumno3_1_VL(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="E";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno3_2(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="";
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno3_3(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo=null;
        String mailNuevo="maria@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test
    public void testModificarAlumno4_1_VL(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="m@e";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_2(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="@estrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_3(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="maria@";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_4(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="mariaestrada";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_5(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo="";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno4_6(){
        setupEscenario2();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        
        String legajoNuevo="ALU0123";
        String nombreNuevo="Maria";
        String domicilioNuevo="Estrada 123";
        String mailNuevo=null;
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test
    public void testModificarAlumno5_1_1(){
        setupEscenario1();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        Asignatura asignatura2= entidades.buscaAsignaturaPorId("3456");
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test
    public void testModificarAlumno5_1_2(){
        setupEscenario7();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        Asignatura asignatura2= entidades.buscaAsignaturaPorId("3456");
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test
    public void testModificarAlumno5_1_VL(){
        setupEscenario1();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU1234";
        String nombreNuevo="Martin";
        String domicilioNuevo="Mitre 1234";
        String mailNuevo="martin@mitre";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        
        aprobadasNuevo.add(asignatura1);
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test
    public void testModificarAlumno5_1_VL2(){
        setupEscenario7();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU1234";
        String nombreNuevo="Martin";
        String domicilioNuevo="Mitre 1234";
        String mailNuevo="martin@mitre";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        
        aprobadasNuevo.add(asignatura1);
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_2_1(){
        setupEscenario1();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        
        //No esta en el sistema, debo crearla o buscarla?
        Asignatura asignatura2= new Asignatura("ASI0123","Fisica");
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_2_2(){
        setupEscenario7();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        
        //No esta en el sistema, debo crearla o buscarla?
        Asignatura asignatura2= new Asignatura("ASI0123","Fisica");
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_3_1(){
        setupEscenario1();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        
        //No esta en el sistema, debo crearla o buscarla?
        Asignatura asignatura2= new Asignatura("ASI4567","Laboratorio");
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_3_2(){
        setupEscenario7();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        
        //No esta en el sistema, debo crearla o buscarla?
        Asignatura asignatura2= new Asignatura("ASI4567","Laboratorio");
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_4_1(){
        setupEscenario1();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        Asignatura asignatura2= null;
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAlumno5_4_2(){
        setupEscenario7();
        
        Alumno testAlumno=entidades.getAlumnos().get(0);
        //TODO que alumno se modifica?
        String legajoNuevo="ALU4567";
        String nombreNuevo="Pedro";
        String domicilioNuevo="Jujuy 4567";
        String mailNuevo="pedro@jujuy";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();
        
        Asignatura asignatura1= entidades.buscaAsignaturaPorId("1234");
        Asignatura asignatura2= null;
        
        aprobadasNuevo.add(asignatura1);
        aprobadasNuevo.add(asignatura2);
        
        controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo);
    }
    
    @Test
    public void testConsultarAlumno1_1(){
        setupEscenario1();
        
        Alumno alumnoEncontrado=entidades.buscaAlumnoPorLegajo("ALU1234");
        Alumno alumnoEsperado=entidades.getAlumnos().get(0);
        Assert.assertEquals(alumnoEsperado,alumnoEncontrado);
    }
    
    @Test
    public void testConsultarAlumno1_1_V1(){
        setupEscenario2();
        
        Alumno alumnoEncontrado=entidades.buscaAlumnoPorLegajo("ALU0123");
        Alumno alumnoEsperado=entidades.getAlumnos().get(0);
        Assert.assertEquals(alumnoEsperado,alumnoEncontrado);
    }
    
    @Test
    public void testConsultarAlumno1_2(){
        setupEscenario1();
        
        Alumno alumnoEncontrado=entidades.buscaAlumnoPorLegajo("ALU0123");
        Alumno alumnoEsperado=entidades.getAlumnos().get(0);
        Assert.assertNotEquals(alumnoEsperado,alumnoEncontrado);
    }
    
    @Test
    public void testConsultarAlumno1_2_V1(){
        setupEscenario3();
        
        Alumno alumnoEncontrado=entidades.buscaAlumnoPorLegajo("ALU0123");
        Alumno alumnoEsperado= new Alumno("ALU0123","Maria","Estrada 123","maria@estrada");
        Assert.assertNotEquals(alumnoEsperado,alumnoEncontrado);
    }
    
    @Test
    public void testBuscarAlumno1_1(){
        setupEscenario4();
        
    }
    
    @Test
    public void testBuscarAlumno1_1_V1(){
        setupEscenario5();
        
    }
    
    @Test
    public void testBuscarAlumno1_2(){
        setupEscenario4();
        
    }
    
    @Test
    public void testBuscarAlumno1_2_V1(){
        setupEscenario6();
        
    }
    */
    
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
        controlador.modificarProfesor(profesor, "PRO0123", "Maria", "Estrada 123", "maria@estrada", "01234567", habilitadas);
        assertTrue("No se modifico el legajo.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("No se modifico el nombre.", profesor.getNombre().equals("Maria"));
        assertTrue("No se modifico el domicilio.", profesor.getDomicilio().equals("Estrada 123"));
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
        setupEscenario_4();
        Profesor profesor = entidades.buscaProfesorPorLegajo("PRO1234");
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
        assertFalse("No se encontraron profesores con ese nombre.", profesores.isEmpty());
        Profesor profesor = profesores.get(0);
        assertTrue("El profesor retornado no tiene el legajo correcto.", profesor.getLegajo().equals("PRO1234"));
        assertTrue("El profesor retornado no tiene el nombre correcto.", profesor.getNombre().equals("Martin"));
        assertTrue("El profesor retornado no tiene el domicilio correcto.", profesor.getDomicilio().equals("Mitre 1234"));
        assertTrue("El profesor retornado no tiene el mail correcto.", profesor.getMail().equals("martin@mitre"));
        assertTrue("El profesor retornado no tiene el telefono correcto.", profesor.getTelefono().equals("12345678"));
    }
    
    @Test
    public void testUbicarProfesor1_1_VL() {
        setupEscenario_5();
        ArrayList<Profesor> profesores = entidades.buscaProfesor("Maria");
        assertFalse("No se encontraron profesores con ese nombre.", profesores.isEmpty());
        Profesor profesor = profesores.get(0);
        assertTrue("El profesor retornado no tiene el legajo correcto.", profesor.getLegajo().equals("PRO0123"));
        assertTrue("El profesor retornado no tiene el nombre correcto.", profesor.getNombre().equals("Maria"));
        assertTrue("El profesor retornado no tiene el domicilio correcto.", profesor.getDomicilio().equals("Estrada 123"));
        assertTrue("El profesor retornado no tiene el mail correcto.", profesor.getMail().equals("maria@estrada"));
        assertTrue("El profesor retornado no tiene el telefono correcto.", profesor.getTelefono().equals("01234567"));
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
    
    @Test
    public void testBajaAsignatura1_1() {
        setupEscenario_7();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI1234");
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
    
    /**
     * CASO ERRONEO: Espera error por Id duplicado pero el escenario no es correcto para que eso pase.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testModificarAsignatura1_6() {
        setupEscenario_8();
        Asignatura asignatura = entidades.buscaAsignaturaPorId("ASI0123");
        ArrayList<Asignatura> correlativas = new ArrayList<Asignatura>();
        controlador.modificarAsignatura(asignatura, "ASI1234", "Fisica", correlativas);
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
        assertFalse("No se encontraron asignaturas con ese nombre.", asignaturas.isEmpty());
        Asignatura asignatura = asignaturas.get(0);
        assertTrue("La asignatura retornada no tiene el Id correcto.", asignatura.getId().equals("ASI2345"));
        assertTrue("La asignatura retornada no tiene el nombre correcto.", asignatura.getNombre().equals("Quimica"));
        assertTrue("La asignatura retornada no tiene la lista de correlativas correcta.", asignatura.getCorrelativas().isEmpty());
    }
    
    @Test
    public void testUbicarAsignatura1_1_VL() {
        setupEscenario_8();
        ArrayList<Asignatura> asignaturas = entidades.buscaAsignatura("Fisica");
        assertFalse("No se encontraron asignaturas con ese nombre.", asignaturas.isEmpty());
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
    public void testAltaCursada2_2(){
        setupEscenario_7_10();
        Asignatura fisica = new Asignatura("ASI0123", "Fisica");
        controlador.altaCursada("CUR0123", fisica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
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
    
    /**
     * CASO ERRONEO: Modifica el Id el escenario en el que es la unica cursada del sistema esperando que haya duplicados.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada1_6(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR1234", quimica, "02-2017", "Sab", "08:00", "11:00", new ArrayList<Alumno>(), new ArrayList<Profesor>());
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
    
    /**
     * CASO ERRONEO: La bateria de pruebas indica que deberia devolver error cuando esta en una clase correcta.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testModificarCursada4_1_VL(){
        setupEscenario_7_11();
        Cursada cursada = entidades.buscaCursadaPorId("CUR0123");
        Asignatura quimica = entidades.buscaAsignaturaPorId("ASI2345");
        controlador.modificarCursada(cursada, "CUR0123", quimica, "02-2017", "Sab", "23:58", "23:59", new ArrayList<Alumno>(), new ArrayList<Profesor>());
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
    
    /**
     * CASO ERRONEO: Los horarios de la cursada no corresponden con el escenario.
     */
    @Test
    public void testConsultaCursada1_1() {
        setupEscenario_7_10();
        Cursada cursada = entidades.buscaCursadaPorId("CUR2345");
        assertTrue("La cursada retornada no tiene el Id correcto.", cursada.getId().equals("CUR2345"));
        assertTrue("La cursada retornada no tiene la asignatura correcta.", cursada.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada retornada no tiene el periodo correcto.", cursada.getPeriodo().equals("01-2017"));
        assertTrue("La cursada retornada no tiene el dia correcto.", cursada.getDia().equals("Lun"));
        assertTrue("La cursada retornada no tiene la hora inicio correcta.", cursada.getHoraInicio().equals("12:00"));
        assertTrue("La cursada retornada no tiene la hora fin correcta.", cursada.getHoraFin().equals("14:00"));
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
    
    /**
     * CASO ERRONEO: Deberia devolver dos cursadas. Los horarios de la primera cursada no corresponden con el escenario.
     */
    @Test
    public void testUbicarCursada1_1() {
        setupEscenario_7_10();
        ArrayList<Cursada> cursadas = entidades.buscaCursada("Quimica");
        assertFalse("No se encontro ninguna cursada por el nombre.", cursadas.isEmpty());
        Cursada cursada = cursadas.get(0);
        assertTrue("La cursada retornada no tiene el Id correcto.", cursada.getId().equals("CUR2345"));
        assertTrue("La cursada retornada no tiene la asignatura correcta.", cursada.getAsignatura() == entidades.buscaAsignaturaPorId("ASI2345"));
        assertTrue("La cursada retornada no tiene el periodo correcto.", cursada.getPeriodo().equals("01-2017"));
        assertTrue("La cursada retornada no tiene el dia correcto.", cursada.getDia().equals("Lun"));
        assertTrue("La cursada retornada no tiene la hora inicio correcta.", cursada.getHoraInicio().equals("12:00"));
        assertTrue("La cursada retornada no tiene la hora fin correcta.", cursada.getHoraFin().equals("14:00"));
        assertTrue("La cursada retornada no tiene la lista de alumnos correcta.", cursada.getAlumnos().isEmpty());
        assertTrue("La cursada retornada no tiene la lista de profesores correcta.", cursada.getProfesores().isEmpty());
    }
    
    @Test
    public void testUbicarCursada1_1_VL() {
        setupEscenario_7_11();
        ArrayList<Cursada> cursadas = entidades.buscaCursada("Quimica");
        assertFalse("No se encontro ninguna cursada por el nombre.", cursadas.isEmpty());
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
