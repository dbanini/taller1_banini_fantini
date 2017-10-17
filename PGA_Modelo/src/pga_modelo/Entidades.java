package pga_modelo;

import java.util.ArrayList;
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
        profesores = new TreeSet<Profesor>();
        alumnos = new TreeSet<Alumno>();
        asignaturas = new TreeSet<Asignatura>();
        cursadas = new TreeSet<Cursada>();
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
     * <b>pre: </b> El profesor no existe en la lista de profesores.
     * <b>post: </b> Se agrega un profesor a la lista de profesores.
     *  @param profesor cumple que es valido.
     */
    public void addProfesor(Profesor profesor){
        profesores.add(profesor);
        verificarInvariante();
    }
    
    /**
     * Elimina un profesor de la lista de profesores y de la lista de profesores en las cursadas en las que participa. <br>
     * <b>pre: </b> El profesor existe en la lista de profesores.
     * <b>post: </b> Se elimina un profesor de la lista de profesores y de las cursadas en las que participa.
     *  @param profesor cumple que es valido.
     */
    public void removeProfesor(Profesor profesor){
        Iterator it;
        Cursada auxCursada;
        
        profesores.remove(profesor);
        it=cursadas.iterator();
        while (it.hasNext()){
            auxCursada=(Cursada) it.next();
            auxCursada.getProfesores().remove(profesor);
        }
        verificarInvariante();
    }
    
    /**
     * Agrega un alumno a la lista de alumnos. <br>
     * <b>pre: </b> El alumno no existe en la lista de alumnos.
     * <b>post: </b> Se agrega un alumno a la lista de alumnos.
     *  @param alumnos cumple que es valido.
     */
    public void addAlumno(Alumno alumno){
        alumnos.add(alumno);
        verificarInvariante();
    }
    
    /**
     * Elimina una alumno de la lista de alumnos y de la lista de alumnos en las cursadas en las que esta anotado. <br>
     * <b>pre: </b> El alumno existe en la lista de alumnos.
     * <b>post: </b> Se elimina un alumno de la lista de alumnos y tambien de las cursadas en las que esta anotado.
     *  @param alumnos cumple que es valido.
     */
    public void removeAlumno(Alumno alumno){
        Iterator it;
        Cursada auxCursada;
        
        alumnos.remove(alumno);
        it=cursadas.iterator();
        while (it.hasNext()){
            auxCursada=(Cursada) it.next();
            auxCursada.getAlumnos().remove(alumno);
        }
        verificarInvariante();
    }
    
    /**
     * Agrega una asignatura a la lista de asignaturas. <br>
     * <b>pre: </b> La asignatura no existe en la lista de asignaturas.
     * <b>post: </b> Se agrega una asignatura a la lista de aisgnaturas.
     *  @param asignatura cumple que es valida.
     */
    public void addAsignatura(Asignatura asignatura){
        asignaturas.add(asignatura);
        verificarInvariante();
    }
    
    /**
     * Elimina una asignatura de la lista de aisgnaturas, se eliminan las cursadas de dicha asignatura y se elimina la 
     * correlatividad en el resto de las asignaturas. <br>
     * <b>pre: </b> La asignatura existe en la lista de asignaturas.
     * <b>post: </b> Se elimina una asignatura de la lista de asignaturas, se eliminan las cursadas de dicha
     *  asignatura y ademas se elimina la asignatura en dichas asignaturas que la tengan de correlativa.
     * @param asignatura cumple que es valida.
     */
    public void removeAsignatura(Asignatura asignatura){
        Iterator it;
        Asignatura auxAsignatura;
        Cursada auxCursada;
        
        asignaturas.remove(asignatura);
        
        //Elimina la asignatura en las correlativas.
        it=asignaturas.iterator();
        while (it.hasNext()){
            auxAsignatura=(Asignatura) it.next();
            auxAsignatura.removeCorrelativa(asignatura);
        }
        //Elimina las cursadas con dicha asignatura.
        it=cursadas.iterator();
        while (it.hasNext()){
            auxCursada=(Cursada) it.next();
            if (auxCursada.getAsignatura().compareTo(asignatura)==0){
                removeCursada(auxCursada);
                it=cursadas.iterator(); //Si no se actualiza el iterador tira excepcion.
            }
        }
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
     * Busqueda de alumnos con determinado nombre.
     * @param string cumple que es valido.
     * @return Retorna en un ArrayList los alumnos con determinado nombre pasado por parametro.
     */
    public ArrayList<Alumno> buscaAlumno (String nombre){
        Iterator it;
        Alumno alumnoAux;
        ArrayList<Alumno> alumnosEncontrados = new ArrayList<Alumno>();
        
        it=alumnos.iterator();
        while (it.hasNext()){
            alumnoAux=(Alumno) it.next();
            if (alumnoAux.getNombre().equalsIgnoreCase(nombre)){
                alumnosEncontrados.add(alumnoAux);
            }
        }
        return alumnosEncontrados;
    }
    
    /**
     * Busca un alumno en la lista mediante su legajo. <br>
     * <b>post: </b> Se devuelve el alumno con el cual corresponde el legajo. 
     * Si no fue encontrado, se devuelve nulo.
     * @param legajo Legajo por el cual buscar el alumno.
     */
    public Alumno buscaAlumnoPorLegajo(String legajo) {
        Alumno alumno = null;
        boolean encontrado = false;
        
        // Iteramos en el set y verificamos que el alumno tenga el legajo buscado.
        Iterator<Alumno> it = alumnos.iterator();
        while (it.hasNext() && !encontrado) {
            alumno = it.next();
            encontrado = alumno.getLegajo().equals(legajo);
        }
        
        return encontrado ? alumno : null;
    }
    
    /**
     * Busqueda de profesores con determinado nombre.
     * @param string cumple que es valido.
     * @return Retorna en un ArrayList los profesores con determinado nombre pasado por parametro.
     */
    public ArrayList<Profesor> buscaProfesor (String nombre){
        Iterator it;
        Profesor profesoresAux;
        ArrayList<Profesor> ProfesoresEncontrados = new ArrayList<Profesor>();
        
        it=alumnos.iterator();
        while (it.hasNext()){
            profesoresAux=(Profesor) it.next();
            if (profesoresAux.getNombre().equalsIgnoreCase(nombre)){
                ProfesoresEncontrados.add(profesoresAux);
            }   
        }
        return ProfesoresEncontrados;
    }
    
    /**
     * Busca un profesor en la lista mediante su legajo. <br>
     * <b>post: </b> Se devuelve el profesor con el cual corresponde el legajo. 
     * Si no fue encontrado, se devuelve nulo.
     * @param legajo Legajo por el cual buscar el profesor.
     */
    public Profesor buscaProfesorPorLegajo(String legajo) {
        Profesor profesor = null;
        boolean encontrado = false;
        
        // Iteramos en el set y verificamos que el alumno tenga el legajo buscado.
        Iterator<Profesor> it = profesores.iterator();
        while (it.hasNext() && !encontrado) {
            profesor = it.next();
            encontrado = profesor.getLegajo().equals(legajo);
        }
        
        return encontrado ? profesor : null;
    }
    
    /**
     * Busqueda de asignaturas con determinado nombre.
     * @param string cumple que es valido.
     * @return Retorna en un ArrayList las asignaturas con determinado nombre pasado por parametro.
     */
    public ArrayList<Asignatura> buscaAsignatura (String nombre){
        Iterator it;
        Asignatura asignaturaAux;
        ArrayList<Asignatura> asignaturaEncontrados = new ArrayList<Asignatura>();
        
        it=alumnos.iterator();
        while (it.hasNext()){
            asignaturaAux=(Asignatura) it.next();
            if (asignaturaAux.getNombre().equalsIgnoreCase(nombre)){
                asignaturaEncontrados.add(asignaturaAux);
            }
        }
        return asignaturaEncontrados;
    }
    
    /**
     * Busca una asignatura en la lista mediante su id. <br>
     * <b>post: </b> Se devuelve la asignatura con el cual corresponde el id. 
     * Si no fue encontrado, se devuelve nulo.
     * @param id Id por el cual buscar la asignatura.
     */
    public Asignatura buscaAsignaturaPorId(String id) {
        Asignatura asignatura = null;
        boolean encontrado = false;
        
        // Iteramos en el set y verificamos que el alumno tenga el id buscado.
        Iterator<Asignatura> it = asignaturas.iterator();
        while (it.hasNext() && !encontrado) {
            asignatura = it.next();
            encontrado = asignatura.getId().equals(id);
        }
        
        return encontrado ? asignatura : null;
    }
    
    /**
     * Busqueda de cursadas con determinado nombre de asignatura.
     * @param string cumple que es valido.
     * @return Retorna en un ArrayList las cursadas cuya asignatura coincide con el nombre pasado por parametro.
     */
    public ArrayList<Cursada> buscaCursada (String nombre){
        Iterator it;
        Cursada cursadaAux;
        ArrayList<Cursada> cursadaEncontrados = new ArrayList<Cursada>();
        
        it=alumnos.iterator();
        while (it.hasNext()){
            cursadaAux=(Cursada) it.next();
            if (cursadaAux.getAsignatura().getNombre().equalsIgnoreCase(nombre)){
                cursadaEncontrados.add(cursadaAux);
            }
        }
        return cursadaEncontrados;
    }
    
    /**
     * Busca una cursada en la lista mediante su id. <br>
     * <b>post: </b> Se devuelve la cursada con el cual corresponde el id. 
     * Si no fue encontrado, se devuelve nulo.
     * @param id Id por el cual buscar la cursada.
     */
    public Cursada buscaCursadaPorId(String id) {
        Cursada cursada = null;
        boolean encontrado = false;
        
        // Iteramos en el set y verificamos que el alumno tenga el id buscado.
        Iterator<Cursada> it = cursadas.iterator();
        while (it.hasNext() && !encontrado) {
            cursada = it.next();
            encontrado = cursada.getId().equals(id);
        }
        
        return encontrado ? cursada : null;
    }
    
    /**
     * Genera un nuevo legajo unico para un nuevo alumno.
     * TODO: Alguna busqueda mas eficiente.
     */
    public String nuevoLegajoAlumno() {
        String legajo = "ALU9999";
        boolean encontrado = false;
        for (int i = 0; (i < 9999) && !encontrado; i++) {
            legajo = String.format("ALU%04d", i);
            encontrado = buscaAlumnoPorLegajo(legajo) == null;
        }
        return legajo;
    }
    
    /**
     * Genera un nuevo legajo unico para un nuevo profesor.
     * TODO: Alguna busqueda mas eficiente.
     */
    public String nuevoLegajoProfesor() {
        String legajo = "PRO9999";
        boolean encontrado = false;
        for (int i = 0; (i < 9999) && !encontrado; i++) {
            legajo = String.format("PRO%04d", i);
            encontrado = buscaProfesorPorLegajo(legajo) == null;
        }
        return legajo;
    }
    
    /**
     * Genera un nuevo legajo unico para una nueva asignatura.
     * TODO: Alguna busqueda mas eficiente.
     */
    public String nuevoIdAsignatura() {
        String id = "ASI9999";
        boolean encontrado = false;
        for (int i = 0; (i < 9999) && !encontrado; i++) {
            id = String.format("ASI%04d", i);
            encontrado = buscaAsignaturaPorId(id) == null;
        }
        return id;
    }
    
    /**
     * Genera un nuevo legajo unico para una nueva cursada.
     * TODO: Alguna busqueda mas eficiente.
     */
    public String nuevoIdCursada() {
        String id = "CUR9999";
        boolean encontrado = false;
        for (int i = 0; (i < 9999) && !encontrado; i++) {
            id = String.format("CUR%04d", i);
            encontrado = buscaCursadaPorId(id) == null;
        }
        return id;
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
