package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartcupboard.github.com.demo.cupboard.CupboardRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShelfService {
    private final ShelfRepository shelfRepository;
    private final CupboardRepository cupboardRepository;

    @Transactional(readOnly = true)
    public List<ShelfSimpleDto> getAll() {
        return shelfRepository.findAll()
                .stream()
                .map(ShelfSimpleDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ShelfDto getById(Long shelfId) {
        return new ShelfDto(shelfRepository.getOne(shelfId));
    }

    @Transactional
    public ShelfDto create(CreateUpdateShelfCommand command) {
        Shelf shelf = new Shelf();

        shelf.setTitle(command.getTitle());
        shelf.setCupboard(cupboardRepository.getOne(command.getCupboardId()));
        return new ShelfDto(shelfRepository.save(shelf));
    }

    @Transactional
    public ShelfDto updateById(Long shelfId, CreateUpdateShelfCommand command) {
        Shelf shelf = shelfRepository.getOne(shelfId);

        shelf.setTitle(command.getTitle());
        shelf.setCupboard(cupboardRepository.getOne(command.getCupboardId()));
        return new ShelfDto(shelfRepository.save(shelf));
    }

    @Transactional
    public void deleteById(Long shelfId) {
        shelfRepository.deleteById(shelfId);
    }
}
