package smartcupboard.github.com.demo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDto> getAll() {
        return null;
    }

    public ItemDto getById(Long sampleId) {
        return null;
    }

    public List<ItemEventDto> getHistory(Long sampleId) {
        return null;
    }

    public ItemDto create(CreateItemCommand command) {
        return null;
    }

    public void deleteById(Long sampleId) {
    }
}
