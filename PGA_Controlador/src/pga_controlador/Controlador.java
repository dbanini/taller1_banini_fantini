package pga_controlador;

import java.util.ArrayList;
import java.util.Iterator;

import pga_modelo.Entidades;
import pga_modelo.Alumno;
import pga_modelo.Profesor;
import pga_modelo.Asignatura;
import pga_modelo.Cursada;
import pga_controlador.ControladorListener;

import pga_controlador.ControladorListener.Cambios;

import pga_modelo.Asignatura;
import pga_modelo.Persona;

public class Controlador {
    private Entidades entidades;
    private ControladorListener listener;
    
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
    
    private boolean confirmarAccion(ControladorListener.Accion a) {
        if (listener != null) {
            return listener.confirmarAccion(a);
        }
        else {
            return true;
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
    
    private void alumnoValidarDatos(String legajo, String nombre, String domicilio, String mail, ArrayList<Asignatura> aprobadas) throws IllegalArgumentException {
        personaValidarDatos(legajo, nombre, domicilio, mail);
        
        if (!Alumno.legajoEsValido(legajo)) {
            throw new IllegalArgumentException("El legajo no cumple con la mascara de formato requerida.");
        }
        else if (!Alumno.aprobadasConCorrelativas(aprobadas)) {
            throw new IllegalArgumentException("La lista de aprobadas contiene asignaturas que no tienen correlativas aprobadas.");
        }
    }
    
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
    
    private void profesorValidarDatos(String legajo, String nombre, String domicilio, String mail, String telefono) throws IllegalArgumentException {
        personaValidarDatos(legajo, nombre, domicilio, mail);
        
        if (!Profesor.legajoEsValido(legajo)) {
            throw new IllegalArgumentException("El legajo no cumple con la mascara de formato requerida.");
        }
        else if (!Profesor.telefonoEsValido(telefono)) {
            throw new IllegalArgumentException("El telefono no es valido. No debe ser vacio y solo debe contener caracteres alfanumericos.");
        }
    }
    
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
    
    private void asignaturaValidarDatos(String id, String nombre) throws IllegalArgumentException {
        boolean entradaValida = true;
        if (!Asignatura.idEsValido(id)) {
            throw new IllegalArgumentException("El Id no cumple con la mascara de formato requerida.");
        }
        else if (!Asignatura.nombreEsValido(nombre)) {
            throw new IllegalArgumentException("El nombre no es valido. No debe ser vacio y solo debe contener caracteres alfanumericos.");
        }
    }
    
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
        else {
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
    *  Crea un nuevo alumno vacio.
    */
    public Alumno crearAlumnoVacio() {
        Alumno alumno = new Alumno();
        alumno.setLegajo(entidades.nuevoLegajoAlumno());
        entidades.addAlumno(alumno);
        return alumno;
    }
    
    /**
     * Da de alta el alumno.
     */
    public Alumno altaAlumno(String legajo, String nombre, String domicilio, String mail, ArrayList<Asignatura> aprobadas) throws IllegalArgumentException {
        if (entidades.buscaAlumnoPorLegajo(legajo) != null) {
            throw new IllegalArgumentException("El legajo ya esta en uso por otro alumno.");
        }
        
        alumnoValidarDatos(legajo, nombre, domicilio, mail, aprobadas);
        Alumno alumno = new Alumno(legajo, nombre, domicilio, mail);
        alumno.setAprobadas(aprobadas);
        return alumno;
    }
    
    /**
     * Modifica al alumno.
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
     * Da de baja el alumno.
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
    *  Crea un nuevo profesor vacio.
    */
    public Profesor crearProfesorVacio() {
        Profesor profesor = new Profesor();
        profesor.setLegajo(entidades.nuevoLegajoProfesor());
        entidades.addProfesor(profesor);
        return profesor;
    }
    
    /**
     * Da de alta al profesor.
     */
    public Profesor altaProfesor(String legajo, String nombre, String domicilio, String mail, String telefono, ArrayList<Asignatura> habilitadas) throws IllegalArgumentException {
        if (entidades.buscaProfesorPorLegajo(legajo) != null) {
            throw new IllegalArgumentException("El legajo ya esta en uso por otro profesor.");
        }
        
        profesorValidarDatos(legajo, nombre, domicilio, mail, telefono);
        Profesor profesor = new Profesor(legajo, nombre, domicilio, mail, telefono);
        profesor.setHabilitadas(habilitadas);
        return profesor;
    }
    
    /**
     * Modifica al profesor.
     */
    public boolean modificarProfesor(Profesor profesor, String legajo, String nombre, String domicilio, String mail, String telefono, ArrayList<Asignatura> habilitadas) throws IllegalArgumentException {
        profesorValidarDatos(legajo, nombre, domicilio, mail, telefono);
        
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
     * Da de baja al profesor.
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
    *  Crea una nueva asignatura vacia.
    */
    public Asignatura crearAsignaturaVacia() {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(entidades.nuevoIdAsignatura());
        entidades.addAsignatura(asignatura);
        return asignatura;
    }
    
    /**
     * Da de alta a la asignatura.
     */
    public Asignatura altaAsignatura(String id, String nombre, ArrayList<Asignatura> correlativas) throws IllegalArgumentException {
        if (entidades.buscaAsignaturaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra asignatura.");
        }
        
        asignaturaValidarDatos(id, nombre);
        Asignatura asignatura = new Asignatura(id, nombre);
        asignatura.setCorrelativas(correlativas);
        return asignatura;
    }
    
    /**
     * Modifica a la asignatura.
     */
    public boolean modificarAsignatura(Asignatura asignatura, String id, String nombre, ArrayList<Asignatura> correlativas) throws IllegalArgumentException {
        asignaturaValidarDatos(id, nombre);
        
        // Si el id fue cambiado, verificar que no este en uso por otra asignatura.
        if (!id.equals(asignatura.getId()) && entidades.buscaAsignaturaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra asignatura.");
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
     * Da de baja la asignatura.
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
    *  Crea una nueva cursada vacia.
    */
    public Cursada crearCursadaVacia() throws IllegalStateException {
        ArrayList<Asignatura> asignaturas = entidades.getAsignaturas();
        if (asignaturas.isEmpty()) {
            throw new IllegalStateException("Debe existir al menos una asignatura para poder crear una cursada.");
        }
        
        Cursada cursada = new Cursada();
        cursada.setId(entidades.nuevoIdCursada());
        cursada.setAsignatura(asignaturas.get(0));
        entidades.addCursada(cursada);
        return cursada;
    }
    
    /**
     * Da de alta a la cursada.
     */
    public Cursada altaCursada(String id, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin, ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores) throws IllegalArgumentException {
        if (entidades.buscaCursadaPorId(id) != null) {
            throw new IllegalArgumentException("El Id ya esta en uso por otra cursada.");
        }
        
        cursadaValidarDatos(id, asignatura, periodo, dia, horaInicio, horaFin, alumnos, profesores, null);
        Cursada cursada = new Cursada(id, asignatura, periodo, dia, horaInicio, horaFin);
        cursada.setAlumnos(alumnos);
        cursada.setProfesores(profesores);
        return cursada;
    }
    
    /**
     * Modifica a la cursada.
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
     * Da de baja la cursada.
     */
    public void bajaCursada(Cursada cursada) {
        if (!entidades.getCursadas().contains(cursada)) {
            throw new IllegalArgumentException("La cursada no se encuentra en la coleccion de entidades.");
        }
        
        // No se requiere validar la operacion.
        entidades.removeCursada(cursada);
    }
}
