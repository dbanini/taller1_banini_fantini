package pga_modelo;

import java.util.ArrayList;

/**
 * Representa un profesor junto con sus datos. <br>
 * <b>inv: </b> <br>
 * El atributo legajo debe cumplir la mascara de legajo del profesor (PROXXXX (X 0-9)) y debe ser unica. <br>
 * El atributo telefono debe ser alfanumerico distinto de nulo y vacio. <br>
 * El ArrayList participar solo puede contener asignaturas validas y no se deben repetir. <br>
 */
public class Profesor extends Persona{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String telefono;
    private ArrayList<Asignatura> participar;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea un profesor con sus atributos. <br>
     * <b>pre: </b> El legajo es unico.
     * <b>post: </b> Se crea un Profesor con sus datos.
     * @param legajo debe cumplir la mascara de legajo del profesor (PROXXXX (X 0-9))
     * @param domicilio alfanumerico - domicilio!=null && domicilio!=""
     * @param telefono alfanumerico - telefono!=null && telefono!=""
     * @param mail debe cumplir la mascara de mail (AAAAA@AAAAAA)
     */
    public Profesor(String legajo, String domicilio, String telefono, String mail) {
        super(legajo,domicilio,mail);
        this.telefono=telefono;
        participar=new ArrayList<Asignatura>();
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

    public void setParticipar(ArrayList<Asignatura> participar) {
        this.participar = participar;
        verificarInvariante();
    }

    public ArrayList<Asignatura> getParticipar() {
        return participar;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /** 
     * Agrega una asignatura al profesor. <br>
     * <b>pre: </b> La asignatura no existe en la lista de asignaturas del profesor.
     * <b>post: </b> Se agrega una asignatura al profesor.
     * @param asignatura cumple que es valida.
     */
    public void addParticipacion (Asignatura asignatura){
        participar.add(asignatura);
        verificarInvariante();
    }
    
    /**
     * Elimina una asignatura del profesor. <br>
     * <b>pre: </b> La asignatura existe en la lista de asignaturas del profesor.
     * <b>post: </b> Se elimina una asignatura de la lista de asignaturas del profesor.
     * @param asignatura cumple que es valida.
     */
    public void removeParticipacion (Asignatura asignatura){
        participar.remove(asignatura);
        verificarInvariante();
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si un legajo es valido. <br>
     * El legajo debe empezar con "PRO". <br>
     * El legajo debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el legajo es valido, false en caso contrario. 
     */
    private boolean legajoEsValido(){
        int numeroLegajo;
        String auxLegajo;
        
        try{
            if(getLegajo().startsWith("PRO")){
                auxLegajo=getLegajo();
                auxLegajo=auxLegajo.substring(3);
                numeroLegajo=Integer.parseInt(auxLegajo);
                if (numeroLegajo>0 && numeroLegajo<1000)
                    return true;
                
            }
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }
    
    /**
     * Comprueba que el telefono sea valido. <br>
     * El atributo telefono debe ser distinto de null y de vacio. <br>
     * @return True si el telefono es valido, false en caso contrario. 
     */
    private boolean telefonoEsValido(){
        if (telefono!=null && telefono.equals(""))
            return true;
        return false;
    }
    
    /**
     * Comprueba que la lista sea valida. <br>
     * La lista de asignaturas participables debe ser distinta de null.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean participarEsValido(){
        if (participar!=null)
            return true;
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El legajo cumple con la mascara de profesor. <br>
     * El telefono es distinto de null y de vacio.<br>
     * La lista de asignaturas participables es distinta de null.
     */
    private void verificarInvariante(){
        assert legajoEsValido(): "La mascara del legajo es invalida.";
        assert telefonoEsValido(): "El telefono es invalido.";
        assert participarEsValido(): "La lista de asignaturas participables es invalida.";
        
    }
}
