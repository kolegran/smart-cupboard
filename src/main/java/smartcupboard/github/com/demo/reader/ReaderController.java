package smartcupboard.github.com.demo.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping("/readers")
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        return ResponseEntity.ok(readerService.getAll());
    }

    @GetMapping("/readers/{readerId}")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable String readerId) {
        return ResponseEntity.ok(readerService.getById(readerId));
    }

    @PostMapping("/readers")
    public ResponseEntity<ReaderDto> createReader(@RequestBody @Valid CreateUpdateReaderCommand command) {
        return ResponseEntity.ok(readerService.create(command));
    }

    @PutMapping("/readers/{readerId}")
    public ResponseEntity<ReaderDto> updateReaderById(
        @PathVariable String readerId,
        @RequestBody @Valid CreateUpdateReaderCommand command
    ) {
        return ResponseEntity.ok(readerService.updateById(readerId, command));
    }

    @DeleteMapping("/readers/{readerId}")
    public ResponseEntity<Void> deleteReaderById(@PathVariable String readerId) {
        readerService.deleteById(readerId);
        return ResponseEntity.ok().build();
    }
}
