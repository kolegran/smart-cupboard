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

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.getById(itemId));
    }

    @GetMapping("/items/{itemId}/history")
    public ResponseEntity<List<ItemEventDto>> getItemHistory(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.getHistory(itemId));
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDto> createItem(@RequestBody @Valid CreateItemCommand command) {
        return ResponseEntity.ok(itemService.create(command));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long itemId) {
        itemService.deleteById(itemId);
        return ResponseEntity.ok().build();
    }
}
