package smartcupboard.github.com.demo.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {
    private final SampleRepository sampleRepository;

    public List<SampleDto> getAll() {
        return null;
    }

    public SampleDto getById(Long sampleId) {
        return null;
    }

    public List<SampleEventDto> getHistory(Long sampleId) {
        return null;
    }

    public SampleDto create(CreateSampleCommand command) {
        return null;
    }

    public void deleteById(Long sampleId) {
    }
}
