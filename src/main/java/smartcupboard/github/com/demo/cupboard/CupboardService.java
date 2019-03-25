package smartcupboard.github.com.demo.cupboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CupboardService {
    private final CupboardRepository cupboardRepository;

    public List<CupboardDto> getAll() {
        return null;
    }

    public CupboardDto getById(Long cupboardId) {
        return null;
    }

    public CupboardDto create(CreateCupboardCommand command) {
        return null;
    }

    public void deleteById(Long cupboardId) {
    }
}
