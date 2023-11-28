import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emp.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Employee Exceptions

	@ExceptionHandler(EmployeeNotFoundException.class)
	public Response handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		Response response = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		response.setErrorMessage("Employee Not Found");
		return response;
	}

	// Global Exception Handler

	@ExceptionHandler(Exception.class)
	public Response handleException(Exception ex) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		response.setErrorMessage("Internal server error");
		return response;
	}
}
