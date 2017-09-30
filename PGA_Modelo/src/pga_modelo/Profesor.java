package pga_modelo;

import java.util.ArrayList;

public class Profesor {
    private String legajo;
    private String domicilio;
    private String telefono;
    private String mail;
    private ArrayList<Asignatura> participar;
    
    public Profesor(String legajo, String domicilio, String telefono, String mail) {
        this.legajo=legajo;
        this.domicilio=domicilio;
        this.telefono=telefono;
        this.mail=mail;
    }
}
