package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Representa una cursada junto con sus datos. <br>
 * El id debe cumplir la mascara de cursada (CURXXXX (X 0-9)) y debe ser unica. <br>
 * La asignatura debe ser valida. <br>
 * El periodo debe cumplir con la mascara de Periodo (CC-AAAA (CC cursada : 01 o 02) y AAAA (A�o)) <br>
 * El dia debe pertenecer a Lun, Mar, Mi�, Jue, Vie, Sab o Dom. <br>
 * La hora debe cumplir con la mascada de Hora (99:99 (9 : 0-9)) <br>
 * La lista de profesores es distinta de null. <br>
 * La lista de alumnos es distinta de null.
 */
public class Cursada implements Comparable<Cursada>{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private String id;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String hora;
    private TreeSet<Profesor> profesores;
    private TreeSet<Alumno> alumnos;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Crea una cursada con sus atributos. <br>
     * @param id debe cumplir la mascara de cursada (CURXXXX (X 0-9)) y debe ser unica. <br>
     * @param asignatura debe existir. <br>
     * @param periodo debe cumplir con la mascara de Periodo (CC-AAAA (CC cursada : 01 o 02) y AAAA (A�o)) <br>
     * @param dia debe pertenecer a Lun, Mar, Mi�, Jue, Vie, Sab o Dom. <br>
     * @param hora debe cumplir con la mascada de Hora (99:99 (9 : 0-9))
     */
    public Cursada(String id, Asignatura asignatura, String periodo, String dia, String hora) {
        this.id=id;
        this.asignatura=asignatura;
        this.periodo=periodo;
        this.dia=dia;
        this.hora=hora;
        profesores= new TreeSet<Profesor>();
        alumnos= new TreeSet<Alumno>();
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

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        verificarInvariante();
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
        verificarInvariante();
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setDia(String dia) {
        this.dia = dia;
        verificarInvariante();
    }

    public String getDia() {
        return dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
        verificarInvariante();
    }

    public String getHora() {
        return hora;
    }

    public void setProfesores(TreeSet<Profesor> profesores) {
        this.profesores = profesores;
        verificarInvariante();
    }

    public TreeSet<Profesor> getProfesores() {
        return profesores;
    }

    public void setAlumnos(TreeSet<Alumno> alumnos) {
        this.alumnos = alumnos;
        verificarInvariante();
    }

    public TreeSet<Alumno> getAlumnos() {
        return alumnos;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    /**
     * Agrega un profesor a la lista de profesores.<br>
     * <b>pre: </b> El profesor no existe en la lista.
     * <b>post: </b> Se agrego el profesor a la lista.
     * @param profesor cumple que es valido.
     */
    public void addProfesor(Profesor profesor){
        profesores.add(profesor);
        verificarInvariante();
    }
    
    /**
     * Elimina un profesor de la lista de profesores.<br>
     * <b>pre: </b> El profesor existe en la lista.
     * <b>post: </b> Se elimina al profesor de la lista.
     * @param  profesor cumple que es valido.
     */
    public void removeProfesor(Profesor profesor){
        profesores.remove(profesor);
        verificarInvariante();
    }
    
    /**
     * Agrega un alumno a la lista de alumnos.<br>
     * <b>pre: </b> El alumno no existe en la lista.
     * <b>post: </b> Se agrego el alumno a la lista.
     * @param alumno cumple que es valido.
     */
    public void addAlumno(Alumno alumno){
        alumnos.add(alumno);
        verificarInvariante();
    }
    
    /**
     * Elimina un alumno de la lista de alumnos.<br>
     * <b>pre: </b> El alumno existe en la lista.
     * <b>post: </b> Se elimina al alumno de la lista.
     * @param  alumno cumple que es valido.
     */
    public void removeAlumno(Alumno alumno){
        alumnos.remove(alumno);
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
        Profesor profesor;
        Alumno alumno;
        
        string="Identificacion: "+id+" Periodo: "+periodo+" Dia: "+dia+" Hora: "+hora+" "+asignatura.toString();
        it=profesores.iterator();
        while (it.hasNext()){
            profesor=(Profesor)it.next();
            string+=" "+profesor.toString();
        }
        string+="/n";
        it=alumnos.iterator();
        while (it.hasNext()){
            alumno=(Alumno)it.next();
            string+=" "+alumno.toString();
        }
        string+="/n";
        return string;
        
    }
    
    /**
     * Compara esta cursada con otra cursada. <br>
     * @param o Es la otra cursada a comparar.
     * @return Si this<o retorna negativo. Si this==o retorna 0. Si this>o retorna positivo.
     */
    @Override
    public int compareTo(Cursada o) {
        return asignatura.getNombre().compareToIgnoreCase(o.getAsignatura().getNombre());
    }
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    
    /**
     * Comprueba si el id es valido. <br>
     * El id debe ser distinto de null. <br>
     * El id debe empezar con "CUR" y luego contener 4 caracteres. <br>
     * El id debe terminar con un numero entre 0 y 9999. <br>
     * @return True si el id es valido, false en caso contrario. 
     */
    private boolean idEsValido() {
        int numeroLegajo;
        String auxLegajo;
        
        if (id!=null){
            if(id.startsWith("CUR")){
                auxLegajo=id;
                auxLegajo=auxLegajo.substring(3);
                try{
                    numeroLegajo=Integer.parseInt(auxLegajo);
                    if (numeroLegajo>0 && numeroLegajo<9999)
                        return true;
                }catch (NumberFormatException e){
                    return false;
                }
            }
        }
        return false;
    }
    
    /**
     * Comprueba que la asignatura sea valida. <br>
     * El atributo asignatura debe ser distinto de null y de vacio. <br>
     * @return True si la asignatura es valida, false en caso contrario. 
     */
    private boolean asignaturaEsValido() {
        if (asignatura!=null)
            return true;
        return false;
    }
    
    /**
     * Comprueba que el periodo sea valido. <br>
     * El periodo cumple con la mascara de periodo CC-AAAA (CC cursada : 01 o 02) y AAAA (A�o) <br>
     * @return True si el periodo es valido, false en caso contrario.
     */
    private boolean periodoEsValido() {
        String auxPeriodo;
        int anio;
    
        if ((periodo.startsWith("01") || periodo.startsWith("02")) && periodo.contains("-")){
            auxPeriodo=periodo;
            auxPeriodo=auxPeriodo.substring(3);
            anio=Integer.parseInt(auxPeriodo);
            if (anio>1900 && anio<2100)
                return true;
        }
        return false;
            
    }
    
    /**
     * Comprueba que el dia sea valido. <br>
     * El dia cumple con uno de los dias de la semana. <br>
     * @return True si el dia es valido, false en caso contrario.
     */
    private boolean diaEsValido() {
        switch (dia){
        
        case "Lun":
        case "Mar":
        case "Mie":
        case "Jue":
        case "Vie":
        case "Sab":
        case "Dom":
            return true;
        default:
            return false;
        }
    }

    /**
     * Comprueba que la hora sea valida. <br>
     * La hora cumple con la mascara 99:99 (9 : 0-9) <br>
     * @return True si la hora es valida, false en caso contrario.
     */ 
    private boolean horaEsValido() {
        String auxHora;
        int horas,minutos;
        
        if (hora.contains(":")){
            auxHora=hora;
            auxHora=auxHora.substring(3);
            minutos=Integer.parseInt(auxHora);
            auxHora=hora;
            auxHora=auxHora.substring(0,1); 
            try{
                horas=Integer.parseInt(auxHora);
                if (horas>0 && horas<24 && minutos>0 && minutos<60)
                    return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        return false;
    }
    
    /**
     * Comprueba que la lista de profesores sea valida. <br>
     * La lista de profesores es distinta de null. <br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean profesoresEsValido() {
        if (profesores!=null)
            return true;
        return false;
    }
    
    /**
     * Comprueba que la lista de alumnos sea valida. <br>
     * La lista de alumnos es distinta de null. <br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean alumnosEsValido() {
        if (alumnos!=null)
            return true;
        return false;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El id cumple con la mascara. <br>
     * La asignatura es distinta de null. <br>
     * El periodo cumple con la mascara. <br>
     * El dia es igual a algun string de dias. <br>
     * La hora cumple con la mascara. <br>
     * La lista de profesores es distinta de null. <br>
     * La lista de alumnos es distinta de null.
     */
    private void verificarInvariante(){
        assert idEsValido(): "El id es invalido.";
        assert asignaturaEsValido(): "La asignatura es invalida.";
        assert periodoEsValido(): "El periodo es invalido.";
        assert diaEsValido(): "El dia es invalido.";
        assert horaEsValido(): "La hora es invalida.";
        assert profesoresEsValido(): "La lista de profesores es invalida.";
        assert alumnosEsValido(): "La lista de alumnos es invalida.";
    }
}
