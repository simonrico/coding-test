package univision.simon.rico.univision.simon.rico.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import univision.simon.rico.univision.simon.rico.model.ErrorResponse;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

/**
 * Error controller.
 * Created by srico on 4/4/17.
 */
@RestController
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController{

  public static final String ERROR = "/error";


  /**
   * Default error response
   * @param request
   * @return
   */
  @RequestMapping(value = ERROR)
  @ResponseBody
  public ResponseEntity<ErrorResponse> error(HttpServletRequest request) {
    ErrorResponse errorResponse = new ErrorResponse();

    errorResponse.setStatus((Integer) request
        .getAttribute("javax.servlet.error.status_code"));
    errorResponse.setMessage(Optional.of(HttpStatus.valueOf(errorResponse.getStatus()))
        .map(HttpStatus::getReasonPhrase).orElseGet(null));
    return new ResponseEntity<>(errorResponse,
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  public String getErrorPath() {
    return ERROR;
  }
}
