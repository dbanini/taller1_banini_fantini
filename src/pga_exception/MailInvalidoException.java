package pga_exception;

public class MailInvalidoException extends ControladorException{
	public MailInvalidoException (String mensaje) {
		super(mensaje);
	}
}
