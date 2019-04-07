package smartcupboard.github.com.demo.device;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfRepository;
import smartcupboard.github.com.demo.item.Item;
import smartcupboard.github.com.demo.item.ItemRepository;
import smartcupboard.github.com.demo.itemhistory.ItemHistory;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryDto;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryRepository;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final ItemRepository itemRepository;
    private final ItemHistoryRepository itemHistoryRepository;
    private final ShelfRepository shelfRepository;

    @Transactional
    public DeviceSimpleDto registration(RegistrationDeviceCommand command) {
        Device device = new Device();
        device.setId(command.getId());
        device.setTitle(command.getTitle());
        device.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        device.setShelf(shelfRepository.getOne(command.getShelfId()));

        return new DeviceSimpleDto(deviceRepository.save(device));
    }

    @Transactional
    public List<ItemHistoryDto> addEvents(EventDeviceCommand command) {
        List<ItemHistory> newItemHistoryList = new ArrayList<>();

        Device device = deviceRepository.getOne(command.getDeviceId());

        Specification<ItemHistory> specification = (rootItemHistory, qItemHistory, cb) -> {
            Predicate itemHistoryPredicate = cb.equal(rootItemHistory.get("shelf").get("id"), device.getShelf().getId());

            Subquery<Number> subQueryItem = qItemHistory.subquery(Number.class);
            Root<ItemHistory> rootSubItem = subQueryItem.from(ItemHistory.class);

            subQueryItem.select(cb.max(rootSubItem.get("createdAt")));
            subQueryItem.groupBy(rootSubItem.get("item").get("id"));

            Predicate uniqIdPredicate = cb.in(rootItemHistory.get("createdAt")).value(subQueryItem);
            return cb.and(itemHistoryPredicate, uniqIdPredicate);
        };
        List<ItemHistory> existItemHistoryList = itemHistoryRepository.findAll(specification);

        for (ItemData cmd : command.getItems()) {
            Optional<ItemHistory> existItem = existItemHistoryList.stream()
                    .filter(obj -> obj.getItem().getRfid().equals(cmd.getRfid()))
                    .findAny();

            if (existItem.isPresent()) {
                existItemHistoryList.remove(existItem.get());
            } else {
                ItemHistory itemHistory = new ItemHistory();
                itemHistory.setShelf(device.getShelf());

                Specification<Item> itemSpecification = (rootItem, qItem, cb) -> {
                    Predicate itemPredicate = cb.equal(rootItem.get("rfid"), cmd.getRfid());

                    return itemPredicate;
                };

                itemHistory.setItem(itemRepository.findOne(itemSpecification).orElseThrow());
                itemHistory.setCreatedAt(new Timestamp(new Date().getTime()));

                newItemHistoryList.add(itemHistory);
            }
        }

        for (ItemHistory notExist : existItemHistoryList) {
            // ItemHistory without Shelf
        }

        return itemHistoryRepository.saveAll(newItemHistoryList)
                .stream()
                .map(ItemHistoryDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<DeviceSimpleDto> getAll() {
        return deviceRepository.findAll()
                .stream()
                .map(DeviceSimpleDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeviceSimpleDto getById(String deviceId) {
        return new DeviceSimpleDto(deviceRepository.getOne(deviceId));
    }

    @Transactional
    public DeviceSimpleDto update(String deviceId, UpdateDeviceCommand command) {
        return null;
    }

    @Transactional
    public void deleteById(String deviceId) {
        deviceRepository.deleteById(deviceId);
    }
}
