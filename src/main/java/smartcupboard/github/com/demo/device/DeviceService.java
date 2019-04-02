package smartcupboard.github.com.demo.device;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Transactional
    public DeviceSimpleDto registration(RegistrationDeviceCommand command) {
        Device device = new Device();

        device.setId(command.getId());
        device.setTitle(command.getTitle());
        device.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        return new DeviceSimpleDto(deviceRepository.save(device));
    }

    @Transactional
    public DeviceSimpleDto addEvents(String deviceId, List<EventDeviceCommand> command) {
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
}
