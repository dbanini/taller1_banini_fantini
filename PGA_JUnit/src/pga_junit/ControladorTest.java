package pga_junit;

import java.util.ArrayList;

import org.junit.Assert;
import static org.junit.Assert.*;
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
    /**
     * Crea un escenario vacio.
     */
    private void setupEscenario1(){
        entidades = new Entidades();
        controlador = new Controlador(entidades);
    }
    
    private void setupEscenario2(){
        //Esperar los casos de prueba.
    }
    
    private void setupEscenario3(){
        //Esperar los casos de prueba.
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    @Test
    public void testCrearAlumnoVacio(){
        setupEscenario1();
        Assert.assertNotNull(controlador.crearAlumnoVacio());
    }
            
    @Test
    //Alta Alumno no esta siendo usado en principal.
    public void testAltaAlumno(){
        //TODO:
        /*
        setupEscenario1();
        String legajo="";
        String nombre="";
        String domicilio="";
        String mail="";
        ArrayList<Asignatura> aprobadas= new ArrayList<Asignatura>();
        Alumno testAlumno= new Alumno (legajo,nombre,domicilio,mail);
        testAlumno.setAprobadas(aprobadas);
        */
        fail();
    }
    
    @Test
    public void testModificarAlumno(){
        setupEscenario1();
        String legajo="";
        String nombre="";
        String domicilio="";
        String mail="";
        ArrayList<Asignatura> aprobadas= new ArrayList<Asignatura>();
        
        String legajoNuevo="";
        String nombreNuevo="";
        String domicilioNuevo="";
        String mailNuevo="";
        ArrayList<Asignatura> aprobadasNuevo= new ArrayList<Asignatura>();        
        
        Alumno testAlumno= new Alumno (legajo,nombre,domicilio,mail);
        testAlumno.setAprobadas(aprobadas);
        
        Assert.assertTrue(controlador.modificarAlumno(testAlumno, legajoNuevo, nombreNuevo, domicilioNuevo, mailNuevo, aprobadasNuevo));
    }
    
    @Test
    public void testBajaAlumno(){
        setupEscenario1();
        Alumno alumno = new Alumno();
        controlador.getEntidades().addAlumno(alumno);
        
        assertTrue (controlador.bajaAlumno(alumno));
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
    public void testModificarProfesor(){
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
    }
    
    @Test
    public void testBajaProfesor(){
        setupEscenario1();
        Profesor profesor = new Profesor();
        controlador.getEntidades().addProfesor(profesor);
        
        assertTrue (controlador.bajaProfesor(profesor));
    }
    
    @Test
    public void testCrearAsignaturaVacia(){
        setupEscenario1();
        Assert.assertNotNull(controlador.crearAsignaturaVacia());
    }
            
    @Test
    public void testAltaAsignatura(){
        //TODO:
    }
    
    @Test
    public void testModificarAsignatura(){
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
    }
    
    @Test
    public void testBajaAsignatura(){
        setupEscenario1();
        Asignatura asignatura = new Asignatura();
        controlador.getEntidades().addAsignatura(asignatura);
        
        assertTrue (controlador.bajaAsignatura(asignatura));
    }
    
    @Test
    public void testCrearCursadaVacia(){
        setupEscenario1();
        Assert.assertNotNull(controlador.crearCursadaVacia());
    }
            
    @Test
    public void testAltaCursada(){
        //TODO:
    }
    
    @Test
    public void testModificarCursada(){
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
    }
    
    @Test
    public void testBajaCursada(){
        setupEscenario1();
        Asignatura asignatura = new Asignatura();
        Cursada cursada = new Cursada();
        cursada.setAsignatura(asignatura);
        controlador.getEntidades().addAsignatura(asignatura);
        controlador.getEntidades().addCursada(cursada);
        
        controlador.bajaCursada(cursada);
        
        Assert.assertFalse(controlador.getEntidades().getCursadas().contains(cursada));
    }
}
