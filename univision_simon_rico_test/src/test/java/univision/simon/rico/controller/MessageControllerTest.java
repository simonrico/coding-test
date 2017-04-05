package univision.simon.rico.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import univision.simon.rico.CodeTestApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import univision.simon.rico.univision.simon.rico.controllers.MessageController;
import univision.simon.rico.univision.simon.rico.service.MessageService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test the message controller.
 * Created by srico on 4/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CodeTestApplication.class)
@WebAppConfiguration
public class MessageControllerTest {

  /**
   * Web application Context for Unit Test
   */
  @Autowired
  private WebApplicationContext context;

  /**
   * Mock MVC for Unit Testing
   */
  private MockMvc mvc;

  /**
   * Message controller with inject mocks.
   */
  @InjectMocks
  private MessageController messageController;

  /**
   * Message service mock.
   */
  @Mock
  private MessageService messageService;



  /**
   * Set up the tests.
   */
  public void setUp() {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  /**
   * Set up tests.
   */
  @Before
  public void setUp2() {
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(messageController).build();
  }

  /**
   * Test the Get message method.
   *
   * @throws Exception
   */
  @Test
  public void getMessage() throws Exception {
    setUp();
    this.mvc.perform(get("/v1/messages/1234")).andExpect(status().isOk())
        .andExpect(content().string(containsString("1234")));

    this.mvc.perform(get("/v1/messages")).andExpect(status().isNotFound());
  }

  /**
   * Test the Get message using a service mock.
   *
   * @throws Exception
   */
  @Test
  public void getMessageServiceMock() throws Exception {
    setUp2();
    Mockito.when(messageService.getMessage())
        .thenReturn("TEST MESSAGE");
    this.mvc.perform(get("/v1/messages/1234")).andExpect(status().isOk());
  }





  }