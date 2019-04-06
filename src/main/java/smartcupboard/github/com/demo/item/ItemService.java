package smartcupboard.github.com.demo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemDto> getAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ItemDto getById(Long itemId) {
        return new ItemDto(itemRepository.getOne(itemId));
    }

    @Transactional(readOnly = true)
    public List<ItemEventDto> getHistory(Long itemId) {
        return null;
    }

    @Transactional
    public ItemDto create(CreateItemCommand command) {
        Item item = new Item();

        item.setTitle(command.getTitle());
        item.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return new ItemDto(itemRepository.save(item));
    }

    @Transactional
    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
