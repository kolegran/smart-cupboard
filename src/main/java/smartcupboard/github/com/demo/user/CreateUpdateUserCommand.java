package smartcupboard.github.com.demo.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateUserCommand {
    @Length(min = 1)
    private String firstName;

    @Length(min = 1)
    private String lastName;

    @Length(min = 5)
    private String email;

    @NotNull
    private Long roleId;
}
