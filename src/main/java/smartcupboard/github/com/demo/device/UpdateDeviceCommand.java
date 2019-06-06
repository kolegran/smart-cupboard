package smartcupboard.github.com.demo.device;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class UpdateDeviceCommand {
    @Length(min = 1, max = 50)
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @Positive
    private Long shelfId;
}
