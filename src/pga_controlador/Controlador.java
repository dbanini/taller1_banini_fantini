package pga_controlador;

import java.util.ArrayList;
import java.util.Iterator;

import pga_modelo.Entidades;
import pga_modelo.Alumno;
import pga_modelo.Profesor;
import pga_modelo.Asignatura;
import pga_modelo.Cursada;

import pga_modelo.Persona;

public class Controlador {
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    private Entidades entidades;
    private ControladorListener listener;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Construye un controlador para las entidades.
     * @param entidades Las entidades a controlar.
     */
    public Controlador(Entidades entidades) {
        this(entidades, null);
    }
    
    /**
     * Construye un controlador para las entidades.
     * @param entidades Las entidades a controlar.
     * @param listener El listener que sera notificado de los cambios al modelo y que será responsable de confirmar
     * acciones cuando se necesite.
     */
    public Controlador(Entidades entidades, ControladorListener listener) {
        super();
        this.entidades = entidades;
        this.listener = listener;
    }
    
    // -----------------------------------------------------------------
    // Getters y setters
    // -----------------------------------------------------------------
    
    public Entidades getEntidades() {
        return entidades;
    }
    
    public void setEntidades(Entidades entidades){
        this.entidades=entidades;
    }
    
    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
    private boolean confirmarAccion(ControladorListener.Accion a) {
        if (listener != null) {
            return listener.confirmarAccion(a);
        }
        else {
            return false;
        }
    }
    
    private void notificarCambios(ControladorListener.Cambios cambio) {
        notificarCambios(cambio, null, null);
    }
    
    private void notificarCambios(ControladorListener.Cambios cambio, Object primero) {
        notificarCambios(cambio, primero, null);
    }
    
    private void notificarCambios(ControladorListener.Cambios cambio, Object primero, Object segundo) {
        if (listener != null) {
            listener.notificarCambios(cambio, primero, segundo);
        }
    }
    
    /**
     * Valida que los atributos de una persona sean validos. <br>
     * @param legajo El legajo a validar.
     * @param nombre El nombre a validar.
     * @param domicilio El domicilio a validar.
     * @param mail El mail a validar.
     * @throws IllegalArgumentException Se lanza si algun parametro no es valido.
     */
    private void personaValidarDatos(String legajo, String nombre, String domicilio, String mail) throws IllegalArgumentException {
        if (!Persona.legajoEsValido(legajo)) {
            throw new IllegalArgumentException("El legajo no es valido. No debe ser vacio.");
        }
        else if (!Persona.nombreEsValido(nombre)) {
            throw new IllegalArgumentException("El nombre no es valido. No debe ser vacio y solo debe contener caracteres alfanumericos.");
        }
        else if (!Persona.domicilioEsValido(domicilio)) {
            throw new IllegalArgumentException("El domicilio no es valido. No debe ser vacio y solo debe contener caracteres alfanumericos.");
        }
        else if (!Persona.mailEsValido(mail)) {
            throw new IllegalArgumentException("El mail no es valido. Debe respetar la mascara de mail.");
        }
    }
    
    /**
     * Valida que los parametros sean validos. <br>
     * @param legajo El legajo a validar.
     * @param nombre El nombre a validar.
     * @param domicilio El domicilio a validar.
     * @param mail El mail a validar. 
     * @param aprobadas La lista de asignaturas aprobadas a validar.
     * @throws IllegalArgumentException Se lanza si algun parametro no es valido.
     */
    private void alumnoValidarDatos(String legajo, String nombre, String domicilio, String mail, ArrayList<Asignatura> aprobadas) throws IllegalArgumentException {
        personaValidarDatos(legajo, nombre, domicilio, mail);
        
        if (!Alumno.legajoEsValido(legajo)) {
            throw new IllegalArgumentException("El legajo no cumple con la mascara de formato requerida.");
        }
        else if (aprobadas.contains(null)) {
            throw new IllegalArgumentException("La lista de aprobadas contiene asignaturas nulas.");
        }
        else if (!entidades.getAsignaturas().containsAll(aprobadas)) {
            throw new IllegalArgumentException("La lista de aprobadas contiene asignaturas que no se encuentran en el sistema.");
        }
        else if (!Alumno.aprobadasConCorrelativas(aprobadas)) {
            throw new IllegalArgumentException("La lista de aprobadas contiene asignaturas que no tienen correlativas aprobadas.");
        }
    }
    

