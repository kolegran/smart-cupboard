package smartcupboard.github.com.demo.device;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
public class DeviceSimpleDto {
    private final String macAddress;
    private final UUID uuid;
    private final Timestamp createdAt;
    private final String title;

    public DeviceSimpleDto(Device device) {
        this.macAddress = device.getMacAddress();
        this.uuid = device.getUuid();
        this.title = device.getTitle();
        this.createdAt = device.getCreatedAt();
    }
}
