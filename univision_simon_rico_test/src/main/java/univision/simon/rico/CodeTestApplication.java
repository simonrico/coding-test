package univision.simon.rico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application.
 * Created by srico on 4/4/17.
 */
@SpringBootApplication
public class CodeTestApplication {

  public static final String API_VERSION = "/v1";

  /**
   * The constant JSON.
   */
  public static final String JSON = "application/json";

  /**
   * Main Method to start Spring Boot application.
   *
   * @param args String Main Args
   */
  public static void main(final String[] args) {
    SpringApplication.run(CodeTestApplication.class, args);
  }
}