    /**
     * Verifica si el alumno puede mantenerse en las cursadas en que se encuentra si se utiliza esta nueva lista de 
     * aprobadas. Si no puede se pregunta si debe eliminarse de las cursadas en las que no se puede mantener y si se 
     * confirma la accion, se elimina de dichas cursadas.
     * @param alumno El alumno a modificar su lista de aprobadas.
     * @param aprobadas La nueva lista de aprobadas del alumno.
     * @return True si el alumno utiliza la lista nueva de aprobadas, False en caso contrario.
     */
    private boolean alumnoValidarModificacion(Alumno alumno, ArrayList<Asignatura> aprobadas) {
        // Verificar si el alumno puede mantenerse en las cursadas en que se encuentra si se utiliza esta nueva lista de aprobadas.
        ArrayList<Cursada> cursadasAlumno = entidades.buscaCursadasConAlumno(alumno);
        Iterator<Cursada> it = cursadasAlumno.iterator();
        Cursada cursada = null;
        boolean entradaValida = true;
        boolean corregirCursadas = false;
        while (it.hasNext() && entradaValida) {
            cursada = it.next();
            if (!aprobadas.containsAll(cursada.getAsignatura().getCorrelativas())) {
                corregirCursadas = corregirCursadas || confirmarAccion(ControladorListener.Accion.AlumnoBorrarRefsCursadasModificacion);
                entradaValida = corregirCursadas;
                if (corregirCursadas) {
                    cursada.getAlumnos().remove(alumno);
                    notificarCambios(ControladorListener.Cambios.CursadaAlumnoBorrado, cursada, alumno);
                }
            }
        }
        
        return entradaValida;
    }
    
    /**
     * Se verifica que el alumno no este cursando asignaturas. En caso de que este cursando alguna asignatura se
     * pregunta si se desea eliminar al alumno de las cursadas en las que esta anotado.
     * @param alumno El alumno a validar su baja en las cursadas.
     * @return True si el alumno puede ser dado de baja y si esta anotado en alguna cursada, que se confirme la baja
     * del alumno en dichas cursadas, False en caso contrario.
     */
    private boolean alumnoValidarBaja(Alumno alumno) {
        boolean bajaValida = true;
        boolean corregirCursadas = false;
        ArrayList<Cursada> cursadas = entidades.buscaCursadasConAlumno(alumno);
        Iterator<Cursada> itc = cursadas.iterator();
        Cursada cursada = null;
        while (itc.hasNext() && bajaValida) {
            cursada = itc.next();
            corregirCursadas = corregirCursadas || confirmarAccion(ControladorListener.Accion.AlumnoBorrarRefsCursadasBaja);
            bajaValida = corregirCursadas;
            if (corregirCursadas) {
                cursada.getAlumnos().remove(alumno);
                notificarCambios(ControladorListener.Cambios.CursadaAlumnoBorrado, cursada, alumno);
            }
        }
        
        return bajaValida;
    }
    
    /**
     * Valida que los parametros sean validos.
     * @param legajo El legajo a validar.
     * @param nombre El nombre a validar.
     * @param domicilio El domicilio a validar.
     * @param mail El mail a validar.
     * @param telefono El telefono a validar.
     * @param habilitadas La lista de asignaturas habilitadas a validar.
     * @throws IllegalArgumentException
     */
    private void profesorValidarDatos(String legajo, String nombre, String domicilio, String mail, String telefono, ArrayList<Asignatura> habilitadas) throws IllegalArgumentException {
        personaValidarDatos(legajo, nombre, domicilio, mail);
        
        if (!Profesor.legajoEsValido(legajo)) {
            throw new IllegalArgumentException("El legajo no cumple con la mascara de formato requerida.");
        }
        else if (!Profesor.telefonoEsValido(telefono)) {
            throw new IllegalArgumentException("El telefono no es valido. No debe ser vacio y solo debe contener caracteres alfanumericos.");
        }
        else if (habilitadas.contains(null)) {
            throw new IllegalArgumentException("La lista de habilitadas contiene asignaturas nulas.");
        }
        else if (!entidades.getAsignaturas().containsAll(habilitadas)) {
            throw new IllegalArgumentException("La lista de habilitadas contiene asignaturas que no se encuentran en el sistema.");
        }
    }
    
