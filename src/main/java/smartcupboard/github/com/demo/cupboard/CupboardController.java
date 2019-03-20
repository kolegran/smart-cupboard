package smartcupboard.github.com.demo.cupboard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CupboardController {
    private final CupboardService cupboardService;

    @GetMapping("/cupboards")
    public ResponseEntity<List<CupboardDto>> getAllCupboards() {
        return ResponseEntity.ok(cupboardService.getAll());
    }

    @GetMapping("/cupboards/{cupboardId}")
    public ResponseEntity<CupboardDto> getCupboardById(@PathVariable Long cupboardId) {
        return ResponseEntity.ok(cupboardService.getById(cupboardId));
    }

    @PostMapping("/cupboards")
    public ResponseEntity<CupboardDto> createCupboard(@RequestBody @Valid CreateCupboardCommand command) {
        return ResponseEntity.ok(cupboardService.create(command));
    }

    @DeleteMapping("/cupboards/{cupboardId}")
    public ResponseEntity<Void> deleteCupboardById(@PathVariable Long cupboardId) {
        cupboardService.deleteById(cupboardId);
        return ResponseEntity.ok().build();
    }
}
