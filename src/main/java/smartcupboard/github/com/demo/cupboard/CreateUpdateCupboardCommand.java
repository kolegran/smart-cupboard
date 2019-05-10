package smartcupboard.github.com.demo.cupboard;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateCupboardCommand {
    @Length(min = 1, max = 100)
    @NotNull
    @NotBlank
    private String title;
}
