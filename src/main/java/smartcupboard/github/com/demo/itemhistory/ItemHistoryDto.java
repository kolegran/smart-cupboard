package smartcupboard.github.com.demo.itemhistory;

import lombok.Getter;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfSimpleDto;
import smartcupboard.github.com.demo.item.ItemSimpleDto;
import smartcupboard.github.com.demo.user.UserSimpleDto;

import java.sql.Timestamp;

@Getter
public class ItemHistoryDto {
    private Long id;
    private Timestamp createdAt;
    private ItemSimpleDto item;
    //private UserSimpleDto user;
    private ShelfSimpleDto shelf;

    public ItemHistoryDto(ItemHistory itemHistory) {
        this.id = itemHistory.getId();
        this.createdAt = itemHistory.getCreatedAt();
        this.shelf = new ShelfSimpleDto(itemHistory.getShelf());
        this.item = new ItemSimpleDto(itemHistory.getItem());
        //this.user = new UserSimpleDto(itemHistory.getUser());
    }
}
