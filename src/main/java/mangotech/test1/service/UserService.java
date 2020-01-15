package mangotech.test1.service;

import mangotech.test1.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author HungHoang
 * @version 1.0
 */
public interface UserService {
    List<User> findAll();

    Optional<User> findById(int id);

    User findByName(String name);

    void deleteById(int id);

    void save (User user);
}
