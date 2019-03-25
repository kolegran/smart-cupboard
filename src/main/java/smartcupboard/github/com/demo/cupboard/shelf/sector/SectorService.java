package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorRepository sectorRepository;

    @Transactional(readOnly = true)
    public List<SectorDto> getAll() {
        return null;
    }

    @Transactional(readOnly = true)
    public SectorDto getById(Long sectorId) {
        return null;
    }

    @Transactional
    public SectorDto create(CreateUpdateSectorCommand command) {
        return null;
    }

    @Transactional
    public SectorDto updateById(Long sectorId, CreateUpdateSectorCommand command) {
        return null;
    }

    @Transactional
    public void deleteById(Long sectorId) {
    }
}
