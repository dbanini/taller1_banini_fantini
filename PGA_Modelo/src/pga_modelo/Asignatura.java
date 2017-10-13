package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Representa una asignatura junto con sus datos. <br>
 * Debe ser distinta de null y cumplir la mascara de identificación de la asignatura (ASIXXXX (X 0-9)) <br>
 * El nombre debe ser alfanumerico, diferente de null y de vacio. <br>
 * La lista de correlativas debe ser no nula.
 */
public class Asignatura implements Comparable<Asignatura>{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String id;
    private String nombre;
    private TreeSet<Asignatura> correlativas;
    
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
     * Agrega una correlativa a la asignatura. <br>
     * <b>pre: </b> La asignatura no existe en la lista de correlativas.
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
    
    /**
     * Sobreescribe el metodo toString para el objeto. <br>
     * @return Retorna la clase escrita en un string.
     */
    @Override
    public String toString(){
        String string="";
        Iterator it;
        Asignatura asignatura;
        
        string+="Identificacion: "+id+" Nombre: "+nombre+" Correlativas:";
        it=correlativas.iterator();
        while (it.hasNext()){
            asignatura=(Asignatura)it.next();
            string+=" "+asignatura.toString();
        }
        string+="/n";
        return string;
    }
    
    /**
     * Compara esta asignatura con otra asignatura.
     * @param o Es la otra asignatura a comparar.
     * @return Si this<o retorna negativo. Si this==o retorna 0. Si this>o retorna positivo.
     */
    @Override
    public int compareTo(Asignatura o) {
        // TODO Implement this method
        return 1;
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
            if(id.startsWith("ASI")){
                auxLegajo=id;
                auxLegajo=auxLegajo.substring(3);
                try{
                    numeroLegajo=Integer.parseInt(auxLegajo);
                    if (numeroLegajo>0 && numeroLegajo<9999)
                        return true;
                } catch (NumberFormatException e){
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
    private boolean nombreEsValido() {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        
        if (nombre!=null)
            return !p.matcher(nombre).find();
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
