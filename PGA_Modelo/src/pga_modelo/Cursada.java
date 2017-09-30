package pga_modelo;

import java.util.ArrayList;

public class Cursada {
    private String id;
    private String asignatura;
    private String periodo;
    private String dia;
    private String hora;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;
    
    public Cursada(String id, String asignatura, String periodo, String dia, String hora) {
        this.id=id;
        this.asignatura=asignatura;
        this.periodo=periodo;
        this.dia=dia;
        this.hora=hora;
    }
}
