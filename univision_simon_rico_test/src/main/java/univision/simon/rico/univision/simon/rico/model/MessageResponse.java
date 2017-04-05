package univision.simon.rico.univision.simon.rico.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Response object for a message request.
 * Created by srico on 4/4/17.
 */
@Data
@AllArgsConstructor
public class MessageResponse implements Serializable {

  private static final long serialVersionUID = 7456062446277359524L;

  private String id;
  private String message;
}
