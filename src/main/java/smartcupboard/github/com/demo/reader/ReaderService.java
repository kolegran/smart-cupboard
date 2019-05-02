package smartcupboard.github.com.demo.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.shelf.sector.SectorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final SectorRepository sectorRepository;

    @Transactional(readOnly = true)
    public List<ReaderDto> getAll() {
        return readerRepository.findAll()
                .stream()
                .map(ReaderDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReaderDto getById(String readerId) {
        return new ReaderDto(readerRepository.getOne(readerId));
    }

    @Transactional
    public ReaderDto create(CreateUpdateReaderCommand command) {
        Reader reader = new Reader();

        reader.setTitle(command.getTitle());
        reader.setSector(sectorRepository.getOne(command.getSectorId()));
        return new ReaderDto(readerRepository.save(reader));
    }

    @Transactional
    public ReaderDto updateById(String readerId, CreateUpdateReaderCommand command) {
        Reader reader = readerRepository.getOne(readerId);

        reader.setTitle(command.getTitle());
        reader.setSector(sectorRepository.getOne(command.getSectorId()));
        return new ReaderDto(readerRepository.save(reader));
    }

    @Transactional
    public void deleteById(String readerId) {
        readerRepository.deleteById(readerId);
    }
}
