package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Representa un Alumno junto con sus datos. <br>
 * <b>inv:</b> <br>
 * El legajo cumple con la mascara de alumno. <br>
 * La lista de asignaturas aprobadas es distinta de null. <br>
 * El alumno no posee asignaturas aprobadas para las cuales no cumple con las correlativas correspondientes.
 */
public class Alumno extends Persona {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private TreeSet<Asignatura> aprobadas;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor vacio.
     */
    public Alumno() {
        super();
        setLegajo("ALU0000");
        aprobadas = new TreeSet<Asignatura>();
        verificarInvariante();
    }
    
    /**
     * Crea un alumno con sus atributos. <br>
     * <b>post: </b> Se crea un Alumno con sus datos correspondientes y una coleccion vacia de asignaturas aprobadas. <br>
     * @param legajo debe cumplir la mascara de legajo del alumno (ALUXXXX (X 0-9)) <br>
     * @param nombre es alfanumerico, distinto de null y de vacio. <br>
     * @param domicilio es alfanumerico, distinto de null y de vacio. <br>
     * @param mail debe cumplir la mascara de mail (AAAAA@AAAAAA)
     */
    public Alumno(String legajo, String nombre, String domicilio, String mail) {
        super(legajo, nombre, domicilio, mail);
        aprobadas = new TreeSet<Asignatura>();
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
      * Genera una descripcion textual del alumno. <br>
      * @return La descripcion generada.
      */
     public String getDescripcion() {
         String string = super.getDescripcion();
         string += "\nAprobadas:";
         if (!aprobadas.isEmpty()) {
             Iterator<Asignatura> it = aprobadas.iterator();
             Asignatura aprobada = null;
             while (it.hasNext()) {
                 aprobada = it.next();
                 string += "\n * " + aprobada.getId() + "-" + aprobada.getNombre();
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
     * El legajo debe empezar con "ALU" y luego debe contener 4 caracteres. <br>
     * El legajo debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el legajo es valido, false en caso contrario. 
     */
    static public boolean legajoEsValido(String legajo){
        int numeroLegajo;
        String auxLegajo;
        
        if(legajo.startsWith("ALU")){
            auxLegajo = legajo;
            auxLegajo = auxLegajo.substring(3);
            if (auxLegajo.length()==4) {
                try{
                    numeroLegajo=Integer.parseInt(auxLegajo);
                    if (numeroLegajo >= 0 && numeroLegajo <= 9999) {
                        return true;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Comprueba que la lista de asignaturas aprobadas sea distinta de null. <br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean aprobadasEsValido() {
        return aprobadas != null;
    }
    
    /**
     * Comprueba que la lista de asignaturas aprobadas no tenga asignaturas para las cuales no se cumplen las correlativas. <br>
     * @return True si la lista de aprobadas esta compuesta correctamente, false en caso contrario.
     */
    private boolean aprobadasConCorrelativas() {
        boolean correlativasAprobadas = true;
        Iterator<Asignatura> it = aprobadas.iterator();
        Asignatura asignatura = null;
        while (it.hasNext() && correlativasAprobadas) {
            asignatura = it.next();
            if (!aprobadas.containsAll(asignatura.getCorrelativas())) {
                correlativasAprobadas = false;
            }
        }
        
        return correlativasAprobadas;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv:</b> <br>
     * El legajo cumple con la mascara de alumno. <br>
     * La lista de asignaturas aprobadas es distinta de null. <br>
     * El alumno no posee asignaturas aprobadas para las cuales no cumple con las correlativas correspondientes.
     */
    private void verificarInvariante(){
        assert legajoEsValido(getLegajo()) : "La mascara del legajo es invalida.";
        assert aprobadasEsValido() : "La lista de aprobadas es invalida.";
        assert aprobadasConCorrelativas() : "La lista de aprobadas contiene asignaturas que no tienen correlativas aprobadas.";
    }
}
