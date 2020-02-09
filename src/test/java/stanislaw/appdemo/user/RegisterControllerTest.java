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


    @BeforeEach
    void setUp() {
    }

    @Test
    void show_register_page_by_url() throws Exception {
        this.mockMvc.perform(get("/register")).andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    void show_register_page_model_title() throws Exception {
        this.mockMvc.perform(get("/register")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("title", "<s:message code=\"menu.register\"/>"))
        ;
    }

    @Test
    void show_register_page_model_user() throws Exception {
        this.mockMvc.perform(get("/register")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", any(User.class)))
                ;
    }


    @Test
    void show_register_action() throws Exception {
        User user = prepareUserEmpty();

        this.mockMvc.perform(post("/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(u)))
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
}