    /**
     * Verifica si el profesor puede mantenerse en las cursadas en las que participa si se utiliza esta nueva lista 
     * de habilitadas. Si no puede se pregunta si debe eliminarse de las cursadas en las que no se puede mantener y si se 
     * confirma la accion, se elimina de dichas cursadas.
     * @param profesor El profesor a modificar su lista de habilitadas.
     * @param habilitadas La nueva lista de habilitadas del profesor.
     * @return True si el profesor utiliza la lista nueva de habilitadas, False en caso contrario.
     */
    private boolean profesorValidarModificacion(Profesor profesor, ArrayList<Asignatura> habilitadas) {
        // Verificar si el profesor puede mantenerse en las cursadas que esta si se utiliza esta nueva lista de habilitadas.
        ArrayList<Cursada> cursadasProfesor = entidades.buscaCursadasConProfesor(profesor);
        Iterator<Cursada> it = cursadasProfesor.iterator();
        Cursada cursada = null;
        boolean entradaValida = true;
        boolean corregirCursadas = false;
        while (it.hasNext() && entradaValida) {
            cursada = it.next();
            if (!habilitadas.contains(cursada.getAsignatura())) {
                corregirCursadas = corregirCursadas || confirmarAccion(ControladorListener.Accion.ProfesorBorrarRefsCursadasModificacion);
                entradaValida = corregirCursadas;
                if (corregirCursadas) {
                    cursada.getProfesores().remove(profesor);
                    notificarCambios(ControladorListener.Cambios.CursadaProfesorBorrado, cursada, profesor);
                }
            }
        }
        
        return entradaValida;
    }
    
    /**
     * Se verifica que el profesor no este participando en cursadas. En caso de que este participando en alguna 
     * cursadas se pregunta si se desea eliminar al profesor de las cursadas en las que esta anotado.
     * @param profesor El profesor a validar su baja en las cursadas.
     * @return True si el profesor puede ser dado de baja y si esta anotado en alguna cursada, que se confirme la baja
     * del profesor en dichas cursadas, False en caso contrario.
     */
    private boolean profesorValidarBaja(Profesor profesor) {
        boolean bajaValida = true;
        boolean corregirCursadas = false;
        ArrayList<Cursada> cursadas = entidades.buscaCursadasConProfesor(profesor);
        Iterator<Cursada> itc = cursadas.iterator();
        Cursada cursada = null;
        while (itc.hasNext() && bajaValida) {
            cursada = itc.next();
            corregirCursadas = corregirCursadas || confirmarAccion(ControladorListener.Accion.ProfesorBorrarRefsCursadasBaja);
            bajaValida = corregirCursadas;
            if (corregirCursadas) {
                cursada.getProfesores().remove(profesor);
                notificarCambios(ControladorListener.Cambios.CursadaProfesorBorrado, cursada, profesor);
            }
        }
                
        return bajaValida;
    }
    
    /**
     * Valida que los parametros sean validos.
     * @param id El id a validar.
     * @param nombre El nombre a validar.
     * @param correlativas La lista de asignaturas correlativas a validar.
     * @throws IllegalArgumentException Si algun parametro no es valido.
     */
    private void asignaturaValidarDatos(String id, String nombre, ArrayList<Asignatura> correlativas) throws IllegalArgumentException {
        boolean entradaValida = true;
        if (!Asignatura.idEsValido(id)) {
            throw new IllegalArgumentException("El Id no cumple con la mascara de formato requerida.");
        }
        else if (!Asignatura.nombreEsValido(nombre)) {
            throw new IllegalArgumentException("El nombre no es valido. No debe ser vacio y solo debe contener caracteres alfanumericos.");
        }
        else if (correlativas.contains(null)) {
            throw new IllegalArgumentException("La lista de correlativas contiene asignaturas nulas.");
        }
        else if (!entidades.getAsignaturas().containsAll(correlativas)) {
            throw new IllegalArgumentException("La lista de correlativas contiene asignaturas que no se encuentran en el sistema.");
        }
    }
    
