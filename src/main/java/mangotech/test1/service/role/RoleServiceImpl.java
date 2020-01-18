package mangotech.test1.service.role;

import mangotech.test1.dto.RoleDto;
import mangotech.test1.entity.Role;
import mangotech.test1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> findAll() {
        Iterable<Role> roles = roleRepository.findAll();
        return StreamSupport.stream(roles.spliterator(), false).map(s -> {
            return new RoleDto(s.getId(), s.getName());
        }).collect(Collectors.toList());
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = roleRepository.save(new Role(roleDto.getName()));
        roleDto.setId(role.getId());
        return roleDto;
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
