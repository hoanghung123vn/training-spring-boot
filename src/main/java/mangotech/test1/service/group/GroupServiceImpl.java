package mangotech.test1.service.group;

import mangotech.test1.dto.GroupDto;
import mangotech.test1.entity.Group;
import mangotech.test1.entity.Role;
import mangotech.test1.repository.GroupRepository;
import mangotech.test1.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<GroupDto> findAll() {
        Iterable<Group> groups = groupRepository.findAll();

        return StreamSupport.stream(groups.spliterator(), false).map(group -> {
            return new GroupDto(group.getId(), group.getName(), StreamSupport.stream(group.getRoles().spliterator(), false).map(role -> {
                return role.getId();
            }).collect(Collectors.toSet()));
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public GroupDto save(GroupDto groupDto) {
        Set<Role> roles = new HashSet<>();
        groupDto.getRoles_id().forEach(id -> {
            Role role = roleRepository.findById(id).get();
            roles.add(role);
        });
        Group group = new Group(groupDto.getName());
        group.setRoles(roles);
        groupDto.setId(group.getId());
        return groupDto;
    }
}
