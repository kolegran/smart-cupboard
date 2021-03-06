package smartcupboard.github.com.demo.reader;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreateUpdateReaderCommand {
    @Length(min = 1, max = 100)
    @NotNull
    @NotBlank
    private String title;

    @Positive
    @NotNull
    private Long sectorId;
}
