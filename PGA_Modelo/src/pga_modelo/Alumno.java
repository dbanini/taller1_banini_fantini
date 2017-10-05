package pga_modelo;

import java.util.ArrayList;
/**
 * Representa un Alumno junto con sus datos. <br>
 * <b>inv: </b> <br>
 * El legajo debe cumplir la mascara de legajo del alumno (ALUXXXX (X 0-9)) y debe ser unico. <br>
 * El nombre debe ser alfanumerico distinto de null y vacio. <br>
 * La lista de aprobadas solo puede contener asignaturas validas.
 */
public class Alumno extends Persona{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String nombre;
    private ArrayList<Asignatura> aprobadas;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea un alumno con sus atributos. <br>
     * <b>pre: </b> El legajo es unico.
     * <b>post: </b> Se crea un Profesor con sus datos.
     * @param legajo debe cumplir la mascara de legajo del alumno (ALUXXXX (X 0-9))
     * @param nombre alfanumerico - nombre!=null && nombre!=""
     * @param domicilio alfanumerico - domicilio!=null && domicilio!=""
     * @param mail debe cumplir la mascara de mail (AAAAA@AAAAAA)
     */
    public Alumno(String legajo, String nombre, String domicilio, String mail) {
        super(legajo,domicilio,mail);
        this.nombre=nombre;
        aprobadas= new ArrayList<Asignatura>();
        verificarInvariante();
    }
    
    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
        verificarInvariante();
    }

    public String getNombre() {
        return nombre;
    }

    public void setAprobadas(ArrayList<Asignatura> aprobadas) {
        this.aprobadas = aprobadas;
        verificarInvariante();
    }

    public ArrayList<Asignatura> getAprobadas() {
        return aprobadas;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /** 
     * Agrega una asignatura aprobada al alumno. <br>
     * <b>pre: </b> La asignatura no existe en la lista de aprobadas del alumno.
     * <b>pre: </b> El alumno posee las correlativas de la asignatura en su lista de aprobadas.
     * <b>post: </b> Se agrega una aprobada al alumno.
     * @param asignatura cumple que es valida.
     */
    public void addAprobada(Asignatura asignatura){
        aprobadas.add(asignatura);
        verificarInvariante();
    }

    /**
     * Elimina una asignatura aprobada al alumno. <br>
     * <b>pre: </b> La asignatura existe en la lista de aprobadas del alumno.
     * <b>post: </b> Se elimina una aprobada del alumno.
     * @param asignatura cumple que es valida.
     */
    public void removeAprobada(Asignatura asignatura){
        aprobadas.remove(asignatura);
        verificarInvariante();
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si un legajo es valido. <br>
     * El legajo debe empezar con "ALU". <br>
     * El legajo debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el legajo es valido, false en caso contrario. 
     */
    private boolean legajoEsValido(){
        int numeroLegajo;
        String auxLegajo;
        
        try{
            if(getLegajo().startsWith("ALU")){
                auxLegajo=getLegajo();
                auxLegajo=auxLegajo.substring(3);
                numeroLegajo=Integer.parseInt(auxLegajo);
                if (numeroLegajo>0 && numeroLegajo<1000)
                    return true;
            }
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    /**
     * Comprueba que el nombre sea valido. <br>
     * El atributo nombre debe ser distinto de null y de vacio. <br>
     * @return True si el nombre es valido, false en caso contrario. 
     */
    private boolean nombreEsValido(){
        if (nombre!=null)
            return true;
        return false;
    }
    
    /**
     * Comprueba que la lista sea valida. <br>
     * La lista de asignaturas aprobadas debe ser distinta de null.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean aprobadasEsValido(){
        if (aprobadas!=null)
            return true;
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El legajo cumple con la mascara de alumno. <br>
     * El nombre es distinto de null y de vacio.<br>
     * La lista de asignaturas aprobadas es distinta de null.
     * 
     */
    private void verificarInvariante(){
        assert legajoEsValido(): "La mascara del legajo es invalida.";
        assert nombreEsValido(): "El nombre es invalido.";
        assert aprobadasEsValido(): "La lista de aprobadas es invalida.";
    }
}
