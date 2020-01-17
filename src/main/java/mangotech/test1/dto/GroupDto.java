package mangotech.test1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class GroupDto {
    @NotBlank
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private Set<RoleDto> roles;
}
