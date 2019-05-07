package smartcupboard.github.com.demo.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartcupboard.github.com.demo.itemhistory.ItemHistoryDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemSimpleDto>> getAllItems() {
        return ResponseEntity.ok(itemService.getAll());
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemSimpleDto> getItemById(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.getById(itemId));
    }

    @GetMapping("/items/{itemId}/history")
    public ResponseEntity<List<ItemHistoryDto>> getItemHistory(@PathVariable Long itemId) {
        return ResponseEntity.ok(itemService.getHistory(itemId));
    }

    @PostMapping("/items")
    public ResponseEntity<ItemSimpleDto> createItem(@RequestBody @Valid CreateItemCommand command) {
        return ResponseEntity.ok(itemService.create(command));
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long itemId) {
        itemService.deleteById(itemId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/shelfs/{shelfId}/items")
    public ResponseEntity<List<ItemExistDto>> getAllItemsByShelfId(@PathVariable Long shelfId) {
        return ResponseEntity.ok(itemService.getAllItems(shelfId));
    }
}
