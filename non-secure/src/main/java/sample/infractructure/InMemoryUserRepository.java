package sample.infractructure;

import sample.domain.User;
import sample.domain.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> userMap;

    InMemoryUserRepository() {
        Map<String, User> map = new HashMap<>();
        
        map.put("hoge", new User("user", "user", "user"));
        map.put("admin", new User("admin", "admin", "admin"));

        this.userMap = Collections.unmodifiableMap(map);
    }

    @Override
    public Optional<User> find(String username) {
        return Optional.ofNullable(this.userMap.get(username));
    }
}
