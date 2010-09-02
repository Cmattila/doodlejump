package tk.doodlejump.exception;

/**
 * Exception for Service Errors.
 * @author Rafael Nunes
 *
 */
public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2299796425402639498L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

