package smartcupboard.github.com.demo.cupboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CupboardService {
    private final CupboardRepository cupboardRepository;

    @Transactional(readOnly = true)
    public List<CupboardSimpleDto> getAll() {
        return cupboardRepository.findAll()
            .stream()
            .map(CupboardSimpleDto::new)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CupboardDto getById(Long cupboardId) {
        return new CupboardDto(cupboardRepository.getOne(cupboardId));
    }

    @Transactional
    public CupboardDto create(CreateUpdateCupboardCommand command) {
        return saveCupboard(new Cupboard(), command);
    }

    @Transactional
    public CupboardDto update(Long cupboardId, CreateUpdateCupboardCommand command) {
        return saveCupboard(cupboardRepository.getOne(cupboardId), command);
    }

    @Transactional
    public void deleteById(Long cupboardId) {
        cupboardRepository.deleteById(cupboardId);
    }

    private CupboardDto saveCupboard(Cupboard cupboard, CreateUpdateCupboardCommand command) {
        cupboard.setTitle(command.getTitle());
        return new CupboardDto(cupboardRepository.save(cupboard));
    }
}
