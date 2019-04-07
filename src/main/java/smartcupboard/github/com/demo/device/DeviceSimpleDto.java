package smartcupboard.github.com.demo.device;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;

import java.sql.Timestamp;

@Getter
public class DeviceSimpleDto {
    private final String id;
    private final Timestamp createdAt;
    private final String title;
    private final ShelfSimpleDto shelf;

    public DeviceSimpleDto(Device device) {
        this.id = device.getId();
        this.createdAt = device.getCreatedAt();
        this.title = device.getTitle();
        this.shelf = new ShelfSimpleDto(device.getShelf());
    }
}
