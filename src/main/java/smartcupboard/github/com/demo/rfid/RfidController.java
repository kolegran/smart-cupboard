package smartcupboard.github.com.demo.rfid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RfidController {
    public final RfidService rfidService;

    @GetMapping("/rfids")
    public ResponseEntity<List<RfidDto>> getAllRfids() {
        return ResponseEntity.ok(rfidService.getAll());
    }

    @GetMapping("/rfids/{rfidId}")
    public ResponseEntity<RfidDto> getRfidById(@PathVariable String rfidId) {
        return ResponseEntity.ok(rfidService.getById(rfidId));
    }

    @DeleteMapping("/rfids/{rfidId}")
    public ResponseEntity<Void> deleteRfidById(@PathVariable String rfidId) {
        rfidService.deleteById(rfidId);
        return ResponseEntity.ok().build();
    }
}
