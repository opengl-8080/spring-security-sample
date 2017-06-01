package sample.domain;

import java.util.Optional;

public interface UserRepository {
    
    Optional<User> find(String username);
}
