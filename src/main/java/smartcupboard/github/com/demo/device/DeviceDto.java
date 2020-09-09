package smartcupboard.github.com.demo.device;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;

import java.util.Optional;

@Getter
public class DeviceDto extends DeviceSimpleDto {
    private final ShelfSimpleDto shelf;

    public DeviceDto(Device device) {
        super(device);
        this.shelf = Optional.ofNullable(device.getShelf()).isPresent() ?
            new ShelfSimpleDto(device.getShelf())
            : null;
    }
}
