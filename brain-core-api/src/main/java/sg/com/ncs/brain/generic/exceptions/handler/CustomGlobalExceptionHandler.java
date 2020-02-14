package sg.com.ncs.brain.generic.exceptions.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sg.com.ncs.brain.generic.exceptions.BadRequestException;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomErrorResponse userException(HttpServletResponse response) throws IOException {
		return new CustomErrorResponse(ErrorCodes.IMPROPER_REQUEST, "User Exception");
	}

	@ExceptionHandler(value = { IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(Exception ex) {
		return new ErrorResponse(400, "Bad Request");
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse unKnownException(Exception ex, String message) {
		return new ErrorResponse(404, "Not Found");
	}
}