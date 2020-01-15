package mangotech.test1.repository;

import mangotech.test1.entity.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {
    Group findByName(String name);
}
