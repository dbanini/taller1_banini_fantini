package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Representa un profesor junto con sus datos. <br>
 * <b>inv: </b> <br>
 * El atributo legajo debe cumplir la mascara de legajo del profesor (PROXXXX (X 0-9))<br>
 * El atributo telefono debe ser alfanumerico, distinto de null y vacio. <br>
 * La lista de materias participables debe ser distinta de null.
 */
public class Profesor extends Persona {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String telefono;
    private TreeSet<Asignatura> participar;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public Profesor() {
        super();
        setLegajo("PRO0000");
        this.telefono = "0000 000000";
        participar = new TreeSet<Asignatura>();
        verificarInvariante();
    }
    
    /**
     * Crea un profesor con sus atributos. <br>
     * <b>pre: </b> El legajo es unico.
     * <b>post: </b> Se crea un Profesor con sus datos.
     * @param legajo debe cumplir la mascara de legajo del profesor (PROXXXX (X 0-9))
     * @param domicilio alfanumerico - domicilio!=null && domicilio!=""
     * @param telefono alfanumerico - telefono!=null && telefono!=""
     * @param mail debe cumplir la mascara de mail (AAAAA@AAAAAA)
     */
    public Profesor(String legajo, String nombre, String domicilio, String telefono, String mail) {
        super(legajo, nombre, domicilio, mail);
        this.telefono = telefono;
        participar = new TreeSet<Asignatura>();
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------

    public void setTelefono(String telefono) {
        this.telefono = telefono;
        verificarInvariante();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setParticipar(TreeSet<Asignatura> participar) {
        this.participar = participar;
        verificarInvariante();
    }

    public TreeSet<Asignatura> getParticipar() {
        return participar;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
     /**
      * Genera una descripcion textual del alumno.
      * @return La descripcion generada.
      */
     public String getDescripcion() {
         String string = super.getDescripcion();
         string += "\nTelefono: " + telefono + "\n";
         string += "Habilitadas:";
         if (!participar.isEmpty()) {
             Iterator<Asignatura> it = participar.iterator();
             Asignatura habilitada = null;
             while (it.hasNext()) {
                 habilitada = it.next();
                 string += "\n * " + habilitada.getId() + "-" + habilitada.getNombre();
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
     * Comprueba si un legajo es valido. <br>
     * El legajo debe empezar con "PRO" y luego debe contener 4 caracteres.  <br>
     * El legajo debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el legajo es valido, false en caso contrario. 
     */
    static public boolean legajoEsValido(String legajo) {
        int numeroLegajo;
        String auxLegajo;
        
        if(legajo.startsWith("PRO")){
            auxLegajo = legajo;
            auxLegajo = auxLegajo.substring(3);
            if (auxLegajo.length()==4){
                try{
                    numeroLegajo=Integer.parseInt(auxLegajo);
                    if (numeroLegajo>=0 && numeroLegajo<9999)
                        return true;
                } catch (NumberFormatException e){
                    return false;
                }
            }
        }
        return false;
    }
    
    /**
     * Comprueba que el telefono sea valido. <br>
     * El atributo telefono debe ser distinto de null y de vacio. <br>
     * @return True si el telefono es valido, false en caso contrario. 
     */
    static public boolean telefonoEsValido(String telefono){
        Pattern p = Pattern.compile("[^a-zA-Z0-9 ]");
        if (telefono != null && !telefono.equals(""))
            return !p.matcher(telefono).find();
        
        return false;
    }
    
    /**
     * Comprueba que la lista sea valida. <br>
     * La lista de asignaturas participables debe ser distinta de null.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean participarEsValido(){
        return participar != null;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El legajo cumple con la mascara de profesor. <br>
     * El telefono es alfanumerico, distinto de null y de vacio.<br>
     * La lista de asignaturas participables es distinta de null.
     */
    private void verificarInvariante(){
        assert legajoEsValido(getLegajo()): "La mascara del legajo es invalida.";
        assert telefonoEsValido(telefono): "El telefono es invalido.";
        assert participarEsValido(): "La lista de asignaturas participables es invalida.";
    }
}