    /**
     * Verifica si los alumnos pueden mantenerse en las cursadas de esta asignatura con las nuevas correlativas. Si no 
     * pueden se pregunta si deben eliminarse los alumnos de las cursadas en las que no se pueden mantener y si se 
     * confirma la accion, se eliminan de dichas cursadas.
     * @param asignatura La asignatura a modificar correlativas.
     * @param correlativas Las nuevas correlativas de la asignatura.
     * @return True en caso de que se confirme la accion de eliminar a los alumnos de las cursadas en caso de que se 
     * deba hacer, False en caso contrario.
     * @throws IllegalArgumentException Si la lista de correlativas nueva no es valida.
     */
    private boolean asignaturaValidarModificacion(Asignatura asignatura, ArrayList<Asignatura> correlativas) throws IllegalArgumentException {
        if (correlativas.contains(asignatura)) {
            throw new IllegalArgumentException("La lista de correlativas de la asignatura contiene a la asignatura misma.");
        }
        
        // Verificar si los alumnos pueden mantenerse en las cursadas de esta asignatura con las nuevas correlativas.
        ArrayList<Cursada> cursadas = entidades.buscaCursadasConAsignatura(asignatura);
        Iterator<Cursada> itc = cursadas.iterator();
        ArrayList<Alumno> alumnosQuitados = new ArrayList<Alumno>();
        Cursada cursada = null;
        boolean entradaValida = true;
        boolean corregirCursadas = false;
        while (itc.hasNext() && entradaValida) {
            alumnosQuitados.clear();
            cursada = itc.next();
            Iterator<Alumno> ita = cursada.getAlumnos().iterator();
            Alumno alumno = null;
            while (ita.hasNext() && entradaValida) {
                alumno = ita.next();
                if (!alumno.getAprobadas().containsAll(correlativas)) {
                    corregirCursadas = corregirCursadas || confirmarAccion(ControladorListener.Accion.AsignaturaBorrarRefsCursadaAlumnos);
                    entradaValida = corregirCursadas;
                    if (corregirCursadas) {
                        alumnosQuitados.add(alumno);
                    }
                }
            }
            
            if (!alumnosQuitados.isEmpty()) {
                cursada.getAlumnos().removeAll(alumnosQuitados);
                notificarCambios(ControladorListener.Cambios.CursadaAlumnosBorrados, cursada, alumnosQuitados);
            }
        }
        
        // Verificar si los alumnos pueden seguir teniendo esta asignatura como aprobada con las nuevas correlativas.
        ArrayList<Alumno> alumnos = entidades.buscaAlumnosConAsignatura(asignatura);
        Iterator<Alumno> ita = alumnos.iterator();
        Alumno alumno = null;
        boolean corregirAlumnos = false;
        while (ita.hasNext() && entradaValida) {
            alumno = ita.next();
            if (!alumno.getAprobadas().containsAll(correlativas)) {
                corregirAlumnos = corregirAlumnos || confirmarAccion(ControladorListener.Accion.AsignaturaBorrarRefsAlumnosModificacion);
                entradaValida = corregirAlumnos;
                if (corregirAlumnos) {
                    alumno.getAprobadas().remove(asignatura);
                    notificarCambios(ControladorListener.Cambios.AlumnoAprobadaBorrada, alumno, asignatura);
                }
            }
        }
        
        return entradaValida;
    }
    
    /**
     * Si ningun alumno, profesor o cursada interactua con la asignatura, esta es borrada. En cambio si alguna entidad
     * interactua con la asignatura, se pregunta si se desea que las entidades que la incluyen borren su interaccion 
     * antes de que la asignatura pueda ser borrada. Si se responde afirmativamente, se borran las interacciones de la
     * asignatura en las entidades y luego se borra la asignatura.
     * @param asignaturaBaja La asignatura a ser dada de baja.
     * @return True en caso de que la asignatura sea dada de baja y ninguna entidad interactue con ella, False en caso
     * contrario.
     */
    private boolean asignaturaValidarBaja(Asignatura asignaturaBaja) {
        boolean bajaValida = true;
        ArrayList<Alumno> alumnos = entidades.buscaAlumnosConAsignatura(asignaturaBaja);
        ArrayList<Profesor> profesores = entidades.buscaProfesoresConAsignatura(asignaturaBaja);
        ArrayList<Asignatura> asignaturas = entidades.buscaAsignaturasConCorrelativa(asignaturaBaja);
        ArrayList<Cursada> cursadas = entidades.buscaCursadasConAsignatura(asignaturaBaja);
        Iterator<Alumno> ita = alumnos.iterator();
        Iterator<Profesor> itp = profesores.iterator();
        Iterator<Asignatura> itas = asignaturas.iterator();
        Iterator<Cursada> itc = cursadas.iterator();
        Alumno alumno = null;
        Profesor profesor = null;
        Asignatura asignatura = null;
        Cursada cursada = null;
        boolean corregirAlumnos = false;
        boolean corregirProfesores = false;
        boolean corregirAsignaturas = false;
        boolean corregirCursadas = false;
        while (ita.hasNext() && bajaValida) {
            alumno = ita.next();
            corregirAlumnos = corregirAlumnos || confirmarAccion(ControladorListener.Accion.AsignaturaBorrarRefsAlumnosBaja);
            bajaValida = corregirAlumnos;
            if (corregirAlumnos) {
                alumno.getAprobadas().remove(asignaturaBaja);
                notificarCambios(ControladorListener.Cambios.AlumnoAprobadaBorrada, alumno, asignaturaBaja);
            }
        }
        
        while (itp.hasNext() && bajaValida) {
            profesor = itp.next();
            corregirProfesores = corregirProfesores || confirmarAccion(ControladorListener.Accion.AsignaturaBorrarRefsProfesores);
            bajaValida = corregirProfesores;
            if (corregirProfesores) {
                profesor.getHabilitadas().remove(asignaturaBaja);
                notificarCambios(ControladorListener.Cambios.ProfesorHabilitadaBorrada, profesor, asignaturaBaja);
            }
        }
        
        while (itas.hasNext() && bajaValida) {
            asignatura = itas.next();
            corregirAsignaturas = corregirAsignaturas || confirmarAccion(ControladorListener.Accion.AsignaturaBorrarRefsAsignaturas);
            bajaValida = corregirAsignaturas;
            if (corregirAsignaturas) {
                asignatura.getCorrelativas().remove(asignaturaBaja);
                notificarCambios(ControladorListener.Cambios.AsignaturaCorrelativaBorrada, asignatura, asignaturaBaja);
            }
        }
        
        while (itc.hasNext() && bajaValida) {
            cursada = itc.next();
            corregirCursadas = corregirCursadas || confirmarAccion(ControladorListener.Accion.AsignaturaBorrarCursadas);
            bajaValida = corregirCursadas;
            if (corregirCursadas) {
                entidades.removeCursada(cursada);
                notificarCambios(ControladorListener.Cambios.CursadaBorrada, cursada);
            }
        }
        
        if (corregirCursadas) {
            notificarCambios(ControladorListener.Cambios.CursadasBorradas);
        }
        
        return bajaValida;
    }
    
