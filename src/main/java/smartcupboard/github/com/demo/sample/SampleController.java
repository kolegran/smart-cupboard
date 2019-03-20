package smartcupboard.github.com.demo.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;

    @GetMapping("/samples")
    public ResponseEntity<List<SampleDto>> getAllSamples() {
        return ResponseEntity.ok(sampleService.getAll());
    }

    @GetMapping("/samples/{sampleId}")
    public ResponseEntity<SampleDto> getSampleById(@PathVariable Long sampleId) {
        return ResponseEntity.ok(sampleService.getById(sampleId));
    }

    @GetMapping("/samples/{sampleId}/history")
    public ResponseEntity<List<SampleEventDto>> getSampleHistory(@PathVariable Long sampleId) {
        return ResponseEntity.ok(sampleService.getHistory(sampleId));
    }

    @PostMapping("/samples")
    public ResponseEntity<SampleDto> createSample(@RequestBody @Valid CreateSampleCommand command) {
        return ResponseEntity.ok(sampleService.create(command));
    }

    @DeleteMapping("/samples/{sampleId}")
    public ResponseEntity<Void> deleteSampleById(@PathVariable Long sampleId) {
        sampleService.deleteById(sampleId);
        return ResponseEntity.ok().build();
    }
}
