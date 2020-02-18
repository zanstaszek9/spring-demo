package stanislaw.appdemo.user;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import stanislaw.appdemo.validators.UserRegisterValidator;

import javax.persistence.EntityManager;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private UserService userService;

    @Autowired
    private Gson gson;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private User u;

    @MockBean
    private RegisterController registerController;

    @MockBean
    private UserRegisterValidator userRegisterValidator;

    @BeforeEach
    void setUp() {
    }

    /** RegisterController handles the "/register" and "/adduser" URIs.
     * Page should have a title defined by the message.properties file.
     * Page should display registration form with 4 fields.
     * If any field is empty, validation sends an error and red text is displayed under the textfields..
     * If email do not match the regex pattern, validation sends error an error and red text is displayed under the textfields..
     * If password do not match the regex pattern, validation sends error an error and red text is displayed under the textfields.
     * If successful, user is added to the database.
     * */

    @Test
    void show_register_page_by_url() throws Exception {
        // Should confirm if page loads correctly and pass
        // I'm not sure if it tests what is supposed
        this.mockMvc.perform(get("/register")).andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    void show_register_page_model_title() throws Exception {
        // Should confirm if the page's title equals the title form locale file and pass
        // Test fails
        this.mockMvc.perform(get("/register")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("title", "<s:message code=\"menu.register\"/>"))
        ;
    }


    @Test
    void show_register_action_empty_error() throws Exception {
        // Should send the user with empty attributes a return errors,
        // as validation prevents the empty email and password
        // Test fails.
        User user = prepareUserEmpty();
        this.mockMvc.perform(post("/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user)))
                .andDo(print())
                .andExpect(model().hasErrors());
    }

    @Test
    void show_register_action_invalid_email() throws Exception {
        // Should send the user with valid attributes and invalid email
        // returning error from validation
        // Test fails
        User user = prepareUserValid();
        user.setEmail("notEmailAddress");
        this.mockMvc.perform(post("/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user)))
                .andDo(print())
                .andExpect(model().hasErrors());
    }

    @Test
    void show_register_action_valid() throws Exception {
        // Should send the user with valid attributes and pass
        // Test passes, although not tested if user has been added to database.
        User user = prepareUserValid();
        this.mockMvc.perform(post("/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private User prepareUserEmpty(){
        User user = new User();
        user.setEmail("");
        user.setPassword("");
        user.setName("");
        user.setLastName("");

        return user;
    }

    private User prepareUserValid(){
        User user = new User();
        user.setEmail("testvalid@testvalid.com");
        user.setPassword("TestValid1");
        user.setName("Test");
        user.setLastName("Valid");

        return user;
    }
}