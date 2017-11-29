package pga_modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Representa una asignatura junto con sus datos. <br>
 * <b>inv:</b> <br>
 * El legajo cumple con la mascara de asignatura. <br>
 * El nombre es distinto de null y de vacio. <br>
 * La lista de correlativas es distinta de null y no contiene asignaturas nulas. <br>
 * La lista de correlativas no contiene a la asignatura misma.
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
     * Constructor vacio utilizado al serializar y al crear una nueva asignatura.
     */
    public Asignatura() {
        this.id = "ASI0000";
        this.nombre = "Nombre";
        correlativas = new ArrayList<Asignatura>();
        verificarInvariante();
    }
    
    /**
     * Crea una asignatura con sus atributos. <br>
     * <b>post: </b> Se crea una asignatura. <br>
     * @param id El id debe cumplir la mascara de identificacion de la asignatura (ASIXXXX (X 0-9)) <br>
     * @param nombre El nombre de la asignatura. Debe ser alfanumerico y no vacio.
     */
    public Asignatura(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        correlativas = new ArrayList<Asignatura>();
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

    /**
     * Se permite la manipulacion directa de la coleccion.
     * @param correlativas La lista nueva de asignaturas que debe tener aprobadas un alumno para cursar esta materia.
     */
    public void setCorrelativas(ArrayList<Asignatura> correlativas) {
        this.correlativas = correlativas;
        verificarInvariante();
    }

    /**
     * Se permite la manipulacion directa de la coleccion.
     * @return Las correlativas de la materia.
     */
    public ArrayList<Asignatura> getCorrelativas() {
        return correlativas;
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si el id es valido. <br>
     * El id debe empezar con "ASI". <br>
     * El id debe terminar con un numero entre 0 y 9999. <br>
     * @param id Es el id a validar.
     * @return True si el id es valido, false en caso contrario. 
     */
    static public boolean idEsValido(String id) {
        int numeroId;
        String auxId;
        if (id != null && id.startsWith("ASI") && (id.length() == 7)) {
            auxId = id;
            auxId = auxId.substring(3);
            try {
                numeroId = Integer.parseInt(auxId);
                if (numeroId >= 0) {
                    return true;
                }
            } catch (NumberFormatException e) {
                 return false;
            }
        }
        
        return false;
    }

    /**
     * Comprueba que el nombre sea valido. <br>
     * El atributo nombre debe ser distinto de null y de vacio. <br>
     * @param nombre Es el nombre a validar.
     * @return True si el nombre es valido, false en caso contrario. 
     */
    static public boolean nombreEsValido(String nombre) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
        
        if (nombre!=null && !nombre.equals("")){
            return !p.matcher(nombre).find();
        }
        else {
            return false;
        }
    }

    /**
     * Comprueba que la lista sea valida. <br>
     * La lista de correlativas debe ser distinta de null y no contener asignaturas nulas.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    static public boolean correlativasEsValido(ArrayList<Asignatura> correlativas) {
        return correlativas != null && !correlativas.contains(null);
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv:</b> <br>
     * El legajo cumple con la mascara de asignatura. <br>
     * El nombre es distinto de null y de vacio. <br>
     * La lista de correlativas es distinta de null y no contiene asignaturas nulas. <br>
     * La lista de correlativas no contiene a la asignatura misma.
     */
    private void verificarInvariante(){
        assert idEsValido(id) : "El id es invalido.";
        assert nombreEsValido(nombre) : "El nombre de la asignatura es invalido.";
        assert correlativasEsValido(correlativas) : "La lista de correlativas de la asignatura es invalida.";
        assert !correlativas.contains(this) : "La lista de correlativas de la asignatura contiene a la asignatura misma.";
    }
}
