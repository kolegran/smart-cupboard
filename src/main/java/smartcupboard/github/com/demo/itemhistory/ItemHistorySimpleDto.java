package smartcupboard.github.com.demo.itemhistory;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ItemHistorySimpleDto {
    private final Long id;
    private final Timestamp createdAt;

    public ItemHistorySimpleDto(ItemHistory itemHistory) {
        this.id = itemHistory.getId();
        this.createdAt = itemHistory.getCreatedAt();
    }
}
