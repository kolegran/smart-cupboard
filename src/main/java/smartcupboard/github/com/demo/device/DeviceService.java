package smartcupboard.github.com.demo.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorRepository;
import smartcupboard.github.com.demo.item.Item;
import smartcupboard.github.com.demo.item.ItemRepository;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryDto;

import java.sql.Timestamp;
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

    @Transactional
    public DeviceSimpleDto registration(RegistrationDeviceCommand command) {
        Device device = deviceRepository.findById(command.getMacAddress()).orElseGet(() -> {
            Device newDevice = new Device();

            newDevice.setMacAddress(command.getMacAddress());
            newDevice.setUuid(UUID.randomUUID());
            newDevice.setTitle(command.getTitle());
            newDevice.setCreatedAt(new Timestamp(new Date().getTime()));

            return deviceRepository.save(newDevice);
        });
        return new DeviceSimpleDto(device);
    }

    @Transactional
    public List<ItemHistoryDto> addEvents(EventDeviceCommand command) {
        Long shelfId = deviceRepository.getOne(command.getDeviceId()).getShelf().getId();
        List<Sector> sectors = sectorRepository.findByShelfId(shelfId);
        List<Item> lastItems = itemRepository.findAllItems(sectors);

        return null;
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

    public MqttMessage createMessage(DeviceSimpleDto deviceSimpleDto) throws Exception {
        MqttMessage message = new MqttMessage(new ObjectMapper().writeValueAsBytes(deviceSimpleDto));
        message.setQos(2);
        message.setRetained(false);

        return message;
    }
}
