package home.integrationandacceptancetestsdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class WelcomeService {
    public String getWelcomeMessage(@RequestParam(defaultValue = "Visitor") String name) {
        return String.format("Welcome, %s!", name);
    }
}
