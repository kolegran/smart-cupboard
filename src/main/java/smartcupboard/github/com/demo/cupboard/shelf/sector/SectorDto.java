package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;

@Getter
public class SectorDto {
    private final Long id;
    private final String title;
    private final ShelfSimpleDto shelf;

    public SectorDto(Sector sector) {
        this.id = sector.getId();
        this.title = sector.getTitle();
        this.shelf = new ShelfSimpleDto(sector.getShelf());
    }
}
