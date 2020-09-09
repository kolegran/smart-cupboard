package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SectorController {
    private final SectorService sectorService;

    @GetMapping("/cupboards/{cupboardId}/shelfs/{shelfId}/sectors")
    public ResponseEntity<List<SectorSimpleDto>> getAllSectors() {
        return ResponseEntity.ok(sectorService.getAll());
    }

    @GetMapping("/cupboards/{cupboardId}/shelfs/{shelfId}/sectors/{sectorId}")
    public ResponseEntity<SectorDto> getSectorById(@PathVariable Long sectorId) {
        return ResponseEntity.ok(sectorService.getById(sectorId));
    }

    @PostMapping("/cupboards/{cupboardId}/shelfs/{shelfId}/sectors")
    public ResponseEntity<SectorDto> createSector(@RequestBody @Valid CreateUpdateSectorCommand command) {
        return ResponseEntity.ok(sectorService.create(command));
    }

    @PutMapping("/cupboards/{cupboardId}/shelfs/{shelfId}/sectors/{sectorId}")
    public ResponseEntity<SectorDto> updateSectorById(
        @PathVariable Long sectorId,
        @RequestBody @Valid CreateUpdateSectorCommand command
    ) {
        return ResponseEntity.ok(sectorService.updateById(sectorId, command));
    }

    @DeleteMapping("/cupboards/{cupboardId}/shelfs/{shelfId}/sectors/{sectorId}")
    public ResponseEntity<Void> deleteSectorById(@PathVariable Long sectorId) {
        sectorService.deleteById(sectorId);
        return ResponseEntity.ok().build();
    }
}
