package smartcupboard.github.com.demo.device.data;

import lombok.Getter;
import smartcupboard.github.com.demo.device.DeviceSimpleDto;
import smartcupboard.github.com.demo.item.ItemDto;

import java.sql.Timestamp;

@Getter
public class DeviceDataDto {
    private final Long id;
    private final Timestamp createdAt;
    private final DeviceSimpleDto device;
    private final Double weight;
    private final ItemDto item;

    public DeviceDataDto(DeviceData deviceData) {
        this.id = deviceData.getId();
        this.createdAt = deviceData.getCreatedAt();
        this.device = new DeviceSimpleDto(deviceData.getDevice());
        this.weight = deviceData.getWeight();
        this.item = new ItemDto(deviceData.getItem());
    }
}
