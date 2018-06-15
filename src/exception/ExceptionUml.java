package exception;

/**
 * General UML Exception.
 */
public class ExceptionUml extends Exception {
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -3789645322321293954L;

	/**
	 * Create a new UmlException with the specified message.
	 * @param message
	 * 		The message explaining the exception
	 */
	public ExceptionUml(String message) {
		super("initialization failed : " + message);
	}
}
