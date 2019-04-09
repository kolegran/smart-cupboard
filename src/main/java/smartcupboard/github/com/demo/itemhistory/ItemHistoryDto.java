package smartcupboard.github.com.demo.itemhistory;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;
import smartcupboard.github.com.demo.item.ItemSimpleDto;
import smartcupboard.github.com.demo.user.UserSimpleDto;

import java.sql.Timestamp;

@Getter
public class ItemHistoryDto {
    private Long id;
    private Timestamp createdAt;
    private ItemSimpleDto item;
    private UserSimpleDto user;
    private SectorDto sector;

    public ItemHistoryDto(ItemHistory itemHistory) {
        this.id = itemHistory.getId();
        this.createdAt = itemHistory.getCreatedAt();
        this.item = new ItemSimpleDto(itemHistory.getItem());
        this.sector = new SectorDto(itemHistory.getSector());
        this.user = new UserSimpleDto(itemHistory.getUser());
    }
}
