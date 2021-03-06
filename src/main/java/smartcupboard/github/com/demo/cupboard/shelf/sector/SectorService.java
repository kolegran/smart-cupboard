package smartcupboard.github.com.demo.cupboard.shelf.sector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.ShelfRepository;
import smartcupboard.github.com.demo.reader.ReaderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectorService {
    private final SectorRepository sectorRepository;
    private final ShelfRepository shelfRepository;
    private final ReaderRepository readerRepository;

    @Transactional(readOnly = true)
    public List<SectorSimpleDto> getAll() {
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
        return saveSector(new Sector(), command);
    }

    @Transactional
    public SectorDto updateById(Long sectorId, CreateUpdateSectorCommand command) {
        return saveSector(sectorRepository.getOne(sectorId), command);
    }

    @Transactional
    public void deleteById(Long sectorId) {
        sectorRepository.deleteById(sectorId);
    }

    private SectorDto saveSector(Sector sector, CreateUpdateSectorCommand command) {
        sector.setTitle(command.getTitle());
        sector.setShelf(shelfRepository.getOne(command.getShelfId()));
        sector.setReader(readerRepository.getOne(command.getReaderId()));
        return new SectorDto(sectorRepository.save(sector));
    }
}
