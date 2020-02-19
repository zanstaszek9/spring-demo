package stanislaw.appdemo.mainController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MainPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldRedirectToEntryPageUsingEmptyURL() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")))
        ;
    }

    @Test
    void itShouldRedirectToEntryPageUsingIndexURL() throws Exception {
        this.mockMvc.perform(get("/index")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("")))
        ;
    }

    @Test
    void itShouldRedirectToErrorPageUsingIncorrectURL() throws Exception {
        this.mockMvc.perform(get("/asdasdas")).andDo(print())
                .andExpect(status().is(404));        ;
    }


}