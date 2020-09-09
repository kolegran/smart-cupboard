package smartcupboard.github.com.demo.item;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;

@Getter
public class ItemExistDto extends ItemSimpleDto {
    private final SectorDto sector;

    public ItemExistDto(Item item, Sector sector) {
        super(item);
        this.sector = new SectorDto(sector);
    }
}
