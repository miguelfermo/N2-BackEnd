package Projeto.Intermediario.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String username = "Miguel";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
