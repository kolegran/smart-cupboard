package smartcupboard.github.com.demo.device;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EventDeviceCommand {
    private String deviceId;
    private List<ItemData> items = new ArrayList<>();
}
