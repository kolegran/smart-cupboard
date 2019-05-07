package smartcupboard.github.com.demo.reader;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorSimpleDto;

@Getter
public class ReaderDto extends ReaderSimpleDto {
    private final SectorSimpleDto sector;

    public ReaderDto(Reader reader) {
        super(reader);

        this.sector = new SectorSimpleDto(reader.getSector());
    }
}
