package mangotech.test1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
public class RoleDto {
    @NotBlank
    private int id;

    @NotBlank
    private String name;
}