    /**
     * Valida que los parametros sean validos.
     * @param id El id a validar.
     * @param asignatura La asignatura a validar.
     * @param periodo El periodo a validar.
     * @param dia El dia a validar.
     * @param horaInicio La hora de inicio a validar.
     * @param horaFin La hora de fin a validar.
     * @param alumnos La lista de alumnos a validar
     * @param profesores La lista de profesores a validar.
     * @param cursadaIgnorada 
     * @throws IllegalArgumentException Se lanza si algun parametro no es valido.
     */
    private void cursadaValidarDatos(String id, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin, ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, Cursada cursadaIgnorada) throws IllegalArgumentException {
        if (!Cursada.idEsValido(id)) {
            throw new IllegalArgumentException("El Id no cumple con la mascara de formato requerida.");
        }
        else if (!Cursada.periodoEsValido(periodo)) {
            throw new IllegalArgumentException("El periodo no cumple con la mascara de formato requerida.");
        }
        else if (!Cursada.diaEsValido(dia)) {
            throw new IllegalArgumentException("El dia no es valido. No corresponde con los valores permitidos.");
        }
        else if (!Cursada.horaEsValido(horaInicio)) {
            throw new IllegalArgumentException("La hora de inicio no es valida. No corresponde con los valores permitidos.");
        }
        else if (!Cursada.horaEsValido(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio no es valida. No corresponde con los valores permitidos.");
        }
        else if (!Cursada.horaMayorA(horaFin, horaInicio)) {
            throw new IllegalArgumentException("La hora de fin no es valida. Debe ser mayor a la hora de inicio.");
        }
        else if (asignatura == null) {
            throw new IllegalArgumentException("La asignatura es nula.");
        }
        else if (!entidades.getAsignaturas().contains(asignatura)) {
            throw new IllegalArgumentException("La asignatura no se encuentra en el sistema.");
        }
        else {
            if (alumnos.contains(null)) {
                throw new IllegalArgumentException("Los alumnos contienen alumnos nulos.");
            }
            else if (!entidades.getAlumnos().containsAll(alumnos)) {
                throw new IllegalArgumentException("Los alumnos contienen alumnos que no se encuentran en el sistema.");
            }
            else if (profesores.contains(null)) {
                throw new IllegalArgumentException("Los profesores contienen profesores nulos.");
            }
            else if (!entidades.getProfesores().containsAll(profesores)) {
                throw new IllegalArgumentException("Los profesores contienen profesores que no se encuentran en el sistema.");
            }
            
            // Verificar si los nuevos alumnos estan aprobados para esta cursada.
            Iterator<Alumno> ita = alumnos.iterator();
            Alumno alumno = null;
            while (ita.hasNext()) {
                alumno = ita.next();
                if (!alumno.getAprobadas().containsAll(asignatura.getCorrelativas())) {
                    throw new IllegalArgumentException("Los alumnos no tienen las correlativas aprobadas para cursar esta asignatura.");
                }
            }
            
            // Verificar si los nuevos profesores estan habilitados para esta cursada.
            Iterator<Profesor> itp = profesores.iterator();
            Profesor profesor = null;
            while (itp.hasNext()) {
                profesor = itp.next();
                if (!profesor.getHabilitadas().contains(asignatura)) {
                    throw new IllegalArgumentException("Los profesores no tienen la asignatura habilitada para poder participar de esta cursada.");
                }
            }
            
            // Verificar superposicion para los alumnos.
            ita = alumnos.iterator();
            while (ita.hasNext()) {
                ArrayList<Cursada> cursadasAlumno = entidades.buscaCursadasConAlumno(ita.next());
                if (Cursada.seSuperponeCon(cursadasAlumno, horaInicio, horaFin, periodo, dia, cursadaIgnorada)) {
                    throw new IllegalArgumentException("No puede ubicarse la cursada en el plazo elegido. Causa superposicion para los alumnos con otras cursadas.");
                }
            }
            
            // Verificar superposicion para los profesores.
            itp = profesores.iterator();
            while (itp.hasNext()) {
                ArrayList<Cursada> cursadasProfesor = entidades.buscaCursadasConProfesor(itp.next());
                if (Cursada.seSuperponeCon(cursadasProfesor, horaInicio, horaFin, periodo, dia, cursadaIgnorada)) {
                    throw new IllegalArgumentException("No puede ubicarse la cursada en el plazo elegido. Causa superposicion para los profesores con otras cursadas.");
                }
            }
        }
    }
    
    /** 
     * ------------------------------------------------
     * Metodos publicos.
     * ------------------------------------------------
     */
    
    /**
     * RF01 alumno. <br>
     * Da de alta el alumno en la coleccion de alumnos.
     * @return El alumno que se agrega a la coleccion.
     */
    public Alumno altaAlumno(String legajo, String nombre, String domicilio, String mail, ArrayList<Asignatura> aprobadas) throws IllegalArgumentException {
        
        if (entidades.buscaAlumnoPorLegajo(legajo) != null) {
            throw new IllegalArgumentException("El legajo ya esta en uso por otro alumno.");
        }
        
        alumnoValidarDatos(legajo, nombre, domicilio, mail, aprobadas);
        Alumno alumno = new Alumno(legajo, nombre, domicilio, mail);
        alumno.setAprobadas(aprobadas);
        entidades.addAlumno(alumno);
        return alumno;
    }
    
    /**
     * RF03 alumno. <br>
     * Modifica al alumno en la coleccion de alumnos.
     * @return True si la modificacion fue valida, False en caso contrario.
     */
    public boolean modificarAlumno(Alumno alumno, String legajo, String nombre, String domicilio, String mail, ArrayList<Asignatura> aprobadas) throws IllegalArgumentException {
        alumnoValidarDatos(legajo, nombre, domicilio, mail, aprobadas);
        
        // Si el legajo fue cambiado, verificar que no este en uso por otro alumno.
        if (!legajo.equals(alumno.getLegajo()) && entidades.buscaAlumnoPorLegajo(legajo) != null) {
            throw new IllegalArgumentException("El legajo ya esta en uso por otro alumno.");
        }    
        
        boolean modificacionValida = alumnoValidarModificacion(alumno, aprobadas);
        if (modificacionValida) {
            alumno.setLegajo(legajo);
            alumno.setNombre(nombre);
            alumno.setDomicilio(domicilio);
            alumno.setMail(mail);
            alumno.setAprobadas(aprobadas);
        }
        
        return modificacionValida;
    }
    
    /**
     * RF02 alumno. <br>
     * Da de baja el alumno de la coleccion de alumnos.
     * @return True si la baja fue valida, False en caso contrario.
     */
    public boolean bajaAlumno(Alumno alumno) {
        if (!entidades.getAlumnos().contains(alumno)) {
            throw new IllegalArgumentException("El alumno no se encuentra en la coleccion de entidades.");
        }
        
        boolean operacionValida = alumnoValidarBaja(alumno);
        if (operacionValida) {
            entidades.removeAlumno(alumno);
        }
        
        return operacionValida;
    }
    
    /**
     * RF01 profesor. <br>
     * Da de alta al profesor en la coleccion de profesores.
     * @return El profesor que se agrega a la coleccion.
     */
    public Profesor altaProfesor(String legajo, String nombre, String domicilio, String mail, String telefono, ArrayList<Asignatura> habilitadas) throws IllegalArgumentException {
        if (entidades.buscaProfesorPorLegajo(legajo) != null) {
            throw new IllegalArgumentException("El legajo ya esta en uso por otro profesor.");
        }
        
        profesorValidarDatos(legajo, nombre, domicilio, mail, telefono, habilitadas);
        Profesor profesor = new Profesor(legajo, nombre, domicilio, telefono, mail);
        profesor.setHabilitadas(habilitadas);
        entidades.addProfesor(profesor);
        return profesor;
    }
    
    /**
     * RF03 profesor. <br>
     * Modifica al profesor en la coleccion de profesores.
     * @return True si la modificacion fue valida, False en caso contrario.
     */
    public boolean modificarProfesor(Profesor profesor, String legajo, String nombre, String domicilio, String mail, String telefono, ArrayList<Asignatura> habilitadas) throws IllegalArgumentException {
        profesorValidarDatos(legajo, nombre, domicilio, mail, telefono, habilitadas);
        
        // Si el legajo fue cambiado, verificar que no este en uso por otro profesor.
        if (!legajo.equals(profesor.getLegajo()) && entidades.buscaProfesorPorLegajo(legajo) != null) {
            throw new IllegalArgumentException("El legajo ya esta en uso por otro profesor.");
        }
        
        boolean modificacionValida = profesorValidarModificacion(profesor, habilitadas);
        if (modificacionValida) {
            profesor.setLegajo(legajo);
            profesor.setNombre(nombre);
            profesor.setDomicilio(domicilio);
            profesor.setMail(mail);
            profesor.setTelefono(telefono);
            profesor.setHabilitadas(habilitadas);
        }
        
        return modificacionValida;
    }
    
    /**
     * RF02 profesor. <br>
     * Da de baja el profesor de la coleccion de profesores.
     * @return True si la baja fue valida, False en caso contrario.
     */
    public boolean bajaProfesor(Profesor profesor) {
        if (!entidades.getProfesores().contains(profesor)) {
            throw new IllegalArgumentException("El profesor no se encuentra en la coleccion de entidades.");
        }
        
        boolean operacionValida = profesorValidarBaja(profesor);
        if (operacionValida) {
            entidades.removeProfesor(profesor);
        }
        
        return operacionValida;
    }
    
    /**
     * RF01 asignatura. <br>
     * Da de alta la asignatura en la coleccion de asignaturas.
     * @return La asignatura que se agrega a la coleccion.
     */
    public Asignatura altaAsignatura(String id, String nombre, ArrayList<Asignatura> correlativas) throws IllegalArgumentException {
        if (entidades.buscaAsignaturaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra asignatura.");
        }
        
        asignaturaValidarDatos(id, nombre, correlativas);
        Asignatura asignatura = new Asignatura(id, nombre);
        asignatura.setCorrelativas(correlativas);
        entidades.addAsignatura(asignatura);
        return asignatura;
    }
    
    /**
     * RF03 asignatura. <br>
     * Modifica la asignatura en la coleccion de asignaturas.
     * @return True si la modificacion fue valida, False en caso contrario.
     */
    public boolean modificarAsignatura(Asignatura asignatura, String id, String nombre, ArrayList<Asignatura> correlativas) throws IllegalArgumentException {
        asignaturaValidarDatos(id, nombre, correlativas);
        
        // Si el id fue cambiado, verificar que no este en uso por otra asignatura.
        if (!id.equals(asignatura.getId()) && entidades.buscaAsignaturaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra asignatura.");
        }
        else if (correlativas.contains(asignatura)) {
            throw new IllegalArgumentException("La lista de correlativas contiene a la asignatura en si misma.");
        }
        
        boolean modificacionValida = asignaturaValidarModificacion(asignatura, correlativas);
        if (modificacionValida) {
            asignatura.setId(id);
            asignatura.setNombre(nombre);
            asignatura.setCorrelativas(correlativas);
        }
        
        return modificacionValida;
    }
    
    /**
     * RF02 asignatura. <br>
     * Da de baja la asignatura de la coleccion de asignaturas.
     * @return True si la baja fue valida, False en caso contrario.
     */
    public boolean bajaAsignatura(Asignatura asignatura) {
        if (!entidades.getAsignaturas().contains(asignatura)) {
            throw new IllegalArgumentException("La asignatura no se encuentra en la coleccion de entidades.");
        }
        
        boolean operacionValida = asignaturaValidarBaja(asignatura);
        if (operacionValida) {
            entidades.removeAsignatura(asignatura);
        }
        
        return operacionValida;
    }
    
    /**
     * RF06. <br>
     * Da de alta la cursada en la coleccion de cursadas.
     * @return La cursada que se agrega a la coleccion.
     */
    public Cursada altaCursada(String id, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin, ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores) throws IllegalArgumentException {
        if (entidades.buscaCursadaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra cursada.");
        }
        
        cursadaValidarDatos(id, asignatura, periodo, dia, horaInicio, horaFin, alumnos, profesores, null);
        Cursada cursada = new Cursada(id, asignatura, periodo, dia, horaInicio, horaFin);
        cursada.setAlumnos(alumnos);
        cursada.setProfesores(profesores);
        entidades.addCursada(cursada);
        return cursada;
    }
    
    /**
     * RF08. <br>
     * Modifica la cursada en la coleccion de cursadas.
     */
    public void modificarCursada(Cursada cursada, String id, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin, ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores) throws IllegalArgumentException {
        cursadaValidarDatos(id, asignatura, periodo, dia, horaInicio, horaFin, alumnos, profesores, cursada);
        
        // Si el id fue cambiado, verificar que no este en uso por otra asignatura.
        if (!id.equals(cursada.getId()) && entidades.buscaCursadaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra cursada.");
        }
        
        // No se requiere validar la operacion.
        cursada.setId(id);
        cursada.configurar(asignatura, periodo, dia, horaInicio, horaFin, alumnos, profesores);
    }
    
    /**
     * RF07. <br>
     * Da de baja la cursada de la coleccion de cursadas.
     */
    public void bajaCursada(Cursada cursada) {
        if (!entidades.getCursadas().contains(cursada)) {
            throw new IllegalArgumentException("La cursada no se encuentra en la coleccion de entidades.");
        }
        
        // No se requiere validar la operacion.
        entidades.removeCursada(cursada);
    }
    
    /**
     * Da de alta a un alumno a una cursada.
     */
    public void altaCursadaAlumno(Cursada cursada, Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno es nulo.");
        }
        else if (!entidades.getAlumnos().contains(alumno)) {
            throw new IllegalArgumentException("El alumno no se encuentra en el sistema.");
        }
        else if (cursada.getAlumnos().contains(alumno)) {
            throw new IllegalArgumentException("La cursada ya tiene al alumno inscripto.");
        }
        else if (!alumno.getAprobadas().containsAll(cursada.getAsignatura().getCorrelativas())) {
            throw new IllegalArgumentException("El alumno no tiene las correlativas aprobadas para cursar esta asignatura.");
        }
        else if (cursada.seSuperponeCon(entidades.buscaCursadasConAlumno(alumno))) {
            throw new IllegalArgumentException("El alumno esta ocupado en el horario de la cursada.");
        }
        
        cursada.getAlumnos().add(alumno);
    }
    
