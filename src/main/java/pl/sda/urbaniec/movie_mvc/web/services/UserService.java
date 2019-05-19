package pl.sda.urbaniec.movie_mvc.web.services;

import org.springframework.stereotype.Service;
import pl.sda.urbaniec.movie_mvc.data.entity.User;
import pl.sda.urbaniec.movie_mvc.data.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public User findUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
