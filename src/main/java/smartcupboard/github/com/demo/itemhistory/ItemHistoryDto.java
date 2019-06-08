package smartcupboard.github.com.demo.itemhistory;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorDto;
import smartcupboard.github.com.demo.item.ItemSimpleDto;
import smartcupboard.github.com.demo.user.UserSimpleDto;

@Getter
public class ItemHistoryDto extends ItemHistorySimpleDto {
    private final ItemSimpleDto item;
    //private final UserSimpleDto user;
    private final SectorDto sector;

    public ItemHistoryDto(ItemHistory itemHistory) {
        super(itemHistory);

        this.item = new ItemSimpleDto(itemHistory.getItem());
        this.sector = new SectorDto(itemHistory.getSector());
        //this.user = new UserSimpleDto(itemHistory.getUser());
    }
}
