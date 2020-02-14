package sg.com.ncs.brain.generic.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomErrorResponse {
	private ErrorCodes status;
	private String message;

	Logger logger = LoggerFactory.getLogger(CustomErrorResponse.class);

	public CustomErrorResponse() {
		// super();
	}

	public CustomErrorResponse(ErrorCodes status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ErrorCodes getStatus() {
		return status;
	}

	public void setStatus(ErrorCodes status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		logger.error(message);
		return "ErrorResponse [status=" + status + ", message=" + message + "]";
	}
}