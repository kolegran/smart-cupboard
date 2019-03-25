package smartcupboard.github.com.demo.rfid;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RfidRepository extends JpaRepository<Rfid, String> {
}
