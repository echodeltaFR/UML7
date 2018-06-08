package exception;

public class ExceptionInitialization extends Exception{
	public ExceptionInitialization(String message) {
		super("initialization failed : " + message);
	}
}
