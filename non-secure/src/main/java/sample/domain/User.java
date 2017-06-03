package sample.domain;

import java.util.Objects;

public class User {
    private String name;
    private String password;
    private String authority;

    public User(String name, String password, String authority) {
        this.name = name;
        this.password = password;
        this.authority = authority;
    }
    
    public boolean hasAuthority(String authority) {
        return Objects.equals(this.authority, authority);
    }
    
    public boolean hasSamePassword(String password) {
        return Objects.equals(this.password, password);
    }
}
