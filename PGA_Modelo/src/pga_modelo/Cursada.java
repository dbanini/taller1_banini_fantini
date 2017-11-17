package pga_modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Representa una cursada junto con sus datos. <br>
 * <b>inv: </b>
 * El id cumple con la mascara. <br>
 * La asignatura es distinta de null. <br>
 * El periodo cumple con la mascara. <br>
 * El dia es igual a algun string de dias. <br>
 * La hora inicio cumple con la mascara. <br>
 * La hora fin cumple con la mascara. <br>
 * La hora fin es mayor que la hora inicio. <br>
 * La lista de profesores es distinta de null y no contiene profesores nulos. <br>
 * La lista de alumnos es distinta de null y no contiene alumnos nulos. <br>
 * Los alumnos que participan de la cursada cumplen con las correlatividades de la asignatura. <br>
 * Los profesores que participan de la cursada estan habilitados a dar la asignatura.
 */
public class Cursada {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private String id;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor vacio utilizado al serializar y al crear una nueva cursada.
     */
    public Cursada() {
        this.id = "CUR0000";
        this.asignatura = new Asignatura();
        this.periodo = "01-2017";
        this.dia = "Dom";
        this.horaInicio = "00:00";
        this.horaFin = "23:59";
        profesores = new ArrayList<Profesor>();
        alumnos = new ArrayList<Alumno>();
        verificarInvariante();
    }

    /**
     * Crea una cursada con sus atributos. <br>
     * @param id El id debe cumplir la mascara de cursada (CURXXXX (X 0-9)) y debe ser unica. <br>
     * @param asignatura La asignatura debe existir. <br>
     * @param periodo El periodo debe cumplir con la mascara de Periodo (CC-AAAA (CC cursada : 01 o 02) y AAAA (AAAA>1900 && AAAA<2100)) <br>
     * @param dia El dia debe pertenecer a Lun, Mar, Mie, Jue, Vie, Sab o Dom. <br>
     * @param hora La hora debe cumplir con la mascada de Hora (99:99 (9 : 0-9))
     */
    public Cursada(String id, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin) {
        this.id = id;
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        profesores = new ArrayList<Profesor>();
        alumnos = new ArrayList<Alumno>();
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

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
        verificarInvariante();
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
        verificarInvariante();
    }

    public String getHoraFin() {
        return horaFin;
    }

