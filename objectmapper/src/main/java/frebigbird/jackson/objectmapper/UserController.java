package frebigbird.jackson.objectmapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping("/user")
    public String findUser() {
        return "{\"id\":\"gdhong\",\"name\":\"홍길동\",\"age\":20,\"phone_number\":\"010-0000-0000\"}";
    }

    @RequestMapping("/user2")
    public User findUser2() {
        User user = restTemplate.getForObject("http://localhost:8080/user", User.class);
        user.age = Optional.of(30);
        return user;
    }
}
