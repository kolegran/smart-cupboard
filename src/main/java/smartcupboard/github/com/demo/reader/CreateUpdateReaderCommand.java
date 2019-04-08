package smartcupboard.github.com.demo.reader;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class CreateUpdateReaderCommand {
    @Length(min=2)
    private String title;

    @NotNull
    private Long sectorId;
}
