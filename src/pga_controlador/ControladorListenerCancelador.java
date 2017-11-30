package pga_controlador;

public class ControladorListenerCancelador implements ControladorListener {
	@Override
    public boolean confirmarAccion(Accion accion) {
    	return false;
    }

	@Override
	public void notificarCambios(Cambios cambio, Object primero, Object segundo) {
		// No notifica nada por defecto.
	}
}
