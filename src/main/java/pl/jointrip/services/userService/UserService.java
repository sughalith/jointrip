package pl.jointrip.services.userService;

import org.springframework.stereotype.Service;
import pl.jointrip.models.User;

@Service
public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    User getLoggedUser();
}
