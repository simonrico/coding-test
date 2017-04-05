package univision.simon.rico.univision.simon.rico.model;


import lombok.Data;

import java.io.Serializable;

/**
 * Response object in case of error.
 * Created by srico on 4/4/17.
 */
@Data
public class ErrorResponse implements Serializable {
  private static final long serialVersionUID = -5664589266010390669L;

  private int status;
  private String message;
}
