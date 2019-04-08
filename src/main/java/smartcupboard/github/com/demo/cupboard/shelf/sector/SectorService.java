package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorRepository sectorRepository;

    public List<SectorDto> getAll() {
        return null;
    }

    public SectorDto getById(Long sectorId) {
        return null;
    }

    public SectorDto create(CreateUpdateSectorCommand command) {
        return null;
    }

    public SectorDto updateById(Long sectorId, CreateUpdateSectorCommand command) {
        return null;
    }

    public void deleteById(Long sectorId) {
    }
}
