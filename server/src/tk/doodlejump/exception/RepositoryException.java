package tk.doodlejump.exception;

/**
 * Exception of repository operations
 * @author Gleidson Moura
 *
 */
public class RepositoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -989528584275431347L;

	public RepositoryException() {
		super();
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}
}
