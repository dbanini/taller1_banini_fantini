package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Contiene a las colecciones de las entidades. <br>
 * La lista profesores contiene a los profesores. <br>
 * La lista alumnos contiene a los alumnos. <br>
 * La lista asignaturas contiene a las asignaturas. <br>
 * La lista cursadas contiene a las cursadas. 
 */
public class Entidades {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private TreeSet<Profesor> profesores;
    private TreeSet<Alumno> alumnos;
    private TreeSet<Asignatura> asignaturas;
    private TreeSet<Cursada> cursadas;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea las entidades.
     * <b>post: </b> Se crean las entidades.
     */
    public Entidades(){        
        profesores= new TreeSet<Profesor>();
        alumnos= new  TreeSet<Alumno>();
        asignaturas= new TreeSet<Asignatura>();
        cursadas= new TreeSet<Cursada>();
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------

    public void setProfesores(TreeSet<Profesor> profesores) {
        this.profesores = profesores;
        verificarInvariante();
    }

    public TreeSet<Profesor> getProfesores() {
        return profesores;
    }

    public void setAlumnos(TreeSet<Alumno> alumnos) {
        this.alumnos = alumnos;
        verificarInvariante();
    }

    public TreeSet<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAsignaturas(TreeSet<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
        verificarInvariante();
    }

    public TreeSet<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setCursadas(TreeSet<Cursada> cursadas) {
        this.cursadas = cursadas;
        verificarInvariante();
    }

    public TreeSet<Cursada> getCursadas() {
        return cursadas;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /**
     * Agrega un profesor a la lista de profesores. <br>
     * <b>pre: </b> El profesor no existe en la lista de cursadas.
     * <b>post: </b> Se agrega un profesor a la lista de profesores.
     *  @param profesor cumple que es valido.
     */
    public void addProfesor(Profesor profesor){
        profesores.add(profesor);
        verificarInvariante();
    }
    
    /**
     * Elimina un profesor de la lista de profesores. <br>
     * <b>pre: </b> El profesor existe en la lista de cursadas.
     * <b>post: </b> Se elimina un profesor de la lista de profesores.
     *  @param profesor cumple que es valido.
     */
    public void removeProfesor(Profesor profesor){
        profesores.remove(profesor);
        verificarInvariante();
    }
    
    /**
     * Agrega un alumno a la lista de alumnos. <br>
     * <b>pre: </b> El alumno no existe en la lista de cursadas.
     * <b>post: </b> Se agrega un alumno a la lista de alumnos.
     *  @param alumnos cumple que es valido.
     */
    public void addAlumno(Alumno alumno){
        alumnos.add(alumno);
        verificarInvariante();
    }
    
    /**
     * Elimina una alumno de la lista de alumnos. <br>
     * <b>pre: </b> El alumno existe en la lista de cursadas.
     * <b>post: </b> Se elimina un alumno de la lista de alumnos.
     *  @param alumnos cumple que es valido.
     */
    public void removeAlumno(Alumno alumno){
        alumnos.remove(alumno);
        verificarInvariante();
    }
    
    /**
     * Agrega una asignatura a la lista de asignaturas. <br>
     * <b>pre: </b> La asignatura no existe en la lista de cursadas.
     * <b>post: </b> Se agrega una asignatura a la lista de aisgnaturas.
     *  @param asignatura cumple que es valida.
     */
    public void addAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
        verificarInvariante();
    }
    
    /**
     * Elimina una asignatura de la lista de aisgnaturas. <br>
     * <b>pre: </b> La asignatura existe en la lista de cursadas.
     * <b>post: </b> Se elimina una asignatura de la lista de asignaturas.
     * @param asignatura cumple que es valida.
     */
    public void removeAsignatura(Asignatura asignatura){
        asignaturas.remove(asignatura);
        verificarInvariante();
    }
    
    /** 
     * Agrega una cursada a la lista de cursadas. <br>
     * <b>pre: </b> La cursada no existe en la lista de cursadas.
     * <b>post: </b> Se agrega una cursada a la lista de cursadas.
     * @param cursada cumple que es valida.
     */
    public void addCursada(Cursada cursada){
        cursadas.add(cursada);
        verificarInvariante();
    }
    
    /**
     * Elimina una cursada de la lista de cursadas. <br>
     * <b>pre: </b> La cursada existe en la lista de cursadas.
     * <b>post: </b> Se elimina una cursada de la lista de cursadas.
     * @param cursada cumple que es valida.
     */
    public void removeCursada(Cursada cursada){
        cursadas.remove(cursada);
        verificarInvariante();
    }
    
    /**
     * Sobreescribe el metodo toString para el objeto. <br>
     * @return Retorna la clase escrita en un string.
     */
    @Override
    public String toString(){
        Iterator it;
        String string="";
        Profesor profesor;
        Alumno alumno;
        Asignatura asignatura;
        Cursada cursada;
        
        it=profesores.iterator();
        while (it.hasNext()){
            profesor=(Profesor)it.next();
            string+=" "+profesor.toString();
        }
        string+="/n";
        it=alumnos.iterator();
        while (it.hasNext()){
            alumno=(Alumno)it.next();
            string+=" "+alumno.toString();
        }
        string+="/n";
        it=asignaturas.iterator();
        while (it.hasNext()){
            asignatura=(Asignatura)it.next();
            string+=" "+asignatura.toString();
        }
        string+="/n";
        it=cursadas.iterator();
        while (it.hasNext()){
            cursada=(Cursada)it.next();
            string+=" "+cursada.toString();
        }
        string+="/n";
        return string;
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si la lista profesores es valida. <br>
     * @return True si la lista de profesores es valida, false en caso contrario. 
     */ 
    private boolean profesoresEsValido(){
        if (profesores!=null)
            return true;
        return false;
    }
    
    /**
     * Comprueba si la lista alumnos es valida. <br>
     * @return True si la lista de alumnos es valida, false en caso contrario. 
     */
    private boolean alumnosEsValido(){
        if (alumnos!=null)
            return true;
        return false;
    }
    
    /**
     * Comprueba si la lista asignaturas es valida. <br>
     * @return True si la lista de asignaturas es valida, false en caso contrario. 
     */
    private boolean asignaturasEsValido(){
        if (asignaturas!=null)
            return true;
        return false;
    }
    
    /**
     * Comprueba si la lista cursadas es valida. <br>
     * @return True si la lista de cursadas es valida, false en caso contrario. 
     */
    private boolean cursadasEsValido(){
        if (cursadas!=null)
            return true;
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * La lista de profesores es distinta de null. <br>
     * La lista de alumnos es distinta de null. <br>
     * La lista de asignaturas es distinta de null. <br>
     * La lista de cursadas es distinta de null.
     */
    private void verificarInvariante(){
        assert profesoresEsValido(): "La lista de profesores es invalida.";
        assert alumnosEsValido(): "La lista de alumnos es invalida.";
        assert asignaturasEsValido(): "La lista de asignaturas es invalida.";
        assert cursadasEsValido(): "La lista de cursadas es invalida.";
    }
}
