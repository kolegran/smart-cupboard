package smartcupboard.github.com.demo.device;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class DeviceSimpleDto {
    private final String id;
    private final Timestamp createdAt;
    private final String title;

    public DeviceSimpleDto(Device device) {
        this.id = device.getId();
        this.createdAt = device.getCreatedAt();
        this.title = device.getTitle();
    }
}
