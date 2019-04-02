package smartcupboard.github.com.demo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/samples")
    public ResponseEntity<List<ItemDto>> getAllSamples() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @GetMapping("/samples/{sampleId}")
    public ResponseEntity<ItemDto> getSampleById(@PathVariable Long sampleId) {
        return ResponseEntity.ok(itemService.getById(sampleId));
    }

    @GetMapping("/samples/{sampleId}/history")
    public ResponseEntity<List<ItemEventDto>> getSampleHistory(@PathVariable Long sampleId) {
        return ResponseEntity.ok(itemService.getHistory(sampleId));
    }

    @PostMapping("/samples")
    public ResponseEntity<ItemDto> createSample(@RequestBody @Valid CreateItemCommand command) {
        return ResponseEntity.ok(itemService.create(command));
    }

    @DeleteMapping("/samples/{sampleId}")
    public ResponseEntity<Void> deleteSampleById(@PathVariable Long sampleId) {
        itemService.deleteById(sampleId);
        return ResponseEntity.ok().build();
    }
}
