package smartcupboard.github.com.demo.item;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ItemSimpleDto {
    private final Long id;
    private final String title;
    private final Timestamp createdAt;
    private final String rfid;
    private final ItemStatus itemStatus;

    public ItemSimpleDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.createdAt = item.getCreatedAt();
        this.rfid = item.getRfid();
        this.itemStatus = item.getStatus();
    }
}
