package univision.simon.rico.univision.simon.rico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import univision.simon.rico.univision.simon.rico.model.ErrorResponse;

import javax.servlet.http.HttpServletResponse;

/**
 * General Exception Handler.
 * Created by srico on 4/4/17.
 */
@ControllerAdvice
public class GeneralExceptionHandler {


    /**
     * Method to handle unexpected exceptions.
     *
     * @param resp response
     * @param ex   exception thrown
     *
     * @return Response Entity
     */
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> handleTRUWebException(final Exception ex,
                                                        final HttpServletResponse resp) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Internal Server Error");
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      return new ResponseEntity<ErrorResponse>(errorResponse,
          HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
