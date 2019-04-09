package smartcupboard.github.com.demo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemSimpleDto> getAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemSimpleDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ItemSimpleDto getById(Long itemId) {
        return new ItemSimpleDto(itemRepository.getOne(itemId));
    }

    @Transactional(readOnly = true)
    public List<ItemEventDto> getHistory(Long itemId) {
        return null;
    }

    @Transactional
    public ItemSimpleDto create(CreateItemCommand command) {
        Item item = new Item();

        item.setTitle(command.getTitle());
        item.setCreatedAt(new Timestamp(new Date().getTime()));
        return new ItemSimpleDto(itemRepository.save(item));
    }

    @Transactional
    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
