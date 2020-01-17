package mangotech.test1.service.user;

import mangotech.test1.dto.UserDto;

import java.util.List;

/**
 * @author HungHoang
 * @version 1.0
 */
public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    UserDto findByName(String name);

    void deleteById(int id);

    UserDto save (UserDto user);
}
