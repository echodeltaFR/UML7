package exception;

public class ExceptionInitialization extends ExceptionComposition{
	public ExceptionInitialization(String message) {
		super("initialization failed : " + message);
	}
}
