package pga_modelo;

import java.util.Iterator;
import java.util.regex.Pattern;


/** Representa una persona, ya sea un alumno o un profesor. <br>
 * <b>inv:</b> <br>
 * El legajo es distinto de null y de vacio. <br>
 * El nombre es alfanumerico, distinto de null y de vacio. <br>
 * El domicilio es alfanumerico, distinto de null y de vacio.<br>
 * El mail cumple la mascara.
 */
public abstract class Persona implements Comparable<Persona>{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String legajo;
    private String nombre;
    private String domicilio;
    private String mail;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor vacio.
     */
    public Persona() {
        this.legajo = "LEG0000";
        this.nombre = "Nombre";
        this.domicilio = "Domicilio";
        this.mail = "mail@vacio.com";
        verificarInvariante();
    }
    
    /**
     * Constructor con parametros. Documentado en clases que lo heredan.
     */
    public Persona(String legajo, String nombre, String domicilio, String mail) {
        this.legajo=legajo;
        this.nombre=nombre;
        this.domicilio=domicilio;
        this.mail=mail;
        verificarInvariante();
    }
    
    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------

    public void setLegajo(String legajo) {
        this.legajo = legajo;
        verificarInvariante();
    }

    public String getLegajo() {
        return legajo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
        verificarInvariante();
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setMail(String mail) {
        this.mail = mail;
        verificarInvariante();
    }

    public String getMail() {
        return mail;
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
     /**
      * Genera una descripcion textual de la persona. <br>
      * @return La descripcion generada.
      */
     public String getDescripcion() {
         String string = "";
         string += "Legajo: " + legajo + "\n";
         string += "Nombre: " + nombre + "\n";
         string += "Domicilio: " + domicilio + "\n";
         string += "Mail: " + mail;
         return string;
     }
    
     /**
      * Compara esta persona con otra persona para su ordenamiento. <br>
      * @param o La otra persona a comparar. <br>
      * @return Resultado numerico de la comparacion lexicografica entre Legajos.
      */
    @Override
    public int compareTo(Persona o) {
        return legajo.compareTo(o.getLegajo());
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si un legajo es valido. <br>
     * El legajo debe ser distinto de null y de vacio. <br>
     * @return True si el legajo es valido, false en caso contrario. 
     */
    static public boolean legajoEsValido(String legajo) {
        return legajo != null && !legajo.equals("");
    }
    
    /**
     * Comprueba que el nombre sea valido. <br>
     * El atributo nombre debe ser alfanumerico, distinto de null y de vacio. <br>
     * @return True si el nombre es valido, false en caso contrario. 
     */
    static public boolean nombreEsValido(String nombre) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
        
        if (nombre!=null && !nombre.equals("")){
            return !p.matcher(nombre).find();
        }
        return false;
    }
    
    /**
     * Comprueba si un domicilio es valido. <br>
     * El atributo domicilio debe ser alfanumerico, distinto de null y de vacio. <br>
     * @return True si el domicilio es valido, false en caso contrario. 
     */
    static public boolean domicilioEsValido(String domicilio) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
        
        if (domicilio!=null && !domicilio.equals("")){
            return !p.matcher(domicilio).find();
        }
        return false;
    }
    
    /**
     * Comprueba si un mail es valido. <br>
     * Para ello, si hay arroba y esta es diferente a la posicion 0 y a la ultima del string(no empieza con arroba ni termina) entonces cumple. <br>
     * Si el mail cumple la mascara (AAAAA@AAAAAA) es valido. <br>
     * @return True si el mail es valido, false en caso contrario. 
     */
    static public boolean mailEsValido(String mail) {
        int indice;
        
        if (mail!=null && !mail.equals("")) {
            if(mail.contains("@")){
                indice=mail.indexOf("@");
                if (indice>1 && mail.length()!=indice+1)
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv:</b> <br>
     * El legajo es distinto de null y de vacio. <br>
     * El nombre es alfanumerico, distinto de null y de vacio. <br>
     * El domicilio es alfanumerico, distinto de null y de vacio. <br>
     * El mail cumple la mascara.
     */
    private void verificarInvariante(){
        assert legajoEsValido(legajo): "El legajo es invalido.";
        assert nombreEsValido(nombre): "El nombre es invalido.";
        assert domicilioEsValido(domicilio): "El domicilio es invalido.";
        assert mailEsValido(mail): "El mail es invalido.";
    }
}
