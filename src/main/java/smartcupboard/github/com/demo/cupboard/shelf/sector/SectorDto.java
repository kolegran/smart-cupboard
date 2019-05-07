package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;
import smartcupboard.github.com.demo.reader.ReaderSimpleDto;

@Getter
public class SectorDto extends SectorSimpleDto {
    private final ShelfSimpleDto shelf;
    private final ReaderSimpleDto reader;

    public SectorDto(Sector sector) {
        super(sector);

        this.shelf = new ShelfSimpleDto(sector.getShelf());
        this.reader = new ReaderSimpleDto(sector.getReader());
    }
}
