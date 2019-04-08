package smartcupboard.github.com.demo.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private ReaderRepository readerRepository;

    public List<ReaderDto> getAll() {
        return null;
    }

    public ReaderDto getById(Long readerId) {
        return null;
    }

    public ReaderDto create(CreateUpdateReaderCommand command) {
        return null;
    }

    public ReaderDto updateById(Long readerId, CreateUpdateReaderCommand command) {
        return null;
    }

    public void deleteById(Long readerId) {
    }
}
