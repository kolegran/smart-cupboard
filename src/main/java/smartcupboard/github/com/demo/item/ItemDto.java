package smartcupboard.github.com.demo.item;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ItemDto {
    private final Long id;
    private final String title;
    private final Timestamp createdAt;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.createdAt = item.getCreatedAt();
    }
}
