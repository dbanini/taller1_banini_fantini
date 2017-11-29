package pga_controlador;

public class ControladorListenerConfirmador implements ControladorListener {
	@Override
    public boolean confirmarAccion(Accion accion) {
    	return true;
    }

	@Override
	public void notificarCambios(Cambios cambio, Object primero, Object segundo) {
		// No notifica nada por defecto.
	}
}
