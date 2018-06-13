package exception;

public class ExceptionUml extends Exception {
	public ExceptionUml(String message) {
		super("initialization failed : " + message);
	}
}
