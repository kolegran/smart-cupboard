package smartcupboard.github.com.demo.cupboard.shelf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShelfService {
    private final ShelfRepository shelfRepository;

    public List<ShelfDto> getAll() {
        return null;
    }

    public ShelfDto getById(Long shelfId) {
        return null;
    }

    public ShelfDto create(CreateUpdateShelfCommand command) {
        return null;
    }

    public ShelfDto updateById(Long shelfId, CreateUpdateShelfCommand command) {
        return null;
    }

    public void deleteById(Long shelfId) {
    }
}
