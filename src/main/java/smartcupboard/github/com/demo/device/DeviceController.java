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

    // Embedded
    @PostMapping("/devices")
    public ResponseEntity<DeviceDto> registrationDevice(@RequestBody @Valid RegistrationDeviceCommand command) {
        return ResponseEntity.ok(deviceService.registration(command));
    }

    //Embedded
    @PostMapping("/devices/command/{deviceId}/event")
    public ResponseEntity<DeviceDto> deviceEvent(@PathVariable String deviceId, @RequestBody @Valid EventDeviceCommand command) {
        return ResponseEntity.ok(deviceService.addEvent(deviceId, command));
    }

    @GetMapping("/devices")
    public ResponseEntity<List<DeviceDto>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAll());
    }

    @GetMapping("/devices/{deviceId}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable String deviceId) {
        return ResponseEntity.ok(deviceService.getById(deviceId));
    }

    @PatchMapping("/devices/{deviceId}")
    public ResponseEntity<DeviceDto> updateDeviceById(@PathVariable String deviceId, @RequestBody @Valid UpdateDeviceCommand command) {
        return ResponseEntity.ok(deviceService.update(deviceId, command));
    }

    @DeleteMapping("/devices/{deviceId}")
    public ResponseEntity<Void> deleteDeviceById(@PathVariable String deviceId) {
        deviceService.deleteById(deviceId);
        return ResponseEntity.ok().build();
    }
}
