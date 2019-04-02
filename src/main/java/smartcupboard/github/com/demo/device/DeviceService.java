package smartcupboard.github.com.demo.device;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceDto registration(RegistrationDeviceCommand command) {
        return null;
    }

    public DeviceDto addEvents(String deviceId, List<EventDeviceCommand> command) {
        return null;
    }

    public List<DeviceDto> getAll() {
        return null;
    }

    public DeviceDto getById(String deviceId) {
        return null;
    }

    public DeviceDto update(String deviceId, UpdateDeviceCommand command) {
        return null;
    }

    public void deleteById(String deviceId) {
    }
}
