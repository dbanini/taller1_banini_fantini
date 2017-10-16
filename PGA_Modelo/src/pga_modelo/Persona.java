package pga_modelo;

import java.util.regex.Pattern;


/** Representa una persona, ya sea un alumno o un profesor. <br>
 * El legajo debe ser distinto de null y de vacio. <br>
 * El nombre debe ser alfanumerico, distinto de null y de vacio. <br>
 * El domicilio debe ser alfanumerico, distinto de null y de vacio. <br>
 * El mail debe cumplir la mascara de mail (AAAAA@AAAAAA) y debe ser distinto de null.
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
     * Sobreescribe el metodo toString para el objeto. <br>
     * @return Retorna la clase escrita en un string.
     */
    @Override
    public String toString(){
        String string;
        
        string="Legajo: "+legajo+" Nombre: "+nombre+" Domicilio: "+domicilio+" Mail: "+mail;
        return string;
    }
    
    /**
     *
     * @param o
     * @return
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
    private boolean legajoEsValido() {
        if (legajo!=null && !legajo.equals(""))
            return true;
        return false;
    }
    
    /**
     * Comprueba que el nombre sea valido. <br>
     * El atributo nombre debe ser alfanumerico, distinto de null y de vacio. <br>
     * @return True si el nombre es valido, false en caso contrario. 
     */
    private boolean nombreEsValido(){
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
    private boolean domicilioEsValido() {
        Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
        
        if (domicilio!=null && !domicilio.equals("")){
            return !p.matcher(domicilio).find();
        }
        return false;
    }
    
    /**
     * Comprueba si un mail es valido. <br>
     * Para ello, si hay arroba y esta es diferente a la posicion 0 y a la ultima del string(no empieza con 
     * arroba ni termina) entonces cumple. <br>
     * Si el mail cumple la mascara (AAAAA@AAAAAA) es valido. <br>
     * @return True si el mail es valido, false en caso contrario. 
     */
    private boolean mailEsValido() {
        int indice;
        
        if (mail!=null && !mail.equals(""))
            if(mail.contains("@")){
                indice=mail.indexOf("@");
                if (indice>1 && mail.length()!=indice)
                    return true;
            }
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El legajo es distinto de null y de vacio. <br>
     * El nombre es alfanumerico, distinto de null y de vacio. <br>
     * El domicilio es alfanumerico, distinto de null y de vacio.<br>
     * El mail cumple la mascara.
     */
    private void verificarInvariante(){
        assert legajoEsValido(): "El legajo es invalido.";
        assert nombreEsValido(): "El nombre es invalido.";
        assert domicilioEsValido(): "El domicilio es invalido.";
        assert mailEsValido(): "El mail es invalido.";
    }
}
