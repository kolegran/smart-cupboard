package smartcupboard.github.com.demo.device;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Device {
    @Id
    private String id;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private String title;
}
