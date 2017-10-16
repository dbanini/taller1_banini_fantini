package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Representa un Alumno junto con sus datos. <br>
 * <b>inv: </b> <br>
 * El legajo debe cumplir la mascara de legajo del alumno (ALUXXXX (X 0-9)) <br>
 * La lista de aprobadas debe ser distinta de null.
 */
public class Alumno extends Persona{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private TreeSet<Asignatura> aprobadas;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public Alumno() {
        super();
        setLegajo("ALU0000");
        aprobadas = new TreeSet<Asignatura>();
        verificarInvariante();
    }
    
    /**
     * Crea un alumno con sus atributos. <br>
     * <b>post: </b> Se crea un Alumno con sus datos correspondientes y una coleccion vacia de asignaturas aprobadas.
     * @param legajo debe cumplir la mascara de legajo del alumno (ALUXXXX (X 0-9))
     * @param nombre es alfanumerico, distinto de null y de vacio.
     * @param domicilio es alfanumerico, distinto de null y de vacio.
     * @param mail debe cumplir la mascara de mail (AAAAA@AAAAAA)
     */
    public Alumno(String legajo, String nombre, String domicilio, String mail) {
        super(legajo,nombre,domicilio,mail);
        aprobadas = new TreeSet<Asignatura>();
        // TODO Codificar post-condiciones.
        verificarInvariante();
    }
    
    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------

    public void setAprobadas(TreeSet<Asignatura> aprobadas) {
        this.aprobadas = aprobadas;
        verificarInvariante();
    }

    public TreeSet<Asignatura> getAprobadas() {
        return aprobadas;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /** 
     * Agrega una asignatura aprobada al alumno. <br>
     * <b>pre: </b> La asignatura no existe en la lista de aprobadas del alumno.
     * <b>pre: </b> El alumno posee las correlativas de la asignatura en su lista de aprobadas.
     * <b>post: </b> Se agrega una aprobada al alumno.
     * @param asignatura cumple que es valida.
     */
    public void addAprobada(Asignatura asignatura){
        // TODO Codificar pre-condiciones.
        aprobadas.add(asignatura);
        // TODO Codificar post-condiciones.
        verificarInvariante();
    }

    /**
     * Elimina una asignatura aprobada al alumno. <br>
     * <b>pre: </b> La asignatura existe en la lista de aprobadas del alumno.
     * <b>post: </b> Se elimina una aprobada del alumno.
     * @param asignatura cumple que es valida.
     */
    public void removeAprobada(Asignatura asignatura){
        // TODO Codificar pre-condiciones.
        aprobadas.remove(asignatura);
        // TODO Codificar post-condiciones.
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
        
        string+=super.toString()+ " Aprobadas:";
        it=aprobadas.iterator();
        while (it.hasNext()){
            asignatura=(Asignatura)it.next();
            string+=" "+asignatura.toString();
        }
        string+="/n";
        return string;
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si un legajo es valido. <br>
     * El legajo debe empezar con "ALU" y luego debe contener 4 caracteres. <br>
     * El legajo debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el legajo es valido, false en caso contrario. 
     */
    private boolean legajoEsValido(){
        int numeroLegajo;
        String auxLegajo;
        
        if(getLegajo().startsWith("ALU")){
            auxLegajo=getLegajo();
            auxLegajo=auxLegajo.substring(3);
            if (auxLegajo.length()==4){
                try{
                    numeroLegajo=Integer.parseInt(auxLegajo);
                    if (numeroLegajo>=0 && numeroLegajo<=9999)
                        return true;
                } catch (NumberFormatException e){
                    return false;
                }
            }
        }
        return false;
    }
    
    /**
     * Comprueba que la lista sea valida. <br>
     * La lista de asignaturas aprobadas debe ser distinta de null.<br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean aprobadasEsValido(){
        if (aprobadas!=null)
            return true;
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El legajo cumple con la mascara de alumno. <br>
     * La lista de asignaturas aprobadas es distinta de null.
     */
    private void verificarInvariante(){
        assert legajoEsValido(): "La mascara del legajo es invalida.";
        assert aprobadasEsValido(): "La lista de aprobadas es invalida.";
    }
}
