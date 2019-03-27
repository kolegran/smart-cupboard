package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;
import smartcupboard.github.com.demo.sample.SampleDto;

@Getter
public class SectorDto {
    private final Long id;
    private final String title;
    private final ShelfSimpleDto shelf;
    private final SampleDto sample;

    public SectorDto(Sector sector) {
        this.id = sector.getId();
        this.title = sector.getTitle();
        this.shelf = new ShelfSimpleDto(sector.getShelf());
        this.sample = new SampleDto(sector.getSample());
    }
}
