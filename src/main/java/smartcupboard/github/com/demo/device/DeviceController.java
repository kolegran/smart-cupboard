package smartcupboard.github.com.demo.device;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("/devices")
    public ResponseEntity<List<DeviceSimpleDto>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAll());
    }

    @GetMapping("/devices/{deviceId}")
    public ResponseEntity<DeviceSimpleDto> getDeviceById(@PathVariable String deviceId) {
        return ResponseEntity.ok(deviceService.getById(deviceId));
    }

    @PutMapping("/devices/{deviceId}")
    public ResponseEntity<DeviceSimpleDto> updateDeviceById(@PathVariable String deviceId, @RequestBody @Valid UpdateDeviceCommand command) {
        return ResponseEntity.ok(deviceService.update(deviceId, command));
    }

    @DeleteMapping("/devices/{deviceId}")
    public ResponseEntity<Void> deleteDeviceById(@PathVariable String deviceId) {
        deviceService.deleteById(deviceId);
        return ResponseEntity.ok().build();
    }
}
