package pga_modelo;

import java.util.ArrayList;

public class Alumno {
    private String legajo;
    private String nombre;
    private String domicilio;
    private String mail;
    private ArrayList<Asignatura> aprobadas;
    
    public Alumno(String legajo, String nombre, String domicilio, String mail) {
        this.legajo=legajo;
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.mail=mail;
    }
    
    
}
