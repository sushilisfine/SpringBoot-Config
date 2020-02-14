package sg.com.ncs.brain.generic.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorResponse {
	private int status;
	private String message;

	Logger logger = LoggerFactory.getLogger(ErrorResponse.class);

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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