package exception;

public class ExceptionComposition extends Exception {
	public ExceptionComposition(String message) {
		super("initialization failed : " + message);
	}
}
