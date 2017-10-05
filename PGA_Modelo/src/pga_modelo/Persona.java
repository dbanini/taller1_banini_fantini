package pga_modelo;


/** Representa una persona, ya sea un alumno o un profesor. <br>
 * El legajo debe ser alfanumerico. <br>
 * El domicilio debe ser alfanumerico distinto de null y vacio. <br>
 * El mail debe cumplir la mascara de mail (AAAAA@AAAAAA)
 */
public abstract class Persona {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String legajo;
    private String domicilio;
    private String mail;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public Persona(String legajo, String domicilio, String mail) {
        this.legajo=legajo;
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
     * Comprueba si un domicilio es valido. <br>
     * El domicilio debe ser distinto de null y de vacio. <br>
     * @return True si el domicilio es valido, false en caso contrario. 
     */
    private boolean domicilioEsValido() {
        if (domicilio!=null && !domicilio.equals(""))
            return true;
        return false;
    }
    
    /**
     * Comprueba si un mail es valido. <br>
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
     * El domicilio es distinto de null y de vacio.<br>
     * El mail cumple la mascara.
     */
    private void verificarInvariante(){
        assert legajoEsValido(): "El legajo es invalido.";
        assert domicilioEsValido(): "El domicilio es invalido.";
        assert mailEsValido(): "El mail es invalido.";
    }
}
