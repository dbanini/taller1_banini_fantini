package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Representa una asignatura junto con sus datos. <br>
 * <b>inv:</b> <br>
 * El legajo cumple con la mascara de asignatura. <br>
 * El nombre es distinto de null y de vacio. <br>
 * La lista de correlativas es distinta de null. <br>
 * La lista de correlativas no contiene a la asignatura misma.
 */
public class Asignatura {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String id;
    private String nombre;
    private TreeSet<Asignatura> correlativas;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public Asignatura (){
        this.id = "ASI0000";
        this.nombre = "Nombre";
        correlativas = new TreeSet<Asignatura>();
        verificarInvariante();
    }
    
    /**
     * Crea una asignatura con sus atributos. <br>
     * <b>post: </b> Se crea una asignatura. <br>
     * @param id Debe cumplir la mascara de identificación de la asignatura (ASIXXXX (X 0-9)) <br>
     * @param nombre El nombre de la asignatura. Debe ser alfanumerico y no vacio.
     */
    public Asignatura(String id, String nombre) {
        this.id=id;
        this.nombre=nombre;
        correlativas= new TreeSet<Asignatura>();
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

    public void setCorrelativas(TreeSet<Asignatura> correlativas) {
        this.correlativas = correlativas;
        verificarInvariante();
    }

    public TreeSet<Asignatura> getCorrelativas() {
        return correlativas;
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /**
     * Genera una descripcion textual de la asignatura. <br>
     * @return La descripcion generada.
     */
    public String getDescripcion() {
        String string = "";
        string += "Id: " + id + "\n";
        string += "Nombre: " + nombre + "\n";
        string += "Correlativas:";
        if (!correlativas.isEmpty()) {
            Iterator<Asignatura> it = correlativas.iterator();
            Asignatura correlativa = null;
            while (it.hasNext()) {
                correlativa = it.next();
                string += "\n * " + correlativa.getId() + "-" + correlativa.getNombre();
            }
        }
        else {
            string += " Ninguna";
        }
        
        return string;
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
    static public boolean idEsValido(String id) {
        int numeroId;
        String auxId;
        if (id != null) {
            if(id.startsWith("ASI")) {
                auxId = id;
                auxId = auxId.substring(3);
                try{
                    numeroId=Integer.parseInt(auxId);
                    if (numeroId >= 0 && numeroId <= 9999) {
                        return true;
                    }
                } 
                catch (NumberFormatException e){
                    return false;
                }
            }
        }
        
        return false;
    }

    /**
     * Comprueba que el nombre sea valido. <br>
     * El atributo nombre debe ser distinto de null y de vacio. <br>
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
     * La lista de correlativas debe ser distinta de null.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean correlativasEsValido() {
        return correlativas != null;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv:</b> <br>
     * El legajo cumple con la mascara de asignatura. <br>
     * El nombre es distinto de null y de vacio. <br>
     * La lista de correlativas es distinta de null. <br>
     * La lista de correlativas no contiene a la asignatura misma.
     */
    private void verificarInvariante(){
        assert idEsValido(id) : "El id es invalido.";
        assert nombreEsValido(nombre) : "El nombre de la asignatura es invalido.";
        assert correlativasEsValido() : "La lista de correlativas de la asignatura es invalida.";
        assert !correlativas.contains(this) : "La lista de correlativas de la asignatura contiene a la asignatura misma.";
    }
}
