package pl.sda.urbaniec.movie_mvc.data.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.urbaniec.movie_mvc.data.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByUserName(String userName);

}
