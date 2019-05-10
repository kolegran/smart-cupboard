package smartcupboard.github.com.demo.item;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateItemCommand {
    @Length(min = 1, max = 100)
    @NotBlank
    @NotNull
    private String title;
}
