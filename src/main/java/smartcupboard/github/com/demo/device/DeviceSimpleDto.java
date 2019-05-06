package smartcupboard.github.com.demo.device;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Getter
public class DeviceSimpleDto {
    private final String macAddress;
    private final UUID uuid;
    private final Timestamp createdAt;
    private final String title;
    private final ShelfSimpleDto shelf;

    public DeviceSimpleDto(Device device) {
        this.macAddress = device.getMacAddress();
        this.uuid = device.getUuid();
        this.title = device.getTitle();
        this.createdAt = device.getCreatedAt();
        this.shelf = Optional.ofNullable(device.getShelf()).isPresent() ? new ShelfSimpleDto(device.getShelf()) : null;
    }
}
