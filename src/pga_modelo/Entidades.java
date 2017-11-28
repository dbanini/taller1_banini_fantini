package pga_modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * Contiene todas las colecciones para la administracion del sistema PGA.
 * <b>inv: </b>
 * La lista de profesores es distinta de null. <br>
 * La lista de alumnos es distinta de null. <br>
 * La lista de asignaturas es distinta de null. <br>
 * La lista de cursadas es distinta de null. <br>
 * La lista de profesores debe tener legajos duplicados. <br>
 * La lista de alumnos no debe tener legajos duplicados. <br>
 * La lista de asignaturas no debe tener ids duplicados. <br>
 * La lista de cursadas no debe tener ids duplicados. <br>
 * Cada alumno de la coleccion no participa en cursadas que se superponen. <br>
 * Cada profesor de la coleccion no participa en cursadas que se superponen.
 */
public class Entidades {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private ArrayList<Alumno> alumnos;
    private ArrayList<Profesor> profesores;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Cursada> cursadas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor vacio utilizado al serializar y al crear una neueva entidad.
     */
    public Entidades() {
        alumnos = new ArrayList<Alumno>();
        profesores = new ArrayList<Profesor>();
        asignaturas = new ArrayList<Asignatura>();
        cursadas = new ArrayList<Cursada>();
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------

    /**
     * Setter de alumnos. Acceso publico solo para el serializador. NO USAR.
     */
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
        verificarInvariante();
    }

