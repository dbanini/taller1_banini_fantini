package pga_modelo;

import java.util.ArrayList;

/**
 * Representa una asignatura junto con sus datos. <br>
 * Debe cumplir la mascara de identificación de la asignatura (ASIXXXX (X 0-9)) debe ser unica. <br>
 * El nombre debe ser alfanumerico diferente de null y vacio.
 * La lista de correlativas solo puede contener asignaturas validas.
 */
public class Asignatura {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String id;
    private String nombre;
    private ArrayList<Asignatura> correlativas;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea una asignatura con sus atributos. <br>
     * <b>pre: </b> El id es unico.
     * <b>post: </b> Se crea una asignatura.
     * @param id Debe cumplir la mascara de identificación de la asignatura (ASIXXXX (X 0-9))
     * @param nombre alfanumerico - nombre!=null && nombre!=""
     */
    public Asignatura(String id, String nombre) {
        this.id=id;
        this.nombre=nombre;
        correlativas= new ArrayList<Asignatura>();
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------

    public void setId(String id) {
        this.id = id;
        verificarInvariante();
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        verificarInvariante();
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorrelativas(ArrayList<Asignatura> correlativas) {
        this.correlativas = correlativas;
        verificarInvariante();
    }

    public ArrayList<Asignatura> getCorrelativas() {
        return correlativas;
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /** 
     * Agrega una correlativa a la asignatura. <br>
     * <b>pre: </b> La asignatura no existe en la lista de correlativas.
     * <b>pre: </b> La asignatura a agregar no tiene de correlativa a esta instancia de asignatura.
     * <b>post: </b> Se agrega una asignatura correlativa a la lista de correlativas.
     * @param asignatura cumple que es valida.
     */
    public void addCorrelativa(Asignatura asignatura){
        correlativas.add(asignatura);
        verificarInvariante();
    }
    
    /**
     * Elimina una correlativa de la asignatura. <br>
     * <b>pre: </b> La correlativa existe en la lista de correlativas de la asignatura.
     * <b>post: </b> Se elimina una correlativa de la lista de correlativas de la asignatura.
     * @param asignatura cumple que es valida.
     */
    public void removeCorrelativa(Asignatura asignatura){
        correlativas.remove(asignatura);
        verificarInvariante();
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si el id es valido. <br>
     * El id debe empezar con "ASI". <br>
     * El id debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el id es valido, false en caso contrario. 
     */
    private boolean idEsValido() {
        int numeroLegajo;
        String auxLegajo;
        
        if (id!=null){
            try{
                if(id.startsWith("ASI")){
                    auxLegajo=id;
                    auxLegajo=auxLegajo.substring(3);
                    numeroLegajo=Integer.parseInt(auxLegajo);
                    if (numeroLegajo>0 && numeroLegajo<1000)
                        return true;
                }
            }catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }

    /**
     * Comprueba que el nombre sea valido. <br>
     * El atributo nombre debe ser distinto de null y de vacio. <br>
     * @return True si el nombre es valido, false en caso contrario. 
     */
    private boolean nombreEsValido() {
        if (nombre!=null)
            return true;
        return false;
    }

    /**
     * Comprueba que la lista sea valida. <br>
     * La lista de correlativas debe ser distinta de null.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean correlativasEsValido() {
        if (correlativas!=null)
            return true;
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El legajo cumple con la mascara de asignatura. <br>
     * El nombre es distinto de null y de vacio.<br>
     * La lista de correlativas es distinta de null.
     */
    private void verificarInvariante(){
        assert idEsValido(): "El id es invalido.";
        assert nombreEsValido(): "El nombre es invalido.";
        assert correlativasEsValido(): "La lista de correlativas es invalida.";
    }
}
