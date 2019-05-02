package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateSectorCommand {
    @Length(min = 1)
    private String title;

    @NotNull
    private Long shelfId;

    private String readerId;
}
