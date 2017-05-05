package sample;

import java.util.Objects;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public boolean hasSamePassword(String password) {
        return Objects.equals(this.password, password);
    }
}
