package sg.com.ncs.brain.generic.exceptions;

import sg.com.ncs.brain.generic.exceptions.handler.ErrorCodes;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 7718828512143293558L;

	private final ErrorCodes code;

	public BadRequestException(ErrorCodes code) {
		// super();

		this.code = code;
	}

	public BadRequestException(String message, Throwable cause, ErrorCodes code) {
		// super(message, cause);
		this.code = code;
	}

	public BadRequestException(String message, ErrorCodes code) {
		super(message);
		this.code = code;
	}

	public BadRequestException(Throwable cause, ErrorCodes code) {
		// super(cause);
		this.code = code;
	}

	public ErrorCodes getCode() {
		return this.code;
	}
}
