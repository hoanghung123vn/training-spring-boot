package mangotech.test1.config;

import mangotech.test1.entity.Group;
import mangotech.test1.entity.Role;
import mangotech.test1.entity.User;
import mangotech.test1.repository.GroupRepository;
import mangotech.test1.repository.RoleRepository;
import mangotech.test1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Hung Hoang
 * @version 1.0
 */
@Component
public class DataSeedling implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Add roles
        if(roleRepository.findByName(Const.ROLE_USER) == null){
            roleRepository.save(new Role(Const.ROLE_USER));
        }
        if(roleRepository.findByName(Const.ROLE_ADMIN) == null){
            roleRepository.save((new Role(Const.ROLE_ADMIN)));
        }
        // Add groups
        if(groupRepository.findByName(Const.GROUP_USER) == null){
            Group group = new Group(Const.GROUP_USER);
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName(Const.ROLE_USER));
            group.setRoles(roles);
            groupRepository.save(group);
        }
        if(groupRepository.findByName(Const.GROUP_ADMIN) == null){
            Group group = new Group(Const.GROUP_ADMIN);
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName(Const.ROLE_ADMIN));
            group.setRoles(roles);
            groupRepository.save(group);
        }
        // Add users
        if(userRepository.findByName("user@gmail.com") == null) {
            User user = new User();
            user.setName("user@gmail.com");
            user.setStatus(Const.ACTIVE_STATUS);
            Group group = groupRepository.findByName(Const.GROUP_USER);
            user.setGroup(group);
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
        }
        if(userRepository.findByName("admin@gmail.com") == null){
            User user = new User();
            user.setName("admin@gmail.com");
            user.setStatus(Const.ACTIVE_STATUS);
            Group group = groupRepository.findByName(Const.GROUP_ADMIN);
            user.setGroup(group);
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
        }
    }
}
