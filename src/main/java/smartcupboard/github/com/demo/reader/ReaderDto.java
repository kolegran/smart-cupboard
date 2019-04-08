package smartcupboard.github.com.demo.reader;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;

@Getter
public class ReaderDto {
    private final String id;
    private final String title;
    private final SectorDto sector;

    public ReaderDto(Reader reader) {
        this.id = reader.getId();
        this.title = reader.getTitle();
        this.sector = new SectorDto(reader.getSector());
    }
}
