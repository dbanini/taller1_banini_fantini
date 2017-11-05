package pga_controlador;

public interface ControladorListener {
    enum Accion {
        AlumnoBorrarRefsCursadasBaja,
        AlumnoBorrarRefsCursadasModificacion,
        ProfesorBorrarRefsCursadasBaja,
        ProfesorBorrarRefsCursadasModificacion,
        AsignaturaBorrarRefsAlumnosBaja,
        AsignaturaBorrarRefsAlumnosModificacion,
        AsignaturaBorrarRefsProfesores,
        AsignaturaBorrarRefsAsignaturas,
        AsignaturaBorrarRefsCursadaAlumnos,
        AsignaturaBorrarCursadas
    };
    
    enum Cambios {
        CursadaAlumnoBorrado,
        CursadaAlumnosBorrados,
        CursadaProfesorBorrado,
        AlumnoAprobadaBorrada,
        ProfesorHabilitadaBorrada,
        AsignaturaCorrelativaBorrada,
        CursadaBorrada,
        CursadasBorradas
    };
    
    /**
     * Pide la confirmacion de una accion a realizar.
     * @param accion El codigo que identifica la accion a confirmar.
     * @return Se debe devolver true o false si la accion fue confirmada o no por el usuario.
     */
    public boolean confirmarAccion(Accion accion);
    
    /**
     * Notifica un cambio realizado al modelo.
     * FIXME: Documentar tipos y valores de parametros (primero y segundo) para cada codigo.
     * @param c El codigo que identifica que cambio fue realizado.
     */
    public void notificarCambios(Cambios cambio, Object primero, Object segundo);
}
