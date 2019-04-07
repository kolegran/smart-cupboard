package smartcupboard.github.com.demo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemSimpleDto> getAll() {
        return null;
    }

    public ItemSimpleDto getById(Long itemId) {
        return null;
    }

    public List<ItemEventDto> getHistory(Long itemId) {
        return null;
    }

    public ItemSimpleDto create(CreateItemCommand command) {
        return null;
    }

    public void deleteById(Long itemId) {
    }
}
