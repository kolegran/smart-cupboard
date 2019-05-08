package smartcupboard.github.com.demo.device;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDeviceCommand {
    @NotNull
    private String uuid;
    private String deviceId;
    private List<ReaderData> readers = new ArrayList<>();
}
