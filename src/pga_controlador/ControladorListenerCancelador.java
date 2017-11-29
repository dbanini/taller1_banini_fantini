package pga_controlador;

import pga_controlador.ControladorListener.Accion;

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
