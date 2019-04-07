package smartcupboard.github.com.demo.device;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegistrationDeviceCommand {
    @NotNull
    private String id;

    @NotNull
    private String title;

    private Long shelfId;
}
