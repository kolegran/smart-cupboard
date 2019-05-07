package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.CupboardSimpleDto;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;
import smartcupboard.github.com.demo.device.DeviceSimpleDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShelfDto extends ShelfSimpleDto {
    private final List<SectorDto> sectors;
    private final CupboardSimpleDto cupboard;
    private final DeviceSimpleDto device;

    public ShelfDto(Shelf shelf) {
        super(shelf);

        this.cupboard = new CupboardSimpleDto(shelf.getCupboard());
        this.device = new DeviceSimpleDto(shelf.getDevice());

        this.sectors = shelf.getSectors()
                .stream()
                .map(SectorDto::new)
                .collect(Collectors.toList());
    }
}