    /**
     * Da de baja a un alumno de una cursada.
     */
    public void bajaCursadaAlumno(Cursada cursada, Alumno alumno) {
        if (!cursada.getAlumnos().contains(alumno)) {
            throw new IllegalArgumentException("La cursada no contiene al alumno.");
        }
        
        cursada.getAlumnos().remove(alumno);
    }
    
    /**
     * Da de alta a un profesor a una cursada.
     */
    public void altaCursadaProfesor(Cursada cursada, Profesor profesor) {
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor es nulo.");
        }
        else if (!entidades.getProfesores().contains(profesor)) {
            throw new IllegalArgumentException("El profesor no se encuentra en el sistema.");
        }
        else if (cursada.getProfesores().contains(profesor)) {
            throw new IllegalArgumentException("La cursada ya tiene al profesor inscripto.");
        }
        else if (!profesor.getHabilitadas().contains(cursada.getAsignatura())) {
            throw new IllegalArgumentException("El profesor no tiene las asignatura de esta cursada habilitada.");
        }
        else if (cursada.seSuperponeCon(entidades.buscaCursadasConProfesor(profesor))) {
            throw new IllegalArgumentException("El profesor esta ocupado en el horario de la cursada.");
        }
        
        cursada.getProfesores().add(profesor);
    }
    
    /**
     * Da de baja a un profesor de una cursada.
     */
    public void bajaCursadaProfesor(Cursada cursada, Profesor profesor) {
        if (!cursada.getProfesores().contains(profesor)) {
            throw new IllegalArgumentException("La cursada no contiene al profesor.");
        }
        
        cursada.getProfesores().remove(profesor);
    }
}
