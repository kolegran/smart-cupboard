package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.CupboardSimpleDto;
import smartcupboard.github.com.demo.device.DeviceSimpleDto;

@Getter
public class ShelfSimpleDto {
    private final Long id;
    private final String title;
    private final CupboardSimpleDto cupboard;
    private final DeviceSimpleDto device;

    public ShelfSimpleDto(Shelf shelf) {
        this.id = shelf.getId();
        this.title = shelf.getTitle();
        this.cupboard = new CupboardSimpleDto(shelf.getCupboard());
        this.device = new DeviceSimpleDto(shelf.getDevice());
    }
}
