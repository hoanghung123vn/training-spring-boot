package mangotech.test1.service.user;

import mangotech.test1.config.Const;
import mangotech.test1.dto.UserDto;
import mangotech.test1.entity.Group;
import mangotech.test1.entity.User;
import mangotech.test1.repository.GroupRepository;
import mangotech.test1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> {
            return new UserDto(user.getId(), user.getName(), "no explicit", user.getStatus(), user.getCreatedAt(), user.getUpdatedAt(), user.getGroup().getId());
        }).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(int id) {
        User user = userRepository.findById(id).get();
        return new UserDto(user.getId(), user.getName(), "no explicit", user.getStatus(), user.getCreatedAt(), user.getUpdatedAt(), user.getGroup().getId());
    }

    @Override
    public UserDto findByName(String name) {
        User user = userRepository.findByName(name);
        return new UserDto(user.getId(), user.getName(), "no explicit", user.getStatus(), user.getCreatedAt(), user.getUpdatedAt(), user.getGroup().getId());
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto save(UserDto user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setStatus(Const.ACTIVE_STATUS);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setGroup(groupRepository.findById(user.getGroup_id()).get());
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());
        userRepository.save(newUser);
        return new UserDto(newUser.getId(), newUser.getName(), "no explicit", newUser.getStatus(), newUser.getCreatedAt(), newUser.getUpdatedAt(), newUser.getGroup().getId());
    }

    @Override
    public void setGroup(int user_id, int group_id) {
        User user = userRepository.findById(user_id).get();
        Group group = groupRepository.findById(group_id).get();
        user.setGroup(group);
    }
}
