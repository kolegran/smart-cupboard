package smartcupboard.github.com.demo.device;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EventDeviceCommand {
    @NotNull
    private String itemId;

    @NotNull
    private long createdAt;

    @NotNull
    private Double weight;
}
