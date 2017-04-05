package univision.simon.rico.univision.simon.rico.service.impl;

import org.springframework.stereotype.Service;
import univision.simon.rico.univision.simon.rico.service.MessageService;

import java.util.Date;

/**
 * Message service implementation.
 * Created by srico on 4/5/17.
 */
@Service
public class MessageServiceImpl implements MessageService{
  @Override
  public String getMessage() {
    return MessageService.MESSAGE + new Date().toString();
  }
}
