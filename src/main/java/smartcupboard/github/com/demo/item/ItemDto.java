package smartcupboard.github.com.demo.item;

import lombok.Getter;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemDto extends ItemSimpleDto {
    List<ItemHistoryDto> history;

    public ItemDto(Item item) {
        super(item);

        this.history = item.getItemHistoryList()
                .stream()
                .map(ItemHistoryDto::new)
                .collect(Collectors.toList());
    }
}
