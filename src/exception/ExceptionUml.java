package exception;

public class ExceptionUml extends Exception {
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -3789645322321293954L;

	public ExceptionUml(String message) {
		super("initialization failed : " + message);
	}
}
