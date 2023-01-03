package home.integrationandacceptancetestsdemo.controller;

import home.integrationandacceptancetestsdemo.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerTest {

    @Test
    void shouldGetWelcomeMessage() {
        WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
        when(welcomeService.getWelcomeMessage("Yuri")).thenReturn("Welcome, Yuri!");
        WelcomeController welcomeController = new WelcomeController(welcomeService);
        assertEquals("Welcome, Yuri!", welcomeController.welcome("Yuri"));
    }
}