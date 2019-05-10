package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreateUpdateSectorCommand {
    @Length(min = 1, max = 100)
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @Positive
    private Long shelfId;

    @Length(min = 1, max = 50)
    private String readerId;
}
