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
	
    private void setupEscenario1(){
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura1 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura2 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno1 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno2 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno4 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI2345","Quimica",correlativasAsignatura1);
        Asignatura asignatura2 = new Asignatura("ASI1234","Matematica",correlativasAsignatura2);
        
        //Agrega a colecciones
        aprobadasAlumno3.add(asignatura1);
        aprobadasAlumno4.add(asignatura2);
        
        //Alumnos
        Alumno alumno1 = new Alumno("ALU1234","Martin","Mitre 1234","martin@mitre",aprobadasAlumno1);
        Alumno alumno2 = new Alumno("ALU2345","Jose","Color 2345","jose@colon",aprobadasAlumno2);
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
	
        //Colecciones Entidades
        ArrayList<Asignatura> aprobadasAlumno1 = new ArrayList<Asignatura>();
        
        //Alumnos
        Alumno alumno1 = new Alumno("ALU0123","Maria","Estrada 123","maria@estrada",aprobadasAlumno1);
        
        //Agregar a entidades
        entidades.addAlumno(alumno1);
    }
    
    private void setupEscenario3(){
    }
    
    private void setupEscenario4() {
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura1 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura2 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> habilitadasProfesor1 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> habilitadasProfesor2 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> habilitadasProfesor3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> habilitadasProfesor4 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI2345","Quimica",correlativasAsignatura1);
        Asignatura asignatura2 = new Asignatura("ASI1234","Matematica",correlativasAsignatura2);
        Asignatura asignatura3 = new Asignatura("ASI4567","Laboratorio",correlativasAsignatura3);
        
        //Agrega a colecciones
        habilitadasProfesor3.add(asignatura1);
        habilitadasProfesor3.add(asignatura3);
        habilitadasProfesor4.add(asignatura2);
        
        //Alumnos
        
        //Profesores
        Profesor profesor1 = new Profesor("PRO1234","Martin","Mitre 1234","12345678","martin@mitre",habilitadasProfesor1);
        Profesor profesor2 = new Profesor("PRO2345","Jose","Color 2345","23456789","jose@colon",habilitadasProfesor2);
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
		
        //Colecciones Entidades
        ArrayList<Asignatura> habilitadasProfesor1 = new ArrayList<Asignatura>();
        
        //Profesores
        Profesor profesor1 = new Profesor("PRO0123","Maria","Estrada 123","01234567","maria@estrada",habilitadasProfesor1);
        
        //Agregar a entidades
        entidades.addProfesor(profesor1);
    }
    
    private void setupEscenario6(){
        setupEscenario();
    }

    private void setupEscenario7(){
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura1 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura2 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura4 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura5 = new ArrayList<Asignatura>();        
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI1234","Matematica",correlativasAsignatura1);
        Asignatura asignatura2 = new Asignatura("ASI2345","Quimica",correlativasAsignatura2);
        
        correlativasAsignatura3.add(asignatura1);
        correlativasAsignatura4.add(asignatura2);
        
        Asignatura asignatura3 = new Asignatura("ASI3456","Estadistica",correlativasAsignatura3);
        Asignatura asignatura4 = new Asignatura("ASI4567","Laboratorio",correlativasAsignatura4);
        Asignatura asignatura5 = new Asignatura("ASI5678","Computacion",correlativasAsignatura5);
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
        entidades.addAsignatura(asignatura2);
        entidades.addAsignatura(asignatura3);
        entidades.addAsignatura(asignatura4);
        entidades.addAsignatura(asignatura5);
    }
    
    private void setupEscenario8(){
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura1 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI0123","Fisica",correlativasAsignatura1);
        
        //Agregar a entidades
        entidades.addAsignatura(asignatura1);
    }
    
    private void setupEscenario9(){
        
    }

    private void setupEscenario10(){
	
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura1 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura2 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura4 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> correlativasAsignatura5 = new ArrayList<Asignatura>();
        ArrayList<Profesor> profesoresCursada1 = new ArrayList<Profesor>();
        ArrayList<Profesor> profesoresCursada2 = new ArrayList<Profesor>();
        ArrayList<Profesor> profesoresCursada3 = new ArrayList<Profesor>();
        ArrayList<Profesor> profesoresCursada4 = new ArrayList<Profesor>();
        ArrayList<Profesor> profesoresCursada5 = new ArrayList<Profesor>();
        ArrayList<Profesor> profesoresCursada6 = new ArrayList<Profesor>();
        ArrayList<Alumno> alumnosCursada1 = new ArrayList<Alumno>();
        ArrayList<Alumno> alumnosCursada2 = new ArrayList<Alumno>();
        ArrayList<Alumno> alumnosCursada3 = new ArrayList<Alumno>();
        ArrayList<Alumno> alumnosCursada4 = new ArrayList<Alumno>();
        ArrayList<Alumno> alumnosCursada5 = new ArrayList<Alumno>();
        ArrayList<Alumno> alumnosCursada6 = new ArrayList<Alumno>();
        ArrayList<Asignatura> habilitadasProfesor3 = new ArrayList<Asignatura>();
        ArrayList<Asignatura> aprobadasAlumno3 = new ArrayList<Asignatura>();
        
        //Asignaturas
        Asignatura asignatura1 = new Asignatura("ASI1234","Matematica",correlativasAsignatura1);
        Asignatura asignatura2 = new Asignatura("ASI2345","Quimica",correlativasAsignatura2);
        
        correlativasAsignatura3.add(asignatura1);
        correlativasAsignatura4.add(asignatura2);
        
        Asignatura asignatura3 = new Asignatura("ASI3456","Estadistica",correlativasAsignatura3);
        
        Asignatura asignatura4 = new Asignatura("ASI4567","Laboratorio",correlativasAsignatura4);
        Asignatura asignatura5 = new Asignatura("ASI5678","Computacion",correlativasAsignatura5);
        
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
        
        Cursada cursada1 = new Cursada("CUR1234",asignatura1,"01-2017","Lun","12:00","14:00",profesoresCursada1,alumnosCursada1);
        Cursada cursada2 = new Cursada("CUR2345",asignatura2,"01-2017","Lun","13:00","15:00",profesoresCursada2,alumnosCursada2);
        Cursada cursada3 = new Cursada("CUR3456",asignatura1,"02-2017","Jue","16:00","18:00",profesoresCursada3,alumnosCursada3);
        Cursada cursada4 = new Cursada("CUR4567",asignatura4,"02-2017","Mie","17:00","19:00",profesoresCursada4,alumnosCursada4);
        Cursada cursada5 = new Cursada("CUR5678",asignatura5,"02-2017","Jue","15:00","17:00",profesoresCursada5,alumnosCursada5);
        Cursada cursada6 = new Cursada("CUR6789",asignatura2,"02-2017","Mie","16:00","18:00",profesoresCursada6,alumnosCursada6);
        
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
		
        //Colecciones Entidades
        ArrayList<Asignatura> correlativasAsignatura2 = new ArrayList<Asignatura>();
        ArrayList<Profesor> profesoresCursada1 = new ArrayList<Profesor>();
        ArrayList<Alumno> alumnosCursada1 = new ArrayList<Alumno>();
        
        //Asignaturas
        Asignatura asignatura2 = new Asignatura("ASI2345","Quimica",correlativasAsignatura2);
        
        //Cursadas
        Cursada cursada1 = new Cursada("CUR0123",asignatura2,"02-2017","Sab","08:00","11:00",profesoresCursada1,alumnosCursada1);
    }
    
    private void setupEscenario12(){
        
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
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
    public void testAltaAlumno1_1_VL1(){
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
    public void testAltaAlumno1_4_VL1(){
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
    public void testAltaAlumno1_5_VL1(){
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
    public void testAltaAlumno2_1_VL1(){
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
    public void testAltaAlumno3_1_VL1(){
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
    public void testAltaAlumno4_1_VL1(){
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
    public void testBajaAlumno1_1_VL1(){
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
    public void testBajaAlumno1_2_VL1(){
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
    public void testModificarAlumno1_4_VL1(){
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
    public void testModificarAlumno1_5_VL1(){
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
    public void testModificarAlumno2_1_VL1(){
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
    public void testModificarAlumno3_1_VL1(){
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
    public void testModificarAlumno4_1_VL1(){
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
    public void testModificarAlumno5_1_VL1(){
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
    
    @Test
    public void testCrearProfesorVacio(){
        //TODO:
    }
            
    @Test
    public void testAltaProfesor(){
        setupEscenario1();
    }
    
    @Test
    public void testBajaProfesor(){
        /*
        setupEscenario1();
        Profesor profesor = new Profesor();
        controlador.getEntidades().addProfesor(profesor);
        
        assertTrue (controlador.bajaProfesor(profesor));
        */
    }
    
    @Test
    public void testModificarProfesor(){
        /*
        setupEscenario1();
        String legajo="";
        String nombre="";
        String domicilio="";
        String telefono="";
        String mail="";
        ArrayList<Asignatura> habilitadas= new ArrayList<Asignatura>();
        
        String legajoNuevo="";
        String nombreNuevo="";
        String domicilioNuevo="";
        String telefonoNuevo="";
        String mailNuevo="";
        ArrayList<Asignatura> habilitadasNuevo= new ArrayList<Asignatura>();        
        
        Profesor testProfesor= new Profesor (legajo,nombre,domicilio,telefono,mail);
        testProfesor.setHabilitadas(habilitadas);
        
        Assert.assertTrue(controlador.modificarProfesor(testProfesor, legajoNuevo, nombreNuevo, domicilioNuevo, telefonoNuevo, mailNuevo, habilitadasNuevo));
        */
    }
    
    @Test
    public void testCrearAsignaturaVacia(){
        /*
        setupEscenario1();
        Assert.assertNotNull(controlador.crearAsignaturaVacia());
        */
    }
            
    @Test
    public void testAltaAsignatura(){
        //TODO:
    }
    
    @Test
    public void testBajaAsignatura(){
        /*
        setupEscenario1();
        Asignatura asignatura = new Asignatura();
        controlador.getEntidades().addAsignatura(asignatura);
        
        assertTrue (controlador.bajaAsignatura(asignatura));
        */
    }
    
    @Test
    public void testModificarAsignatura(){
        /*
        setupEscenario1();
        String id="";
        String nombre="";
        ArrayList<Asignatura> correlativas;
        
        String idNuevo="";
        String nombreNuevo="";
        ArrayList<Asignatura> correlativasNuevo;      
        
        Asignatura testAsignatura = new Asignatura(id,nombre);
        testAsignatura.setCorrelativas(correlativas);
        
        Assert.assertTrue(controlador.modificarAsignatura(testAsignatura,idNuevo,nombreNuevo,correlativasNuevo));
        */
    }
    
    @Test
    public void testCrearCursadaVacia(){
        /*
        setupEscenario1();
        Assert.assertNotNull(controlador.crearCursadaVacia());
        */
    }
            
    @Test
    public void testAltaCursada(){
        //TODO:
    }
    
    @Test
    public void testBajaCursada(){
        /*
        setupEscenario1();
        Asignatura asignatura = new Asignatura();
        Cursada cursada = new Cursada();
        cursada.setAsignatura(asignatura);
        controlador.getEntidades().addAsignatura(asignatura);
        controlador.getEntidades().addCursada(cursada);
        
        controlador.bajaCursada(cursada);
        
        Assert.assertFalse(controlador.getEntidades().getCursadas().contains(cursada));
        */
    }
    
    @Test
    public void testModificarCursada(){
        /*
        setupEscenario1();
        String id="";
        String nombre="";
        ArrayList<Asignatura> correlativas;
        Asignatura asignatura = new Asignatura(id,nombre);
        asignatura.setCorrelativas(correlativas);
        
        id="";
        String periodo="";
        String dia="";
        String horaInicio="";
        String horaFin="";
        ArrayList<Profesor> profesores;
        ArrayList<Alumno> alumnos;
        
        Cursada testCursada= new Cursada (id,asignatura,periodo,dia,horaInicio,horaFin);
        testCursada.setProfesores(profesores);
        testCursada.setAlumnos(alumnos);
        
        String idNuevo="";
        String periodoNuevo="";
        String diaNuevo="";
        String horaInicioNuevo="";
        String horaFinNuevo="";
        ArrayList<Profesor> profesoresNuevo;
        ArrayList<Alumno> alumnosNuevo;
        
        controlador.modificarCursada(testCursada,idNuevo,asignatura,periodoNuevo,diaNuevo, horaInicioNuevo,horaFinNuevo, alumnosNuevo,profesoresNuevo);
        */
    }
}
