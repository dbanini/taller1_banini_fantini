package pga_exception;

public class ControladorException extends IllegalArgumentException {
	public ControladorException (String mensaje) {
		super(mensaje);
	}
}
