package smartcupboard.github.com.demo.rfid;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RfidService {
    private final RfidRepository rfidRepository;

    public List<RfidDto> getAll() {
        return null;
    }

    public RfidDto getById(String rfidId) {
        return null;
    }

    public void deleteById(String rfidId) {
    }
}
