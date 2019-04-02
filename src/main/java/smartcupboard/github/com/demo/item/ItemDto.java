package smartcupboard.github.com.demo.item;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;

import java.sql.Timestamp;

@Getter
public class ItemDto {
    private final String id;
    private final String title;
    private final Timestamp createdAt;
    private final Timestamp changedAt;
    private final Timestamp deletedAt;

    private final SectorDto sector;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.createdAt = item.getCreatedAt();
        this.changedAt = item.getChangedAt();
        this.deletedAt = item.getDeletedAt();

        this.sector = new SectorDto(item.getSector());
    }
}
