package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorRepository sectorRepository;
    private final ShelfRepository shelfRepository;

    @Transactional(readOnly = true)
    public List<SectorDto> getAll() {
        return sectorRepository.findAll()
                .stream()
                .map(SectorDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SectorDto getById(Long sectorId) {
        return new SectorDto(sectorRepository.getOne(sectorId));
    }

    @Transactional
    public SectorDto create(CreateUpdateSectorCommand command) {
        Sector sector = new Sector();

        sector.setTitle(command.getTitle());
        sector.setShelf(shelfRepository.getOne(command.getShelfId()));

        return new SectorDto(sectorRepository.save(sector));
    }

    @Transactional
    public SectorDto updateById(Long sectorId, CreateUpdateSectorCommand command) {
        Sector sector = sectorRepository.getOne(sectorId);

        sector.setTitle(command.getTitle());
        sector.setShelf(shelfRepository.getOne(command.getShelfId()));

        return new SectorDto(sectorRepository.save(sector));
    }

    @Transactional
    public void deleteById(Long sectorId) {
        sectorRepository.deleteById(sectorId);
    }
}
