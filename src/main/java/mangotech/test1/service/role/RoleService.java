package mangotech.test1.service.role;

import mangotech.test1.dto.RoleDto;

import java.util.List;

public interface RoleService{
    List<RoleDto> findAll();

    RoleDto save(RoleDto roleDto);

    void deleteById(int id);
}
