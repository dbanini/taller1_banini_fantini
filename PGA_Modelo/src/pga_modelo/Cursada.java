package pga_modelo;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Representa una cursada junto con sus datos. <br>
 * El id debe cumplir la mascara de cursada (CURXXXX (X 0-9)) <br>
 * La asignatura debe ser valida. <br>
 * El periodo debe cumplir con la mascara de Periodo (CC-AAAA (CC cursada : 01 o 02) y AAAA (Año)) <br>
 * El dia debe pertenecer a Lun, Mar, Mié, Jue, Vie, Sab o Dom. <br>
 * La hora inicio debe cumplir con la mascada de Hora (99:99 (9 : 0-9)) <br>
 * La hora fin debe cumplir con la mascada de Hora (99:99 (9 : 0-9)) <br>
 * La hora fin debe ser mayor en valor numerico que la hora inicio <br>
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
    private String horaInicio;
    private String horaFin;
    private TreeSet<Profesor> profesores;
    private TreeSet<Alumno> alumnos;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public Cursada() {
        this.id = "CUR0000";
        this.asignatura = new Asignatura();
        this.periodo = "01-2017";
        this.dia = "Dom";
        this.horaInicio = "12:00";
        this.horaFin = "14:00";
        profesores = new TreeSet<Profesor>();
        alumnos = new TreeSet<Alumno>();
        verificarInvariante();
    }
    
    /**
     * Crea una cursada con sus atributos. <br>
     * @param id debe cumplir la mascara de cursada (CURXXXX (X 0-9)) y debe ser unica. <br>
     * @param asignatura debe existir. <br>
     * @param periodo debe cumplir con la mascara de Periodo (CC-AAAA (CC cursada : 01 o 02) y AAAA (Año)) <br>
     * @param dia debe pertenecer a Lun, Mar, Mié, Jue, Vie, Sab o Dom. <br>
     * @param hora debe cumplir con la mascada de Hora (99:99 (9 : 0-9))
     */
    public Cursada(String id, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin) {
        this.id = id;
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        profesores = new TreeSet<Profesor>();
        alumnos = new TreeSet<Alumno>();
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

    public void setHoraInicio(String hora) {
        this.horaInicio = hora;
        verificarInvariante();
    }

    public String getHoraInicio() {
        return horaInicio;
    }
    
    public void setHoraFin(String hora) {
        this.horaFin = hora;
        verificarInvariante();
    }

    public String getHoraFin() {
        return horaFin;
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
        
        string="Identificacion: "+id+" Periodo: "+periodo+" Dia: "+dia+" Hora I: "+horaInicio + "Hora F:" + horaFin +" "+asignatura.toString();
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
        return id.compareTo(o.getId());
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
    static public boolean idEsValido(String id) {
        int numeroId;
        String auxId;
        if (id != null) {
            if(id.startsWith("CUR")) {
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
     * El periodo cumple con la mascara de periodo CC-AAAA (CC cursada : 01 o 02) y AAAA (Año) <br>
     * @return True si el periodo es valido, false en caso contrario.
     */
    private boolean periodoEsValido() {
        String auxPeriodo;
        int anio;
    
        if ((periodo.startsWith("01") || periodo.startsWith("02")) && periodo.contains("-") && periodo.length()==7){
            auxPeriodo=periodo.substring(2);
            if (auxPeriodo.startsWith("-")){
                auxPeriodo=auxPeriodo.substring(1);
                anio=Integer.parseInt(auxPeriodo);
                if (anio>1900 && anio<2100)
                    return true;
            }
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
        case "Mi�":
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
     * Comprueba que la hora especificada sea valida. <br>
     * La hora cumple con la mascara 99:99 (9 : 0-9) <br>
     * @return True si la hora es valida, false en caso contrario.
     */ 
    public boolean horaEsValido(String hora) {
        String auxHora;
        int horas=0,minutos=0;
        
        if (hora.contains(":")){
            auxHora=hora.substring(3);
            
            minutos=Integer.parseInt(auxHora);
            auxHora=hora.substring(0,2);
            try{
                horas=Integer.parseInt(auxHora);
                if (horas>=0 && horas<24 && minutos>=0 && minutos<60)
                    return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        return false;
    }
    
    /**
     * Comprueba si una hora es mayor a otra. <br>
     * <b>pre: </b> Las horas deben cumplir con la mascara 99:99 (9 : 0-9) <br>
     * @return True si la horaA es mayor a la horaB, false en caso contrario.
     */ 
    public boolean horaMayorA(String horaA, String horaB) {
        assert horaEsValido(horaA) : "La hora A es invalida.";
        assert horaEsValido(horaB) : "La hora B es invalida.";
        
        // TODO Implementar chequeo entre horas.
        
        return true;
    }
    
    /**
     * Comprueba que la lista de profesores sea valida. <br>
     * La lista de profesores es distinta de null. <br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean profesoresEsValido() {
        return profesores != null;
    }
    
    /**
     * Comprueba que la lista de alumnos sea valida. <br>
     * La lista de alumnos es distinta de null. <br>
     * @return True si la lista es valida, false en caso contrario.
     */
    private boolean alumnosEsValido() {
        return alumnos != null;
    }
    
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * El id cumple con la mascara. <br>
     * La asignatura es distinta de null. <br>
     * El periodo cumple con la mascara. <br>
     * El dia es igual a algun string de dias. <br>
     * La hora inicio cumple con la mascara. <br>
     * La hora fin cumple con la mascara. <br>
     * La hora fin es mayor que la hora inicio. <br>
     * La lista de profesores es distinta de null. <br>
     * La lista de alumnos es distinta de null.
     */
    private void verificarInvariante(){
        assert idEsValido(id): "El id es invalido.";
        assert asignaturaEsValido(): "La asignatura es invalida.";
        assert periodoEsValido(): "El periodo es invalido.";
        assert diaEsValido(): "El dia es invalido.";
        assert horaEsValido(horaInicio): "La hora inicio es invalida.";
        assert horaEsValido(horaFin): "La hora fin es invalida.";
        assert horaMayorA(horaFin, horaInicio): "La hora fin no es mayor a la hora inicio.";
        assert profesoresEsValido(): "La lista de profesores es invalida.";
        assert alumnosEsValido(): "La lista de alumnos es invalida.";
    }
}
