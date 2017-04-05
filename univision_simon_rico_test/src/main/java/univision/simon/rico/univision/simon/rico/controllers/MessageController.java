package univision.simon.rico.univision.simon.rico.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import univision.simon.rico.CodeTestApplication;
import univision.simon.rico.univision.simon.rico.model.MessageResponse;

import java.util.Date;

/**
 * Messages controller.
 * Created by srico on 4/4/17.
 */
@RestController
@RequestMapping(value = CodeTestApplication.API_VERSION + MessageController.MESSAGE)
public class MessageController {

  public static final String MESSAGE = "/messages";


  @RequestMapping(value = "/{id}",
      produces = CodeTestApplication.JSON, method = {RequestMethod.GET, RequestMethod.HEAD})
  final MessageResponse getMessage(@PathVariable final String id) {
    return new MessageResponse(id, "Hello World!!  " + new Date().toString());

  }
}
