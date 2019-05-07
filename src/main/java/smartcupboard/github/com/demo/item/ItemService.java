package smartcupboard.github.com.demo.item;

import com.google.common.collect.Iterables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorRepository;
import smartcupboard.github.com.demo.itemhistory.ItemHistory;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryDto;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final SectorRepository sectorRepository;
    private final ItemHistoryRepository itemHistoryRepository;

    @Transactional(readOnly = true)
    public List<ItemSimpleDto> getAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemSimpleDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ItemDto getById(Long itemId) {
        return new ItemDto(itemRepository.getOne(itemId));
    }

    @Transactional(readOnly = true)
    public List<ItemHistoryDto> getHistory(Long itemId) {
        return itemHistoryRepository.findByItemId(itemId)
                .stream()
                .map(ItemHistoryDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemDto create(CreateItemCommand command) {
        Item item = new Item();

        item.setTitle(command.getTitle());
        item.setCreatedAt(new Timestamp(new Date().getTime()));
        return new ItemDto(itemRepository.save(item));
    }

    @Transactional
    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Transactional(readOnly = true)
    public List<ItemExistDto> getAllItems(Long shelfId) {
        List<Sector> sectors = sectorRepository.findByShelfId(shelfId);
        List<Item> items = itemRepository.findAllItems(sectors);

        return items.stream()
                .map(obj -> new ItemExistDto(obj, Iterables.getLast(obj.getItemHistoryList()).getSector()))
                .collect(Collectors.toList());
    }
}
