package smartcupboard.github.com.demo.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateUserCommand {
    @Length(min = 1, max = 40)
    @NotNull
    @NotBlank
    private String firstName;

    @Length(min = 1, max = 40)
    @NotNull
    @NotBlank
    private String lastName;

    @Length(min = 5, max = 150)
    @NotNull
    @NotBlank
    private String email;
}
