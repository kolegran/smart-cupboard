package smartcupboard.github.com.demo.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfRepository;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorRepository;
import smartcupboard.github.com.demo.item.Item;
import smartcupboard.github.com.demo.item.ItemRepository;
import smartcupboard.github.com.demo.item.ItemStatus;
import smartcupboard.github.com.demo.itemhistory.ItemHistory;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryRepository;
import smartcupboard.github.com.demo.reader.ReaderRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final SectorRepository sectorRepository;
    private final ItemRepository itemRepository;
    private final ReaderRepository readerRepository;
    private final ItemHistoryRepository itemHistoryRepository;
    private final ShelfRepository shelfRepository;

    @Transactional
    public DeviceSimpleDto registration(RegistrationDeviceCommand command) {
        final Device device = deviceRepository.findById(command.getMacAddress()).orElseGet(() -> {
            final Device newDevice = new Device();
            newDevice.setMacAddress(command.getMacAddress());
            newDevice.setUuid(UUID.randomUUID());
            newDevice.setTitle(command.getTitle());
            newDevice.setCreatedAt(new Timestamp(new Date().getTime()));
            return deviceRepository.save(newDevice);
        });
        return new DeviceSimpleDto(device);
    }

    @Transactional
    public void addEvents(EventDeviceCommand command) {
        final Device device = deviceRepository.getOne(command.getDeviceId());
/*
        if (!command.getUuid().equals(device.getUuid().toString())) {
            throw new Exception("Device is unauthorized");
        }
*/
        final Long shelfId = device.getShelf().getId();
        List<Item> lastItems = itemRepository.findAllItems(sectorRepository.findByShelfId(shelfId));
        final List<String> allRfids = itemRepository.findAll().stream()
            .map(Item::getRfid)
            .collect(Collectors.toList());

        for (ReaderData reader : command.getReaders()) {
            final List<String> rfids = reader.getItems()
                    .stream()
                    .map(ItemData::getRfid)
                    .collect(Collectors.toList());

            final List<Item> newItems = new ArrayList<>();
            for (String rd : rfids) {
                if (!allRfids.contains(rd)) {
                    final Item item = new Item();
                    item.setRfid(rd);
                    item.setTitle("UNKNOWN");
                    item.setCreatedAt(new Timestamp(new Date().getTime()));
                    item.setStatus(ItemStatus.PUT);
                    newItems.add(item);
                }
            }
            itemRepository.saveAll(newItems);

            List<Item> items = itemRepository.findByRfidIn(rfids);
            lastItems.removeAll(items);

            items = items
                .stream()
                .peek(object -> object.setStatus(ItemStatus.PUT))
                .collect(Collectors.toList());

            itemRepository.saveAll(items);

            final Sector sector = readerRepository.getOne(reader.getReaderId()).getSector();
            items.addAll(newItems);
            final List<ItemHistory> itemHistoryList = items
                    .stream()
                    .map(obj -> {
                        final ItemHistory itemHistory = new ItemHistory();
                        itemHistory.setCreatedAt(new Timestamp(new Date().getTime()));
                        itemHistory.setSector(sector);
                        itemHistory.setItem(obj);
                        return itemHistory;
                    })
                    .collect(Collectors.toList());

            itemHistoryRepository.saveAll(itemHistoryList);
        }

        lastItems = lastItems
                .stream()
                .peek(obj -> obj.setStatus(ItemStatus.TAKEN))
                .collect(Collectors.toList());

        itemRepository.saveAll(lastItems);
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
        final Device device = deviceRepository.getOne(deviceId);
        device.setTitle(command.getTitle());
        device.setShelf(shelfRepository.getOne(command.getShelfId()));
        return new DeviceSimpleDto(deviceRepository.save(device));
    }

    @Transactional
    public void deleteById(String deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    public MqttMessage createMessage(DeviceSimpleDto deviceSimpleDto) throws Exception {
        final MqttMessage message = new MqttMessage(new ObjectMapper().writeValueAsBytes(deviceSimpleDto));
        message.setQos(2);
        message.setRetained(false);
        return message;
    }
}
