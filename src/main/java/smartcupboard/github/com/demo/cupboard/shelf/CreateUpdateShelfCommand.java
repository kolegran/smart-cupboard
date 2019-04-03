package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateShelfCommand {
    @Length(min = 1)
    private String title;

    @NotNull
    private Long cupboardId;
}
