package mangotech.test1.service.basev2;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper<T, U> {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

}
