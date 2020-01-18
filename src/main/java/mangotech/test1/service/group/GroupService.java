package mangotech.test1.service.group;

import mangotech.test1.dto.GroupDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> findAll();

    void deleteById(int id);

    GroupDto save(GroupDto groupDto);
}