    /** Devuelve la coleccion de alumnos. Acceso publico para el serializador. NO MODIFICAR MANUALMENTE.
     */
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Setter de profesores. Acceso publico solo para el serializador. NO USAR.
     */
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
        verificarInvariante();
    }

    /** Devuelve la coleccion de profesores. Acceso publico para el serializador. NO MODIFICAR MANUALMENTE.
     */
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Setter de asignaturas. Acceso publico solo para el serializador. NO USAR.
     */
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
        verificarInvariante();
    }

    /** Devuelve la coleccion de asignaturas. Acceso publico para el serializador. NO MODIFICAR MANUALMENTE.
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    /**
     * Setter de cursadas. Acceso publico solo para el serializador. NO USAR.
     */
    public void setCursadas(ArrayList<Cursada> cursadas) {
        this.cursadas = cursadas;
        verificarInvariante();
    }

    /** Devuelve la coleccion de cursadas. Acceso publico para el serializador. NO MODIFICAR MANUALMENTE.
     */
    public ArrayList<Cursada> getCursadas() {
        return cursadas;
    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Agrega un alumno a la lista de alumnos. <br>
     * <b>pre: </b> El alumno no existe en la lista de alumnos.
     * <b>post: </b> Se agrega un alumno a la lista de alumnos.
     *  @param alumnos El alumno a agregar a la coleccion.
     */
    public void addAlumno(Alumno alumno) {
        assert !alumnos.contains(alumno) : "El alumno ya existe en la lista de alumnos.";
        alumnos.add(alumno);
        assert alumnos.contains(alumno) : "El alumno no fue agregado a la lista de alumnos.";
        verificarInvariante();
    }

    /**
     * Elimina un alumno de la lista de alumnos. <br>
     * <b>pre: </b> El alumno existe en la lista de alumnos.
     * <b>pre: </b> El alumno no debe estar en la lista de alumnos de ninguna cursada.
     * <b>post: </b> Se elimina un alumno de la lista de alumnos.
     *  @param alumnos El alumno a eliminar de la coleccion.
     */
    public void removeAlumno(Alumno alumno) {
        assert alumnos.contains(alumno) : "El alumno no existe en la lista de alumnos.";
        assert buscaCursadasConAlumno(alumno).isEmpty() : "Hay cursadas que contienen referencias al alumno.";
        alumnos.remove(alumno);
        assert !alumnos.contains(alumno) : "El alumno no fue eliminado de la lista de alumnos.";
        verificarInvariante();
    }

    /**
     * Agrega un profesor a la lista de profesores. <br>
     * <b>pre: </b> El profesor no existe en la lista de profesores.
     * <b>post: </b> Se agrega un profesor a la lista de profesores.
     *  @param profesor El profesor a agregar a la coleccion.
     */
    public void addProfesor(Profesor profesor) {
        assert !profesores.contains(profesor) : "El profesor ya existe en la lista de profesores.";
        profesores.add(profesor);
        assert profesores.contains(profesor) : "El profesor no fue agregado a la lista de profesores.";
        verificarInvariante();
    }

    /**
     * Elimina un profesor de la lista de profesores. <br>
     * <b>pre: </b> El profesor existe en la lista de profesores.
     * <b>pre: </b> El profesor no debe estar en la lista de profesores de ninguna cursada.
     * <b>post: </b> Se elimina un profesor de la lista de profesores.
     *  @param profesor El profesor a eliminar de la coleccion.
     */
    public void removeProfesor(Profesor profesor) {
        assert profesores.contains(profesor) : "El profesor no existe en la lista de profesores.";
        assert buscaCursadasConProfesor(profesor).isEmpty() : "Hay cursadas que contienen referencias al profesor.";
        profesores.remove(profesor);
        assert !profesores.contains(profesor) : "El profesor no fue eliminado de la lista de profesores.";
        verificarInvariante();
    }

    /**
     * Agrega una asignatura a la lista de asignaturas. <br>
     * <b>pre: </b> La asignatura no existe en la lista de asignaturas.
     * <b>post: </b> Se agrega una asignatura a la lista de aisgnaturas.
     *  @param asignatura La asignatura a agregar a la coleccion.
     */
    public void addAsignatura(Asignatura asignatura) {
        assert !asignaturas.contains(asignatura) : "La asignatura ya existe en la lista de asignaturas.";
        asignaturas.add(asignatura);
        assert asignaturas.contains(asignatura) : "La asignatura no fue agregada a la lista de asignaturas.";
        verificarInvariante();
    }

    /**
     * Elimina una asignatura de la lista de asignaturas.
     * <b>pre: </b> La asignatura existe en la lista de asignaturas.
     * <b>pre: </b> La asignatura no debe estar en la lista de aprobadas de ningun alumno.
     * <b>pre: </b> La asignatura no debe estar en la lista de habilitadas de ningun profesor.
     * <b>pre: </b> La asignatura no debe estar en la lista de correlativas de otra asignatura.
     * <b>pre: </b> La asignatura no debe estar asignada a alguna cursada.
     * <b>post: </b> Se elimina una asignatura de la lista de asignaturas.
     * @param asignatura La asignatura a eliminar de la coleccion.
     */
    public void removeAsignatura(Asignatura asignatura) {
        assert asignaturas.contains(asignatura) : "La asignatura no existe en la lista de asignaturas.";
        assert buscaAlumnosConAsignatura(asignatura).isEmpty() : "Hay alumnos que contienen referencias a la asignatura.";
        assert buscaProfesoresConAsignatura(asignatura).isEmpty() : "Hay profesores que contienen referencias a la asignatura.";
        assert buscaAsignaturasConCorrelativa(asignatura).isEmpty() : "Hay asignaturas que tienen como correlativa a esta asignatura.";
        assert buscaCursadasConAsignatura(asignatura).isEmpty() : "Hay cursadas que refieren a la asignatura.";
        asignaturas.remove(asignatura);
        assert !asignaturas.contains(asignatura) : "La asignatura no ha sido eliminada.";
        verificarInvariante();
    }

    /**
     * Agrega una cursada a la lista de cursadas. <br>
     * <b>pre: </b> La cursada no existe en la lista de cursadas. <br>
     * <b>post: </b> Se agrega una cursada a la lista de cursadas. <br>
     * @param cursada La cursada a agregar a la coleccion.
     */
    public void addCursada(Cursada cursada) {
        assert !cursadas.contains(cursada) : "La cursada ya existe en la lista de cursadas.";
        cursadas.add(cursada);
        assert cursadas.contains(cursada) : "La cursada no fue agregada a la lista de cursadas.";
        verificarInvariante();
    }

    /**
     * Elimina una cursada de la lista de cursadas. <br>
     * <b>pre: </b> La cursada existe en la lista de cursadas. <br>
     * <b>post: </b> Se elimina una cursada de la lista de cursadas. <br>
     * @param cursada La cursada a eliminar de la coleccion.
     */
    public void removeCursada(Cursada cursada) {
        assert cursadas.contains(cursada) : "La cursada no existe en la lista de cursadas.";
        cursadas.remove(cursada);
        assert !cursadas.contains(cursada) : "La cursada no ha sido eliminada de la lista de cursadas.";
        verificarInvariante();
    }

    /**
     * Busqueda de alumnos con determinado nombre. <br>
     * @param nombre El nombre del alumno a buscar. <br>
     * @return Retorna en un ArrayList los alumnos con el nombre especificado.
     */
    public ArrayList<Alumno> buscaAlumno(String nombre) {
        Iterator<Alumno> it;
        Alumno alumnoAux;
        ArrayList<Alumno> alumnosEncontrados = new ArrayList<Alumno>();

        it = alumnos.iterator();
        while (it.hasNext()) {
            alumnoAux = it.next();
            if (alumnoAux.getNombre().equalsIgnoreCase(nombre)) {
                alumnosEncontrados.add(alumnoAux);
            }
        }

        return alumnosEncontrados;
    }

    /**
     * Busca un alumno en la lista mediante su legajo. <br>
     * @param legajo El legajo del alumno a buscar. <br>
     * @return El alumno si fue encontrado, null en caso contrario.
     */
    public Alumno buscaAlumnoPorLegajo(String legajo) {
        Alumno alumno = null;
        boolean encontrado = false;

        // Iteramos en el set y verificamos que el alumno tenga el legajo buscado.
        Iterator<Alumno> it = alumnos.iterator();
        while (it.hasNext() && !encontrado) {
            alumno = it.next();
            encontrado = alumno.getLegajo().equals(legajo);
        }

        return encontrado ? alumno : null;
    }

    /**
     * Busqueda de profesores con determinado nombre. <br>
     * @param nombre El nombre del profesor a buscar. <br>
     * @return Retorna en un ArrayList los profesores con el nombre especificado.
     */
    public ArrayList<Profesor> buscaProfesor(String nombre) {
        Iterator<Profesor> it;
        Profesor profesoresAux;
        ArrayList<Profesor> ProfesoresEncontrados = new ArrayList<Profesor>();

        it = profesores.iterator();
        while (it.hasNext()) {
            profesoresAux = it.next();
            if (profesoresAux.getNombre().equalsIgnoreCase(nombre)) {
                ProfesoresEncontrados.add(profesoresAux);
            }
        }

        return ProfesoresEncontrados;
    }

    /**
     * Busca un profesor en la lista mediante su legajo. <br>
     * @param legajo El legajo del profesor a buscar. <br>
     * @return El profesor si fue encontrado, null en caso contrario.
     */
    public Profesor buscaProfesorPorLegajo(String legajo) {
        Profesor profesor = null;
        boolean encontrado = false;

        // Iteramos en el set y verificamos que el alumno tenga el legajo buscado.
        Iterator<Profesor> it = profesores.iterator();
        while (it.hasNext() && !encontrado) {
            profesor = it.next();
            encontrado = profesor.getLegajo().equals(legajo);
        }

        return encontrado ? profesor : null;
    }

    /**
     * Busqueda de asignaturas con determinado nombre. <br>
     * @param nombre El nombre de la asignatura a buscar. <br>
     * @return Retorna en un ArrayList las asignaturas con el nombre especificado.
     */
    public ArrayList<Asignatura> buscaAsignatura(String nombre) {
        Iterator<Asignatura> it;
        Asignatura asignaturaAux;
        ArrayList<Asignatura> asignaturaEncontrados = new ArrayList<Asignatura>();

        it = asignaturas.iterator();
        while (it.hasNext()) {
            asignaturaAux = it.next();
            if (asignaturaAux.getNombre().equalsIgnoreCase(nombre)) {
                asignaturaEncontrados.add(asignaturaAux);
            }
        }

        return asignaturaEncontrados;
    }

    /**
     * Busca una asignatura en la lista mediante su id. <br>
     * @param id El id de la asignatura a buscar. <br>
     * @return La asignatura si fue encontrada, null en caso contrario.
     */
    public Asignatura buscaAsignaturaPorId(String id) {
        Asignatura asignatura = null;
        boolean encontrado = false;

        // Iteramos en el set y verificamos que el alumno tenga el id buscado.
        Iterator<Asignatura> it = asignaturas.iterator();
        while (it.hasNext() && !encontrado) {
            asignatura = it.next();
            encontrado = asignatura.getId().equals(id);
        }

        return encontrado ? asignatura : null;
    }

    /**
     * Busqueda de cursadas con determinado nombre de asignatura. <br>
     * @param nombre El nombre de la cursada a buscar. <br>
     * @return Retorna en un ArrayList las cursadas cuya asignatura coincide con el nombre pasado por parametro.
     */
    public ArrayList<Cursada> buscaCursada(String nombre) {
        Iterator<Cursada> it;
        Cursada cursadaAux;
        ArrayList<Cursada> cursadaEncontrados = new ArrayList<Cursada>();

        it = cursadas.iterator();
        while (it.hasNext()) {
            cursadaAux = it.next();
            if (cursadaAux.getAsignatura().getNombre().equalsIgnoreCase(nombre)) {
                cursadaEncontrados.add(cursadaAux);
            }
        }

        return cursadaEncontrados;
    }

    /**
     * Busca una cursada en la lista mediante su id. <br>
     * @param id El id de la cursada a buscar. <br>
     * @return La cursada si fue encontrada, null en caso contrario.
     */
    public Cursada buscaCursadaPorId(String id) {
        Cursada cursada = null;
        boolean encontrado = false;

        // Iteramos en el set y verificamos que el alumno tenga el id buscado.
        Iterator<Cursada> it = cursadas.iterator();
        while (it.hasNext() && !encontrado) {
            cursada = it.next();
            encontrado = cursada.getId().equals(id);
        }

        return encontrado ? cursada : null;
    }

    /**
     * Devuelve una lista de los alumnos que tienen la asignatura buscada aprobada. <br>
     * @param asignatura La asignatura a buscar. <br>
     * @return La lista de alumnos.
     */
    public ArrayList<Alumno> buscaAlumnosConAsignatura(Asignatura asignatura) {
        ArrayList<Alumno> lista = new ArrayList<Alumno>();
        Iterator<Alumno> it = alumnos.iterator();
        Alumno alumno = null;
        while (it.hasNext()) {
            alumno = it.next();
            if (alumno.getAprobadas().contains(asignatura)) {
                lista.add(alumno);
            }
        }

        return lista;
    }

    /**
     * Devuelve una lista de los profesores que tienen la asignatura buscada habilitada. <br>
     * @param asignatura La asignatura a buscar. <br>
     * @return La lista de profesores.
     */
    public ArrayList<Profesor> buscaProfesoresConAsignatura(Asignatura asignatura) {
        ArrayList<Profesor> lista = new ArrayList<Profesor>();
        Iterator<Profesor> it = profesores.iterator();
        Profesor profesor = null;
        while (it.hasNext()) {
            profesor = it.next();
            if (profesor.getHabilitadas().contains(asignatura)) {
                lista.add(profesor);
            }
        }

        return lista;
    }

    /**
     * Devuelve una lista de asignaturas que tienen la asignatura como correlativa. <br>
     * @param correlativa La asignatura correlativa a buscar. <br>
     * @return La lista de asignaturas.
     */
    public ArrayList<Asignatura> buscaAsignaturasConCorrelativa(Asignatura correlativa) {
        ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
        Iterator<Asignatura> it = asignaturas.iterator();
        Asignatura asignatura = null;
        while (it.hasNext()) {
            asignatura = it.next();
            if (asignatura.getCorrelativas().contains(correlativa)) {
                lista.add(asignatura);
            }
        }

        return lista;
    }

    /**
     * Devuelve una lista de las cursadas que tienen la asignatura buscada asignada. <br>
     * @param asignatura La asignatura a buscar. <br>
     * @return La lista de cursadas.
     */
    public ArrayList<Cursada> buscaCursadasConAsignatura(Asignatura asignatura) {
        ArrayList<Cursada> lista = new ArrayList<Cursada>();
        Iterator<Cursada> it = cursadas.iterator();
        Cursada cursada = null;
        while (it.hasNext()) {
            cursada = it.next();
            if (cursada.getAsignatura() == asignatura) {
                lista.add(cursada);
            }
        }

        return lista;
    }

    /**
     * Devuelve una lista de las cursadas que tienen al alumno buscado. <br>
     * @param alumno El alumno a buscar. <br>
     * @return La lista de cursadas.
     */
    public ArrayList<Cursada> buscaCursadasConAlumno(Alumno alumno) {
        ArrayList<Cursada> lista = new ArrayList<Cursada>();
        Iterator<Cursada> it = cursadas.iterator();
        Cursada cursada = null;
        while (it.hasNext()) {
            cursada = it.next();
            if (cursada.getAlumnos().contains(alumno)) {
                lista.add(cursada);
            }
        }

        return lista;
    }

    /**
     * Devuelve una lista de las cursadas que tienen al profesor buscado. <br>
     * @param profesor El profesor a buscar. <br>
     * @return La lista de cursadas.
     */
    public ArrayList<Cursada> buscaCursadasConProfesor(Profesor profesor) {
        ArrayList<Cursada> lista = new ArrayList<Cursada>();
        Iterator<Cursada> it = cursadas.iterator();
        Cursada cursada = null;
        while (it.hasNext()) {
            cursada = it.next();
            if (cursada.getProfesores().contains(profesor)) {
                lista.add(cursada);
            }
        }

        return lista;
    }

    /**
     * Genera un nuevo legajo unico para un nuevo alumno. <br>
     * @return El nuevo legajo.
     */
    public String nuevoLegajoAlumno() {
        // TODO: Alguna busqueda mas eficiente.
        String legajo = "ALU9999";
        boolean encontrado = false;
        for (int i = 0; (i <= 9999) && !encontrado; i++) {
            legajo = String.format("ALU%04d", i);
            encontrado = buscaAlumnoPorLegajo(legajo) == null;
        }
        return legajo;
    }

    /**
     * Genera un nuevo legajo unico para un nuevo profesor. <br>
     * @return El nuevo legajo.
     */
    public String nuevoLegajoProfesor() {
        // TODO: Alguna busqueda mas eficiente.
        String legajo = "PRO9999";
        boolean encontrado = false;
        for (int i = 0; (i <= 9999) && !encontrado; i++) {
            legajo = String.format("PRO%04d", i);
            encontrado = buscaProfesorPorLegajo(legajo) == null;
        }
        return legajo;
    }

    /**
     * Genera un nuevo legajo unico para una nueva asignatura.
     * @return El nuevo Id.
     */
    public String nuevoIdAsignatura() {
        // TODO: Alguna busqueda mas eficiente.
        String id = "ASI9999";
        boolean encontrado = false;
        for (int i = 0; (i <= 9999) && !encontrado; i++) {
            id = String.format("ASI%04d", i);
            encontrado = buscaAsignaturaPorId(id) == null;
        }
        return id;
    }

    /**
     * Genera un nuevo legajo unico para una nueva cursada.
     * @return El nuevo Id.
     */
    public String nuevoIdCursada() {
        // TODO: Alguna busqueda mas eficiente.
        String id = "CUR9999";
        boolean encontrado = false;
        for (int i = 0; (i <= 9999) && !encontrado; i++) {
            id = String.format("CUR%04d", i);
            encontrado = buscaCursadaPorId(id) == null;
        }
        return id;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Comprueba si la lista profesores es valida. <br>
     * @return True si la lista de profesores es valida, false en caso contrario.
     */
    private boolean profesoresEsValido() {
        return profesores != null;
    }

    /**
     * Comprueba si la lista alumnos es valida. <br>
     * @return True si la lista de alumnos es valida, false en caso contrario.
     */
    private boolean alumnosEsValido() {
        return alumnos != null;
    }

    /**
     * Comprueba si la lista asignaturas es valida. <br>
     * @return True si la lista de asignaturas es valida, false en caso contrario.
     */
    private boolean asignaturasEsValido() {
        return asignaturas != null;
    }

    /**
     * Comprueba si la lista cursadas es valida. <br>
     * @return True si la lista de cursadas es valida, false en caso contrario.
     */
    private boolean cursadasEsValido() {
        return cursadas != null;
    }

    /**
     * Verifica que los legajos de todos los profesores sean únicos.
     * @return True si la lista de profesores no contiene legajos duplicados, false en caso contrario.
     */
    private boolean profesoresSinDuplicados() {
        boolean sinDuplicados = true;
        TreeSet<String> legajos = new TreeSet<String>();
        Iterator<Profesor> it = profesores.iterator();
        String legajo = null;
        while (it.hasNext() && sinDuplicados) {
            legajo = it.next().getLegajo();
            if (legajos.contains(legajo)) {
                sinDuplicados = false;
            } else {
                legajos.add(legajo);
            }
        }

        return sinDuplicados;
    }

    /**
     * Verifica que los legajos de todos los alumnos sean únicos.
     * @return True si la lista de alumnos no contiene legajos duplicados, false en caso contrario.
     */
    private boolean alumnosSinDuplicados() {
        boolean sinDuplicados = true;
        TreeSet<String> legajos = new TreeSet<String>();
        Iterator<Alumno> it = alumnos.iterator();
        String legajo = null;
        while (it.hasNext() && sinDuplicados) {
            legajo = it.next().getLegajo();
            if (legajos.contains(legajo)) {
                sinDuplicados = false;
            } else {
                legajos.add(legajo);
            }
        }

        return sinDuplicados;
    }

    /**
     * Verifica que los ids de todas las asignaturas sean únicos.
     * @return True si la lista de asignaturas no contiene ids duplicados, false en caso contrario.
     */
    private boolean asignaturasSinDuplicados() {
        boolean sinDuplicados = true;
        TreeSet<String> ids = new TreeSet<String>();
        Iterator<Asignatura> it = asignaturas.iterator();
        String id = null;
        while (it.hasNext() && sinDuplicados) {
            id = it.next().getId();
            if (ids.contains(id)) {
                sinDuplicados = false;
            } else {
                ids.add(id);
            }
        }

        return sinDuplicados;
    }

    /**
     * Verifica que los ids de todas los cursadas sean únicos.
     * @return True si la lista de cursadas no contiene ids duplicados, false en caso contrario.
     */
    private boolean cursadasSinDuplicados() {
        boolean sinDuplicados = true;
        TreeSet<String> ids = new TreeSet<String>();
        Iterator<Cursada> it = cursadas.iterator();
        String id = null;
        while (it.hasNext() && sinDuplicados) {
            id = it.next().getId();
            if (ids.contains(id)) {
                sinDuplicados = false;
            } else {
                ids.add(id);
            }
        }

        return sinDuplicados;
    }

    /**
     * Comprueba que las cursadas de una lista de cursadas no se superpongan. <br>
     * @param cursadasLista Lista de cursadas a verificar. <br>
     * @return True si no existen superposiciones, false en caso contrario.
     */
    private boolean cursadasSinSuperposicion(ArrayList<Cursada> cursadasLista) {
        // Buscar entre las cursadas que le corresponden si existe alguna superposicion de horarios.
        boolean sinSuperposicion = true;
        Iterator<Cursada> it = cursadasLista.iterator();
        Cursada cursada = null;
        while (it.hasNext() && sinSuperposicion) {
            cursada = it.next();
            if (cursada.seSuperponeCon(cursadasLista)) {
                sinSuperposicion = false;
            }
        }

        return sinSuperposicion;
    }

    /**
     * Comprueba que los alumnos no participen de cursadas superpuestas. <br>
     * @return True si no existen superposiciones, false en caso contrario.
     */
    private boolean cursadaAlumnosSinSuperposicion() {
        boolean sinSuperposicion = true;
        Iterator<Alumno> ita = alumnos.iterator();
        Alumno alumno = null;
        while (ita.hasNext() && sinSuperposicion) {
            alumno = ita.next();

            // Buscar todas las cursadas en las que participa este alumno.
            ArrayList<Cursada> cursadasEncontradas = buscaCursadasConAlumno(alumno);
            sinSuperposicion = cursadasSinSuperposicion(cursadasEncontradas);
        }

        return sinSuperposicion;
    }

    /**
     * Comprueba que los profesores no participen de cursadas superpuestas. <br>
     * @return True si no existen superposiciones, false en caso contrario.
     */
    private boolean cursadaProfesoresSinSuperposicion() {
        boolean sinSuperposicion = true;
        Iterator<Profesor> itp = profesores.iterator();
        Profesor profesor = null;
        while (itp.hasNext() && sinSuperposicion) {
            profesor = itp.next();

            // Buscar todas las cursadas en las que participa este profesor.
            ArrayList<Cursada> cursadasEncontradas = buscaCursadasConProfesor(profesor);
            sinSuperposicion = cursadasSinSuperposicion(cursadasEncontradas);
        }

        return sinSuperposicion;
    }

    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: </b>
     * La lista de profesores es distinta de null. <br>
     * La lista de alumnos es distinta de null. <br>
     * La lista de asignaturas es distinta de null. <br>
     * La lista de cursadas es distinta de null. <br>
     * La lista de profesores no debe tener legajos duplicados. <br>
     * La lista de alumnos no debe tener legajos duplicados. <br>
     * La lista de asignaturas no debe tener ids duplicados. <br>
     * La lista de cursadas no debe tener ids duplicados. <br>
     * Cada alumno de la coleccion no participa en cursadas que se superponen. <br>
     * Cada profesor de la coleccion no participa en cursadas que se superponen.
     */
    private void verificarInvariante() {
        assert profesoresEsValido() : "La lista de profesores es invalida.";
        assert alumnosEsValido() : "La lista de alumnos es invalida.";
        assert asignaturasEsValido() : "La lista de asignaturas es invalida.";
        assert cursadasEsValido() : "La lista de cursadas es invalida.";
        assert profesoresSinDuplicados() : "La lista de profesores contiene legajos duplicados.";
        assert alumnosSinDuplicados() : "La lista de alumnos contiene legajos duplicados.";
        assert asignaturasSinDuplicados() : "La lista de asignaturas contiene ids duplicados.";
        assert cursadasSinDuplicados() : "La lista de cursadas contiene ids duplicados.";
        assert cursadaAlumnosSinSuperposicion() : "Hay alumnos que participan en cursadas superpuestas.";
        assert cursadaProfesoresSinSuperposicion() : "Hay alumnos que participan en cursadas superpuestas.";
    }
}
