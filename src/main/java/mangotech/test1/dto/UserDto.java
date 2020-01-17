package mangotech.test1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private int status;

    private Date created_at;

    private Date updated_at;

    private int group_id;

}
