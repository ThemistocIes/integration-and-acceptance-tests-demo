package home.integrationandacceptancetestsdemo.controller;

import home.integrationandacceptancetestsdemo.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WelcomeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WelcomeService welcomeService;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        when(welcomeService.getWelcomeMessage("Visitor")).thenReturn("Welcome, Visitor!");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome, Visitor!")));
        verify(welcomeService).getWelcomeMessage("Visitor");
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        when(welcomeService.getWelcomeMessage("Yuri")).thenReturn("Welcome, Yuri!");
        mockMvc.perform(get("/welcome?name=Yuri"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome, Yuri!")));
        verify(welcomeService).getWelcomeMessage("Yuri");
    }
}