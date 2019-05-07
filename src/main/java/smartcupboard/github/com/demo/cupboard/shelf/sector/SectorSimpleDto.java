package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.Getter;

@Getter
public class SectorSimpleDto {
    private final Long id;
    private final String title;

    public SectorSimpleDto(Sector sector) {
        this.id = sector.getId();
        this.title = sector.getTitle();
    }
}
