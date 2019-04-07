package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShelfController {
    private final ShelfService shelfService;

    @GetMapping("/cupboards/{cupboardId}/shelfs")
    public ResponseEntity<List<ShelfSimpleDto>> getAllShelfs() {
        return ResponseEntity.ok(shelfService.getAll());
    }

    @GetMapping("/cupboards/{cupboardId}/shelfs/{shelfId}")
    public ResponseEntity<ShelfDto> getShelfById(@PathVariable Long shelfId) {
        return ResponseEntity.ok(shelfService.getById(shelfId));
    }

    @PostMapping("/cupboards/{cupboardId}/shelfs")
    public ResponseEntity<ShelfDto> createShelf(@RequestBody @Valid CreateUpdateShelfCommand command) {
        return ResponseEntity.ok(shelfService.create(command));
    }

    @PutMapping("/cupboards/{cupboardId}/shelfs/{shelfId}")
    public ResponseEntity<ShelfDto> updateShelfById(@PathVariable Long shelfId,
                                                @RequestBody @Valid CreateUpdateShelfCommand command) {
        return ResponseEntity.ok(shelfService.updateById(shelfId, command));
    }

    @DeleteMapping("/cupboards/{cupboardId}/shelfs/{shelfId}")
    public ResponseEntity<Void> deleteShelfById(@PathVariable Long shelfId) {
        shelfService.deleteById(shelfId);
        return ResponseEntity.ok().build();
    }
}
