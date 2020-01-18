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
    private int id;

    @NotBlank
    private String name;

    private Set<Integer> roles_id;
}