    /**
     * Se permite la manipulacion directa de la coleccion.
     * @param profesores La lista nueva de profesores que participan en la materia.
     */
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
        verificarInvariante();
    }

    /**
     * Se permite la manipulacion directa de la coleccion desde el controlador.
     * @return La lista de profesores que participan en la materia.
     */
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Se permite la manipulacion directa de la coleccion.
     * @param alumnos La lista nueva de alumnos que estan anotados en la cursada.
     */
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
        verificarInvariante();
    }

    /**
     * Se permite la manipulacion directa de la coleccion desde el controlador.
     * @return La lista de alumnos que estan anotados en la cursada.
     */
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Permite modificar la configuracion de la cursada sin provocar errores por el invariante basados en el orden de operaciones.
     * @param asignatura La nueva asignatura de la cursada.
     * @param periodo El nuevo periodo de la cursada.
     * @param dia El nuevo dia de la cursada.
     * @param horaInicio La nueva hora de inicio de la cursada.
     * @param horaFin La nueva hora de fin de la cursada.
     * @param alumnos Los nuevos alumnos de la cursada.
     * @param profesores Los nuevos profesores de la cursada.
     */
    public void configurar(Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin,
                           ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores) {
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.alumnos = alumnos;
        this.profesores = profesores;
        verificarInvariante();
    }

    /**
     * Comprueba si esta cursada se superpone con otra en base al periodo, dia y hora de inicio y fin. <br>
     * @param cursada El parametro con el cual se verifica la superposicion de la cursada. <br>
     * @return True si existe una superposicion, false en caso contrario.
     */
    public boolean seSuperponeCon(Cursada cursada) {
        return seSuperponeCon(cursada, horaInicio, horaFin, periodo, dia);
    }

    /**
     * Comprueba si esta cursada se superpone con otra en base al periodo, dia y hora de inicio y fin, para un horario especifico. <br>
     * @param cursada La cursada con la cual se verifica la superposicion. <br>
     * @param horaInicio La hora inicial con la cual se verifica la superposicion. <br>
     * @param horaFin La hora final con la cual se verifica la superposicion. <br>
     * @param periodo El periodo con el cual se verifica la superposicion. <br>
     * @param dia El dia con el cual se verifica la superposicion. <br>
     * @return true si existe una superposicion, false en caso contrario.
     */
    static public boolean seSuperponeCon(Cursada cursada, String horaInicio, String horaFin, String periodo,
                                         String dia) {
        if (cursada.getPeriodo().equals(periodo) && cursada.getDia().equals(dia)) {
            if (!horaInicio.equals(cursada.getHoraFin()) && !horaFin.equals(cursada.getHoraInicio()) &&
                !horaMayorA(horaInicio, cursada.getHoraFin()) && !horaMayorA(cursada.getHoraInicio(), horaFin)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Comprueba si esta cursada se superpone con otra lista de cursadas. <br>
     * @param cursadas Lista de cursadas con la cual se verifica la superposicion. Puede incluirse esta cursada
     * en la lista, la cual sera ignorada. <br>
     * @return true si existe una superposicion, false en caso contrario.
     */
    public boolean seSuperponeCon(ArrayList<Cursada> cursadas) {
        return seSuperponeCon(cursadas, horaInicio, horaFin, periodo, dia, this);
    }

    /**
     * Comprueba si esta cursada se superpone con otra lista de cursadas en un horario especifico. <br>
     * @param cursadas Lista de cursadas con la cual se verifica la superposicion. <br>
     * @param cursadaIgnorada Una cursada opcional que puede ser ignorada de la lista. <br>
     * @return true si existe una superposicion, false en caso contrario.
     */
    static public boolean seSuperponeCon(ArrayList<Cursada> cursadas, String horaInicio, String horaFin, String periodo,
                                         String dia, Cursada cursadaIgnorada) {
        boolean conSuperposicion = false;
        Iterator<Cursada> it = cursadas.iterator();
        Cursada cursada = null;
        while (it.hasNext() && !conSuperposicion) {
            cursada = it.next();
            if ((cursada != cursadaIgnorada) && seSuperponeCon(cursada, horaInicio, horaFin, periodo, dia)) {
                conSuperposicion = true;
            }
        }

        return conSuperposicion;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Comprueba si el id es valido. <br>
     * El id debe ser distinto de null. <br>
     * El id debe empezar con "CUR" y luego contener 4 caracteres. <br>
     * El id debe terminar con un numero entre 0 y 9999. <br>
     * @param id El id a validar. <br>
     * @return true si el id es valido, false en caso contrario.
     */
    static public boolean idEsValido(String id) {
        int numeroId;
        String auxId;
        if (id != null && id.startsWith("CUR") && (id.length() == 7)) {
            auxId = id;
            auxId = auxId.substring(3);
            try {
                numeroId = Integer.parseInt(auxId);
                if (numeroId >= 0 && numeroId <= 9999) {
                    return true;
                }
            } catch (NumberFormatException e) {
                 return false;
            }
        }
        
        return false;
    }

    /**
     * Comprueba que la asignatura sea valida. <br>
     * El atributo asignatura debe ser distinto de null y de vacio. <br>
     * @return true si la asignatura es valida, false en caso contrario.
     */
    private boolean asignaturaEsValido() {
        return asignatura != null;
    }

    /**
     * Comprueba que el periodo sea valido. <br>
     * El periodo cumple con la mascara de periodo CC-AAAA (CC cursada : 01 o 02) (AAAA anio : entre 1900 y 2100)<br>
     * @param periodo El periodo a validar. <br>
     * @return true si el periodo es valido, false en caso contrario.
     */
    static public boolean periodoEsValido(String periodo) {
        String auxPeriodo;
        int anio;

        if (periodo.length() == 7 && (periodo.startsWith("01") || periodo.startsWith("02"))) {
            auxPeriodo = periodo.substring(2);
            if (auxPeriodo.startsWith("-")) {
                auxPeriodo = auxPeriodo.substring(1);
                try {
                    anio = Integer.parseInt(auxPeriodo);
                    if (anio > 1900 && anio < 2100)
                        return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Comprueba que el dia sea valido. <br>
     * El dia cumple con uno de los dias de la semana. <br>
     * @param dia El dia a validar. <br>
     * @return true si el dia es valido, false en caso contrario.
     */
    static public boolean diaEsValido(String dia) {
        if (dia != null) {
            switch (dia) {
            case "Lun":
            case "Mar":
            case "Mié":
            case "Jue":
            case "Vie":
            case "Sab":
            case "Dom":
                return true;
            default:
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Comprueba que la hora especificada sea valida. <br>
     * La hora cumple con la mascara XX:YY (XX : 0-24) (YY : 0-60) <br>
     * @param hora La hora a validar. <br>
     * @return true si la hora es valida, false en caso contrario.
     */
    static public boolean horaEsValido(String hora) {
        String auxHora;
        int horas = 0, minutos = 0;

        if (hora.length() == 5 && hora.charAt(2) == ':') {
            auxHora = hora.substring(3);
            try {
                minutos = Integer.parseInt(auxHora);
                auxHora = hora.substring(0, 2);
                horas = Integer.parseInt(auxHora);
                if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60)
                    return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Comprueba si una hora es mayor a otra. <br>
     * <b>pre: </b> Las horas deben cumplir con la mascara 99:99 (9 : 0-9) <br>
     * @param horaA La primera hora a comparar. <br>
     * @param horaB La segunda hora a comparar. <br>
     * @return true si la horaA es mayor a la horaB, false en caso contrario.
     */
    static public boolean horaMayorA(String horaA, String horaB) {
        assert horaEsValido(horaA) : "La hora A es invalida.";
        assert horaEsValido(horaB) : "La hora B es invalida.";
        return horaA.compareTo(horaB) > 0;
    }

    /**
     * Comprueba que la lista de profesores sea valida. <br>
     * La lista de profesores es distinta de null. <br>
     * @return true si la lista es valida, false en caso contrario.
     */
    private boolean profesoresEsValido() {
        return profesores != null && !profesores.contains(null);
    }

    /**
     * Comprueba que la lista de alumnos sea valida. <br>
     * La lista de alumnos es distinta de null. <br>
     * @return true si la lista es valida, false en caso contrario.
     */
    private boolean alumnosEsValido() {
        return alumnos != null && !alumnos.contains(null);
    }

    /**
     * Comprueba que los alumnos que participan cumplan con las correlatividades de la asignatura. <br>
     * @return true si estan todos los alumnos habilitados, false en caso contrario.
     */
    private boolean alumnosHabilitados() {
        boolean habilitados = true;
        Iterator<Alumno> it = alumnos.iterator();
        Alumno alumno = null;
        while (it.hasNext() && habilitados) {
            alumno = it.next();

            // Verificamos si el alumno no ha aprobado todas las correlativas requeridas por la asignatura.
            if (!alumno.getAprobadas().containsAll(asignatura.getCorrelativas())) {
                habilitados = false;
            }
        }

        return habilitados;
    }

    /**
     * Comprueba que los profesores que participan esten habilitados a dar la cursada. <br>
     * @return True si estan todos los profesores habilitados, false en caso contrario.
     */
    private boolean profesoresHabilitados() {
        boolean habilitados = true;
        Iterator<Profesor> it = profesores.iterator();
        Profesor profesor = null;
        while (it.hasNext() && habilitados) {
            profesor = it.next();

            // Verificamos si el profesor esta habilitado a dar la asignatura.
            if (!profesor.getHabilitadas().contains(asignatura)) {
                habilitados = false;
            }
        }

        return habilitados;
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
     * La lista de profesores es distinta de null y no contiene profesores nulos. <br>
     * La lista de alumnos es distinta de null y no contiene alumnos nulos. <br>
     * Los alumnos que participan de la cursada cumplen con las correlatividades de la asignatura. <br>
     * Los profesores que participan de la cursada estan habilitados a dar la asignatura.
     */
    private void verificarInvariante() {
        assert idEsValido(id) : "El id es invalido.";
        assert asignaturaEsValido() : "La asignatura es invalida.";
        assert periodoEsValido(periodo) : "El periodo es invalido.";
        assert diaEsValido(dia) : "El dia es invalido.";
        assert horaEsValido(horaInicio) : "La hora inicio es invalida.";
        assert horaEsValido(horaFin) : "La hora fin es invalida.";
        assert horaMayorA(horaFin, horaInicio) : "La hora fin no es mayor a la hora inicio.";
        assert profesoresEsValido() : "La lista de profesores es invalida.";
        assert alumnosEsValido() : "La lista de alumnos es invalida.";
        assert alumnosHabilitados() : "Existen alumnos que no estan habilitados a participar en la cursada.";
        assert profesoresHabilitados() : "Existen profesores que no estan habilitados a dar la cursada.";
    }
}
